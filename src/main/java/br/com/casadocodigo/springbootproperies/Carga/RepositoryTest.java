package br.com.casadocodigo.springbootproperies.Carga;

import br.com.casadocodigo.springbootproperies.domain.Cliente;
import br.com.casadocodigo.springbootproperies.domain.Item;
import br.com.casadocodigo.springbootproperies.domain.Pedido;
import br.com.casadocodigo.springbootproperies.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RepositoryTest
        implements ApplicationRunner
{

    private static final long ID_CLIENTE_LUCAS = 11l;
    private static final long ID_CLIENTE_EDUARDO = 22l;

    private static final long ID_ITEM1 = 100l;
    private static final long ID_ITEM2 = 101l;
    private static final long ID_ITEM3 = 102l;

    private static final long ID_PEDIDO1 = 1000l;
    private static final long ID_PEDIDO2 = 1001l;
    private static final long ID_PEDIDO3 = 1002l;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        System.out.println(">>> Iniciando carga de dados...");
        Cliente lucas = new Cliente(ID_CLIENTE_LUCAS,"Lucas","SP");
        Cliente eduardo = new Cliente(ID_CLIENTE_EDUARDO,"Eduardo","SP");

        Item dog1 = new Item(ID_ITEM1,"Green Dog tradicional",25d);
        Item dog2 = new Item(ID_ITEM2,"Green Dog tradicional picante",27d);
        Item dog3 = new Item(ID_ITEM3,"Green Dog max salada",30d);

        List<Item> listaPedidoLucas1 = new ArrayList<Item>();
        listaPedidoLucas1.add(dog1);

        List<Item> listaPedidoEduardo = new ArrayList<Item>();
        listaPedidoEduardo.add(dog2);
        listaPedidoEduardo.add(dog3);

        Pedido pedidoDoLucas = new Pedido(ID_PEDIDO1,lucas,listaPedidoLucas1,dog1.getPreco());
        lucas.novoPedido(pedidoDoLucas);

        Pedido pedidoDoEduardo = new Pedido(ID_PEDIDO2,eduardo,listaPedidoEduardo,dog2.getPreco()+dog3.getPreco());
        eduardo.novoPedido(pedidoDoEduardo);

        System.out.println(">>> Pedido 1 - Lucas : "+ pedidoDoLucas);
        System.out.println(">>> Pedido 2 - Eduardo: "+ pedidoDoEduardo);


        clienteRepository.save(eduardo);
        System.out.println(">>> Gravado cliente 2: "+eduardo);

        List<Item> listaPedidoLucas2 = new ArrayList<Item>();
        listaPedidoLucas2.add(dog2);
        Pedido pedido2DoLucas  = new Pedido(ID_PEDIDO3,lucas,listaPedidoLucas2,dog2.getPreco());
        lucas.novoPedido(pedido2DoLucas);
        clienteRepository.save(lucas);
        System.out.println(">>> Pedido 2 - Lucas : "+ pedido2DoLucas);
        System.out.println(">>> Gravado cliente 1: "+lucas);

    }

}