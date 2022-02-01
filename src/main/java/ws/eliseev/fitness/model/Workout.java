package ws.eliseev.fitness.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@Table(name = "WORKOUT")
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

}


