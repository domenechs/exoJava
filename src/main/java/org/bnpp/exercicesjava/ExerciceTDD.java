package org.bnpp.exercicesjava;

public class ExerciceTDD {

    public static String transformerEntierEnString(int nombre) throws Exception {
        if(nombre < 0){
            throw (new Exception("No negative number allowed"));
        }
        if(nombre%3 == 0 && nombre%7 == 0){
            return "FIZZQIX";
        }
        if(nombre%3 == 0 && nombre%5 == 0){
            return "FIZZBUZZ";
        }
        if(nombre%3 == 0){
            return "FIZZ";
        }
        if(nombre%5 == 0){
            return "BUZZ";
        }
        if(nombre%7 == 0 && nombre != 7){
            return "QIX";
        }
        return String.valueOf(nombre);
    }
}
