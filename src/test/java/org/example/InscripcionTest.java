package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {
    @Test
    @DisplayName("Prueba acepta/rechaza inscripción correctamente")
    public void testeoFuncionAprobada() {

        //Creacion de muestra de datos

        //Creacion de materias
        Materia materia1 = new Materia("AM1", new ArrayList<>());
        Materia materia2 = new Materia("Fisica1", new ArrayList<>());
        Materia materiaConCorrelativa1 = new Materia("AM2", new ArrayList<>());
        Materia materiaConCorrelativa2 = new Materia("Fisica2", new ArrayList<>());
        Materia materia5 = new Materia("AGA", new ArrayList<>());

        //Adición de correlativas a las materias que lo requieren
        materiaConCorrelativa1.agregarCorrelativas(materia1);
        materiaConCorrelativa2.agregarCorrelativas(materia2);

        //Creacion de grupos de materias de los alumnos y para la inscripcion
        List<Materia> grupoMaterias1 = new ArrayList<Materia>();
        List<Materia> grupoMaterias2 = new ArrayList<Materia>();
        List<Materia> grupoMateriasACursar = new ArrayList<Materia>();

        //Grupo que contiene AM1 y Fisica 1
        grupoMaterias1.add(materia1);
        grupoMaterias1.add(materia2);

        //Grupo que contiene AM1 y AGA
        grupoMaterias2.add(materia1);
        grupoMaterias2.add(materia5);

        //Materias a cursar contiene AM2 y Fisica 2
        grupoMateriasACursar.add(materiaConCorrelativa1);
        grupoMateriasACursar.add(materiaConCorrelativa2);

        //Creacion de alumnos
        Alumno alumnoConCorrelativas = new Alumno(grupoMaterias1, "Tomas"); //Este estudiante tiene aprobadas AM1 y Fisica 1
        Alumno alumnoSinCorrelativas = new Alumno(grupoMaterias2, "Franco"); //Este estudiante tiene aprobadas AM1 y AGA

        //Creacion de inscripciones (Ambos estudiantes se inscriben para cursar AM2 y Fisica 2)
        Inscripcion inscripcion1 = new Inscripcion(grupoMateriasACursar, alumnoConCorrelativas);
        Inscripcion inscripcion2 = new Inscripcion(grupoMateriasACursar, alumnoSinCorrelativas);

        //Asserts
        assertTrue(inscripcion1.aprobada()); //Estudiante con las correlativas aprobadas devuelve true
        assertFalse(inscripcion2.aprobada()); //Estudiante sin las correlativas aprobadas devuelve false
    }
}
