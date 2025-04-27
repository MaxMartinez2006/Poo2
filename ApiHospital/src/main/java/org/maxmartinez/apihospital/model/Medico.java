package org.maxmartinez.apihospital.model;

import jakarta.persistence.*;
@Entity
@Table (name = "medicos")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombre;
    private String apellido;
    private String especialidad;
    private Long id;
    private  String sexo;

    //constructor vacio


    public Medico() {
    }

    //constructores

    public Medico(String nombre, String apellido, String especialidad, int id, String sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.id = (long) id;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = (long) id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Medico{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append(", especialidad='").append(especialidad).append('\'');
        sb.append(", id=").append(id);
        sb.append(", sexo='").append(sexo).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
