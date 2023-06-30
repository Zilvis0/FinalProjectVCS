package lt.vcs.final_project.exercise_repo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lt.vcs.final_project.program_repo.Program;

import java.util.List;

@Entity
@Table(name = "exercise_pool")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Integer id;

    @Column(name = "exercise_name")
    private String exerciseName;

    @Column(name = "exercise_description")
    private String exerciseDescription;

    @Column(name = "is_equipment_needed")
    private Boolean isEquipmentNeeded;

    @ManyToMany(mappedBy = "exercises")
    private List<Program> programs;


    public Exercise(String exerciseName, String exerciseDescription, Boolean isEquipmentNeeded) {
        this.exerciseName = exerciseName;
        this.exerciseDescription = exerciseDescription;
        this.isEquipmentNeeded = isEquipmentNeeded;
    }
}
