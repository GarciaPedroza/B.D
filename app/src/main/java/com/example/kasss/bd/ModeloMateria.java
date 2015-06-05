package com.example.kasss.bd;

/**
 * Created by USUARIO on 28/05/2015.
 */
public class ModeloMateria {


    private String id_materia;
    private String nombre;
    private String creditos;
    private String semestre;

    public String getId_materia()  {
        return id_materia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCreditos() {
        return creditos;
    }

    public String getSemestre() {
        return semestre;
    }

    public ModeloMateria(String id_materia, String nombre , String creditos, String semestre){
        this.id_materia = id_materia;
        this.nombre = nombre;
        this.creditos = creditos;
        this.semestre = semestre;
    }

}


