package ws.eliseev.fitness.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;

/**
 * Сущность BodyCharacteristics
 * @author Tsoy Roman
 */

@Entity
@Data
@Table(name = "FIT_BODY_CHARACTERISTICS")
@NoArgsConstructor
@Getter
@Setter
@Audited
public class BodyCharacteristics {

    /** Поле id - Первичный ключ, генерация IDENTITY */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /** Рост в см */
    @Column(name = "HEIGHT")
    private short height;

    /** Вес в кг */
    @Column(name = "WEIGHT")
    private short weight;

    /** Индекс массы тела */
    @Column(name = "BMI")
    private byte bmi;

}
