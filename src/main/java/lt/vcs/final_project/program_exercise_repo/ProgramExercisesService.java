package lt.vcs.final_project.program_exercise_repo;

import lt.vcs.final_project.exercise_repo.Exercise;
import lt.vcs.final_project.program_repo.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramExercisesService {

    @Autowired
    public ProgramExercisesRepository programExercisesRepository;

    public List<Program> getProgramByName(String name) {
        return programExercisesRepository.getProgramExercisesLikeName("%" + name + "%");
    }

    public void addExerciseToProgram(Program program, Exercise exercise) {
        ProgramExercises programExercises = new ProgramExercises(program, exercise);
        programExercisesRepository.save(programExercises);
    }


    public void removeExerciseFromProgram(Program program, Exercise exercise) {
        programExercisesRepository.deleteByProgramAndExercise(program.getId(), exercise.getId());
    }

}
