package br.com.fatesg.pizzaria.services;

import br.com.fatesg.pizzaria.models.Usuario;
import static br.com.fatesg.pizzaria.services.CriptografiaSenha.encrypt;
import java.sql.*;

public class UsuarioService {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/pizzaria";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "aluno";

    public static void cadastrarUsuario(String nome, String cpf, String telefone, String endereco, String senha) {

        String senhaCriptografada = encrypt(senha);
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            //INSERIR USUÁRIO
            String insertSQL = "INSERT INTO usuarios (nome, cpf, telefone, endereco, senha) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(insertSQL);

            //PASSA OS VALORES PARA OS PARÂMETROS
            statement.setString(1, nome);
            statement.setString(2, cpf);
            statement.setString(3, telefone);
            statement.setString(4, endereco);
            statement.setString(5, senhaCriptografada);

            //EXECUTA O SCRIPT
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean verificarCPFCadastrado(String cpf) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            //LOCALIZA O CPF NO BD CONFORME O DIGITADO
            String selectSQL = "SELECT * FROM usuarios WHERE cpf = ?";

            PreparedStatement statement = connection.prepareStatement(selectSQL);

            //DEFINE O PARÃMETRO CPF
            statement.setString(1, cpf);

            ResultSet result = statement.executeQuery();

            //LOCALIZADO RETORNA TRUE
            return result.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //ACESSA INFORMAÇÕES DO USUÁRIO JÁ LOGADO
    public static Usuario obterUsuarioLogado(String cpf, String senha) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            //LOCALIZA O USUARIO
            String selectSQL = "SELECT * FROM usuarios WHERE cpf = ? AND senha = ?";

            PreparedStatement statement = connection.prepareStatement(selectSQL);

            statement.setString(1, cpf);
            statement.setString(2, senha);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int id = result.getInt("id");
                String nome = result.getString("nome");
                String telefone = result.getString("telefone");
                String endereco = result.getString("endereco");
                return new Usuario(id, nome, cpf, telefone, endereco, senha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
