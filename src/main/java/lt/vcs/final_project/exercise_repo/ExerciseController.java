package lt.vcs.final_project.exercise_repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

//    http://localhost:8080/exercises/all
    @GetMapping(path = "/all")
    public String fetchAllExercises(Model model){
        List<Exercise> list = exerciseService.getAllExercises();
        model.addAttribute("exercise_list", list);
        return "/exercise_pool/exercise_pool";
    }

}
