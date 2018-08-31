package com.exochain.myproject.features.homepage;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Locale;

@Controller
@SessionAttributes(names = {"visitor"})
public class RootController {
    // Just for demonstration purposes of adding a UUID to Session and Tracking
    private static final TimeBasedGenerator UUID_GENERATOR = Generators.timeBasedGenerator();

    @ModelAttribute("visitor")
    public TestVisitor createTestVisitorObject(HttpSession httpSession) {
        Instant i = Instant.ofEpochMilli(httpSession.getCreationTime());
        ZonedDateTime sessionStart = ZonedDateTime.ofInstant(i, ZoneOffset.UTC);

        return new TestVisitor(UUID_GENERATOR.generate().toString(), sessionStart);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Locale locale, Model model) {
        return "index";
    }
}
