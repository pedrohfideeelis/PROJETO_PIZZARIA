package br.com.fatesg.pizzaria.services;

import br.com.fatesg.pizzaria.factory.Pizza;
import br.com.fatesg.pizzaria.models.PedidoItem;
import java.sql.*;
import java.util.List;

public class PedidoService {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/pizzaria";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "aluno";

    public static void inserirPedido(int usuarioId, String descricao, double valorTotal) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String insertSQL = "INSERT INTO pedidos (usuario_id, descricao, valor_total) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(insertSQL);
            statement.setInt(1, usuarioId);
            statement.setString(2, descricao);
            statement.setDouble(3, valorTotal);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static double calcularValorTotal(List<PedidoItem> carrinho) {
        double valorTotal = 0.0;
        for (PedidoItem pedidoItem : carrinho) {
            Pizza pizza = pedidoItem.getPizza();
            int quantidade = pedidoItem.getQuantidade();
            double valorItem = pizza.cost() * quantidade;
            valorTotal += valorItem;
        }
        return valorTotal;
    }
}
