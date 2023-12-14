package br.com.NinjaVortex.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Jutso {
    private String jutso;
    private String descricao;
    private String tipo;
    private String dificuldade;

}
