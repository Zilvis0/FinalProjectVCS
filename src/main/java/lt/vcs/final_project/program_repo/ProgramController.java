package lt.vcs.final_project.program_repo;

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

    //    http://localhost:8080/programs/all
    @GetMapping(path = "/all")
    public String fetchAllPrograms(Model model){
        List<Program> list = programService.getAllPrograms();
        model.addAttribute("program_list", list);
        return "/programs/programs";
    }

    @GetMapping(path = "/id/{id}")
    public String fetchProgramById(Model model, @PathVariable int id){
        Program program = programService.getProgramById(id);
        model.addAttribute("program_object", program);
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
        model.addAttribute("program_object", program);
        return "/programs/programDetails";
    }
}
