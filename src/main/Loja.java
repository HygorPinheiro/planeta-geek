package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.Produto;
import utils.Utils;

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
                System.out.print("VOLTE SEMPRE!\n");
                System.exit(0);

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

    // Implementação de comprar produtos

    private static void comprarProdutos() {
        if (produtos.size() > 0) {
            System.out.println("Código do produto: \n");

            System.out.println("Produtos Disponíveis: \n");
            for (Produto p : produtos) {
                System.out.println(p + "\n");
            }

            int id = Integer.parseInt(input.next()); // pegamos o id para achar o produto
            boolean isPresent = false;

            for (Produto p : produtos) {
                if (p.getId() == id) {
                    int qtd = 0;

                    try { // Aqui devemos validar se o id do produto se encontra disponível na nossa lista
                          // de produtos com p como parâmetro
                        qtd = carrinho.get(p);
                        carrinho.put(p, qtd + 1); // A cada vez que adicionarmos um produto será implementado +1
                    } catch (NullPointerException e) {
                        // se o produto for o primeiro do carrinho (match no id)
                        carrinho.put(p, 1);
                    }
                    System.out.println(p.getNome() + " adicionado com Sucesso!");
                    isPresent = true; // Agora mudamos para true pq já existe em nosso carrinho.

                    if (isPresent) {
                        System.out.println("Deseja adicionar outro produto ao carrinho de compras? \n");
                        System.out.println("Digite 1 para inserir outro produto ou 0 para sair");

                        int option = Integer.parseInt(input.next());

                        if (option == 1) {
                            comprarProdutos();
                        } else {
                            finalizarCompra();
                        }
                    }
                } else {
                    System.out.println("Produto não encontrado!!!");
                    menu();
                }
            }
        } else {
            System.out.println("Produto(s) não cadastrado(s)!!!");
            menu();
        }
    }

    private static void verCarrinho() { // Aqui percorremos o carrinho de produtos com produtos já cadastrados em nosso
                                        // carrinho e mostramos com o uso de keyset.
        System.out.println("---Produtos no seu carrinho: \n");
        if (carrinho.size() > 0) {
            for (Produto p : carrinho.keySet()) {
                System.out.println("Produto: " + p + "\nQuantidade: " + carrinho.get(p));
            }
        } else {
            System.out.println("Carrinho VAZIO!!!");
            menu();
        }
    }

    private static void finalizarCompra() {
        Double valorDaCompra = 0.0;
        System.out.println("Seus produtos: \n");

        for (Produto p : carrinho.keySet()) { // Aqui será o calculo do preço do produto x quantidade do produto para
                                              // fechar a compra com o valor total por cada produto.
            int qtd = carrinho.get(p);
            valorDaCompra += p.getPreco() * qtd;
            System.out.println(p);
            System.out.println("Quantidade: " + qtd);
        }
        System.out.println("O valor da sua compra é: " + valorDaCompra);
        carrinho.clear();
        System.out.print("ORBIGADO PELA PREFERÊNCIA, VOLTE SEMPRE!\n");
        menu();
    }
}
