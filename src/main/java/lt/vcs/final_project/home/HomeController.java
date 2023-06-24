package lt.vcs.final_project.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/SportSite")
public class HomeController {

    // http://localhost:8080/SportSite/home
    @GetMapping(path = "/home")
    public String displayHome(){return "home";}
}
