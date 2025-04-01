package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Alumno {
    private List<Materia> materiasAprobadas = new ArrayList<>();
    private String nombre;

    public Alumno(List<Materia> materiasAprobadas, String nombre) {
        this.materiasAprobadas = materiasAprobadas;
        this.nombre = nombre;
    }

    public void agregarMaterias(Materia ... materias){
        Collections.addAll(this.materiasAprobadas, materias);
    }
}