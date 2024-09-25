package at.kaindorf.bankaccount.pojos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CustomerTest {

    @Autowired
    private EntityManager em;
/*
    @BeforeEach
    public void initDB() {
        em.getTransaction().begin();
        Customer customer = Customer.builder()
                .birthdate(LocalDate.now())
                .gender(Gender.m)
                .firstname("G")
                .lastname("Kla")
                .build();
        em.persist(customer);
    }

 */

    @Test
    public void testNumberOfCustomer() {
        TypedQuery<Long> tquery = em.createQuery("SELECT count(c) FROM Customer c", Long.class);
        Long expected = 990L;
        Long actual = tquery.getSingleResult();
        assertEquals(expected, actual);
    }

}