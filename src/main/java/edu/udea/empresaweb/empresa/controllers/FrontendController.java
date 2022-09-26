package edu.udea.empresaweb.empresa.controllers;

import edu.udea.empresaweb.empresa.entities.User;
import edu.udea.empresaweb.empresa.services.EmployeeService;
import edu.udea.empresaweb.empresa.services.EnterpriseService;
import edu.udea.empresaweb.empresa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FrontendController {

    @Autowired
    private EnterpriseService enterpriseService;

    @Autowired
    private  UserService userService;

    public FrontendController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        if(principal!=null){

            User user = this.userService.getUser(principal.getClaims());
            System.out.println(principal.getClaims());
            model.addAttribute("user", user);
        }
        return "home";
    }

    @GetMapping("/enterprises")
    public String viewPageEnterprise(Model model){
        model.addAttribute("listEnterprises", enterpriseService.getAllEnterprises());
        return "index0";
    }

    /*
    @GetMapping("/employees")
    public String viewPageEmployee(Model model){
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index1";
    }
    */
}
