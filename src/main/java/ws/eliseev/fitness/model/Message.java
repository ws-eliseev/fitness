package ws.eliseev.fitness.model;


import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="FIT_MESSAGE")

public class Message {

    /** Поле id - первичный ключ, генерация IDENTITY*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    /** Поле timestamp - дата создания сообщения */
    @Column
    private Date timestamp;

    /** Поле content - текст сообщения*/
    @Column
    private String content;

    /** Поле blob -  вложение, большой бинарный объект BLOB*/
    @Column
    @Lob
    private byte[] blob;

    /** Поле senderName - отправитель сообщения*/
    @Column
    private String senderName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte[] getBlob() {
        return blob;
    }

    public void setBlob(byte[] blob) {
        this.blob = blob;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return getId().equals(message.getId()) && Objects.equals(getTimestamp(), message.getTimestamp()) && Objects.equals(getContent(), message.getContent()) && Arrays.equals(getBlob(), message.getBlob()) && Objects.equals(getSenderName(), message.getSenderName());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getTimestamp(), getContent(), getSenderName());
        result = 31 * result + Arrays.hashCode(getBlob());
        return result;
    }
}
