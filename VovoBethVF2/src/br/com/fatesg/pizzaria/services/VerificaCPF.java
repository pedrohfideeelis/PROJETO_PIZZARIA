/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatesg.pizzaria.services;

import java.util.InputMismatchException;

public class VerificaCPF {

    public static boolean validarCPF(String cpf) {
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
}
