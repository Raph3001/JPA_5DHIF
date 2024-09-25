package at.kaindorf.bankaccount.pojos;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: Exa_01_JPA_5DHIF_2024
 * Created by: raph
 * Date: 2024-09-11
 * Time: 14:01:22
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "customerSequence")
    //@SequenceGenerator(name = "customerSequence", initialValue = 0, allocationSize = 10)
    //private Long customerId;
    //@GeneratedValue(strategy = GenerationType.UUID)
    //private String customerId;

    /*@Id
    @Column(length = 10)
    private String ssn;
    @Id
    private Long id;*/

    //@EmbeddedId
    //private CustomerPk PK;

    @Id
    @GeneratedValue
    //@JsonIgnore
    private Long customerId;


    @Column(nullable = true, unique = false)
    private String firstname;
    @Column(nullable = true, unique = false)
    private String lastname;
    @Column(nullable = true, unique = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonFormat(pattern = "yyyy-MM-dd", locale = "US")
    private LocalDate birthdate;

    @ManyToMany
    @JoinTable(joinColumns = {
            @JoinColumn(name = "customer_id")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "account_id")
    })
    @JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
    @JsonSubTypes({
            @JsonSubTypes.Type(GiroAccount.class),
            @JsonSubTypes.Type(SavingsAccount.class)
    })
    private List<Account> accounts = new ArrayList<>();


}
