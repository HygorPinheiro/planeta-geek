package main;

import java.util.ArrayList;
import java.util.Scanner;

import model.Produto;

public class Loja {
    private static Scanner input = new Scanner(System.in); // scanner oara receber os valores
    private static ArrayList<Produto> produtos; // Criamos uam arraylist para os produtos

    public static void main(String[] args) {
        produtos = new ArrayList<>();
        menu();
    }

    // Criação do Menu

    private static void menu() {

        System.out.print("----------------------------------------------\n");
        System.out.print("---------BEM VINDO(A) AO PLANETA GEEK---------\n");
        System.out.print("----------------------------------------------\n");
        System.out.print("--------------SELECIONE UMA OPÇÃO-------------\n");
        System.out.print("----------------------------------------------\n");
        System.out.print("         OPÇÃO 1 | CADASTRAR PRODUTO          \n");
        System.out.print("         OPÇÃO 2 | LISTAR PRODUTO             \n");
        System.out.print("         OPÇÃO 3 | EXCLUIR PRODUTO             \n");
        System.out.print("         OPÇÃO 4 | SAIR                       \n");
        System.out.print("----------------------------------------------\n");

        // Criação das opções do menu e implementação de seus métodos

        int option = input.nextInt();

        switch (option) {
            case 1:
                cadastrarProdutos();
                break;
            case 2:
                listarProdutos();
                break;
            case 4:
                System.out.print("VOLTE SEMPRE!\n");
                System.exit(0);
            case 3:
                excluirProduto();
                menu();
                break;
            default:
                System.out.print("OPÇÃO INVALIDA!!!\n");
                menu();
                break;
        }
    }

    // Criação dos Métodos

    private static void cadastrarProdutos() {
        // Recebendo as informações de entrada do produto
        System.out.println("Nome do produto: ");
        String nome = input.next();        
        System.out.println("Preço do produto: ");
        Double preco = input.nextDouble();
        System.out.println("Quantidade do produto: ");
        int quantidade = input.nextInt();
    
        Produto produto = new Produto(nome, preco, quantidade);
        produtos.add(produto);
    
        // Indicando que o produto foi cadastrado
        System.out.println(produto.getNome() + " cadastrado com sucesso!");
    
        System.out.println("Deseja cadastrar mais itens? Digite 1 para sim e 0 para sair");
        int option = input.nextInt();
    
        if (option == 1) {
            cadastrarProdutos();
        } else if (option == 0) {
            menu();
        } else {
            System.out.println("Opção inválida!");
            cadastrarProdutos();
        }
    }    

    private static void listarProdutos() {
        // aqui temos um FOR para Produto passand "p" como referência para cada
        // produto dentro da lista de produtos ele será mostrado
        if (produtos.size() > 0) {
            System.out.println("Lista de produtos: \n");

            for (Produto p : produtos) {
                System.out.println(p);
            }
        } else {
            System.out.println("Nenhum produto cadastrado");
        }
        menu();
    }

    private static void excluirProduto() {
        System.out.println("Digite o ID do produto que deseja excluir: ");
        int id = input.nextInt();
    
        boolean produtoEncontrado = false;
    
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
    
            if (produto.getId() == id) {
                produtos.remove(i);
                System.out.println("Produto removido com sucesso!");
                produtoEncontrado = true;
                break;
            }
        }
    
        if (!produtoEncontrado) {
            System.out.println("Produto não encontrado!");
        }
    
        menu();
    }
    
}
