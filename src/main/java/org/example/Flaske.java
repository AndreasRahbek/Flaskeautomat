package org.example;

public class Flaske {

    private String type;
    private static int ID = 1;
    int flaskeID;

    public Flaske(){
        flaskeID = ID;
        ID++;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type + '\'' +
                ", " + flaskeID + '\'';
    }
}
