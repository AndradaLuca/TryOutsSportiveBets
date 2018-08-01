package com.example.marius.sportivebets.database;

import com.example.marius.sportivebets.database.entity.User;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

   public static final String[] cnp = new String[]{"2970312125746", "1900423465789","1970418124240"};
   public static final String[] name = new String[] {"Luca Andrada", "Pascalau Marius","Luca Asd"};
   public static final String[] email = new String[]{"andradaa.luca@gmail.com","pascalaumarius3@gmail.com","asd@asd.com"};
   public static final String[] address= new String[]{"Mehedinti 21","Observator","Alurel Vlaicu nr 23"};
   public static final String[] password = new String[]{"andrada","marius","asd"};
   private static final Double[] ammount = new Double[]{0.0,0.0,0.0};



   public static List<User> generateUsers()
   {
       List<User> users= new ArrayList<>();
       for(int i =0; i<cnp.length; i++)
       {
           User user = new User();
           user.setPassword(password[i]);
           user.setMail(email[i]);
           user.setAddress(address[i]);
           user.setCNP(cnp[i]);
           user.setMouney(ammount[i]);
           user.setName(name[i]);
           users.add(user);
       }

       return users;
   }
}
