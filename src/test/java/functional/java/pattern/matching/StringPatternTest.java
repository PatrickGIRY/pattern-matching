package functional.java.pattern.matching;


import org.junit.Test;

import java.util.Optional;

import static functional.java.pattern.matching.PatternMatching.when;
import static org.assertj.core.api.Assertions.assertThat;

public class StringPatternTest {

    @Test
    public void matching_when_pattern_matches() {

        PatternMatching<? super String, String> pm = when("world"::equals, x -> "Hello, " + x);

        assertThat(pm.matches("world")).isEqualTo(Optional.of("Hello, world"));
    }

    @Test
    public void matching_when_pattern_matches_no_string() {

        PatternMatching<? super String, String> pm = when("world"::equals, x -> "Hello, " + x);

        assertThat(pm.matches("Bob")).isEqualTo(Optional.empty());

    }
}
