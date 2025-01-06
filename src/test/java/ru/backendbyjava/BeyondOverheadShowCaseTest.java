package ru.backendbyjava;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.backendbyjava.domain.model.overhead.ManyRowsEntity;
import ru.backendbyjava.domain.model.overhead.ManyRowsNameProjection;
import ru.backendbyjava.domain.repository.overhead.ManyRowsEntityRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendWithHibernateApplication.class)
@ContextConfiguration(initializers = {ShowCaseCommon.Initializer.class})
@DirtiesContext
public class BeyondOverheadShowCaseTest extends ShowCaseCommon {
    private static final Integer COLLECTION_SIZE = 500000;
    private static final Integer COLLECTION_WITH_ELEMENTS_LIKE_5 = 204756;

    @Autowired
    private ManyRowsEntityRepository manyRowsEntityRepository;

    @Test
    public void checkFindAllUsingStatelessSession() {
        List<ManyRowsEntity> manyRowsEntityList = manyRowsEntityRepository.findAllUsingStatelessSession();
        Assertions.assertEquals(COLLECTION_SIZE, manyRowsEntityList.size());
    }

    @Test
    public void checkFindAllUsingStream() {
        manyRowsEntityRepository.findAllUsingStream();
    }

    @Test
    public void checkFindAllWithUsingProjection() {
        List<ManyRowsNameProjection> manyRowsList = manyRowsEntityRepository.findAllByNameLike("%5%");
        Assertions.assertEquals(COLLECTION_WITH_ELEMENTS_LIKE_5, manyRowsList.size());
    }
}
