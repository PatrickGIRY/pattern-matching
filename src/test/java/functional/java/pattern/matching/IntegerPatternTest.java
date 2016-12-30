package functional.java.pattern.matching;


import org.junit.Test;

import java.util.Optional;

import static functional.java.pattern.matching.PatternMatching.when;
import static org.assertj.core.api.Assertions.assertThat;

public class IntegerPatternTest {

    @Test
    public void matching_when_pattern_matches() {

        PatternMatching<? super Integer, String> pm = when(x -> x == 42, x -> "forty-two");

        assertThat(pm.matches(42)).isEqualTo(Optional.of("forty-two"));

    }

    @Test
    public void action_return_optional() {
        final PatternMatching<? super Number, Optional<String>> pm =
                when(Integer.class::isInstance, x -> Optional.<String>empty());

        assertThat(pm.matches(42)).isEqualTo(Optional.of(Optional.empty()));
    }

    @Test
    public void matching_when_pattern_matches_no_integer() {

        PatternMatching<? super Integer, String> pm = when(x -> x == 42, x -> "forty-two");

        assertThat(pm.matches(43)).isEqualTo(Optional.empty());
    }
}
