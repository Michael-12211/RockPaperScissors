package ca.sheridancollege.kempemi.assignment1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChoiceController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping ("determineWinner")
    public String determineResults(Model model, @RequestParam("gesture") String gesture){

        model.addAttribute("player", gesture);
        model.addAttribute("computer", "unkown");
        model.addAttribute("result", "unkown");

        return "Results";
    }
}
