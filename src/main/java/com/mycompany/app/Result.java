package com.mycompany.app;

public class Result {
    private int division;
    private int quotient;
    private int subtrahend;
    private int remainder;

    public Result (int division, int quotient, int subtrahend, int remainder){
        this.division = division;
        this.quotient = quotient;
        this.subtrahend = subtrahend;
        this.remainder = remainder;
    }


    public int getSubtrahend() {
        return subtrahend;
    }

    public int getQuotient() {
        return quotient;
    }

    public int getRemainder() {
        return remainder;
    }

    public void setQuotient(int quotient) {
        this.quotient = quotient;
    }

    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }

    public void setSubtrahend(int subtrahend) {
        this.subtrahend = subtrahend;
    }

    @Override
    public String toString() {
        return "делимое " + division + " частное " + quotient + " вычитаемое " + subtrahend + " остаток " +  remainder;
    }
}


