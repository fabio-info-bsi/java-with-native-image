package br.com.fabex;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class NativeImageWithResource {

    public static void main(String[] args) throws IOException {
        try (InputStream resourceAsStream = NativeImageWithResource.class.getClassLoader()
                .getResourceAsStream("file.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(resourceAsStream)))
        ) {
            reader.lines().forEach(System.out::println);
        }

        try (InputStream resourceAsStream = NativeImageWithResource.class.getClassLoader()
                .getResourceAsStream("file-module-dep.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(resourceAsStream)))
        ) {
            reader.lines().forEach(System.out::println);
        }
    }
}