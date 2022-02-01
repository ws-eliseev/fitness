package ws.eliseev.fitness.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutDto {

    private Long id;

    private String name;

    private String exercise;

    private int set;

    private int repeat;

    private String area;
}
