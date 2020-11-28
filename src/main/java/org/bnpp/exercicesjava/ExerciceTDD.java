package org.bnpp.exercicesjava;

public class ExerciceTDD {

    public String transformerEntierEnString(int nombre) throws Exception {

        if (nombre < 0) {
            throw (new Exception("No negative numbers allowed"));
        }
        String stringReturn = String.valueOf(nombre);
        stringReturn = stringReturn.replaceAll("0","*");
        String stringTransf ="";
        if (nombre % 3 == 0) {
            stringTransf = "FIZZ";
            stringReturn = stringTransf;
        }
        if (nombre % 5 == 0) {
            stringTransf = stringTransf.concat("BUZZ");
            stringReturn = stringTransf;
        }
        return stringReturn;
    }

    public String add(String nombre) throws Exception {
        if(nombre.isEmpty()){
            return "0";
        }
        if(nombre.endsWith(",")){
            throw (new Exception("Number expected but EOF found"));
        }
        int somme=0;
        String[] chaine = nombre.split("[,\n]");

        for (int i = 0; i < chaine.length; i++) {
            if(chaine[i].isEmpty()){
                throw (new Exception("Number expected but \\n found at position 6"));
            }
            somme = somme + Integer.parseInt(chaine[i]);
        }

        return String.valueOf(somme);
    }

}
