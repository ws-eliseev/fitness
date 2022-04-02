package ws.eliseev.fitness.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;


/**
 * DTO объект от сущности Address
 * @see ws.eliseev.fitness.model.Address
 * @author Мельник Андрей
 */
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressDto {

    private Long id;

    private String region ;

    private String city;

    private String street ;

    private int houseNumber;

    private int apartmentNumber;

    @Override
    public String toString() {
        return "AddressDto{" +
                "id=" + id +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", apartmentNumber=" + apartmentNumber +
                '}';
    }
}
