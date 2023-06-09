package pro.sky.HW20.service;

import com.fasterxml.jackson.core.exc.InputCoercionException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.HW20.exception.IncorrectNameException;
import pro.sky.HW20.exception.IncorrectSurnameException;

@Service
public class ValidatorService {

    public String validateName(String name) {
        name = StringUtils.trimToNull(name);
        if (!StringUtils.isAlpha(name)) {
            throw new IncorrectNameException(name);
        }
        return StringUtils.capitalize(name.toLowerCase());
    }

    public String validateSurname(String surname) throws IncorrectSurnameException {
    surname = StringUtils.trimToNull(surname);
       String[] surnames = surname.split("-");
    for (int i = 0; i < surnames.length; i++) {
        if (!StringUtils.isAlpha(surnames[i])) {
            throw new IncorrectSurnameException(surname);
        }
        surnames[i] = StringUtils.capitalize(surnames[i].toLowerCase());
        }
    return String.join("-", surnames);
    }
    }

