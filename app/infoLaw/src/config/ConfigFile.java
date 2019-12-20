package config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ConfigFile {

    public static BufferedReader leitor = null;

    public static boolean abreArquivo(String arquivo) {
        try {
            leitor = new BufferedReader(new FileReader(new File(arquivo)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean fechaArquivo() {
        try {
            leitor.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String leDadosArquivo() {
        String path = "";
        try {                                       
            String arquivo = "config.ini";
            if (abreArquivo(arquivo)) {
                String linha = leitor.readLine();

                if (linha.equalsIgnoreCase("[Config]")) {
                    linha = leitor.readLine();
                    String[] result = null;
                    while (linha != null) {
                        result = linha.split("=");
                        if (result[0].equalsIgnoreCase("path")) {
                            path = result[1];
                        }
                        linha = leitor.readLine();
                    }
                }
            }
        } catch (Exception e) {

        }
        fechaArquivo();
        return path;
    } 
}