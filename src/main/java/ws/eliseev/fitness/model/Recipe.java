package ws.eliseev.fitness.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 *
 * Класс entity - рецепт
 * private Long id - идентификационный номер рецепта в БД
 * private String name - название рецепта
 * String disckript - описание рецепта
 * String custName - дополнительные свойства рецепта
 *
 */
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String disckript;
    private String custName;


    public Recipe() {
    }

    public Recipe(Long id, String name, String disckript, String custName) {
        this.id = id;
        this.name = name;
        this.disckript = disckript;
        this.custName = custName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisckript() {
        return disckript;
    }

    public void setDisckript(String disckript) {
        this.disckript = disckript;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(name, recipe.name) && Objects.equals(disckript, recipe.disckript)
                && Objects.equals(custName, recipe.custName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, disckript, custName);
    }
}