package lt.vcs.final_project.program_repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProgramRepository extends CrudRepository<Program, Integer> {

    @Query(value = "SELECT * FROM programs WHERE program_name LIKE :name", nativeQuery = true)
    List<Program> getProgramLikeName(String name);
}
