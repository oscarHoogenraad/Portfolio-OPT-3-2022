package controller;

import java.util.ArrayList;

public class Account {
    public String getUsername() {
        return username;
    }

    private String username;
    private String password;

    public boolean isIngelogd() {
        return ingelogd;
    }

    public void setIngelogd(boolean ingelod) {
        this.ingelogd = ingelod;
    }

    private boolean ingelogd;

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

    public static Account ingelogdeUser(){
        for(Account i: accountList){
            if(i.ingelogd){
                return i;
            }
        }
        return null;
    }

    public void uitgelogdeUser(){
        for(Account i: accountList){
            if(i.isIngelogd()){
                i.ingelogd = false;
            }
        }
    }

    public Account(String username, String password, int userNumber){
        this.userNumber = userNumber;
        this.username = username;
        this.password = password;
        accountList.add(this);
    }

}

