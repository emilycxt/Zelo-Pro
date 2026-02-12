package com.dev.emilycxt.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrdemServico {

    private Long id;
    private Cliente cliente;
    private String localizacao;
    private String descricaoSolicitacao;
    private String servicoRealizado;
    private BigDecimal valor;
    private StatusOrdemServico status;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFinalizacao;

    public OrdemServico() {
    }

    //Construtor para abrir uma nova OS
    public OrdemServico(Cliente cliente, String localizacao, String descricaoSolicitacao) {
        this.cliente = cliente;
        this.localizacao = localizacao;
        this.descricaoSolicitacao = descricaoSolicitacao;
        this.status = StatusOrdemServico.ABERTO;
        this.dataAbertura = LocalDateTime.now();
        this.valor = BigDecimal.ZERO;
    }

    public OrdemServico(Long id, Cliente cliente, String localizacao, String descricaoSolicitacao, 
                        String servicoRealizado, BigDecimal valor, StatusOrdemServico status, 
                        LocalDateTime dataAbertura, LocalDateTime dataFinalizacao) {
        this.id = id;
        this.cliente = cliente;
        this.localizacao = localizacao;
        this.descricaoSolicitacao = descricaoSolicitacao;
        this.servicoRealizado = servicoRealizado;
        this.valor = valor;
        this.status = status;
        this.dataAbertura = dataAbertura;
        this.dataFinalizacao = dataFinalizacao;
    }

    // --- Getters e Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricaoSolicitacao() {
        return descricaoSolicitacao;
    }

    public void setDescricaoSolicitacao(String descricaoSolicitacao) {
        this.descricaoSolicitacao = descricaoSolicitacao;
    }

    public String getServicoRealizado() {
        return servicoRealizado;
    }

    public void setServicoRealizado(String servicoRealizado) {
        this.servicoRealizado = servicoRealizado;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public StatusOrdemServico getStatus() {
        return status;
    }

    public void setStatus(StatusOrdemServico status) {
        this.status = status;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(LocalDateTime dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }
}