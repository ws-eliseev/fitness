package ws.eliseev.fitness.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.Date;

@Audited
@Entity
@Table(name = "FIT_DOCUMENT")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Document {

    /** Поле id - Первичный ключ, генерация IDENTITY  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /** Поле  даты создания документа  */
    @Column(name="DATE_OF_CREATION")
    private Date dateOfCreation;

    /** Поле  даты изменения документа  */
    @Column(name="LAST_MODIFIED")
    private Date lastModified;

    /** Поле типа  документа  */
    @Column(name="DOCUMENT_TYPE")
    private String documentType;

    /** Поле содержания документа  */
    @Lob
    @Column(name="CONTENT")
    private byte[] content;

    /** Поле автора документа  */
    @Column(name="AUTHOR")
    private String author;





}
