package com.company.libraryhw.service;

import com.company.libraryhw.exception.IncorrectFirstNameException;
import com.company.libraryhw.exception.IncorrectLastNameException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ValidatorServise {

    public String validateFirstName(String firstName) {
        if (!StringUtils.isAlpha(firstName)) {
            throw new IncorrectFirstNameException();
        }
        return StringUtils.capitalize(firstName.toLowerCase());
    }

    public String validateLastName(String lastName) {
        String[] lastNames = lastName.split("-");
        for (int i = 0; i < lastNames.length; i++) {
            if (!StringUtils.isAlpha(lastNames[i])) {
                throw new IncorrectLastNameException();
            }
            lastNames[i] = StringUtils.capitalize(lastNames[i].toLowerCase());
        }
        return String.join("-", lastNames);
    }


}
