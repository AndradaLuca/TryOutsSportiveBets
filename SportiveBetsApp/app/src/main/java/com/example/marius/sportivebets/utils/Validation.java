package com.example.marius.sportivebets.utils;

import android.arch.persistence.room.util.StringUtil;
import android.media.MediaCodec;
import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class Validation {

    public static Boolean isEmailValid(String email)
    {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();

    }

    public static Boolean inUsernameValid(String username)
    {
       return !username.isEmpty() && !username.trim().isEmpty();


    }

    public static Boolean isCnpValid(String cnp)
    {
      return cnp.length()==13 && cnp.contains("[0-9]+");

    }

    public static Boolean isPasswordValid(String password)
    {
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        return password.matches(pattern);
    }

    public static Boolean isAddressValid(String address)
    {
       return !address.isEmpty();
    }


}
