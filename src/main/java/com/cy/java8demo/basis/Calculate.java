package
        com.cy.java8demo.basis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        // 32位不能省略
        System.out.println(-15 >>> 2);
        System.out.println(tableSizeFor(25000));

        List<Object> objects = new ArrayList<>();
        Map<Object, Object> objectObjectHashMap = new HashMap<>(16);
    }
}
