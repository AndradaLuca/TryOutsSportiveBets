package com.example.marius.sportivebets.utils;

import android.util.Patterns;

import org.joda.time.DateTime;
import org.joda.time.Years;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Validation {


    public static boolean isLoginEmailValid(String email){
        return !email.isEmpty();
    }

    public static boolean isLoginPasswordValid(String password){
        return !password.isEmpty();
    }

    public static Boolean isEmailValid(String email)
    {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();

    }

    public static Boolean isUsernameValid(String username)
    {
        return !username.isEmpty();


    }

    public static Boolean isCnpValid(String cnp)
    {
        char fisrtCharacterOfYear = cnp.charAt(1);
        char secondCharacterOfYear = cnp.charAt(2);

        char firstCharacterOfMonth = cnp.charAt(3);
        char secondCharacterOfMonth = cnp.charAt(4);

        char firstCharacterOfDay = cnp.charAt(5);
        char secondCharacterOFDay = cnp.charAt(6);

        String dateString = firstCharacterOfDay + secondCharacterOFDay + "-" + firstCharacterOfMonth + secondCharacterOfMonth + "-" + fisrtCharacterOfYear + secondCharacterOfYear;

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");

        Date cnpDate = null;
        try {
            cnpDate = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        Date curentDate = new Date();


        DateTime dateOfBirth = new DateTime(cnpDate);
        DateTime dateNow = new DateTime(curentDate);

        int years = Years.yearsBetween(dateOfBirth, dateNow).getYears();

        return cnp.length() == 13 & years >= 18;

    }

    public static Boolean isPasswordValid(String password, String secondPassword)
    {

        return password.equals(secondPassword);
    }

    public static Boolean isAddressValid(String address)
    {
       return !address.isEmpty();
    }


}
