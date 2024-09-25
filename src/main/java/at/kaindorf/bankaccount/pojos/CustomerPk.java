package at.kaindorf.bankaccount.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Project: Exa_01_JPA_5DHIF_2024
 * Created by: raph
 * Date: 2024-09-11
 * Time: 14:33:55
 */

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPk implements Serializable {
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ssn;
    @GeneratedValue
    private Long id;

}
