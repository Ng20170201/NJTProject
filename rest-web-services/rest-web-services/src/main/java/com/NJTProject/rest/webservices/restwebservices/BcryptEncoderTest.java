/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NJTProject.rest.webservices.restwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Andjela
 */
public class BcryptEncoderTest {

    private static String textPass;
    private static String encodedPassword;
    private static BCryptPasswordEncoder encoder;

    public static void main(String[] args) {

        /*  for (int i = 1; i <= 10; i++) {
            String encodedString = encoder.encode("nikola");
            System.out.println(encodedString);
        }*/
        encoder = new BCryptPasswordEncoder();
       

    }

    public void setPassword(String textPass) {
        this.textPass = textPass;
    }

    public  String getEncodedPassword() throws Exception {

        if (!textPass.isEmpty()) {
            encodedPassword = encoder.encode(textPass);
            return encodedPassword;
        } else {
            throw new Exception("TextPass problem");
        }
    }

}
