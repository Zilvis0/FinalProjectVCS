package lt.vcs.final_project.exercise_repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {
    @Autowired
    private ExercisePoolRepository exercisePoolRepository;

    public List<Exercise> getAllExercises(){return (List<Exercise>) exercisePoolRepository.findAll();}

    public Exercise getExerciseById(int id){
        return exercisePoolRepository.findById(id).get();
    }

    public List<Exercise> getExerciseByName(String name){
        return exercisePoolRepository.getExerciseLike("%" + name + "%");
    }

    public void saveExercise(Exercise exercise){
        exercisePoolRepository.save(exercise);
    }

    public void deleteExercise(int id){
        exercisePoolRepository.deleteById(id);
    }
}
