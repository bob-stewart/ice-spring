package com.exochain.ice.features.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

import com.exochain.ice.Card;
import com.exochain.ice.IDB;

@RestController
@RequestMapping("/api/v0")
public class APIController {

    @Autowired
    private IDB db;

    @RequestMapping(value = {"/", "/create"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String createCard(@RequestBody Card card) {
        return "{\"id\":" + db.addCard(card) + "}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateCard(@PathVariable String id, @RequestBody Card card) {
        db.updateCard(id, card);
        return "{\"success\": \"updated\"}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Card getCard(@PathVariable String id) {
        return db.getCard(id);
    }

}

