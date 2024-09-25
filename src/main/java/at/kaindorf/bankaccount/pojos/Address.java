package at.kaindorf.bankaccount.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project: Exa_01_JPA_5DHIF_2024
 * Created by: raph
 * Date: 2024-09-12
 * Time: 10:20:39
 */

@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private Long addressId;

    @Column(length = 100, nullable = false)
    private String streetname;

    @Column(scale = 5)
    private Integer zipCode;

    @Column(length = 100, nullable = false)
    private String city;

}
