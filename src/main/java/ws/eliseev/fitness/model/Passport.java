package ws.eliseev.fitness.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FIT_PASSPORT")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Passport {

    /** Поле id - Первичный ключ, генерация IDENTITY*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /** Поле номера паспорта  */
    @Column(name = "PASSPORT_NUMBER")
    private int passport_number ;

    /** Поле серии паспорта   */
    @Column(name = "PASSPORT_SERIES")
    private int passport_series;

    /** Поле даты выдачи  паспорта   */
    @Column(name = "DATE_OF_ISSUE")
    private  int date_of_issue ;

    /** Поле указания ведомства которое выдало паспорта   */
    @Column(name = "AUTHORITY")
    private String authority;

    /** Поле указания кода подразделения паспорта   */
    @Column(name = "SUBDIVISION_CODE")
    private int subdivision_code;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "ADDRESS_ID")
    private Address address ;

    @Override
    public String toString() {
        return  "Паспорт:"+
                "Номер=" + passport_number+";" + " "+
                "Серия=" + passport_series+";" +" "+
                "Дата выдачи=" + date_of_issue+";" +" "+
                "Кем выдан:" + authority + '\'' +" "+
                "Код подразделения=" + subdivision_code+";" +" "+
                "Адрес регистрации=" + address ;
    }
}
