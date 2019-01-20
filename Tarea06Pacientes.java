/*
 */
package tarea06pacientes;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Iván
 */

public class Tarea06Pacientes {

    public static void main(String[] args) throws IOException, ClassNotFoundException, EOFException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        Scanner linea = new Scanner (System.in);
        boolean bandera = false;
        int opc = 0;
        File fichero = new File("pacientes.dat");
        pacientes obj_p = null;
        while (!bandera)
        {
            try{
            System.out.println("*=================Menú=================*");
            System.out.println("    1. Añadir paciente");
            System.out.println("    2. Listar pacientes");
            System.out.println("    3. Buscar paciente");
            System.out.println("    4.Borrar fichero de datos paciente.dat");
            System.out.println("    5.Salir");
            System.out.println("Que desea realizar: ");
            opc= linea.nextInt();
            }catch(InputMismatchException e)
                    {
                        //teclado.reset();
                        System.out.print("Debes introducir un número del menú");
                    }
            switch (opc) {
                case 1:
                    if (fichero.exists())
                    {
                System.out.println("---------------Introducir Datos del paciente--------------");
                System.out.println("Introduce la habitación-cama: ");
                String habitacionCama = teclado.readLine();
                System.out.println("Introduce el nombre del paciente: ");
                String nombre = teclado.readLine();
                System.out.println("Introduce los apellidos del paciente: ");
                String apellidos = teclado.readLine();
                System.out.println("Introuce la dieta: ");
                String dieta = teclado.readLine();
                obj_p = new pacientes(habitacionCama, nombre, apellidos, dieta);
                    }
                    else
                    {
                        File crear = new File("pacientes.dat");
                        crear.createNewFile();
                        System.out.println("El archivo pacientes.dat ha sido creado");
                    }
                if (fichero.exists())
                {
                try{
                MiObjectOutputStream oos= new MiObjectOutputStream(new FileOutputStream(fichero,true));
                oos.writeObject(obj_p);
                oos.close();
                }catch(IOException e){
                    
                }
                }
                else
                {
                try{
                ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(fichero));
                oos.writeObject(obj_p);
                oos.close();
                }catch(IOException e){}
                }
                break;
                case 2:
                ObjectInputStream ois= new ObjectInputStream(new FileInputStream(fichero));
                try{     
                while(true){
                pacientes aux=(pacientes)ois.readObject();
                System.out.println(aux.gethabitacionCama());
                System.out.println(aux.getnombre());
                System.out.println(aux.getapellidos());
                System.out.println(aux.getdieta());
                System.out.println("");
            }
        }catch(ClassNotFoundException e){
        }catch(EOFException e){
        }catch(IOException e){
        }
                break;
                case 3:
                break;
                case 4:
                File borrar = new File("pacientes.dat");
                fichero.delete();
                case 5:
                bandera = true;
            }
        }
    }
    }
