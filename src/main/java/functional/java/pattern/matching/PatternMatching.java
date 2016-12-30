package functional.java.pattern.matching;


import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
public interface PatternMatching<E, R> {

    static <T extends E, E, R> PatternMatching<E, R> when(Predicate<E> predicate, Function<T, R> action) {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(action);

        return value -> {
            if (predicate.test(value)) {
                return Optional.of(action.apply((T)value));
            } else {
                return Optional.empty();
            }
        };
    }

    default <T extends E> PatternMatching<E, R> otherwise(Function<T, R> action) {
        Objects.requireNonNull(action);

        return value -> {
            final Optional<R> result = matches(value);
            if (result.isPresent()) {
                return result;
            } else {
                return Optional.of(action.apply((T)value));
            }
        };
    }

    default <U extends E> PatternMatching<E, R> orWhen(Predicate<E> predicate, Function<U, R> action) {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(action);

        return value -> {
            final Optional<R> result = matches(value);
            if (result.isPresent()) {
                return result;
            } else {
                if (predicate.test(value)) {
                    return Optional.of(action.apply((U)value));
                } else {
                    return Optional.empty();
                }
            }
        };

    }

    Optional<R> matches(E value);

}
