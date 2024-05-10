package com.example.example4sem6_rikky_and_morty_rest.controller;

import com.example.example4sem6_rikky_and_morty_rest.domain.Characters;
import com.example.example4sem6_rikky_and_morty_rest.domain.Result;
import com.example.example4sem6_rikky_and_morty_rest.service.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ControllerAPI {
    @Autowired
    private ServiceApi serviceApi;

    @GetMapping("/characters")
    public ResponseEntity<Characters> getAllCharacters() {
        Characters allCharacters = serviceApi.getAllCharacters();
        return new ResponseEntity<>(allCharacters, HttpStatus.OK);
    }

    @GetMapping("/character/{id}")
    public ResponseEntity<Result> getCharacterById(@PathVariable Integer id) {
        Result character = serviceApi.getCharacterById(id);
        return new ResponseEntity<>(character, HttpStatus.OK);
    }

    @GetMapping("/characters/name/{name}")
    public ResponseEntity<Characters> getCharacterByName(@PathVariable String name) {
        Characters character = serviceApi.getCharacterByName(name);
        return new ResponseEntity<>(character, HttpStatus.OK);
    }

    @GetMapping("/characters/gender/{gender}")
    public ResponseEntity<Characters> getCharactersByGender(@PathVariable String gender) {
        Characters characters = serviceApi.getCharacterByGender(gender);
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }
}