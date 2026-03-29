package util;

import model.Evento;

import java.io.*;
import java.util.*;

public class FileUtil {

    public static void salvar(List<Evento> eventos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("events.data"))) {
            for (Evento e : eventos) {
                bw.write(e.toFile());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Evento> carregar() {
        List<Evento> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("events.data"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                lista.add(Evento.fromFile(linha));
            }
        } catch (IOException e) {
            System.out.println("Sem arquivo inicial.");
        }

        return lista;
    }
}
