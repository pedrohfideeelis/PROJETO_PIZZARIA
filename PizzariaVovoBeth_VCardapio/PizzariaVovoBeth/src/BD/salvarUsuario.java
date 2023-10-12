package BD;

import Classes.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class salvarUsuario {
    private static final String FILENAME = "usuarios.txt";

    public static void salvarUsuario(Usuario usuario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true))) {
            writer.write(usuario.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao salvar usuário no arquivo.");
        }
    }

    public static List<Usuario> carregarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String login = parts[0];
                    String senha = parts[1];
                    String cpf = parts[2];
                    String telefone = parts[3];
                    String endereco = parts[4];
                    Usuario usuario = new Usuario(login, senha, cpf, telefone, endereco);
                    usuarios.add(usuario);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar usuários do arquivo.");
        }

        return usuarios;
    }
}
