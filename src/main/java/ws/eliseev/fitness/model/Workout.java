package ws.eliseev.fitness.model;

import lombok.*;

import javax.persistence.*;

/**
 * Сущность Workout и сопоставление с БД
 * @author Корнеев Аркадий
 */

//@Getter
//@Setter
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "WORKOUT")
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

        public String getExercise() {
                return exercise;
        }

        public void setExercise(String exercise) {
                this.exercise = exercise;
        }

        public int getRepeat() {
                return repeat;
        }

        public void setRepeat(int repeat) {
                this.repeat = repeat;
        }

        public int getSet() {
                return set;
        }

        public void setSet(int set) {
                this.set = set;
        }

        public Area getArea() {
                return area;
        }

        public void setArea(Area area) {
                this.area = area;
        }

}


