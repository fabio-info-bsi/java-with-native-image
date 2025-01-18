package br.com.fabex.aot;

public class Main {
    public static int version;

    static {
        version = Integer.parseInt(System.getProperty("version", "0"));
    }

    public static void main(String[] args) {
        System.out.println("Version: " + version);
    }
}