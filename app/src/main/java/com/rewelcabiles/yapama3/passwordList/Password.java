package com.rewelcabiles.yapama3.passwordList;

public class Password {
    private String name, password;

    public Password(String name, String password) {
        this.name = name;
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
