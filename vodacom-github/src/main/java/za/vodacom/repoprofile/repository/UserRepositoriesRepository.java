package za.vodacom.repoprofile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.vodacom.repoprofile.domain.UserRepositories;

import java.util.List;


@org.springframework.stereotype.Repository
public interface UserRepositoriesRepository extends JpaRepository<UserRepositories, Long> {

    List<UserRepositories> findByUsername(String username);

    void deleteByUsername(String userName);
}
