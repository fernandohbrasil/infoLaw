package model;

import java.util.Date;
import util.CurrencyUtil;

public class Conta {

    private int id;
    private Entidade entidade;
    private Date dataCriacao;
    private Double valorTotal;
    private int status;
    private int usuarioid;
    private int usuarioidalteracao;
    private String obs;

    public Conta() {
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
    
    public String getValorTotalFormatado() {
        return "R$ " + CurrencyUtil.getFormatCurrency(valorTotal);
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
