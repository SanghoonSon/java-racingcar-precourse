package racingcar.global;

import java.util.regex.Pattern;

public enum Patterns {
    ONLY_NUMBER("^[0-9]*?");

    private final String regex;

    Patterns(String regex) {
        this.regex = regex;
    }

    public boolean matches(String value) {
        return Pattern.matches(this.regex, value);
    }
}
