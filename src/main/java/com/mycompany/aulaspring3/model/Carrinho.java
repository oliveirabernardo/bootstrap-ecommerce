package com.mycompany.aulaspring3.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Cliente cliente;
    @OneToMany(mappedBy = "carrinho", fetch = FetchType.EAGER)
    private List<Pedido> pedidos =  new ArrayList<>();

    public Carrinho (Cliente cliente) {
        this.setCliente(cliente);
    }

    public Carrinho() {

    }

    public int getId() {
        return id;
    }

    public void setCliente(Cliente proprietario) {
        this.cliente = proprietario;
    }

    public Cliente getCliente() {
        return cliente;
    }

/*    public void addItem(Produto produto) {
        boolean found = false;
            for (Pedido i : pedidos) {
                if (i.getProduto().getCodigo() == produto.getCodigo()) {
                    i.addQuantidade(1);
                    System.out.println("1");
                    found = true;
                }
            }
            if (!found) {
                Pedido item = new Pedido(this,produto);
                this.pedidos.add(item);
                for (Pedido i : pedidos) {
                    if (i.getProduto().getCodigo() == produto.getCodigo()) {
                        i.addQuantidade(1);
                        System.out.println("2");
                    }
                }
            }
    }*/

    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public void removerItem(int id) {
        for (Iterator<Pedido> it = pedidos.iterator(); it.hasNext();) {
            Pedido pedido = it.next();
            if (pedido.getProduto().getId() == id) {
                if (pedido.getQuantidade() == 1) {
                    it.remove();
                } else {
                    pedido.diminuirQuantidade(1);
                }
            }
        }
    }

/*    public void getProdutos() {
        if (produtos.size() > 0) {
            int index = 1;
            for (Produto item : produtos) {
                System.out.println(String.format(
                        "%d | Tipo: %s \n Marca: %s",
                        index++,
                        item.getTipo(),
                        item.getMarca()
                ));
            }
        } else {
            System.out.println("carrinho vazio");
        }
    }*/

    public List<Pedido> getPedidos() {
        return this.pedidos;
    }

    public Pedido getItem(int id) {
        Pedido i = null;
        for (Pedido pedido : pedidos) {
            if (pedido.getProduto().getId() == id) {
                i = pedido;
            }
        }
        return i;
    }

    public float getValorTotal() {
        float valorTotal = 0;
        for (Pedido pedido : pedidos) {
            valorTotal += pedido.getProduto().getValor();
        }
        return valorTotal;
    }


}
