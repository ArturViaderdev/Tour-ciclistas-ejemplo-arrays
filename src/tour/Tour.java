/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author arturv
 */
public class Tour {

    private static int[] dorsalciclista;
    private static String []nombreciclista;
    private static int[] edadciclista;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner entrada=new Scanner(System.in);
        int opcion;
        boolean sal=false;
        dorsalciclista = new int[0];
        nombreciclista = new String[0];
        edadciclista = new int[0];
        //Bucle del menú se repite hasta que se introduce la opción 0 para salir.
        do
        {
            System.out.println("1-Insertar nuevo ciclista.");
            System.out.println("2-Informar de cuantos ciclistas tiene el vector.");
            System.out.println("3-Mostrar todos los ciclistas del vector.");
            System.out.println("4-Mostrar el ciclista más grande y el más pequeño.");
            System.out.println("5-Buscar ciclista por nombre.");
            System.out.println("6-Caluclar la media de edad de todos los ciclistas.");
            System.out.println("7-Borrar un ciclista.");
            System.out.println("8-Ordenar el vector de edad. Se rompen correspondencias.");
            System.out.println("9-Ordenar el vector de nombre.");
            System.out.println("0-Salir");
            System.out.println("Introduce una opción.");
            try
            {
                //Se pide la opción al usuario
                opcion=entrada.nextInt();
                switch(opcion)
                {
                    case 0:
                        //Si el usuario introduce 0 se sale del bucle del menú y del programa
                        sal=true;
                        break;
                     case 1:
                        insertarciclista();       
                        break;
                     case 2:
                        cuantosciclistas();
                        break;
                     case 3:
                         mostrarciclistas();
                         break;
                     case 4:
                         masgrandepequeno();
                         break;
                     case 5:
                         buscarpornombre();
                         break;
                     case 6:
                         calcularmedia();
                         break;
                     case 7:
                         borrarunciclista();
                         break;
                     case 8:
                         ordenaredad();
                         break;
                     case 9:
                         ordenarnombre();
                         break;
                    default:
                }
            }
            catch(Exception e){
                System.out.println("Error.");
            }  
        }
        while(!sal);
       
    }
    
    private static void ordenarnombre()
    {
        Arrays.sort(nombreciclista);
        System.out.println("Array de nombre de ciclistas ordenada. Se ha roto la correspondencia. Se procede a mostrarla.");
        for(String nombre : nombreciclista)
        {
            System.out.println(nombre);
        }
    }
    
    private static void ordenaredad()
    {
        Arrays.sort(edadciclista);
        System.out.println("Array de edad de ciclistas ordenada. Se ha roto la correspondencia. Se procede a mostrarla.");
        for(int edad : edadciclista)
        {
            System.out.println(edad);
        }
        
    }
    
    private static void borrarunciclista()
    {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String nombre;
        boolean encontrado=false, sal = false;
        int cont;
        System.out.println("Introduce el nombre del ciclista a borrar. Se borrará el primer ciclista que se encuentre con ese nombre.");
        try
        {
            nombre = lector.readLine();
            cont=0;
            while(!sal)
            {
               if(cont<nombreciclista.length)
               {
                   if(nombreciclista[cont].equals(nombre))
                   {
                       encontrado=true;
                       sal=true;
                   }
                   else
                   {
                       cont++;
                   }
               }
               else
               {
                   sal=true;
               }
            }
            //Si se ha encontrado el ciclista se procede a eliminarlo desplazando los ciclistas posteriores
            if(encontrado)
            {
                while(cont<nombreciclista.length -1)
                {
                    nombreciclista[cont]=nombreciclista[cont+1];
                    dorsalciclista[cont]=dorsalciclista[cont+1];
                    edadciclista[cont]=edadciclista[cont+1];
                    cont++;
                }
                //Ahora hago las array un elemento más pequeñas copiándolas en unas nuevas
                dorsalciclista = java.util.Arrays.copyOf(dorsalciclista, dorsalciclista.length -1);
                nombreciclista = java.util.Arrays.copyOf(nombreciclista, nombreciclista.length - 1);
                edadciclista = java.util.Arrays.copyOf(edadciclista, edadciclista.length - 1);
                System.out.println("Ciclista eliminado.");
            }
            else
            {
                System.out.println("No existe un ciclista con este nombre.");
            }
        }
        catch(Exception e){
            System.out.println("Error.");
        }  
    }
    
    private static void calcularmedia()
    {
        double media=0;
        
        
        if(nombreciclista.length>0)
        {
            for(int cont=0;cont<nombreciclista.length;cont++)
            {
                media+=edadciclista[cont]; 
            }
            media/=nombreciclista.length;
            System.out.println("La media de edad es de " + media + ".");
        }
        else
        {
            System.out.println("No hay ciclistas");
        }
    }
    
    private static void mostrarciclista(int numero)
    {
        System.out.println("Ciclista número " + (numero+1) + " Posición " + numero + " de las array.");
        System.out.println("Nombre:" + nombreciclista[numero]);
        System.out.println("Dorsal:" + dorsalciclista[numero]);
        System.out.println("Edad:" + edadciclista[numero]);
    }
    
    //Muestra los datos de los ciclistas con un nombre introducido por el usuario
    private static void buscarpornombre()
    {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String nombre;
        boolean encontrado=false;
        System.out.println("Introduce el nombre del ciclista a buscar.");
        try
        {
            nombre = lector.readLine();
            for(int cont=0;cont<nombreciclista.length;cont++)
            {
                if(nombreciclista[cont].equals(nombre))
                {
                    encontrado=true;
                    mostrarciclista(cont);
                }
            }
            if(!encontrado)
            {
                System.out.println("No existe un ciclista con este nombre.");
            }
            
        }
        catch(Exception e){
            System.out.println("Error.");
        }  
    }
    
    //Obtiene el ciclista mas grande y el mas pequeño192.168.1.194
    //No se tiene en cuenta si hay mas de un ciclista con la misma edad
    private static void masgrandepequeno()
    {
        int masgrande =0, maspequeno=0;
        for(int cont=0;cont<nombreciclista.length;cont++)
        {
            if(cont>0)
            {
                if(edadciclista[cont]>edadciclista[masgrande])
                {
                    masgrande = cont;
                }
                if(edadciclista[cont]<edadciclista[maspequeno])
                {
                    maspequeno = cont;
                }
            }   
        }
        if(nombreciclista.length>0)
        {
            System.out.println("El ciclista mas grande es " + nombreciclista[masgrande] + " y tiene " + edadciclista[masgrande] + " años.");
            System.out.println("El ciclista mas pequeño es " + nombreciclista[maspequeno] + " y tiene " + edadciclista[maspequeno] + " años.");
        }
    }
    
    //Muestra todos los ciclistas por pantalla
    private static void mostrarciclistas()
    {
        for(int cont=0;cont<nombreciclista.length;cont++)
        {
            mostrarciclista(cont);
        }
    }
    
    //Muestra la longitud de las arrays por pantalla
    private static void cuantosciclistas()
    {
        System.out.println("El vector tiene " + nombreciclista.length + " ciclistas.");
    }
    
    //Añade un ciclista a las array
    private static void insertarciclista()
    {
       int dorsal, edad;
       String nombre;
       Scanner entrada=new Scanner(System.in);
       BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Intruduce el nombre del nuevo ciclista.");
       try
       {
           nombre= lector.readLine();
           System.out.println("Introduce el dorsal del nuevo ciclista.");
           dorsal=entrada.nextInt();
           System.out.println("Introduce la edad del nuevo ciclista.");
           edad = entrada.nextInt();
           //hago que las array tengan una posición más copiándolas, simulo que son dinámicas
           dorsalciclista = java.util.Arrays.copyOf(dorsalciclista, dorsalciclista.length + 1);
           nombreciclista = java.util.Arrays.copyOf(nombreciclista, nombreciclista.length + 1);
           edadciclista = java.util.Arrays.copyOf(edadciclista, edadciclista.length + 1);
           //Guardo los datos del nuevo ciclista en el último elemento de las array que tiene datos en blanco    
           nombreciclista[nombreciclista.length-1] = nombre;
           dorsalciclista[dorsalciclista.length-1] = dorsal;
           edadciclista[edadciclista.length-1] = edad;
           System.out.println("Ciclista añadido.");
           
       }
       catch(Exception e){
            System.out.println("Error.");
        }  
    }
    
}
