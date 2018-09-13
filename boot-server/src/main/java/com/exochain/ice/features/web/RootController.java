package com.exochain.ice.features.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.exochain.ice.model.Card;
import com.exochain.ice.IDB;

@Controller
@SessionAttributes(names = {"visitor"})
public class RootController {

    @Autowired
    private IDB db;

    @Value("${api.base}")
    private String baseURL;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greetingPage() {
        return "greeting";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String makeCardPage() {
        return "make-card";
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.FOUND)
    public RedirectView makeCardPost(@RequestParam HashMap<String, String> cardData) {
        Card card = new Card(cardData);
        String id = db.addCard(card).toString();
        // return new RedirectView("/api/v0/" + id); // TODO: Create print page and redirect there
        return new RedirectView("/" + id + "/print"); // ie use this
    }

    @RequestMapping(value = "/{id}/print", method = RequestMethod.GET)
    public String printCardPage(ModelMap model, @PathVariable String id) {
        Card card = db.getCard(id);
        model.addAttribute("card", card);
        model.addAttribute("baseURL", baseURL);
        return "print-card";
    }

}

