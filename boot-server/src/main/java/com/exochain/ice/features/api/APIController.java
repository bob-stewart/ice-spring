package com.exochain.ice.features.homepage;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Locale;

import com.exochain.ice.model.Card;
import com.exochain.ice.IDB;

class TestObject {
    public String hello;
    public String there;
    public String friend;
}

@RestController
@SessionAttributes(names = {"visitor"})
@RequestMapping("/api/v0")
public class APIController {
    // Just for demonstration purposes of adding a UUID to Session and Tracking
    private static final TimeBasedGenerator UUID_GENERATOR = Generators.timeBasedGenerator();

    private MockDB db;

    public APIController() {
        db = new MockDB();
    }

    @ModelAttribute("visitor")
    public TestVisitor createTestVisitorObject(HttpSession httpSession) {
        Instant i = Instant.ofEpochMilli(httpSession.getCreationTime());
        ZonedDateTime sessionStart = ZonedDateTime.ofInstant(i, ZoneOffset.UTC);

        return new TestVisitor(UUID_GENERATOR.generate().toString(), sessionStart);
    }

    @RequestMapping(value = "/visitor", method = RequestMethod.GET)
    public TestObject homePage(Locale locale, Model model) {
        TestObject test = new TestObject();
        test.hello = "Hello ";
        test.there = "there, ";
        test.friend = "friend.";
        return test;
    }

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

