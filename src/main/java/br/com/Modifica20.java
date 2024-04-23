package br.com;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Modifica20{
    public static void main(String[] args) {
        try {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Insira os detalhes do produto:");
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Preço: ");
                double preco = scanner.nextDouble();
                System.out.print("Quantidade: ");
                int quantidade = scanner.nextInt();

                Produto produto = new Produto(nome, preco, quantidade);

                adicionarProdutoAoCSV(produto);
            }

            System.out.println("Produto adicionado com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void adicionarProdutoAoCSV(Produto produto) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter("produtos.csv", true))) {
            String[] linha = {produto.getNome(), String.valueOf(produto.getPreco()), String.valueOf(produto.getQuantidade())};
            writer.writeNext(linha);
        }
    }
}