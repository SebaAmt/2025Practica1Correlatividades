package org.example;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter

public class Materia {
    private String nombre;
    private List<Materia> materiasCorrelativas = new ArrayList<>();

    public Materia(String nombre, List<Materia> materiasCorrelativas) {
        this.nombre = nombre;
        this.materiasCorrelativas = materiasCorrelativas;
    }


    public void agregarCorrelativas(Materia ... materias) {
        Collections.addAll(this.materiasCorrelativas, materias);
    }

    public void eliminarCorrelativa(Materia materia){
        this.materiasCorrelativas.remove(materia);
    }
}