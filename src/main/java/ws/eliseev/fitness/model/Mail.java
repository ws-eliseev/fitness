package ws.eliseev.fitness.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


/**
 * Сущность Mail
 * @author Tsoy Roman
 */

@Entity
@Data
@Table(name = "FIT_MAIL")
@NoArgsConstructor
@Getter
@Setter
public class Mail {

    /** Поле id - Первичный ключ, генерация IDENTITY*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /** Шаблон письма*/
    @Column(name = "TEMPLATE")
    private String template;

}
