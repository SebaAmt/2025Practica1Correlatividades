package org.example;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Inscripcion {
    private List<Materia> materias = new ArrayList<>();
    private Alumno alumno;

    public Inscripcion(List<Materia> materias, Alumno alumno) {
        this.materias = materias;
        this.alumno = alumno;
    }

    public void agregarMaterias(Materia ... materias) {
        Collections.addAll(this.materias, materias);
    }

    public void eliminarMateria(Materia materia) {
        materias.remove(materia);
    }

    public boolean aprobada() {
        List<Materia> materiasDelAlumno = this.alumno.getMateriasAprobadas();
        List<Materia> correlativasDeMateriasInscriptas = this.getMaterias().stream()
                .flatMap(materia -> materia.getMateriasCorrelativas().stream())
                .collect(Collectors.toList());


        return materiasDelAlumno.containsAll(correlativasDeMateriasInscriptas);
    }

}
