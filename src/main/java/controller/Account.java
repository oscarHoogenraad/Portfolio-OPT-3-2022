package controller;

import java.util.ArrayList;

public class Account {
    public String getUsername() {
        return username;
    }

    private String username;
    private String password;

    public int getUserNumber() {
        return userNumber;
    }

    private int userNumber;
    private static ArrayList<Account>accountList= new ArrayList<Account>();


    public String getPassword() {
        return password;
    }

    public static ArrayList<Account> getAccountList() {
        return accountList;
    }

    public Account(String username, String password, int userNumber){
        this.userNumber = userNumber;
        this.username = username;
        this.password = password;
        accountList.add(this);
    }
}

