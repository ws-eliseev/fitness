package ws.eliseev.fitness.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Table(name = "FIT_RECIPE")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    /** Поле id - Первичный ключ, генерация IDENTITY*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /** Поле наименования рецепта */
    @Column(name = "NAME", nullable = false)
    private String name;

    /** Поле имени уникального  рецепта */
    @Column(name = "UNIQUE_RECIPE_FIELD")
    private String uniqueRecipeField;

    /** Поле количества калорий */
    @Column(name = "CALORIES")
    private int calories;

    /** Поле количества белков */
    @Column(name = "PROTEINS")
    private int proteins;

    /** Поле количества жиров */
    @Column(name = "FAT")
    private int fat;

    /** Поле количества углеводов */
    @Column(name = "CARBOHYDRATES")
    private int carbohydrates;

    /** Поле для указания ингредиентов */
    @ManyToMany
    @JoinTable(
            name = "FIT_RECIPE_INGREDIENT"
            , joinColumns = @JoinColumn(name = "RECIPE_ID")
            , inverseJoinColumns = @JoinColumn(name = "INGREDIENT_ID"))
    private Set <Ingredient> ingredients = new HashSet<>() ;

    /** Поле изображения рецепта */
    @Column(name = "IMAGE")
    private String image;

}