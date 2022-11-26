package com.Proxym.EventManagementSys.validator;
import com.Proxym.EventManagementSys.dto.userDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {
    public static List<String> validate(userDto userDto){
        List<String> errors = new ArrayList<>();
        //case when the userDto is null
        if (userDto==null){
            errors.add("Veuillez remplir le nom de l'utilisateur !!! ");
            errors.add("Veuillez remplir l'email de l'utilisateur !!! ");
            errors.add("Veuillez remplir le mot de passe de l'utilisateur !!! ");
            errors.add("Veuillez remplir le numéro de téléphone  de l'utilisateur !!! ");
            errors.add("Veuillez remplir l'adresse'de l'utilisateur !!! ");
        }

        if(!StringUtils.hasLength(userDto.getUserName()))
            errors.add("Veuillez remplir le nom de l'utilisateur !!! ");

        if(!StringUtils.hasLength(userDto.getEmail()))
            errors.add("Veuillez remplir l'email'de l'utilisateur !!! ");

        if(userDto.getPassword()==null)
            errors.add("Veuillez remplir le mot de passe  de l'utilisateur !!! ");

        if(userDto.getPhoneNumber()==null)
            errors.add("Veuillez remplir le numéro de téléphone  de l'utilisateur !!! ");


        if(userDto.getAddress()==null)
            errors.add("Veuillez remplir l'adresse'de l'utilisateur !!! ");
        else{
            if(userDto.getAddress().getCountry()==null) {
                errors.add(" le pays  de l'utilisateur est un champs obligatoire !!! ");
            }
            if(userDto.getAddress().getTown()==null)
                errors.add(" la ville   de l'utilisateur est un champs obligatoire !!! ");
            if(userDto.getAddress().getZIP_code()==null)
                errors.add(" le code postal de l'utilisateur est un champs obligatoire !!! ");

        }

        return errors;
    }
}
