package baekjoon.basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class test {
    private final String name; // 필드

    public test(String name) { // 생성자
        this.name = name;
    }

    public String getName() { // Getter Method
        return name;
    }
    private static test nana = new test("nana");
    private static test john = new test("john");

    static Set<test> set = new HashSet<>(Arrays.asList(nana, john));

    public static void main(String[] args) {

    }

}
