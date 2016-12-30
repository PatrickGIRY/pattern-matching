package functional.java.pattern.matching;


import org.junit.Test;

import java.util.Optional;

import static functional.java.pattern.matching.PatternMatching.when;
import static org.assertj.core.api.Assertions.assertThat;

public class ClassPatternTest {

    @Test
    public void matching_when_pattern_matches() {


        final PatternMatching<? super Number, String> pm =
                when(Integer.class::isInstance, x -> "Integer: " + x)
                .orWhen(Double.class::isInstance, x -> "Double: " + x);

        assertThat(pm.matches(42)).isEqualTo(Optional.of("Integer: 42"));
        assertThat(pm.matches(1.42)).isEqualTo(Optional.of("Double: 1.42"));

    }

    @Test
    public void matching_when_pattern_matches_and_action_return_null() {

        final PatternMatching<? super Number, Optional<String>> pm =
                when(Integer.class::isInstance, x -> Optional.<String>empty());

        assertThat(pm.matches(42)).isEqualTo(Optional.of(Optional.empty()));

    }

    @Test
    public void matching_pattern_matches_no_class() {

        PatternMatching<? super Number, String> pm =
                when(Integer.class::isInstance, x -> "Integer: " + x);

        assertThat(pm.matches(43.1)).isEqualTo(Optional.empty());
    }

}
