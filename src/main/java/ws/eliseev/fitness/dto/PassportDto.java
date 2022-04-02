package ws.eliseev.fitness.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.repository.cdi.Eager;
import ws.eliseev.fitness.model.Address;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * DTO объект от сущности Passport
 * @see ws.eliseev.fitness.model.Passport
 * @author Мельник Андрей
 */
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PassportDto {

    private Long id;

    private int passport_number ;

    private int passport_series;

    private  int date_of_issue ;

    private String authority;

    private int subdivision_code;

    private AddressDto address ;

    @Override
    public String toString() {
        return "PassportDto{" +
                "id=" + id +
                ", passport_number=" + passport_number +
                ", passport_series=" + passport_series +
                ", date_of_issue=" + date_of_issue +
                ", authority='" + authority + '\'' +
                ", subdivision_code=" + subdivision_code +
                '}';
    }
}
