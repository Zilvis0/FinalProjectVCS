package lt.vcs.final_project.program_exercise_repo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lt.vcs.final_project.exercise_repo.Exercise;
import lt.vcs.final_project.program_repo.Program;

@Entity
@Table(name = "program_exercises")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProgramExercises {

    @EmbeddedId
    private ProgramExercisesId id;

    @ManyToOne
    @JoinColumn(name = "programId", insertable=false, updatable=false)
    private Program program;

    @ManyToOne
    @JoinColumn(name = "exerciseId", insertable=false, updatable=false)
    private Exercise exercise;

    public ProgramExercises(Program program, Exercise exercise) {
        this.program = program;
        this.exercise = exercise;
        this.id = new ProgramExercisesId(program.getId(), exercise.getId());
    }
}
