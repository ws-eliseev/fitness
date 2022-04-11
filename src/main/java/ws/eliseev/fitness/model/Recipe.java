package ws.eliseev.fitness.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@Entity
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
    private String name;

    /**
     * Поле имени уникального  рецепта
     */
    @Column(name = "UNIQUE_RECIPE_FIELD")
    private String uniqueRecipeField;

    /**
     * Поле количества калорий
     */
    @Column(name = "CALORIES")
    private double calories;

    /**
     * Поле количества белков
     */
    @Column(name = "PROTEINS")
    private double proteins;

    /**
     * Поле количества жиров
     */
    @Column(name = "FAT")
    private double fat;

    /**
     * Поле количества углеводов
     */
    @Column(name = "CARBOHYDRATES")
    private double carbohydrates;

    /**
     * Поле для указания ингредиентов
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "FIT_RECIPE_INGREDIENT"
            , joinColumns = @JoinColumn(name = "RECIPE_ID")
            , inverseJoinColumns = @JoinColumn(name = "INGREDIENT_ID"))
    @Fetch(FetchMode.JOIN)
    private Set<Ingredient> ingredients;

    /**
     * Поле изображения рецепта
     */
    @Column(name = "IMAGE")
    private String image;

}