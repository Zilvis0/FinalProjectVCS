package lt.vcs.final_project.program_repo;

import lt.vcs.final_project.exercise_repo.Exercise;
import lt.vcs.final_project.exercise_repo.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/programs")
public class ProgramController {

    @Autowired
    public ProgramService programService;

    @Autowired
    public ExerciseService exerciseService;

    public ProgramController(ProgramService programService, ExerciseService exerciseService) {
        this.programService = programService;
        this.exerciseService = exerciseService;
    }

    @PostMapping("/id/{programId}/add-exercise")
    public String addExerciseToProgram(@PathVariable("programId") Integer programId,
                                       @RequestParam("exerciseId") Integer exerciseId) {
        Program program = programService.getProgramById(programId);
        Exercise exercise = exerciseService.getExerciseById(exerciseId);

        if (program != null && exercise != null) {
            program.getExercises().add(exercise);
            programService.saveProgram(program);
        }

        return "redirect:/programs/id/" + programId;
    }

    @GetMapping("/id/{programId}/delete-exercise")
    public String deleteExerciseFromProgram(@PathVariable("programId") Integer programId,
                                            @RequestParam("exerciseId") Integer exerciseId) {
        Program program = programService.getProgramById(programId);
        Exercise exercise = exerciseService.getExerciseById(exerciseId);

        if (program != null && exercise != null) {
            program.getExercises().remove(exercise);
            programService.saveProgram(program);
        }

        return "redirect:/programs/id/" + programId;
    }


    //    http://localhost:8080/programs/all

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String loadProgramsPage(Model model){
        model.addAttribute("key_program", new Program());

        List<Program> programList = programService.getAllPrograms();
        model.addAttribute("key_program_list", programList);

        return "/programs/programs";
    }
    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public String searchProgramsByName(
            Model model,
            @ModelAttribute(value = "key_program") Program program
    ){

        List<Program> list = programService.getProgramByName(program.getProgramName());

        model.addAttribute("key_program_list", list);
        return "/programs/programs";
    }

    @GetMapping(path = "/id/{id}")
    public String fetchProgramById(Model model, @PathVariable int id){

        Program program = programService.getProgramById(id);
        model.addAttribute("program_object", program);

        List<Exercise>exerciseList = exerciseService.getAllExercises();
        model.addAttribute("key_exercise_list", exerciseList);
        return "/programs/programDetails";
    }

    //    http://localhost:8080/programs/new
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String createProgram(Model model)
            {
        model.addAttribute("key_program", new Program());
        return "/programs/newProgram";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createProgram(
            Model model,
            @ModelAttribute(value = "key_program") Program program
    ){
        programService.saveProgram(program);
        return "redirect:/programs/id/" + program.getId();
    }

}
