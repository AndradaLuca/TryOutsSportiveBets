package com.example.marius.sportivebets.utils;

import android.util.Patterns;

import java.util.regex.Pattern;

public class Validation {

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
        return cnp.length() == 13;

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
