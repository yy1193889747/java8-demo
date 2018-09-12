package com.cy.java8demo.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author congyang.guo
 */
class Apple {
    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

public class AppleSort {
    public static void main(String[] args) {

        ArrayList inventory = new ArrayList();
        Collections.sort(inventory, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() > o2.getWeight() ? o1.getWeight() : o2.getWeight();
            }
        });

        inventory.sort(Comparator.comparing(Apple::getWeight));

    }
}
