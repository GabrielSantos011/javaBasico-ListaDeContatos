package br.com.listaDeContatos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ListaDeContatos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> contatos = new HashMap<>(); // Criando o HashMap

        while (true) {
            System.out.println("""
                               --- Menu ---
                               1. Adicionar contato
                               2. Remover contato
                               3. Buscar contato
                               4. Listar contatos
                               5. Sair
                               Escolha uma opção: """);

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefone = scanner.nextLine();
                    contatos.put(nome, telefone); // Adiciona ou atualiza o contato
                    System.out.println("Contato adicionado!");
                    break;

                case 2:
                    System.out.print("Digite o nome do contato a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    if (contatos.remove(nomeRemover) != null) {
                        System.out.println("Contato removido!");
                    } else {
                        System.out.println("Contato não encontrado!");
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome do contato a ser buscado: ");
                    String nomeBuscar = scanner.nextLine();
                    if (contatos.containsKey(nomeBuscar)) {
                        System.out.println("Telefone: " + contatos.get(nomeBuscar));
                    } else {
                        System.out.println("Contato não encontrado!");
                    }
                    break;

                case 4:
                    System.out.println("\nLista de contatos:");
                    for (Map.Entry<String, String> entry : contatos.entrySet()) {
                        System.out.println(entry.getKey() + " -> " + entry.getValue());
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

}
