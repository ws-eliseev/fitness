package ws.eliseev.fitness.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

import javax.persistence.*;

@Entity
@Indexed
@Table(name = "FIT_RECIPE")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    /**
     * Поле id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /**
     * Поле названия рецепта
     */
    @Field(store = Store.YES)
    @Column(name = "NAME", nullable = false)
    private String name;

    /**
     * Поле описания рецепта
     */
    @Field(store = Store.YES)
    @Column(name = "UNIQUE_RECIPE_FIELD")
    private String uniqueRecipeField;

    /**
     * Поле количества калорий в блюде
     */
    @Field(store = Store.YES)
    @Column(name = "CALORIES")
    private int calories;

    /**
     * Поле количества белков в блюде
     */
    @Field(store = Store.YES)
    @Column(name = "PROTEINS")
    private int proteins;

    /**
     * Поле количества жиров в блюде
     */
    @Field(store = Store.YES)
    @Column(name = "FAT")
    private int fat;

    /**
     * Поле количества углеводов в блюде
     */
    @Field(store = Store.YES)
    @Column(name = "CARBOHYDRATES")
    private int carbohydrates;

    /**
     * Поле времени приема пищи (завтрак - обед - ужин)
     */
    @Field(store = Store.YES)
    @Column(name = "MEALS")
    private String meals;

    /**
     * Поле рейтинга рецепта
     */
    @Field(store = Store.YES)
    @Column(name = "RATING")
    private int rating;

    @NoArgsConstructor
    public enum Meal{
        BREAKFAST,
        DINNER,
        LUNCH
    }
}