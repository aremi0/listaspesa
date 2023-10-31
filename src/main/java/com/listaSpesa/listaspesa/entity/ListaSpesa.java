package com.listaSpesa.listaspesa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;
import java.io.*;
import java.net.*;

import java.util.Objects;


@Entity
@Data
@AllArgsConstructor
public class ListaSpesa {
    @Id
    @GeneratedValue
    private int idLista;

    private int nElementi;

    private String nomeLista;

    public ListaSpesa() throws MalformedURLException {
        nomeLista = nameGenerator();
    }

    private String nameGenerator() throws MalformedURLException {
        URL url = new URL("https://random-word-api.herokuapp.com/word");
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return content.toString();

        } catch (IOException e) {
            System.out.println("nameGenerator: " + e.getMessage());
            return "untitled";
        }
        finally {
            Objects.requireNonNull(con).disconnect();
        }
    }

    @Override
    public String toString() {
        return "ListaSpesa{" +
                "idLista=" + idLista +
                ", nElementi=" + nElementi +
                ", nomeLista='" + nomeLista + '\'' +
                '}';
    }
}
