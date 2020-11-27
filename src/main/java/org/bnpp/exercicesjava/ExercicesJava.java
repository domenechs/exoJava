package org.bnpp.exercicesjava;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ExercicesJava {
    // Exercice 1
    public static double sommeEntiersAuCarre(double... entiers) {
        double somme = 0;

        if (entiers.length == 0) {
            return -1;
        }

        for (double entier : entiers) {
            somme = somme + Math.pow(entier, 2);
        }
        return somme;
    }

    // Exercice 2
    public static int calculeMoyenne(float[] tableau) throws Exception {
        float somme = 0;

        if (tableau.length == 0) {
            throw (new Exception("Le tableau est vide!!!"));
        }
        for (float v : tableau) {
            somme = somme + v;
        }
        return (int) (somme / tableau.length);
    }

    // Exercice 3
    public static int trouverIndexPlusEloigneDeZero(int[] tableau) {
        int valeurMax = 0;
        int valeurMaxAbsolu = 0;
        int indexTableau = 0;

        for (int i = 0; i < tableau.length; i++) {
            int valeurAbsolu = Math.abs(tableau[i]);

            if (valeurAbsolu > valeurMaxAbsolu || (valeurAbsolu == valeurMaxAbsolu &&(valeurMax < 0 && tableau[i] > 0))) {
                valeurMaxAbsolu = valeurAbsolu;
                valeurMax = tableau[i];
                indexTableau = i;
            } /*else {
                if (valeurAbsolu == valeurMaxAbsolu) {
                    if (valeurMax < 0 && tableau[i] > 0) {
                        valeurMaxAbsolu = valeurAbsolu;
                        valeurMax = tableau[i];
                        indexTableau = i;
                    }
                }
            }*/
        }
        return indexTableau;
    }

    // Exercice 4 (Fibonacci)
    public long SuiteFibonacci(int nombre) {
        long nombreFibo = 0;
        long nombreFiboMoins1 = 0;
        long nombreFiboMoins2 = 1;

        if (nombre == 0) return 0;
        if (nombre == 1) return 1;
        for (int i = 2; i <= nombre; i++) {
            nombreFibo = nombreFiboMoins1 + nombreFiboMoins2;
            nombreFiboMoins1 = nombreFiboMoins2;
            nombreFiboMoins2 = nombreFibo;
        }
        return nombreFibo;
    }

    //Exercice 5 Sue Helen
    public static boolean MarieSueHelenOk(int age, int notePhysique, int revenuAnnuel) {

        if (revenuAnnuel > 1000000) {
            return true;
        }
        return (age >= 18 && age <= 35) && (notePhysique >= 8) && (revenuAnnuel >= 50000);
    }

    //Exercice 6 #######
    public static String remplacerCaractere(String chaine) {
        if (chaine.length() <= 4) {
            return chaine;
        }
        char[] newChaine = chaine.toCharArray();
        for (int i = 0; i < newChaine.length - 4; i++) {
            newChaine[i] = '#';
        }
        return new String(newChaine);
    }

    //Exercice 7
    public static String convertirChaine(String chaine) {
        char[] newChaine = chaine.toCharArray();
        int nombreMaj = 0;
        int nombreMin = 0;
        for (char c : newChaine) {
            if (Character.isUpperCase(c)) {
                nombreMaj++;
            } else {
                nombreMin++;
            }
        }
        if (nombreMin > nombreMaj) {
            return chaine.toLowerCase();
        } else {
            if (nombreMin < nombreMaj) {
                return chaine.toUpperCase();
            }
        }
        return chaine;
    }

    //Exercice 8
    public static int maximumMultiple(int[] tableau) {
        int valeurMax = tableau[0] * tableau[1];
        for (int i = 0; i < tableau.length - 1; i++) {
            int calcul = tableau[i] * tableau[i + 1];
            if (calcul > valeurMax) {
                valeurMax = calcul;
            }
        }
        return valeurMax;
    }

    // Exercice 9
    public static int trouverNombre(Integer[] tableau) {
        TreeSet<Integer> set = new TreeSet<>(Arrays.asList(tableau));
        int resultat = 0;

        int sizeTreeSet = set.size();
        for (int i = 0; i < sizeTreeSet; i++) {
            resultat = (resultat * 10) + set.pollFirst();
        }
        return resultat;
    }

    //Exercice 11
    public static boolean rendreMonnaie(int nombrePieces10, int nombrePieces20, int nombrePieces50, int somme) {
        boolean monnaie10 = true, monnaie20 = true, monnaie50 = true;
        while ((monnaie10 || monnaie20 || monnaie50) && (somme != 0)) {
            if (somme >= 50 && nombrePieces50 > 0) {
                nombrePieces50--;
                somme -= 50;
            } else {
                monnaie50 = false;
                if (somme >= 20 && nombrePieces20 > 0) {
                    nombrePieces20--;
                    somme -= 20;
                } else {
                    monnaie20 = false;
                    if (somme >= 10 && nombrePieces10 > 0) {
                        nombrePieces10--;
                        somme -= 10;
                    } else {
                        monnaie10 = false;
                    }
                }
            }
        }
        return somme == 0;
    }

    //Exercice Fichier NIO
    public static void TouverNombreOccurenceDeChaqueMotDansUnTexte(){
        List<String> texteRimbaud = lectureFichier();
        texteRimbaud = transformeListEnTableauEtTri(texteRimbaud);
        List<String> listeAEcrireDansFichier = compterMotTexte(texteRimbaud);
        ecrireFichier(listeAEcrireDansFichier);
    }

    public static List<String> lectureFichier(){
        Path path = Paths.get("Rimbaud.txt");
        List<String> texteRimbaud = new ArrayList<>();
        try {
            texteRimbaud = Files.readAllLines(path);
        }catch (Exception e){
            e.printStackTrace();
        }
        return texteRimbaud;
    }

    public static List<String> transformeListEnTableauEtTri(List<String> texteRimbaud) {
        String[] tableauString = new String[texteRimbaud.size()];
        tableauString = texteRimbaud.toArray(tableauString);
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < tableauString.length; i++) {
            tableauString[i] = tableauString[i].replaceAll("[:;.!,]"," ");
            String[] mots = tableauString[i].split(" ");
            for (String mot : mots) {
                if (!mot.equals("")) {
                    newList.add(mot.toLowerCase());
                }
            }
        }
        newList.sort(Comparator.naturalOrder());
        return newList;
    }

    public static List<String> compterMotTexte(List<String> texteRimbaud) {
        String [] tableauMotTrie = new String[texteRimbaud.size()];
        tableauMotTrie = texteRimbaud.toArray(tableauMotTrie);
        List<String> listeAEcrireDansFichier = new ArrayList<>();
        String mot = tableauMotTrie[0];
        int nombreMot=1;
        int nombreMotMax=0;
        String MotMax= "";
        for (String s : tableauMotTrie) {
            if (s.equals(mot)) {
                nombreMot++;
            } else {
                listeAEcrireDansFichier.add(mot + ": " + nombreMot);
                if (nombreMot > nombreMotMax){
                    nombreMotMax = nombreMot;
                    MotMax = mot;
                }
                mot = s;
                nombreMot = 1;
            }
        }
        listeAEcrireDansFichier.add("Nombre Total de mots: "+tableauMotTrie.length);
        listeAEcrireDansFichier.add("Mot le plus utilise est: "+MotMax);
        return listeAEcrireDansFichier;
    }


    public static void ecrireFichier(List<String> liste){
        Path path = Paths.get("occurence.txt");
        boolean exists = Files.exists(path);
        if(!exists){
            try {
                Files.createFile(path);
                Files.write(path, liste, StandardOpenOption.APPEND);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}