package com.mycompany.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class IntegerDivision {
    Step step = new Step();

    public void longDivision(int division, int divisor) {
        List<Integer> numbers = integerToList(division);
        int i = 0;
        while (listToInteger(numbers) >= division) {
            if (hasNextDivision(numbers, divisor)) {
                int temp2 = findDivision(numbers, divisor);
                divisionOnStep(i, temp2, divisor);
                int stepRemainded = stepResult(i);
                List<Integer> stepNumbers = integerToList(stepRemainded);
                numbers = combineLists(stepNumbers, numbers);
                i++;
            }
        }
        step.printList();
    }

    public boolean hasNextDivision(List<Integer> list, int divisor) {
        Iterator<Integer> it = list.iterator();
        int division = it.next();
        if (division == 0) {
            return true;
        }
        while (division <= divisor) {
            if (!it.hasNext()) {
                return false;
            } else {
                division = division * 10 + it.next();
            }
        }
        return true;
    }


    public int stepResult(int index) {
        Result result = step.getResult(index);

        return result.getRemainder();
    }

    public List<Integer> combineLists(List<Integer> one, List<Integer> two) {
        one.addAll(two);
        return one;
    }

    public int listToInteger(List<Integer> numbers) {
        int number = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int pow = Math.abs(i - numbers.size() + 1);
            number += numbers.get(i) * (int) Math.pow(10, pow);
        }
        return number;
    }

    public List<Integer> integerToList(int division) {
        List<Integer> numbers = new ArrayList<>();
        int lengthDivision = lengthNumber(division);
        for (int i = 0; i < lengthDivision; i++) {
            numbers.add(division % 10);
            division /= 10;
        }
        Collections.reverse(numbers);
        return numbers;
    }

    private int lengthNumber(int number) {
        return (int) Math.log10(number) + 1;
    }


    public int findDivision(List<Integer> list, int divisor) {
        Iterator<Integer> it = list.iterator();
        int division = list.get(0);
        if (division == 0) {
            list.remove(0);
            return division;
        }
        while (division < divisor) {
            if (it.hasNext()) {
                division = division * 10 + list.get(1);
                list.remove(0);
            } else {
                return division;
            }
        }
        return division;
    }


    private void divisionOnStep ( int index, int division, int divisor){
        int quotient = 0;
        int remainder;
        int subtrahend;
        int temp = division;

        while (temp - divisor >= 0) {
            temp -= divisor;
            quotient += 1;
        }
        subtrahend = quotient * divisor;
        remainder = division - subtrahend;
        step.addStepResult(index, division, quotient, subtrahend, remainder);
    }


}
