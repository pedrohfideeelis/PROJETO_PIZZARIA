package br.com.fatesg.pizzaria.models;

import br.com.fatesg.pizzaria.factory.Pizza;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int usuarioId;
    private String descricao;
    private double valorTotal;
    private List<PedidoItem> itens;

    public Pedido(int usuarioId, String descricao) {
        this.usuarioId = usuarioId;
        this.descricao = descricao;
        this.valorTotal = 0.0;
        this.itens = new ArrayList<>();
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<PedidoItem> getItens() {
        return itens;
    }

    public void adicionarItem(PedidoItem item) {
        itens.add(item);
        valorTotal += item.getSubtotal();
    }

    public void removerItem(PedidoItem item) {
        if (itens.remove(item)) {
            valorTotal -= item.getSubtotal();
        }
    }

    public void limparCarrinho() {
        itens.clear();
        valorTotal = 0.0;
    }
}
