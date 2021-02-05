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

        String result = "";
        int compChoice = (int) Math.floor(Math.random() * 3);
        int res = 0; //0 means computer wins, 1 means tie, 2 means player wins
        String compGesture = "";
        if (compChoice == 0){
            compGesture = "rock";
            switch (gesture) {
                case "rock":
                    res = 1;
                    break;
                case "paper":
                    res = 2;
                    break;
                case "scissors":
                    res = 0;
                    break;
                }
            }
        else if (compChoice == 1){
            compGesture = "paper";
            switch (gesture) {
                case "rock":
                    res = 0;
                    break;
                case "paper":
                    res = 1;
                    break;
                case "scissors":
                    res = 2;
                    break;
            }
        }
        else {
            compGesture = "scissors";
            switch (gesture) {
                case "rock":
                    res = 2;
                    break;
                case "paper":
                    res = 0;
                    break;
                case "scissors":
                    res = 1;
                    break;
            }
        }

        if (gesture == "") {
            gesture = "undecided";
            res = 0;
        }

        if (res == 0){
            result = "computer wins!";
        }
        else if (res == 2) {
            result = "you win!";
        }
        else if (res == 1){
            result = "tie!";
        }
        else{
            result = "computer wins by default!";
            gesture = "undecided";
        }

        model.addAttribute("player", gesture);
        model.addAttribute("computer", compGesture);
        model.addAttribute("result", result);

        return "Results";
    }
}
