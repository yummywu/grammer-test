package com.eden.apache.commons;

import java.util.Base64;

public class Base64Test {
    public static void main(String[] args) {

        /*java8 util包添加了对base64的支持， 包括基本的base64，url safe的base64， mime友好的base64*/
        byte[] encodedBytes = Base64.getEncoder().encode("Test".getBytes());
        System.out.println("encodedBytes " + new String(encodedBytes));
        byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
        System.out.println("decodedBytes " + new String(decodedBytes));

        /*比较url encoder 与 encoder*/
        String helloStr = "hello";
        System.out.println(Base64.getUrlEncoder().encodeToString(helloStr.getBytes()));
        System.out.println(Base64.getUrlEncoder().encodeToString(helloStr.getBytes()));
        System.out.println(Base64.getUrlEncoder().encode(helloStr.getBytes()));
        System.out.println(Base64.getUrlEncoder().encode(helloStr.getBytes()));
    }
}
