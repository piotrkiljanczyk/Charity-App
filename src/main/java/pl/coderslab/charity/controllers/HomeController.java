package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.services.interfaces.DonationService;


@Controller
public class HomeController {

    private final DonationService donationService;

    public HomeController(DonationService donationService) {
        this.donationService = donationService;
    }

    @ModelAttribute
    public void sumOfDonationBags(Model model) {
        model.addAttribute("donationBags", donationService.giveDonationBags());
    }

    @ModelAttribute
    public void sumOfDonation(Model model) {
        model.addAttribute("donationSum", donationService.giveDonationSum());
    }

    @RequestMapping({"/", ""})
    public String homeAction(Model model){
        return "general/index";
    }
}
