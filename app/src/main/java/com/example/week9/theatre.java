package com.example.week9;

public class theatre {
    private String ID="";
    private String Name="";

    public theatre(){}
    public theatre(String i, String p) {
        ID = i;
        Name = p;
    }

    public String getID() {
        return ID;
    }



    public String toString() {
        return Name;
    }
}
