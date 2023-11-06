package br.com.fatesg.pizzaria.services;

import br.com.fatesg.pizzaria.models.Usuario;
import static br.com.fatesg.pizzaria.services.CriptografiaSenha.encrypt;
import java.sql.*;

public class LoginService {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/pizzaria";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "aluno";

    public static Usuario fazerLogin(String cpf, String senha) {

        String senhaCriptografada = encrypt(senha);
        
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            //LOCALIZA O USUÁRIO DE ACORDO AO CPF E A SENHA
            String selectSQL = "SELECT * FROM usuarios WHERE cpf = ? AND senha = ?";

            PreparedStatement statement = connection.prepareStatement(selectSQL);

            statement.setString(1, cpf);
            statement.setString(2, senhaCriptografada);

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
