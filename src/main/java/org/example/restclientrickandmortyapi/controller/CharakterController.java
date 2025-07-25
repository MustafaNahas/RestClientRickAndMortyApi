package org.example.restclientrickandmortyapi.controller;


import org.example.restclientrickandmortyapi.model.Charakter;
import org.example.restclientrickandmortyapi.service.CharakterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Charakter")
public class CharakterController {
    private final CharakterService charakterService;
    public CharakterController(CharakterService charakterService) {
        this.charakterService = charakterService;

    }
    @GetMapping()
    public List< Charakter> getAllCharakters() {
         return charakterService.getAllCharakters();
    }
    @GetMapping("/{id}")
    public Charakter getCharakterById(@PathVariable int id) {
        return charakterService.getCharakterById(id);
    }
    @GetMapping("/status")
    public List<Charakter> getCharakterByStatus(@RequestParam(required = false) String status) {
        if (status == null) {
            status = "alive";
        }
        return charakterService.getCharakterByStatus(status);

    }
}
