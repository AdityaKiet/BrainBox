package com.egnesse.sckullappsuperadmin.dto;

/**
 * Created by adityaagrawal on 16/02/16.
 */
public class SessionDTO {
    private String secret;
    private String id;
    private String maxAge;


    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(String maxAge) {
        this.maxAge = maxAge;
    }

    @Override
    public String toString() {
        return "SessionDTO{" +
                "secret='" + secret + '\'' +
                ", id='" + id + '\'' +
                ", maxAge='" + maxAge + '\'' +
                '}';
    }
}
