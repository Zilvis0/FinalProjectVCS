package lt.vcs.final_project.program_repo;

import lt.vcs.final_project.exercise_repo.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService {
    @Autowired
    public ProgramRepository programRepository;

    public List<Program> getAllPrograms(){return (List<Program>) programRepository.findAll();}

    public Program getProgramById(int id){
        return programRepository.findById(id).get();
    }

    public List<Program> getProgramByName(String name){
        return programRepository.getProgramLikeName("%" + name + "%");
    }

    public void saveProgram(Program program){
        programRepository.save(program);
    }

    public void deleteProgram(int id){
        programRepository.deleteById(id);
    }
}
