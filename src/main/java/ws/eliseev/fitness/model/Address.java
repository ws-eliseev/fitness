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
@AllArgsConstructor
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

    @Override
    public String toString() {
        return
                "Область/Край=" + region+";"+
                "Город/Населенный пункт=" + city + ";"+
                "Улица=" + street + ";"+
                "Дом=" + houseNumber+";"+
                "Квартира=" + apartmentNumber +";";
    }
}
