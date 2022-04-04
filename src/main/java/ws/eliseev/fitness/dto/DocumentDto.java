package ws.eliseev.fitness.dto;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DocumentDto {

    private Long id;

    private Date dateOfCreation;

    private Date lastModified;

    private String documentType;

    private byte[] content;

    private String author;


}
