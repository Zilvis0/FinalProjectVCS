package lt.vcs.final_project.exercise_repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExercisePoolRepository extends CrudRepository<Exercise, Integer> {

    @Query(value = "SELECT * FROM exercise_pool WHERE exercise_name LIKE :name", nativeQuery = true)
    List<Exercise> getExerciseLike(String name);

}
