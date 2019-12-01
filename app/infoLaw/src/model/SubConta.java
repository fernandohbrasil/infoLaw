package model;

import java.util.Date;

public class SubConta {

    private Conta conta;
    private int sequencia;
    private Date dataVencimento;
    private Date dataPagamento;
    private double valorParcela;
    private double valorPago;
    private int situacao;
    private int repassado;

    public SubConta() {
    }

    public SubConta(Conta conta, int sequencia, Date dataVencimento, Date dataPagamento, double valorParcela, double valorPago) {
        this.conta = conta;
        this.sequencia = sequencia;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.valorParcela = valorParcela;
        this.valorPago = valorPago;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public int getSituacao() {
        return situacao;
    }

    public String getSituacaoS() {
        switch (this.situacao) {
            case 0:
                return "Em Aberto";
            case 1:
                return "Pago";
            case 2:
                return "Cancelado";
            default:
                return "";

        }
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public int getRepassado() {
        return repassado;
    }

    public void setRepassado(int repassado) {
        this.repassado = repassado;
    }
}
