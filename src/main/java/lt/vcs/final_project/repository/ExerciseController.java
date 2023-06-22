package lt.vcs.final_project.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/SportSite")
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;

    // http://localhost:8080/SportSite/home
    @GetMapping(path = "/home")
    public String displayHome(){return "home";}
}
