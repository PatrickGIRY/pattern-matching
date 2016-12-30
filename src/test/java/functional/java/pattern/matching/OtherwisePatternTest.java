package functional.java.pattern.matching;


import org.junit.Test;

import java.util.Optional;

import static functional.java.pattern.matching.PatternMatching.when;
import static org.assertj.core.api.Assertions.assertThat;

public class OtherwisePatternTest {

    @Test
    public void matching_when_always_pattern_matches() {

        PatternMatching<? super String, String> pm = when(x-> false, x -> "")
                .otherwise(x -> "got this object: " + x);

        assertThat(pm.matches("foo")).isEqualTo(Optional.of("got this object: foo"));
    }
}
