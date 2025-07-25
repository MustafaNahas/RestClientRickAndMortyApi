package org.example.restclientrickandmortyapi.model;

import lombok.With;

import java.util.List;

@With
public record Charakter(String id,String name, String status, String species) {

}
