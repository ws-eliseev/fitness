package ws.eliseev.fitness.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Table(name = "WORKOUT")
@Entity
public class Workout {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        private Long id;

        @Column(name="NAME", nullable = false)
        private String name;

        @Column(name="EXERCISE")
        private String exercise;

        @Column(name="REPEAT")
        private int repeat;

        @Column(name="SET")
        private int set;

        @Column(name = "AREA")
//        @Enumerated(EnumType.STRING)
        private String area;

        @NoArgsConstructor
        enum Area {
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

        public String getArea() {
                return area;
        }

        public void setArea(String area) {
                this.area = area;
        }
}


