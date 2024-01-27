package org.launchcode.models;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import static java.util.Objects.isNull;

public class User {
    @NotBlank(message = "Username can't be blank")
    @Size(min = 5, max = 15, message = "Username has to be 5-15 characters")
    private String userName;
    @Email
    private String email;
    @NotBlank(message = "Password can't be blank")
    @Size(min = 6, message = "Password needs to be at least 6 characters")
    private String password;
    private int ID;
    private static int nextID = 1;

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;
    public User() {
        this.ID = nextID;
        nextID++;
    }
    public User(String userName, String email, String password, String verifyPassword) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    public int getID() {
        return ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    private void checkPassword() {
        if(isNull(this.verifyPassword) || isNull(this.password)) {
            verifyPassword = null;
        }
        else if (!this.verifyPassword.equals(this.password)) {
            verifyPassword = null;
        }

    }



    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }


}
