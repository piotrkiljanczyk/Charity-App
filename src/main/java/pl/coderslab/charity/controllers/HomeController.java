package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.services.interfaces.DonationService;
import pl.coderslab.charity.services.interfaces.InstitutionService;


@Controller
public class HomeController {

    private final DonationService donationService;
    private final InstitutionService institutionService;

    public HomeController(DonationService donationService, InstitutionService institutionService) {
        this.donationService = donationService;
        this.institutionService = institutionService;
    }

    @ModelAttribute
    public void sumOfDonationBags(Model model) {
        model.addAttribute("donationBags", donationService.giveDonationBags());
    }

    @ModelAttribute
    public void sumOfDonation(Model model) {
        model.addAttribute("donationSum", donationService.giveDonationSum());
    }

    @ModelAttribute
    public void addListOfInstitutions(Model model) {
        model.addAttribute("institutions", institutionService.findAll());
    }

    @RequestMapping({"/", ""})
    public String homeAction(Model model){
        return "general/index";
    }
}
