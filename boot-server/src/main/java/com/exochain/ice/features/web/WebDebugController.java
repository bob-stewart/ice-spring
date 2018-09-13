package com.exochain.ice.features.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.ui.ModelMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

class DebugTest {
    private String field = "Wooowee";
    public String toString() {
        return "testie " + field;
    }
    public String getField() {
        return field;
    }
}

@Controller
@RequestMapping("/debug")
public class WebDebugController {

    @RequestMapping(value = "ftl", method = RequestMethod.GET)
    public ModelAndView ftlTestPage(Model model) {
        DebugTest test = new DebugTest();
        ModelAndView mnv = new ModelAndView("debug");
        mnv.addObject("test", test);
        return mnv;
    }

}

