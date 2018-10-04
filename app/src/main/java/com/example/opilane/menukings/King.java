package com.example.opilane.menukings;



//Lihtne mudel klass, kus saame oma andmed
public class King {

    private String name, text;
    private int from, to;

    //constructor
    public King(String name, int from, int to, String text){
        this.name = name;
        this.from = from;
        this.to = to;
        this.text = text;
    }
    //alt+insert
    //getterid
    public String getName() {
        return name;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public String getText() {
        return text;
    }
    //toString method that will return the value from each object in the ListView container

    public String toString() {
        return name;
    }


     public String getKing(){
        return name + " reign " + from + " to " + to;
     }
}
