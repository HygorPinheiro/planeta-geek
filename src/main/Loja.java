package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.Produto;

public class Loja {
    private static Scanner input = new Scanner(System.in); // scanner oara receber os valores
    private static ArrayList<Produto> produtos; // Criamos uam arraylist para os produtos
    private static Map<Produto, Integer> carrinho; // Map ou Mapper para nosso carrinho

    public static void main(String[] args) {
        produtos = new ArrayList<>();
        carrinho = new HashMap<>(); // Classe que implementa um Mapper
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
        System.out.print("         OPÇÃO 3 | COMPRAR PRODUTO            \n");
        System.out.print("         OPÇÃO 4 | CARRINHO                   \n");
        System.out.print("         OPÇÃO 5 | SAIR                       \n");
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

            case 3:
                comprarProdutos();
                break;

            case 4:
                verCarrinho();
                break;

            case 5:
                System.out.print("ORBIGADO PELA PREFERÊNCIA, VOLTE SEMPRE!\n");
                System.exit();

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

        // Instanciando o produto

        Produto produto = new Produto(nome, preco);
        produtos.add(produto);

        // Dizendo que o produto foi cadastrado

        System.out.println(produto.getNome() + " cadastrado com sucesso!");
        menu();
    }

    // Listando os produtos, vamos verificar com o IF se há algum produto já
    // cadastrado em nossa lista

    private static void listarProdutos() {
        // aqui temos um FOR IT para Produto passand "p" como referência para cada
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

    // Implementação de comprar produtos

    private static void comprarProdutos() {

    }
}
