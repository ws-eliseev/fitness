package ws.eliseev.fitness.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FIT_ADDRESS")
@Setter
@Getter
@NoArgsConstructor
public class Address {

    /** Поле id - Первичный ключ, генерация IDENTITY*/
    @Id
    @Column(name = "ID")
    private Long id;

    /** Поле указания области   */
    @Column(name = "REGION")
    private String region ;

    /** Поле указания города/населенного пункта   */
    @Column(name = "CITY")
    private String city;

    /** Поле указания улицы   */
    @Column(name = "STREET")
    private String street ;

    /** Поле указания номера дома   */
    @Column(name = "HOUSE_NUMBER")
    private int houseNumber;

    /** Поле указания номера квартиры   */
    @Column(name="APARTMENT_NUMBER")
    private int apartmentNumber;

    @Builder
    public Address(Long id, String region, String city, String street, int houseNumber, int apartmentNumber) {
        this.id = id;
        this.region = region;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }
}
