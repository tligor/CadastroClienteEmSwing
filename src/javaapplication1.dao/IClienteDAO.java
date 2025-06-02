/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.dao;

import java.util.Collection;
import javaapplication1.domain.Cliente;

/**
 *
 * @author rodrigo.pires
 */
public interface IClienteDAO {
    
    Boolean cadastrar(Cliente cliente);
    
    Boolean excluir(Long cpf);
    
    Boolean alterar(Cliente cliente);
    
    Cliente consultar(Long cpf);
    
    Collection<Cliente> buscarTodos();
}
