package at.kaindorf.bankaccount;

import at.kaindorf.bankaccount.pojos.Customer;
import at.kaindorf.bankaccount.pojos.CustomerPk;
import at.kaindorf.bankaccount.pojos.Gender;
import at.kaindorf.bankaccount.repos.CustomerRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

/**
 * Project: Exa_01_JPA_5DHIF_2024
 * Created by: raph
 * Date: 2024-09-11
 * Time: 14:24:51
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class CustomerTest {

    private final CustomerRepository customerRepository;

    @PostConstruct
    public void saveCustomer() {
        Customer customer = Customer.builder()
                //.PK(new CustomerPk("", 0L))
                .firstname("Deng")
                .lastname("Xiaoping")
                .gender(Gender.m)
                .birthdate(LocalDate.of(1970, Month.JANUARY, 1))
                .build();
        //Customer customer = new Customer();
        //customer.setId(213L);
        //customer.setSsn("1234-567890");
        //customer.setFirstname("Gamers");
        customerRepository.save(customer);
    }

}
