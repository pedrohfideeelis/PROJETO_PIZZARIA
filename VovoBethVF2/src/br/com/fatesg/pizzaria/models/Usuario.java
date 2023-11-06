package br.com.fatesg.pizzaria.models;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private String senha;
    private List<Pedido> pedidos;

    public Usuario(int id, String nome, String cpf, String telefone, String endereco, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.senha = senha;
        this.pedidos = new ArrayList<>();
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getSenha() {
        return senha;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
