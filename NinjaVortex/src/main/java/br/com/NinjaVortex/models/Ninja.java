package br.com.NinjaVortex.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Ninja {
    private int id;
    private String name;
    private String rank;
    private List<Jutso> jutsos;
    private String elemento;

}
