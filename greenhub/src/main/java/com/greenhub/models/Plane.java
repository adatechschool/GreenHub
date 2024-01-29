package com.greenhub.models;

public class Plane extends AbstractModeOfTransport{

    public int overtime () {
        return 0;
    }
    public Plane(){
        super("Plane", 285);
    }
}