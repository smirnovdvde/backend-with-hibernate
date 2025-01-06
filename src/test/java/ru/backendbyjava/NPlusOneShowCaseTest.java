package ru.backendbyjava;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.backendbyjava.domain.model.nplusone.BatchUser;
import ru.backendbyjava.domain.model.nplusone.EagerUser;
import ru.backendbyjava.domain.model.nplusone.EntityGraphUser;
import ru.backendbyjava.domain.model.nplusone.LazyPost;
import ru.backendbyjava.domain.model.nplusone.LazyUser;
import ru.backendbyjava.domain.repository.nplusone.BatchUserRepository;
import ru.backendbyjava.domain.repository.nplusone.EagerUserRepository;
import ru.backendbyjava.domain.repository.nplusone.EntityGraphUserRepository;
import ru.backendbyjava.domain.repository.nplusone.LazyUserRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendWithHibernateApplication.class)
@ContextConfiguration(initializers = {ShowCaseCommon.Initializer.class})
@DirtiesContext
public class NPlusOneShowCaseTest extends ShowCaseCommon {
    private static final Logger LOG = LoggerFactory.getLogger(NPlusOneShowCaseTest.class);

    @Autowired
    private EagerUserRepository eagerUserRepository;
    @Autowired
    private LazyUserRepository lazyUserRepository;
    @Autowired
    private BatchUserRepository batchUserRepository;
    @Autowired
    private EntityGraphUserRepository entityGraphUserRepository;

    @Test
    public void checkProblemExistenceWithEager() {
        LOG.info("selecting from database with eager users starts....");
        List<EagerUser> eagerUsers = eagerUserRepository.findAll();
        LOG.info("selecting from database with eager users ends....");
    }

    @Test
    @Transactional
    public void checkProblemExistenceWithLazy() {
        LOG.info("selecting from database with lazy users starts....");
        List<LazyUser> users = lazyUserRepository.findAll();
        List<LazyPost> posts = users.get(0).getPosts();
        Assert.assertEquals(5, posts.size());
        LOG.info("selecting from database with lazy users ends....");
    }

    @Test
    @Transactional
    public void checkProblemExistenceWithBatch() {
        LOG.info("selecting from database with batch users starts....");
        List<BatchUser> users = batchUserRepository.findAll();
        Assert.assertNotNull(users.get(0).getPosts().get(0));
        LOG.info("selecting from database with batch users ends....");
    }

    @Test
    public void checkProblemExistenceWithJoinFetch() {
        LOG.info("selecting from database with join fetch users starts....");
        List<EagerUser> users = eagerUserRepository.findAllByJoinFetch();
        Assert.assertEquals(2, users.size());
        LOG.info("selecting from database with join fetch users ends....");
    }

    @Test
    public void checkProblemExistenceWithLeftJoinFetch() {
        LOG.info("selecting from database with left join fetch users starts....");
        List<EagerUser> users = eagerUserRepository.findAllByLeftJoinFetch();
        Assert.assertEquals(3, users.size());
        LOG.info("selecting from database with left join fetch users ends....");
    }

    @Test
    public void checkProblemExistenceWithEntityGraph() {
        LOG.info("selecting from database with entity graph users starts....");
        List<EntityGraphUser> users = entityGraphUserRepository.findAll();
        Assert.assertEquals(3, users.size());
        LOG.info("selecting from database with entity graph users ends....");
    }
}
