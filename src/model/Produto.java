package model;

//Aqui falta o import do util do método de conversão de valores.
import utils.Utils;

public class Produto {
    private static int count = 1; // Aqui cada produto terá um ID começando de 1.

    private int id;
    private String nome;
    private Double preco;

    public Produto(String nome, Double preco) {
        this.id = count;
        this.nome = nome;
        this.preco = preco;
        Produto.count += 1; // Aqui cada produto terá uma contagem de ID começando de 1.
    }

    // Aqui estão os métodos geters e seters//

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    // Aqui é como o produto será mostrado: id + nome + preço//

    public String toString() {
        return "Id: " + this.getId() +
                "\nNome: " + this.getNome() +
                "\nPreço: " + this.getPreco();
    }

    // public String toString() {
    // double precoDouble = Double.parseDouble(this.getPreco());
    // return "Id: " + this.getId() +
    // "\nNome: " + this.getNome() +
    // "\nPreço: " + Utils.doubleToString(precoDouble);
    // }

}
