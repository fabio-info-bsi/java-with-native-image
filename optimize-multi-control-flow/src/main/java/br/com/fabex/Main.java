package br.com.fabex;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        if (args.length == 0) {
            throw new IllegalArgumentException("There is no arguments");
        }
        int interactions = Optional.of(Integer.parseInt(args[0])).orElse(100);
        String option = Optional.of(args[1]).orElse("-");
        for (int i = 0; i < interactions; i++) {
            switch (option) {
                case "1": {
                    System.out.println("option 1");
                }
                break;
                case "2": {
                    System.out.println("option 2");
                }
                break;
                default: {
                    System.out.println("ops! ");
                }
            }
        }
    }
}