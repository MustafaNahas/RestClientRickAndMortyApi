package org.example.restclientrickandmortyapi.service;


import org.example.restclientrickandmortyapi.model.Charakter;
import org.example.restclientrickandmortyapi.model.CharakterData;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CharakterService {

    private final RestClient restClient;

    public CharakterService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("https://rickandmortyapi.com/api").build();
    }

    public List<Charakter> getAllCharakters( ) {
        List<Charakter> charakterList=   restClient.get()
                .uri("/character?page=2")
                .retrieve()
                .body(CharakterData.class).results();

        return charakterList;
    }
    public Charakter getCharakterById(int id) {
        Charakter  charakter=restClient.get()
                .uri("/character/"+id)
                .retrieve()
                .body(Charakter.class);
        return charakter;
    }
    public List<Charakter> getCharakterByStatus(@RequestParam String status) {
        List<Charakter> charakterList=   restClient.get()
                .uri("/character?status="+status)
                .retrieve()
                .body(CharakterData.class).results();

        return charakterList;
    }
}
