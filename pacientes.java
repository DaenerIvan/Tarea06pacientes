/*
 */
package tarea06pacientes;

import java.io.Serializable;

public class pacientes implements Serializable{
    private static final long serialVersionUID = 1L;
    //atributos
    private String habitacionCama;
    private String nombre;
    private String apellidos;
    private String dieta;
    

//Constructor
public pacientes (String habitacionCama, String nombre, String apellidos, String dieta){
    this.habitacionCama = habitacionCama;
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.dieta = dieta;
}
//getters y setters
public String gethabitacionCama()
{
    return habitacionCama;
}
public void sethabitacionCama(String habitacionCama)
{
    this.habitacionCama= habitacionCama;
}
public String getnombre()
{
    return nombre;
}
public void setnombre(String nombre)
{
    this.nombre= nombre;
}
public String getapellidos()
{
    return apellidos;
}
public void setapellidos(String apellidos)
{
    this.apellidos= apellidos;
}
public String getdieta()
{
    return dieta;
}
public void setdieta(String dieta)
{
    this.dieta= dieta;
}
@Override
public String toString()
{
    return "Datos de paciente: Habitacion-cama: " + habitacionCama + "Nombre: " + nombre + "Apellidos: " + apellidos + "Dieta: " + dieta;
}
}
