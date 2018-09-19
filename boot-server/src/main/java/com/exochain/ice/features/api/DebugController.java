package com.exochain.ice.features.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.util.LinkedMultiValueMap;

import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.exochain.ice.Card;
import com.exochain.ice.IDB;

@RestController
@RequestMapping("/api/debug")
public class DebugController {

    @Autowired
    private IDB db;

    @RequestMapping(value = "/{id}/query-string", method = RequestMethod.GET)
    public String getCard(@PathVariable String id) {
        Card card = db.getCard(id);
        String queryString = UriComponentsBuilder.fromHttpUrl("http://testthis.com")
            .queryParams(new ObjectMapper().convertValue(card, LinkedMultiValueMap.class))
            .build()
            .toUri()
            .toString();
        return queryString;
    }

}

