package ws.eliseev.fitness.model;

import lombok.*;

import javax.persistence.*;

/**
 * Сущность Workout и сопоставление с БД
 * @author Корнеев Аркадий
 */

@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "FIT_WORKOUT")
@Entity
public class Workout {

        /** Поле id - Первичный ключ, генерация IDENTITY*/
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        private Long id;

        /** Поле название упражнения */
        @Column(name="NAME", nullable = false)
        private String name;

        /** Поле указания группы мышц */
        @Column(name="EXERCISE")
        private String exercise;

        /** Поле количество повторений */
        @Column(name="REPEAT")
        private int repeat;

        /** Поле количество подходов */
        @Column(name="SET")
        private int set;

        /** Поле месторасположение для занятий
         * @deprecated поле указано как String (по задумке Enum)
         */
        @Column(name = "AREA")
        @Enumerated(EnumType.STRING)
        private Area area;

        /** Вложенный Enum со значениями Дом и Зал*/
        @NoArgsConstructor
        public enum Area {
                HOME,
                GYM;
        }
}


