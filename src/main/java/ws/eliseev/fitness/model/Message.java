package ws.eliseev.fitness.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="FIT_MESSAGE")
@Data
public class Message {

    /** Поле id - первичный ключ, генерация IDENTITY*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    /** Поле timestamp - дата создания сообщения */
    private Date timestamp;

    /** Поле content - текст сообщения*/
    private String content;

    /** Поле blob -  вложение, большой бинарный объект BLOB*/
    @Lob
    private byte[] blob;

    /** Поле senderName - отправитель сообщения*/
    private String senderName;
}
