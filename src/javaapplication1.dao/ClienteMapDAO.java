/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.dao;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import javaapplication1.domain.Cliente;

/**
 *
 * @author rodrigo.pires
 */
public class ClienteMapDAO implements IClienteDAO {
    
    private final Map<Long, Cliente> map;
    
    public ClienteMapDAO() {
        this.map = new TreeMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (cliente == null || map.containsKey(cliente.getCpf())) {
            return false;
        }
        
        map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public Boolean excluir(Long cpf) {
        Cliente clienteRemovido = map.remove(cpf);
        return clienteRemovido != null;
    }

    @Override    
    public Boolean alterar(Cliente cliente) {
        if (cliente == null || !map.containsKey(cliente.getCpf())) {
            return false;
        }
        
        Cliente clienteCadastrado = map.get(cliente.getCpf());
        clienteCadastrado.setNome(cliente.getNome());
        clienteCadastrado.setTel(cliente.getTel());
        clienteCadastrado.setNumero(cliente.getNumero());
        clienteCadastrado.setEnd(cliente.getEnd());
        clienteCadastrado.setCidade(cliente.getCidade());
        clienteCadastrado.setEstado(cliente.getEstado());
        
        return true;
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }
    
    @Override
    public Collection<Cliente> buscarTodos(){
        return map.values();
    }
    
}
