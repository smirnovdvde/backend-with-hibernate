package ru.backendbyjava.domain.repository.nplusone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.backendbyjava.domain.model.nplusone.EagerUser;

import java.util.List;
import java.util.UUID;

public interface EagerUserRepository extends JpaRepository<EagerUser, UUID> {
    @Query("select user from EagerUser user join fetch user.posts")
    List<EagerUser> findAllByJoinFetch();

    @Query("select user from EagerUser user left join fetch user.posts")
    List<EagerUser> findAllByLeftJoinFetch();
}
