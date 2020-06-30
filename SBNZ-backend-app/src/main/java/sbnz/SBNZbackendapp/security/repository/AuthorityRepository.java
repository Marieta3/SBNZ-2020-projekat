package sbnz.SBNZbackendapp.security.repository;

import sbnz.SBNZbackendapp.security.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findAuthorityByName(String name);
}
