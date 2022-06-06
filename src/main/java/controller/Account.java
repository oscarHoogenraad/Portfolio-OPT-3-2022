package controller;

import java.util.ArrayList;

public abstract class Account implements IAccount{
    public String getUsername() {
        return username;
    }

    public Account(String username, String password, int userNumber){
        this.userNumber = userNumber;
        this.username = username;
        this.password = password;
        accountList.add(this);
    }

    private String username;
    private String password;
    private boolean keuzeAdmin;
    private boolean ingelogd;
    private int userNumber;

    public boolean isKeuzeAdmin() {
        return keuzeAdmin;
    }

    public void setKeuzeAdmin(boolean keuzeAdmin) {
        this.keuzeAdmin = keuzeAdmin;
    }


    public boolean isIngelogd() {
        return ingelogd;
    }

    public void setIngelogd(boolean ingelod) {
        this.ingelogd = ingelod;
    }


    public int getUserNumber() {
        return userNumber;
    }

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

}

