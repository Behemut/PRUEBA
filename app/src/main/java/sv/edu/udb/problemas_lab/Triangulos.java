package sv.edu.udb.problemas_lab;

public class Triangulos {  // Save as "Circle.java"
    // private instance variable, not accessible from outside this class
    // Constructors (overloaded)
    /** Constructs a triangle instance with default value */

   public String Clasificar(int a, int b, int c){
        if ((a == b)  &&  (b==c) && (a==c)){
            return "Equilatero";
        }
       if ((a != b) ||  (b!=c) || (a!=c)){
           return  "Escalenos";
       }
        else
           return "Isosceles";
   };
}