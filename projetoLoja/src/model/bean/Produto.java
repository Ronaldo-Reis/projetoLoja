
package model.bean;


public class Produto  {
    
    private int id;
    private String descricao;
    private double preco;
    private Venda venda;

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    } 

    @Override
    public String toString() {
        return getDescricao(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
