package javaapplication1.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javaapplication1.domain.Cliente;

/**
 *
 * @author rodrigo.pires
 */
public class ClienteSetDAO implements IClienteDAO {
    
    private final Set<Cliente> set;
    
    public ClienteSetDAO() {
        this.set = new HashSet<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (cliente == null) {
            return false;
        }
        return this.set.add(cliente);
    }

    @Override
    public Boolean excluir(Long cpf) {
        Cliente clienteEncontrado = consultar(cpf);
        if (clienteEncontrado != null) {
            this.set.remove(clienteEncontrado);
            return true;
        }
        return false;
    }

    @Override
    public Boolean alterar(Cliente cliente) {
        if (cliente == null || !this.set.contains(cliente)) {
            return false;
        }
        
        Cliente clienteCadastrado = consultar(cliente.getCpf());
        if (clienteCadastrado != null) {
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setTel(cliente.getTel());
            clienteCadastrado.setNumero(cliente.getNumero());
            clienteCadastrado.setEnd(cliente.getEnd());
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setEstado(cliente.getEstado());
            return true;
        }
        return false;
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.set.stream()
                .filter(cliente -> cliente.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return new HashSet<>(this.set);
    }
}