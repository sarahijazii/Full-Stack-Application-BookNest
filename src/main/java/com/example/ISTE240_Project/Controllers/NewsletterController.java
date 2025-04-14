package com.example.ISTE240_Project.Controllers;

import com.example.ISTE240_Project.Services.NewsletterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NewsletterController {

    private final NewsletterService newsletterService;

    public NewsletterController(NewsletterService newsletterService) {
        this.newsletterService = newsletterService;
    }

    @PostMapping("/subscribe")
    public String subscribe(@RequestParam String email, Model model, RedirectAttributes redirectAttributes) {
        boolean alreadySubscribed = newsletterService.existsByEmail(email);

        if (alreadySubscribed) {
            redirectAttributes.addFlashAttribute("subscribed", false);
            redirectAttributes.addFlashAttribute("subscribeFailed", true);
        } else {
            newsletterService.save(email);
            redirectAttributes.addFlashAttribute("subscribed", true);
        }

        return "redirect:/home";
    }
}
