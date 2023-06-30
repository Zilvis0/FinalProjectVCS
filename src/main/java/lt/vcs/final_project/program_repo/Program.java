package lt.vcs.final_project.program_repo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lt.vcs.final_project.exercise_repo.Exercise;

import java.util.List;

@Entity
@Table(name = "programs")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id")
    private Integer id;

    @Column(name = "program_name")
    private String programName;

    @ManyToMany
    @JoinTable(
            name = "program_exercises",
            joinColumns = @JoinColumn(name = "program_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id")
    )
    private List<Exercise> exercises;

    public Program(String programName) {
        this.programName = programName;
    }
}
