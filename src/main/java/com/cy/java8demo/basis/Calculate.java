package com.cy.java8demo.basis;

/**
 * @author congyang.guo
 */
public class Calculate {

    /**
     * hashmap计算最小2的幂次方
     *
     * @param cap
     * @return
     */
    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }

    public static void main(String[] args) {
        // todo 存疑
        System.out.println(-15 >>> 2);
    }
}
