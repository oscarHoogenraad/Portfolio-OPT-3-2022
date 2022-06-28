package controller.models;

import java.util.ArrayList;

public abstract class Account{

    Product edits;
    private String username;
    private String password;
    private boolean keuzeAdmin;
    private boolean ingelogd;
    private int userNumber;

    public Account(String username, String password, int userNumber, boolean keuzeAdmin){
        this.userNumber = userNumber;
        this.username = username;
        this.password = password;
        this.keuzeAdmin=keuzeAdmin;
        accountList.add(this);
    }

    public String getUsername() {
        return username;
    }

    public boolean isKeuzeAdmin() {
        return keuzeAdmin;
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

