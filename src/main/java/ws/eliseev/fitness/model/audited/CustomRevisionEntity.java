package ws.eliseev.fitness.model.audited;

import lombok.EqualsAndHashCode;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FIT_REVINFO")
@RevisionEntity(CustomRevisionEntityListener.class)
@EqualsAndHashCode
public class
CustomRevisionEntity extends DefaultRevisionEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "USERNAME")
    private String username;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
