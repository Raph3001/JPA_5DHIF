package at.kaindorf.bankaccount.pojos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Project: Exa_01_JPA_5DHIF_2024
 * Created by: raph
 * Date: 2024-09-18
 * Time: 14:28:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("Giro")
@EqualsAndHashCode(callSuper = true)
public class GiroAccount extends Account {

    private Double overdraft;

    private Float debitInterest;

    private Float creditInterest;

}
