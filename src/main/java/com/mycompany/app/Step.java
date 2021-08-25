package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class Step {
    private List<Result> steps;

    public Step(){
        steps = new ArrayList<>();
    }

    public void addStepResult(int index, int division, int quotient, int subtrahend, int remainder){
        steps.add(index, new Result(division,quotient, subtrahend, remainder));
    }

    public Result getResult(int index){
        return steps.get(index);
    }

    public void printList (){
        for (Result result: steps){
            System.out.println(result.toString());
        }
    }



}

