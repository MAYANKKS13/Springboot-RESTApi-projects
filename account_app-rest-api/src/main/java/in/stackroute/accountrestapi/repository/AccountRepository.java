package in.stackroute.accountrestapi.repository;

import in.stackroute.accountrestapi.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends JpaRepository<Accounts, Integer> {
}
