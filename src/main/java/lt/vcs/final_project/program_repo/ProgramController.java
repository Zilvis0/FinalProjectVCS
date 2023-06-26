package lt.vcs.final_project.program_repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/programs")
public class ProgramController {
    @Autowired
    public ProgramService programService;

    //    http://localhost:8080/programs/all
    @GetMapping(path = "/all")
    public String fetchAllPrograms(Model model){
        List<Program> list = programService.getAllPrograms();
        model.addAttribute("program_list", list);
        return "/programs/programs";
    }
}
