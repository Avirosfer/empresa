package edu.udea.empresaweb.empresa.controllers;


import edu.udea.empresaweb.empresa.entities.Enterprise;
import edu.udea.empresaweb.empresa.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
    public class EnterpriseController {
    @Autowired
    EnterpriseService enterpriseService;


   /* @GetMapping("/enterprises")
    public String viewPageEnterprise(Model model, @AuthenticationPrincipal OidcUser principal){
        model.addAttribute("listEnterprises", enterpriseService.getAllEnterprises());
        return "index0";
    }

    */

    @GetMapping("/NewEnterpriseForm")
    public String showNewEnterpriseForm(Model model) {
        // create model attribute to bind form data
        Enterprise enterprise = new Enterprise();
        model.addAttribute("enterprise", enterprise);
        return "new_enterprise";
    }


    @PostMapping("/saveEnterprise")
    @DateTimeFormat(pattern="dd-MM-yyyy")
    public String saveEnterprise(@ModelAttribute("enterprise") Enterprise enterprise) {
        // save enterprise to database
        enterpriseService.saveEnterprise(enterprise);
        return "redirect:/enterprises";
    }

    @GetMapping("/UpdateEnterprise/{id}")
    public String showFormForUpdateEnterprise(@PathVariable ( value = "id") long id, Model model) {
        // get enterprise from the service
        Enterprise enterprise = enterpriseService.getEnterpriseById(id);

        // set enterprise as a model attribute to pre-populate the form
        model.addAttribute("enterprise", enterprise);
        return "update_enterprise";
    }

    @GetMapping("/deleteEnterprise/{id}")
    public String deleteEnterprise(@PathVariable (value = "id") long id) {
        // call delete enterprise method
        this.enterpriseService.deleteEnterpriseById(id);
        return "redirect:/enterprises";
    }
}























