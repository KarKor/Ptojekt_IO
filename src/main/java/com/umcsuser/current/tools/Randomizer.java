package com.umcsuser.current.tools;

public class Randomizer {
    public int randomize(int low, int high){
        return (int) ((Math.random() * (high - low)) + low);
    }
}
