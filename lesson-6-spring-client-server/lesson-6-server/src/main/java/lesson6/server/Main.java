package lesson6.server;

import java.util.Random;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        Random rn = new Random();
        int tasks = 41;
        int res;
        for(int task = 1; task < tasks; task++) {
            res = rn.nextInt() % 4;
            System.out.println(abs(res) + 1);
        }
    }
}
