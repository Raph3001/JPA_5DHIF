package at.kaindorf.bankaccount.repos;

import at.kaindorf.bankaccount.pojos.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {



}
