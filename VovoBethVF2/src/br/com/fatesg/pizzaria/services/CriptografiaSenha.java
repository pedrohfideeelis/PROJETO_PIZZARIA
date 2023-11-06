package br.com.fatesg.pizzaria.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografiaSenha {

    public static String encrypt(String input) {
        try {
            // Crie uma instância do MessageDigest com o algoritmo MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Converta a string de entrada em um array de bytes
            byte[] inputBytes = input.getBytes("UTF-8");

            // Atualize o MessageDigest com os bytes da entrada
            md.update(inputBytes);

            // Calcule o hash MD5
            byte[] digest = md.digest();

            // Converta o hash em uma representação hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // Trate a exceção de algoritmo MD5 não encontrado
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            // Trate outras exceções, como UnsupportedEncodingException
            e.printStackTrace();
            return null;
        }
    }
}
