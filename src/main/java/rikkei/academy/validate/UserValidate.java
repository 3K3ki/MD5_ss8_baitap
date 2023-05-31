package rikkei.academy.validate;

import org.springframework.validation.Errors;
import rikkei.academy.model.User;

public class UserValidate {
    public void checkValidate(User c, Errors error){
        if(c.getFirstName().trim().equals("")&&c.getLastName().trim().equals("")){
            error.rejectValue("firstName","name.empty");
        }
        if (c.getPhoneNumber().trim().equals("")){
            error.rejectValue("phoneNumber","phoneNumber.empty");
        }
        if (c.getAge()<18){
            error.rejectValue("age","age.size");
        }
        if(c.getEmail().trim().equals("@")){
            error.rejectValue("email","email.char");
        }
    }
}
