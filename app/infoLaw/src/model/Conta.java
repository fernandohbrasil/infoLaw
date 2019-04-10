package model;

import java.util.Date;

public class Conta {

    private int id;
    private Entidade oEntidade;
    private Date dataCriacao;
    private Double valorTotal;
    private int status;
    private String obs;

    public Conta() {
    }

    public Conta(int id, Entidade oEntidade, Date dataCriacao, Double valorTotal, int status) {
        this.id = id;
        this.oEntidade = oEntidade;
        this.dataCriacao = dataCriacao;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Entidade getoEntidade() {
        return oEntidade;
    }

    public void setoEntidade(Entidade oEntidade) {
        this.oEntidade = oEntidade;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
