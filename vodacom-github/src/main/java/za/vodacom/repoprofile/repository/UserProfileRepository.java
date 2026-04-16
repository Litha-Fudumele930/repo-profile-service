package za.vodacom.repoprofile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.vodacom.repoprofile.domain.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, String> {
}
