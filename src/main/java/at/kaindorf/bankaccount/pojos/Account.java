package at.kaindorf.bankaccount.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Exa_01_JPA_5DHIF_2024
 * Created by: raph
 * Date: 2024-09-18
 * Time: 14:27:53
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@Data
@AllArgsConstructor
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Account {


    @Id
    @GeneratedValue
    @JsonIgnore
    private Long accountId;

    @Column(nullable = false)
    private Long accountNumber;

    @Column(nullable = false)
    private Double balance;

    @ManyToMany(mappedBy = "accounts")
    private List<Customer> customerList = new ArrayList<>();

}
