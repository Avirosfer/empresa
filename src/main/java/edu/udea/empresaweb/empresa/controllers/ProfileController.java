package edu.udea.empresaweb.empresa.controllers;



import edu.udea.empresaweb.empresa.entities.Profile;
import edu.udea.empresaweb.empresa.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class ProfileController {
    @Autowired
    ProfileService profileService;


    @GetMapping("/user/id/profile")
    public String viewPageProfile(Model model){
        model.addAttribute("listProfiles", profileService.getAllProfiles());
        return "index3";
    }
    @GetMapping("/showNewProfileForm")
    public String showNewProfileForm(Model model) {
        // create model attribute to bind form data
        Profile profile = new Profile();
        model.addAttribute("profile", profile);
        return "new_profile";
    }

    @PostMapping("/saveProfile")
    public String saveProfile(@ModelAttribute("profile") Profile profile) {
        // save profile to database
        profileService.saveProfile(profile);
        return "redirect://user/id/profile";
    }

    @GetMapping("/showFormForUpdateProfile/{id}")
    public String showFormForUpdateProfile(@PathVariable( value = "id") String id, Model model) {
        // get profile from the service
        Profile profile = profileService.getProfileById(Long.parseLong(id));

        // set profile as a model attribute to pre-populate the form
        model.addAttribute("profile", profile);
        return "update_profile";
    }

    @GetMapping("/deleteProfile/{id}")
    public String deleteProfile(@PathVariable (value = "id") String id) {
        // call delete profile method
        this.profileService.deleteProfileById(Long.parseLong(id));
        return "redirect://user/id/profile";
    }

}
