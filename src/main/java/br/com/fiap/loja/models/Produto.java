package br.com.fiap.loja.models;

import br.com.fiap.loja.models.Dtos.ProdutoAddOuUpdateDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "produto", schema = "loja")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private int quantidade;
    @Column
    private double valor;
    @Column
    private LocalDate dataCriacao = LocalDate.now();

    public Produto(ProdutoAddOuUpdateDTO produtoAddOuUpdateDTO) {
        this.nome = produtoAddOuUpdateDTO.getNome();
        this.quantidade = produtoAddOuUpdateDTO.getQuantidade();
        this.valor = produtoAddOuUpdateDTO.getValor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
    private List<br.com.fiap.loja.models.PedidoItens> PedidoItens;

    public Produto() {
    }
}
