package br.com.fabex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.stream.Collectors;

public class UrlProtocol {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String stringUrl = args.length > 0 ? args[0] : "https://mock.codes";
        URL url = new URI(stringUrl).toURL();
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            int code = con.getResponseCode();
            String response = "";
            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                response += br.lines().collect(Collectors.joining());
            }
            System.out.printf("""
                    {
                        status: %d
                        response: %s
                    }%n""", code, response);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }


    }
}