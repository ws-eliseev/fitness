package ws.eliseev.fitness.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Indexed
@Table(name = "FIT_RECIPE")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    /**
     * Поле id - Первичный ключ, генерация IDENTITY
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /**
     * Поле наименования рецепта
     */
    @Column(name = "NAME", nullable = false)
    @Field(store = Store.YES)
    private String name;

    /**
     * Поле имени уникального  рецепта
     */
    @Column(name = "UNIQUE_RECIPE_FIELD")
    @Field(store = Store.YES)
    private String uniqueRecipeField;

    /**
     * Поле количества калорий
     */
    @Column(name = "CALORIES")
    @Field(store = Store.YES)
    private int calories;

    /**
     * Поле количества белков
     */
    @Column(name = "PROTEINS")
    @Field(store = Store.YES)
    private int proteins;

    /**
     * Поле количества жиров
     */
    @Column(name = "FAT")
    @Field(store = Store.YES)
    private int fat;

    /**
     * Поле количества углеводов
     */
    @Column(name = "CARBOHYDRATES")
    @Field(store = Store.YES)
    private int carbohydrates;

    /**
     * Поле времени приема пищи (завтрак - обед - ужин)
     */
    @Column(name = "MEALS")
    @Field(store = Store.YES)
    private String meals;

    /**
     * Поле рейтинга рецепта
     */
    @Column(name = "RATING")
    @Field(store = Store.YES)
    private int rating;

    /**
     * Поле изображения рецепта
     */
    @Column(name = "IMAGE")
    private String image;

}