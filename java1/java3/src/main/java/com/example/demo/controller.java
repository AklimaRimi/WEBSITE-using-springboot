package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@Controller
public class controller {
    @Autowired
    private service serve;

    @GetMapping("/home")
    public String index(Model model)
    {
        return "home";
    }


    @GetMapping("/customers")
    public String display(Model model)
    {
        model.addAttribute("list",serve.listall());
        return "display";
    }

    @GetMapping("/login")
    public String login(Model model)
    {
        return "sing in";
    }







    @GetMapping("/showNewForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        attributes att = new attributes();
        model.addAttribute("list", att);
        return "new-user";
    }

    @PostMapping("/saveuser")
    public String saveEmployee(@ModelAttribute("list") attributes att){

        serve.save(att);
        return "Welcome";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id")Long id,Model model)
    {
        attributes att = serve .get(id);
        model.addAttribute("list",att);
        return "update";
    }

    @GetMapping("/deleteuser/{id}")
    public String deleteuser(@PathVariable(value = "id")Long id)
    {
        serve.deleteBy(id);
        return "redirect:/customers";

    }

    @PostMapping("/find")
    public String findbymail(  @RequestParam ("email") String email,  @RequestParam("password") String password)
    {
        int list = serve.fin(email, password);
        if(list==1)
        {
            return "welcome";
        }
        else
        {
            return "redirect:/customers";
        }

    }

    @GetMapping("/call")
    public String call()
    {return "call";}


}
