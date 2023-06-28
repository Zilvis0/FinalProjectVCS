package lt.vcs.final_project.program_exercise_repo;

import lt.vcs.final_project.program_repo.Program;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProgramExercisesRepository extends CrudRepository<ProgramExercises, Integer> {

    @Query(value = "SELECT * FROM programs WHERE program_name LIKE :name", nativeQuery = true)
    List<Program> getProgramExercisesLikeName(String name);

    @Modifying
    @Query(value = "DELETE FROM program_exercises WHERE program_id = :programId AND exercise_id = :exerciseId", nativeQuery = true)
    void deleteByProgramAndExercise(@Param("programId") int programId, @Param("exerciseId") int exerciseId);


}
