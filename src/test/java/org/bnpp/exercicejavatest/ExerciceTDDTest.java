package org.bnpp.exercicejavatest;

import org.assertj.core.api.Assertions;
import org.bnpp.exercicesjava.ExerciceTDD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.catchThrowable;


public class ExerciceTDDTest {

//    @BeforeAll
//    public void beforeAll() {
//        ExerciceTDD exo = new ExerciceTDD();
//    }

    @Test
    @DisplayName("Test exercice TDD entier -> String")
    public void test1() throws Exception {
        ExerciceTDD exo = new ExerciceTDD();
        Assertions.assertThat(exo.transformerEntierEnString(1)).isEqualTo("1");
        Assertions.assertThat(exo.transformerEntierEnString(25)).isEqualTo("BUZZ");
        Assertions.assertThat(exo.transformerEntierEnString(2)).isEqualTo("2");
        Assertions.assertThat(exo.transformerEntierEnString(3)).isEqualTo("FIZZ");
        Assertions.assertThat(exo.transformerEntierEnString(6)).isEqualTo("FIZZ");
        Assertions.assertThat(exo.transformerEntierEnString(5)).isEqualTo("BUZZ");
        Assertions.assertThat(exo.transformerEntierEnString(15)).isEqualTo("FIZZBUZZ");
        Assertions.assertThat(exo.transformerEntierEnString(33)).isEqualTo("FIZZ");
        Assertions.assertThat(exo.transformerEntierEnString(101)).isEqualTo("1*1");
        Throwable exception = catchThrowable(() -> exo.transformerEntierEnString(-1));
        Assertions.assertThat(exception).hasMessage("No negative numbers allowed");

    }

    @Test
    @DisplayName("Test exercice String calculator")
    public void test2() throws Exception {
        ExerciceTDD exo = new ExerciceTDD();
        Assertions.assertThat(exo.add("1")).isEqualTo("1");
        Assertions.assertThat(exo.add("1,2")).isEqualTo("3");
        Assertions.assertThat(exo.add("")).isEqualTo("0");
        Assertions.assertThat(exo.add("5,5,6,4")).isEqualTo("20");
        Assertions.assertThat(exo.add("5,5\n6,4")).isEqualTo("20");
        Throwable erreur = catchThrowable(() -> exo.add("175,2,\n354"));
        Assertions.assertThat(erreur).hasMessage("Number expected but \\n found at position 6");
        Throwable erreur2 = catchThrowable(() -> exo.add("1,3,"));
        Assertions.assertThat(erreur2).hasMessage("Number expected but EOF found");
    }
}
