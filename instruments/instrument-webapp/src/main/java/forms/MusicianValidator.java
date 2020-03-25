package forms;

import db.Band.Musician;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 * @author Patrik Procházka
 */
public class MusicianValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Musician.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "country", "country.empty");
    }
}
