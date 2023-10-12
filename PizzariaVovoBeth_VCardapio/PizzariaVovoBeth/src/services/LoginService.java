package services;

import Classes.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginService {

    private static final String FILENAME = "usuarios.txt";

    public static Usuario fazerLogin(String login, String senha) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String usuarioLogin = parts[0];
                    String usuarioSenha = parts[1];
                    String cpf = parts[2];
                    String telefone = parts[3];
                    String endereco = parts[4];

                    if (usuarioLogin.equals(login) && usuarioSenha.equals(senha)) {
                        return new Usuario(usuarioLogin, usuarioSenha, cpf, telefone, endereco);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao verificar as credenciais.");
        }

        return null; // Credenciais não encontradas
    }
}
