package com.example.JogoGourmet.model;

import lombok.Data;

@Data
public class Dish {

	private String description;
    private Dish next;
    private Dish different;

}
