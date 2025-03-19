package com.example.Backend._3.Irmaos.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class User {

    private String nome;

    private String sobrenome;

    private String senha;

    @Id
    private String email;

    private List<ProdutoCarrinho> carrinho;

    private Cartao cartao;

    public static class Cartao {

        private String num_cartao;

        private Double saldo;

        public Cartao(String num_cartao, Double saldo) {
            this.num_cartao = num_cartao;
            this.saldo = saldo;
        }

        public String getNum_cartao() {
            return num_cartao;
        }

        public void setNum_cartao(String num_cartao) {
            this.num_cartao = num_cartao;
        }

        public Double getSaldo() {
            return saldo;
        }

        public void setSaldo(Double saldo) {
            this.saldo = saldo;
        }

        @Override
        public String toString() {
            return "Cartao{" +
                    "num_cartao='" + num_cartao + '\'' +
                    ", saldo=" + saldo +
                    '}';
        }
    }

    public static class ProdutoCarrinho {

        private String id;

        private String nome;

        private int quantidade;

        private Double valor;

        public ProdutoCarrinho(String id, String nome, int quantidade, Double valor) {
            this.id = id;
            this.nome = nome;
            this.quantidade = quantidade;
            this.valor = valor;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

        public Double getValor() {
            return valor;
        }

        public void setValor(Double valor) {
            this.valor = valor;
        }

        @Override
        public String toString() {
            return "ProdutoCarrinho{" +
                    "id='" + id + '\'' +
                    ", nome='" + nome + '\'' +
                    ", valor=" + valor +
                    '}';
        }

    }

    public User(String nome, String sobrenome, String email, Cartao cartao) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cartao = cartao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public List<ProdutoCarrinho> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<ProdutoCarrinho> carrinho) {
        this.carrinho = carrinho;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    @Override
    public String toString() {
        return "User{" +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", cartao=" + cartao +
                '}';
    }
}
