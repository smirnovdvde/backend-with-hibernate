package ru.backendbyjava;

import jakarta.persistence.EntityManager;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import ru.backendbyjava.domain.refintegrity.Dog;
import ru.backendbyjava.domain.refintegrity.Post;
import ru.backendbyjava.domain.refintegrity.User;
import ru.backendbyjava.domain.repository.refintegity.DogRepository;
import ru.backendbyjava.domain.repository.refintegity.PostRepository;
import ru.backendbyjava.domain.repository.refintegity.UserRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendWithHibernateApplication.class)
@ContextConfiguration(initializers = {ShowCaseCommon.Initializer.class})
@DirtiesContext
public class ReferentialIntegrityShowCaseTest extends ShowCaseCommon {
    @Autowired
    private DogRepository dogRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PlatformTransactionManager transactionManager;

    @Test
    public void checkInheritanceCase() {
        Dog dog = new Dog();
        dog.setNickname("my dog");
        dog.setBreed("german dog");
        dogRepository.save(dog);
        dogRepository.deleteById(dog.getId());
    }

    @Test
    public void checkOrphanRemovalCase() {
        // here atomic is used to avoid fulfillment of requirement
        // for variable to be effectively final in lambda
        // in code for testing it is more or less ok to write so
        // in main code - such code smells :)
        AtomicReference<User> firstUserReference = new AtomicReference<>();
        AtomicReference<Post> firstPostOfFirstUserReference = new AtomicReference<>();
        AtomicInteger atomicNumberOfPostsBeforeOrphanRemoval = new AtomicInteger();
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);

        //run in separate transaction
        transactionTemplate.execute(status -> {
            List<User> users = userRepository.findAll();
            User firstUser = users.get(0);
            List<Post> postsOfFirstUser = firstUser.getPosts();

            atomicNumberOfPostsBeforeOrphanRemoval.set(postsOfFirstUser.size());

            Post firstPostOfFirstUser = postsOfFirstUser.get(0);
            postsOfFirstUser.remove(firstPostOfFirstUser);

            firstUserReference.set(firstUser);
            firstPostOfFirstUserReference.set(firstPostOfFirstUser);

            return firstUserReference;
            //no needs to call save method from repository
            //dirty checking is in action
        });


        //run in separate transaction
        transactionTemplate.execute(status -> {
            User firstUserRenewed = userRepository.findById(firstUserReference.get().getId()).get();

            Assertions.assertEquals(atomicNumberOfPostsBeforeOrphanRemoval.get() - 1, firstUserRenewed.getPosts().size());
            Assertions.assertFalse(postRepository.findById(firstPostOfFirstUserReference.get().getId()).isPresent());

            return firstUserRenewed;
        });

    }
}
