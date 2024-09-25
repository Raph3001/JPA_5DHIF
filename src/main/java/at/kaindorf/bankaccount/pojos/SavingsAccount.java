package at.kaindorf.bankaccount.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Project: Exa_01_JPA_5DHIF_2024
 * Created by: raph
 * Date: 2024-09-18
 * Time: 14:28:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("Savings")
@EqualsAndHashCode(callSuper = true)
public class SavingsAccount extends Account {

    private Float interest;

}
