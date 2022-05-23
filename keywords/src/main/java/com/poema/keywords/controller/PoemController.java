package com.poema.keywords.controller;


import com.poema.keywords.service.Poem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/poem")
public class PoemController {


    @Autowired
    Poem poem;


    @PostMapping("/create")
    public String create(){

        try {
            return poem.createPoem();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
