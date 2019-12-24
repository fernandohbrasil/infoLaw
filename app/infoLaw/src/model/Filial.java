package model;

public class Filial {    
    private final String versao;
        private final byte logoByte[];

    public Filial(String versao, byte[] logoByte) {
        this.versao = versao;
        this.logoByte = logoByte;
    }

    public String getVersao() {
        return versao;
    }

    public byte[] getLogoByte() {
        return logoByte;
    }       
}