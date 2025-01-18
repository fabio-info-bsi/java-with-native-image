package br.com.fabex.job;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        System.out.println("Job ...");
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Run");
            }
        }, 0, 1000);
    }
}