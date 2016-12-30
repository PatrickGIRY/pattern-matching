package functional.java.pattern.matching;


import org.junit.Test;

import java.util.Optional;

import static functional.java.pattern.matching.PatternMatching.when;
import static org.assertj.core.api.Assertions.assertThat;

public class CombinePatternTest {

    @Test
    public void matcher_value_with_different_kind_of_pattern() {

        PatternMatching<Object, String> pm = when("world"::equals, x -> "Hello, " + x)
                .orWhen(Double.class::isInstance, x -> "Double: " + x)
                .otherwise(x -> "got this object: " + x);

        assertThat(pm.matches("world")).isEqualTo(Optional.of("Hello, world"));
        assertThat(pm.matches("foo")).isEqualTo(Optional.of("got this object: foo"));
        assertThat(pm.matches(1.42)).isEqualTo(Optional.of("Double: 1.42"));
    }
}
