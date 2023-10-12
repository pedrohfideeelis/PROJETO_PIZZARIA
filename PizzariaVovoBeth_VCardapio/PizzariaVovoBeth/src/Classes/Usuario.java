package Classes;

import java.util.InputMismatchException;

public class Usuario {

    private String login;
    private String senha;
    private String cpf;
    private String telefone;
    private String endereco;

    public Usuario(String login, String senha, String cpf, String telefone, String endereco) {

        if (!validarCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido.");
        }

        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Função de validação do CPF
    private boolean validarCPF(String cpf) {
        // Remove todos os caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        try {
            // Calcula o primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += Integer.parseInt(cpf.substring(i, i + 1)) * (10 - i);
            }
            int digito1 = 11 - (soma % 11);
            if (digito1 == 10 || digito1 == 11) {
                digito1 = 0;
            }

            // Calcula o segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += Integer.parseInt(cpf.substring(i, i + 1)) * (11 - i);
            }
            int digito2 = 11 - (soma % 11);
            if (digito2 == 10 || digito2 == 11) {
                digito2 = 0;
            }

            // Verifica se os dígitos calculados são iguais aos dígitos do CPF
            return (Integer.parseInt(cpf.substring(9, 10)) == digito1)
                    && (Integer.parseInt(cpf.substring(10, 11)) == digito2);
        } catch (InputMismatchException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return login + "," + senha + "," + cpf + "," + telefone + "," + endereco;
    }
}
