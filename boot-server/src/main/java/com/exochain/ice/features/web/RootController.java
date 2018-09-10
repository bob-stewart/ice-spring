package com.exochain.ice.features.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

import com.exochain.ice.model.Card;
import com.exochain.ice.IDB;

@Controller
@SessionAttributes(names = {"visitor"})
public class RootController {

    @Autowired
    private IDB db;

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
    public String makeCardPost(@RequestBody Card card) {
        String id = db.addCard(card).toString();
        return "/" + id + "/print";
    }

}

