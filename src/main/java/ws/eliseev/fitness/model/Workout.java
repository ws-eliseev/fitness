package ws.eliseev.fitness.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "workout")
public class Workout implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private long id;

        @Column(name="name", nullable = false)
        private String name;

        @Column(name="exercises")
        private String exercises;

        @Column(name="time")
        private Time time;

        @Column(name="repeat")
        private int repeat;

        @Column(name="set")
        private int set;

        @Column(name = "area")
        @Enumerated(EnumType.STRING)
        private Area area;

        public Workout(long id, String name, String exercises, Time time, int repeat, int set, Area area) {
                this.id = id;
                this.name = name;
                this.exercises = exercises;
                this.time = time;
                this.repeat = repeat;
                this.set = set;
                this.area = area;
        }

        public Workout() {
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getExercises() {
                return exercises;
        }

        public void setExercises(String exercises) {
                this.exercises = exercises;
        }

        public Time getTime() {
                return time;
        }

        public void setTime(Time time) {
                this.time = time;
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

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Workout workout = (Workout) o;

                if (repeat != workout.repeat) return false;
                if (set != workout.set) return false;
                if (name != null ? !name.equals(workout.name) : workout.name != null) return false;
                if (exercises != null ? !exercises.equals(workout.exercises) : workout.exercises != null) return false;
                if (time != null ? !time.equals(workout.time) : workout.time != null) return false;
                return area == workout.area;
        }

        @Override
        public int hashCode() {
                int result = (int) (id ^ (id >>> 32));
                result = 31 * result + (name != null ? name.hashCode() : 0);
                result = 31 * result + (exercises != null ? exercises.hashCode() : 0);
                result = 31 * result + (time != null ? time.hashCode() : 0);
                result = 31 * result + repeat;
                result = 31 * result + set;
                result = 31 * result + (area != null ? area.hashCode() : 0);
                return result;
        }
}
