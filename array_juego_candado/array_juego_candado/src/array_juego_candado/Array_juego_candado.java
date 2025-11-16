/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package array_juego_candado;

import java.util.Scanner;

/**
 *
 * @author Rafae
 */
public class Array_juego_candado {

 
    
    public static void pista(int[] lock, int tam){
     Scanner scan=new Scanner(System.in);
        char letra;
                          System.out.println("\n");
                          System.out.println("¿Necesitas que te de una pista? s/n");
                          letra=scan.next().charAt(0);
                                    
                                    if(letra=='s'){
                                         int pos=(int)(Math.random()*tam);  
                                        for(int j=0; j<lock.length;j++){
                                           
                                           if(j==pos){
                                               System.out.print(lock[j]);
                                           }else{
                                           System.out.print("x");
                                           }
                                        }
                                    }
                                    
                            System.out.println("\n");
        
    }
    
    public static void recorrer_array(int[]array){
    System.out.println("Mostrando array...");
            for(int i=0;i<array.length;i++){
            System.out.print(array[i]);
        }
            System.out.println("\n");
    }
    
    public static void introducir_numero(int[]num,int tam){
        Scanner scan=new Scanner(System.in);
    System.out.println("Introduzca los valores: ");
        int contador=0;
        while(contador<=tam-1){
            
        num[contador]= scan.nextInt();
        
            while(num[contador]>5){
                  System.out.println("El numero es mayor que 5 por favor vuelva a introoducir un numero: ");
                   num[contador]= scan.nextInt();
            }
            contador++;
        }
    }
    
      public static void Abrir_Candado(int[]array,int[]lock,int tamaño){
          Scanner scan=new Scanner(System.in);
          
          boolean correcto=false;
          int tam=tamaño;
          
          while(correcto==false){
              
          introducir_numero(array,tam);
              
          
         int correctas=0;
         int []posiciones_correctas=new int[tam];
          
          for(int i=0;i<lock.length;i++){
          
              if(array[i]==lock[i]){
                  posiciones_correctas[i]=i+1;
                  correctas=correctas+1;
              }
          }
          
          if(correctas==lock.length){
                 System.out.println("El candado se abrío.");
                 correcto=true;
              }else{
                 System.out.println("El candado sigue cerrado... intentalo de nuevo");
                 System.out.print("Tienes "+correctas+" posiciones correctas en las posiciones: .");
                 
                     for(int i=0;i<posiciones_correctas.length;i++){

                           if(posiciones_correctas[i]!=0){
                         System.out.print(" "+posiciones_correctas[i]+" ");
                          
                             }
                     }  
                     pista(lock,tam);
            }
        }   
    }
     
    
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        
        int tam=0;
        int dificultad=0;
        while(dificultad<=0 || dificultad>3 ){
            
        System.out.println("Elige una dificultad 1.facil, 2.normal o 3.dificil, debe estar entre 1 y 3. (1,2,3)");
        
         dificultad=scan.nextInt();
         
        }
        
        switch (dificultad) {
            
            case 1:
                tam=3;
                break;
                
            case 2:
                tam=5;
                break;
                
            case 3:
                tam=7;
                break;
                
            default:
                break;
        }
        
        
         int []combinacion=new int[tam];
         int []num=new int[tam];
         
         for(int i =0;i<combinacion.length;i++){
         
             combinacion[i]=(int)(Math.random()*6);
             
         }
         
         recorrer_array(combinacion);
         Abrir_Candado(num,combinacion,tam);
    }
    
}
