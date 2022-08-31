package be.digitalcity.tu.pluralSightCourses.PS_StreamLambda.exercices;

import be.digitalcity.tu.pluralSightCourses.PS_StreamLambda.exercises.AdvancedStreamsExercise02;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static be.digitalcity.tu.pluralSightCourses.PS_StreamLambda.Category.*;
import static org.assertj.core.api.Assertions.assertThat;

class AdvancedStreamsExercise02Test {

    private AdvancedStreamsExercise02 exercise = new AdvancedStreamsExercise02();

    @Test
    @DisplayName("Count products per category")
    void countProductsPerCategory() {
        assertThat(exercise.countProductsPerCategory(TestData.getProducts()))
                .describedAs("Exercise 3: Your solution does not return the correct result.")
                .containsExactlyInAnyOrderEntriesOf(Map.of(FOOD, 2L, UTENSILS, 3L, CLEANING, 1L, OFFICE, 1L));
    }
}
