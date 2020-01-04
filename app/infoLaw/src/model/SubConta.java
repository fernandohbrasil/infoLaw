package model;

import java.util.Date;
import util.CurrencyUtil;

public class SubConta {

    private Conta conta;
    private int sequencia;
    private Date dataVencimento;
    private Date dataPagamento;
    private double valorParcela;
    private double valorPago;
    private int situacao;
    private int repassado;
    private int usuarioid;
    private int usuarioidalteracao;

    public SubConta() {
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
    
    public String getValorParcelaFormatado() {
        return "R$ " + CurrencyUtil.getFormatCurrency(valorParcela);
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public double getValorPago() {
        return valorPago;
    }
    
    public String getValorPagoFormatado() {
        return "R$ " + CurrencyUtil.getFormatCurrency(valorPago);        
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

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public int getUsuarioidalteracao() {
        return usuarioidalteracao;
    }

    public void setUsuarioidalteracao(int usuarioidalteracao) {
        this.usuarioidalteracao = usuarioidalteracao;
    }
}
