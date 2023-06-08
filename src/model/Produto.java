package model;

public class Produto {
    private static int count = 1; // Cada produto terá um ID começando de 1.

    private int id;
    private String nome;
    private double preco;
    private int quantidade;

   
    public Produto(String nome, double preco2, int quantidade) {
        this.id = count;
        this.nome = nome;
        this.preco = preco2;
        this.quantidade = quantidade;
        Produto.count += 1; // Cada produto terá uma contagem de ID começando de 1.
    }

    // Métodos getters e setters

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Representação do produto como uma string

    public String toString() {
        return "Id: " + this.getId() +
                "\nNome: " + this.getNome() +
                "\nPreço: " + this.getPreco() +
                "\nQuantidade: " + this.getQuantidade();
    }
}
