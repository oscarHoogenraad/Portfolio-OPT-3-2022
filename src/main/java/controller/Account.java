package controller;

import java.util.ArrayList;

public class Account {
    public String getUsername() {
        return username;
    }

    private String username;
    private String password;
    private boolean ingelogd;
    private static ArrayList<Account>accountList= new ArrayList<Account>();

    public boolean isIngelogd() {
        return ingelogd;
    }

    public String getPassword() {
        return password;
    }

    public static ArrayList<Account> getAccountList() {
        return accountList;
    }

    public Account(String username, String password, boolean ingelogd){
        this.username = username;
        this.password = password;
        this.ingelogd = false;
        accountList.add(this);
    }
}
