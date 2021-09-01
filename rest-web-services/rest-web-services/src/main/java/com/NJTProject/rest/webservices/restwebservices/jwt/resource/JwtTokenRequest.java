/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NJTProject.rest.webservices.restwebservices.jwt.resource;

import java.io.Serializable;

/**
 *
 * @author Andjela
 */
public class  JwtTokenRequest implements Serializable {
  
  private static final long serialVersionUID = -5616176897013108345L;

  private String username;
    private String password;
    
    /*
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTYzMTA5NjUzMCwiaWF0IjoxNjMwNDkxNzMwfQ.l8LTY4RuqBboax_nF4eiI7hEQgBynlHENpPBtxqoLq_hNJXPcgQrVg5siB76rjCekKRafzZOZnMPL--QOnkI9Q"
    */

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
