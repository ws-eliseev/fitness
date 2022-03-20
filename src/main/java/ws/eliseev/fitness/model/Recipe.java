package ws.eliseev.fitness.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
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
    @Column(name = "NAME", nullable = false)
    private String name;

    /**
     * Поле описания рецепта
     */
    @Column(name = "UNIQUE_RECIPE_FIELD")
    private String uniqueRecipeField;

    /**
     * Поле количества калорий в блюде
     */
    @Column(name = "CALORIES")
    private int calories;

    /**
     * Поле количества белков в блюде
     */
    @Column(name = "PROTEINS")
    private int proteins;

    /**
     * Поле количества жиров в блюде
     */
    @Column(name = "FAT")
    private int fat;

    /**
     * Поле количества углеводов в блюде
     */
    @Column(name = "CARBOHYDRATES")
    private int carbohydrates;

    /**
     * Поле времени приема пищи (завтрак - обед - ужин)
     */
    @Column(name = "MEALS")
    private String meals;

    /**
     * Поле рейтинга рецепта
     */
    @Column(name = "RATING")
    private int rating;
}