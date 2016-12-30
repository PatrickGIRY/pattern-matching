package functional.java.pattern.matching;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SwitchCaseTest {

    @Test
    public void switch_case_with_int() {

        assertThat(toGender(1)).isEqualTo("man");
        assertThat(toGender(2)).isEqualTo("woman");
        assertThatThrownBy(() -> toGender(3)) //
                .isInstanceOf(IllegalArgumentException.class) //
                .hasMessage("Unknown gender for code " + 3);

    }

    static String toGender(int genderCode) {
        final String gender;
        switch (genderCode) {
            case 1: gender = "man";
                break;
            case 2: gender = "woman";
                break;
            default:
                throw new IllegalArgumentException("Unknown gender for code " + genderCode);
        }
        return gender;
    }

    @Test
    public void switch_case_with_character() {

        assertThat(toCivility('M')).isEqualTo("Monsieur");
        assertThat(toCivility('W')).isEqualTo("Madame");
        assertThatThrownBy(() -> toCivility('Z')) //
                .isInstanceOf(IllegalArgumentException.class) //
                .hasMessage("Unknown civility for code " + 'Z');

    }

    static String toCivility(char civilityCode) {
        final String civility;
        switch (civilityCode) {
            case 'M' : civility = "Monsieur";
                break;
            case 'W' : civility =  "Madame";
                break;
            default:
                throw new IllegalArgumentException("Unknown civility for code " + civilityCode);
        }
        return civility;
    }


    @Test
    public void switch_case_with_enum() {

        assertThat(toGender(GenderCode.MAN)).isEqualTo("man");
        assertThat(toGender(GenderCode.WOMAN)).isEqualTo("woman");
    }

    static String toGender(GenderCode genderCode) {
        final String gender;
        switch (genderCode) {
            case MAN: gender = "man";
                break;
            case WOMAN: gender = "woman";
                break;
            default:
                throw new IllegalArgumentException("Unknown gender for code " + genderCode);
        }
        return gender;
    }


    enum GenderCode {
        MAN,
        WOMAN
    }

    @Test
    public void switch_case_with_string() {

        assertThat(toCivility("Mr.")).isEqualTo("Monsieur");
        assertThat(toCivility("Mrs.")).isEqualTo("Madame");
        assertThatThrownBy(() -> toCivility("Zzz")) //
                .isInstanceOf(IllegalArgumentException.class) //
                .hasMessage("Unknown civility for abbreviation " + "Zzz");

    }

    static String toCivility(String abbreviation) {
        final String civility;
        switch (abbreviation) {
            case "Mr." : civility = "Monsieur";
                break;
            case "Mrs." : civility =  "Madame";
                break;
            default:
                throw new IllegalArgumentException("Unknown civility for abbreviation " + abbreviation);
        }
        return civility;
    }
}
