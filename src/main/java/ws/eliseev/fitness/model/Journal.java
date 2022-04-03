package ws.eliseev.fitness.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.sql.Date;

/**
 * Сущность Journal
 * @author Tsoy Roman
 */

@Entity
@Data
@Table(name = "FIT_JOURNAL")
@NoArgsConstructor
@Getter
@Setter
@Audited
public class Journal {

    /** Поле id - Первичный ключ, генерация IDENTITY */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /** Дата создания записи */
    @Column(name = "CREATION_DATE")
    private Date creationDate;

    /** Дата модификации записи */
    @Column(name = "MODIFICATION_DATE")
    private Date modificationDate;

    /** Поле для хранения набора характеристик, связь OneToOne*/
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BODY_CHARACTERISTICS_ID", referencedColumnName = "ID")
    private BodyCharacteristics bodyCharacteristics;
}
