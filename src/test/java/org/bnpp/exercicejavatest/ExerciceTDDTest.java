package org.bnpp.exercicejavatest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.bnpp.exercicesjava.ExerciceTDD.transformerEntierEnString;

public class ExerciceTDDTest {

    @Test
    @DisplayName("Test exercice TDD entier -> String")
    public void test1() throws Exception {
        Assertions.assertThat(transformerEntierEnString(7)).isEqualTo("7");
        Assertions.assertThat(transformerEntierEnString(3)).isEqualTo("FIZZ");
        Assertions.assertThat(transformerEntierEnString(5)).isEqualTo("BUZZ");
        Assertions.assertThat(transformerEntierEnString(15)).isEqualTo("FIZZBUZZ");
        Throwable exception = catchThrowable(()->transformerEntierEnString(-5));
        Assertions.assertThat(exception).isNotNull();
        Assertions.assertThat(transformerEntierEnString(14)).isEqualTo("QIX");
        Assertions.assertThat(transformerEntierEnString(21)).isEqualTo("FIZZQIX");
        Assertions.assertThat(transformerEntierEnString(15)).isEqualTo("FIZZBUZZBUZZ");
        Assertions.assertThat(transformerEntierEnString(33)).isEqualTo("FIZZFIZZFIZZ");
    }
}
