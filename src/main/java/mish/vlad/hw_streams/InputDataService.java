package mish.vlad.hw_streams;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class InputDataService {

    public static String validateName(String name) {
        if (StringUtils.isAlpha(name)) {
            return StringUtils.capitalize(name.toLowerCase());
        } else {
            throw new InvalidInputException();
        }
    }

    public static String validateSurname(String inputSurname) {
        String[] surnames = inputSurname.split("-");
        for (int i = 0; i<surnames.length; i++){
            if (StringUtils.isAlpha(surnames[i])) {
                surnames[i] = StringUtils.capitalize(surnames[i].toLowerCase());
            } else {
                throw new InvalidInputException();
            }
        }

        return StringUtils.join(surnames, "-");
    }

}
