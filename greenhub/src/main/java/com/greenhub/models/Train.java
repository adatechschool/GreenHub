package com.greenhub.models;

public class Train extends  AbstractModeOfTransport{
    public int overtime () {
        return 0;
    }
    public Train(){
        super("Train", 4);
    }

}
