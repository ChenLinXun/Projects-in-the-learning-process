package com.movie.utils;

import java.util.UUID;

@SuppressWarnings("all")
public class UUIDutils {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}