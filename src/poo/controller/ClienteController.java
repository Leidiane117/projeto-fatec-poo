package poo.controller;
import  poo.dto.Cliente;
import  poo.model.ClienteDAO;
import java.sql.SQLException;
import java.util.List;

public class ClienteController {
     static ClienteDAO clienteDAO;
    
    public Cliente inserir (Cliente pes) throws SQLException, ClassNotFoundException {
        clienteDAO = new ClienteDAO (); 
        return clienteDAO.inserir(pes);
    }
    public Cliente alterar (Cliente pes) throws SQLException, ClassNotFoundException {
        clienteDAO = new ClienteDAO (); 
        return clienteDAO.alterar(pes);
    }
    public List<Cliente> listar (Cliente pes) throws SQLException, ClassNotFoundException {
        clienteDAO = new ClienteDAO (); 
        return clienteDAO.listar(pes);
    }
    public Cliente excluir(Cliente pes) throws SQLException, ClassNotFoundException {
        clienteDAO = new ClienteDAO (); 
        return clienteDAO.excluir(pes);
    }
   

}

   