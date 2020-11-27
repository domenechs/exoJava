package org.bnpp.exercicejavatest;

import org.assertj.core.api.Assertions;
import org.bnpp.exercicesjava.ExercicesJava;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.catchThrowable;

public class ExercicesJavaTest {

    @Test
    @DisplayName("Test Exercice 1")
    public void test1(){
        Assertions.assertThat(ExercicesJava.sommeEntiersAuCarre(1,2,3)).isEqualTo(14);
        Assertions.assertThat(ExercicesJava.sommeEntiersAuCarre(14,9,-9,1,4,3)).isEqualTo(384);
        Assertions.assertThat(ExercicesJava.sommeEntiersAuCarre()).isEqualTo(-1);
    }

    @Test
    @DisplayName("Test exercice 2")
    public void test2() throws Exception {
        float [] tableau = {10,20};
        float [] tableau2 = {11,12,13,14,15,16};
        Assertions.assertThat(ExercicesJava.calculeMoyenne(tableau)).isEqualTo(15);
        Assertions.assertThat(ExercicesJava.calculeMoyenne(tableau2)).isEqualTo(13);
    }

    @Test
    @DisplayName("test exercice 2 levée Exception")
    public void test3() throws Exception{
        float [] tableauVide = null;
        Throwable exception = catchThrowable(() -> ExercicesJava.calculeMoyenne(tableauVide));
        Assertions.assertThat(exception).isInstanceOf(Exception.class);
    }

    @Test
    @DisplayName("Test exercice 3")
    public void test4(){
        int[] tableau = {1,-2,10,-15,3};
        Assertions.assertThat(ExercicesJava.trouverIndexPlusEloigneDeZero(tableau)).isEqualTo(3);
        int[] tableau2 = {-10,10,3,5};
        Assertions.assertThat(ExercicesJava.trouverIndexPlusEloigneDeZero(tableau2)).isEqualTo(1);
        int[] tableau3 = {-10,10,3,10};
        Assertions.assertThat(ExercicesJava.trouverIndexPlusEloigneDeZero(tableau3)).isEqualTo(1);
    }

    @Test
    @DisplayName("Tst exercice 4")
    public void test5(){
        ExercicesJava fibo = new ExercicesJava();
        Assertions.assertThat(fibo.SuiteFibonacci(3)).isEqualTo(2);
        Assertions.assertThat(fibo.SuiteFibonacci(4)).isEqualTo(3);
        Assertions.assertThat(fibo.SuiteFibonacci(5)).isEqualTo(5);
        Assertions.assertThat(fibo.SuiteFibonacci(6)).isEqualTo(8);
        Assertions.assertThat(fibo.SuiteFibonacci(7)).isEqualTo(13);
        Assertions.assertThat(fibo.SuiteFibonacci(16)).isEqualTo(987);
        Assertions.assertThat(fibo.SuiteFibonacci(49)).isEqualTo(7778742049L);
        Assertions.assertThat(fibo.SuiteFibonacci(80)).isEqualTo(23416728348467685L);
    }

    @Test
    @DisplayName("Test Exercice 5")
    public void test6(){
        Assertions.assertThat(ExercicesJava.MarieSueHelenOk(21,9,60000)).isTrue();
        Assertions.assertThat(ExercicesJava.MarieSueHelenOk(21,7,90000)).isFalse();
        Assertions.assertThat(ExercicesJava.MarieSueHelenOk(90,2,2000000)).isTrue();
    }

    @Test
    @DisplayName("Test Exercice 6")
    public void test7(){
        Assertions.assertThat(ExercicesJava.remplacerCaractere("123456789012")).isEqualTo("########9012");
        Assertions.assertThat(ExercicesJava.remplacerCaractere("1234 5678 9012")).isEqualTo("##########9012");
        Assertions.assertThat(ExercicesJava.remplacerCaractere("MonNomEstPersonne")).isEqualTo("#############onne");
        Assertions.assertThat(ExercicesJava.remplacerCaractere("42")).isEqualTo("42");
        Assertions.assertThat(ExercicesJava.remplacerCaractere("12345")).isEqualTo("#2345");
    }

    @Test
    @DisplayName("Test Exercice 7")
    public void test8(){
        Assertions.assertThat(ExercicesJava.convertirChaine("Toto")).isEqualTo("toto");
        Assertions.assertThat(ExercicesJava.convertirChaine("TITi")).isEqualTo("TITI");
        Assertions.assertThat(ExercicesJava.convertirChaine("taTA")).isEqualTo("taTA");
    }

    @Test
    @DisplayName("Test Exercice 8")
    public void test9(){
        int[] tableau = {1,2,3};
        int[] tableau2 = {9,5,10,2,24,-1,-48};
        int[] tableau3 = {-23,4,-5,99,-27,329,-2,7,-921};
        Assertions.assertThat(ExercicesJava.maximumMultiple(tableau)).isEqualTo(6);
        Assertions.assertThat(ExercicesJava.maximumMultiple(tableau2)).isEqualTo(50);
        Assertions.assertThat(ExercicesJava.maximumMultiple(tableau3)).isEqualTo(-14);
    }

    @Test
    @DisplayName("Test Exercice 9")
    public void test10(){
        Integer[] tableau = {1,3,1};
        Integer[] tableau2 = {5,7,5,9,7};
        Integer[] tableau3 = {9,1,3,1,7,4,6,6,7};
        Assertions.assertThat(ExercicesJava.trouverNombre(tableau)).isEqualTo(13);
        Assertions.assertThat(ExercicesJava.trouverNombre(tableau2)).isEqualTo(579);
        Assertions.assertThat(ExercicesJava.trouverNombre(tableau3)).isEqualTo(134679);
    }

    @Test
    @DisplayName("Test exercice 11")
    public void test11(){
        Assertions.assertThat(ExercicesJava.rendreMonnaie(0,0,0,50)).isFalse();
        Assertions.assertThat(ExercicesJava.rendreMonnaie(2,2,2,200)).isFalse();
        Assertions.assertThat(ExercicesJava.rendreMonnaie(1,2,2,10)).isTrue();
        Assertions.assertThat(ExercicesJava.rendreMonnaie(1,2,2,80)).isTrue();
        Assertions.assertThat(ExercicesJava.rendreMonnaie(1,2,2,90)).isTrue();
        Assertions.assertThat(ExercicesJava.rendreMonnaie(0,2,5,80)).isFalse();
        Assertions.assertThat(ExercicesJava.rendreMonnaie(1,1,1,55)).isFalse();
    }

    @Test
    @DisplayName("Exercice Fichier")
    public void test12(){
        ExercicesJava.TouverNombreOccurenceDeChaqueMotDansUnTexte();
    }
}