package ru.backendbyjava.domain.repository.overhead;

import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.backendbyjava.domain.model.overhead.ManyRowsEntity;

import java.util.List;
import java.util.stream.Stream;

public class ManyRowsEntityRepositoryImpl implements CustomizedManyRowsRepository {

    @Autowired
    private EntityManager entityManager;
    private static final Logger LOG = LoggerFactory.getLogger(ManyRowsEntityRepositoryImpl.class);

    @Override
    public List<ManyRowsEntity> findAllUsingStatelessSession() {
        SessionFactory sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
        List<ManyRowsEntity> manyRowsEntityList;
        try (StatelessSession statelessSession = sessionFactory.openStatelessSession()) {
            manyRowsEntityList = statelessSession.createQuery("from ManyRowsEntity", ManyRowsEntity.class)
                    .unwrap(Query.class).getResultList();
        }
        return manyRowsEntityList;
    }

    @Override
    public void findAllUsingStream() {
        SessionFactory sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
        try (StatelessSession statelessSession = sessionFactory.openStatelessSession()) {
            Stream<ManyRowsEntity> manyRowsStream = statelessSession.createQuery("from ManyRowsEntity ", ManyRowsEntity.class)
                    .unwrap(Query.class).setFetchSize(1000).getResultStream();
            manyRowsStream.forEach(manyRowsEntity -> {
                if (manyRowsEntity.getName().contains("500000")) {
                    LOG.info("name with maximum number is found");
                }
            });
        }
    }
}
