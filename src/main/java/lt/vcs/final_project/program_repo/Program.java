package lt.vcs.final_project.program_repo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "programs")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "program_name")
    private String programName;

    public Program(String programName) {
        this.programName = programName;
    }
}
