package ca.sheridancollege.kempemi.assignment1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChoiceController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping ("determineWinner")
    public String determineResults (){
        return "Results";
    }
}
