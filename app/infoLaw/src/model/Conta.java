package model;

import java.util.Date;

public class Conta {

    private int id;
    private Entidade entidade;
    private Date dataCriacao;
    private Double valorTotal;
    private int status;
    private String obs;

    public Conta() {
    }

    public Conta(int id, Entidade entidade, Date dataCriacao, Double valorTotal, int status) {
        this.id = id;
        this.entidade = entidade;
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

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
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
