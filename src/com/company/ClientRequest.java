package com.company;
import java.io.Serializable;

/**
 * Created by Admin on 21.04.2018.
 * :)
 */
public class ClientRequest implements Serializable {
    private String token;
    private String request;

    public ClientRequest(String token, String request) {
        this.token = token;
        this.request = request;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
