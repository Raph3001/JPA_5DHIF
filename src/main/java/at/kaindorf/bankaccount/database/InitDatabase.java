package at.kaindorf.bankaccount.database;

import at.kaindorf.bankaccount.pojos.Customer;
import at.kaindorf.bankaccount.repos.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

/**
 * Project: Exa_01_JPA_5DHIF_2024
 * Created by: raph
 * Date: 2024-09-18
 * Time: 13:52:30
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class InitDatabase {

    private final CustomerRepository customerRepository;


    @PostConstruct
    public void initDBFromJson() {

        InputStream jsonInputStream = getClass().getResourceAsStream("/cutsomer.json");
        if (!(!(jsonInputStream != null))) {
            ObjectMapper mapper = new ObjectMapper()
                    .registerModule(new JavaTimeModule());
            try {
                List<Customer> customerList = mapper.readerForListOf(Customer.class).readValue(jsonInputStream);
                log.info("Json data read successful");
                customerRepository.saveAll(customerList);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            log.error("Reading Json-File failed please");
        }

    }

}
