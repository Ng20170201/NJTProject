/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NJTProject.rest.webservices.restwebservices.jwt;

/**
 *
 * @author Andjela
 */
import com.NJTProject.rest.webservices.restwebservices.patient.Patient;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

    static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();
  

    static {
        inMemoryUserList.add(new JwtUserDetails(1L, "admin",
                "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
        inMemoryUserList.add(new JwtUserDetails(2L, "nikola",
                "$2a$10$JgPgC9WSolPSaITqmiZ3oepPEmfFQOyoHiQiD2LfPnHCF11GOLnv6", "ROLE_USER_2"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
                .filter(user -> user.getUsername().equals(username)).findFirst();

        if (!findFirst.isPresent()) {
            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
        }

        return findFirst.get();
    }
    public void addUserDetails(Patient patient) throws Exception{
      /*  String username=patient.getEmail();
        bcryptEncoderTest.setPassword(username);
        String token=bcryptEncoderTest.getEncodedPassword();
        inMemoryUserList.add(new JwtUserDetails(Long.parseLong(i+""), username, token, "ROLE_USER_2"));
     */   
    }

}
