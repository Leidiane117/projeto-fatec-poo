package poo.model;
import  poo.dto.Cliente;
import  poo.until.Conexao;
import  java.sql.Connection;
import  java.sql.PreparedStatement;
import  java.sql.ResultSet;
import  java.sql.SQLException;
import  java.sql.Statement;
import  java.util.ArrayList;
import  java.util.List;


public class ClienteDAO {
    private final Connection c;
    public ClienteDAO() throws SQLException, ClassNotFoundException{
    this.c = Conexao.getConexao();
    
    }
 public Cliente inserir(Cliente clienteE) throws SQLException{
        String sql = "insert into cliente " + " (nome, celular, email)" + " values (?,?,?)";
    
        // seta os valores
        try ( // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setString(1,clienteE.getNome());
            stmt.setString(2,clienteE.getCelular());
            stmt.setString(3,clienteE.getEmail());
            
            // executa
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                clienteE.setId(id);
            }
        stmt.close();
        return clienteE;
    }
}

    public Cliente excluir(Cliente clienteE) throws SQLException{
        String sql = "delete from cliente WHERE id = ?";
          // seta os valores
          try ( // prepared statement para inserção
                  PreparedStatement stmt = c.prepareStatement(sql)) {
              // seta os valores
              stmt.setInt(1,clienteE.getId());
              // executa
              stmt.execute();
              stmt.close();
              c.close();
              return clienteE;
            }   
       
    }
          
  

    public Cliente alterar(Cliente clienteE) throws SQLException{
        String sql = "UPDATE cliente SET nome = ?, celular = ?, email = ? WHERE id = ?";
        // seta os valores
        try ( // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,clienteE.getNome());
            stmt.setString(2,clienteE.getCelular());
            stmt.setString(3,clienteE.getEmail());
            stmt.setInt(4,clienteE.getId());
            
            // executa
            stmt.execute();
            stmt.close();
        return clienteE;
    }
 }
    
   public List<Cliente> listar(Cliente clienteEntrada) throws SQLException{
        // usus: array armazena a lista de registros
        List<Cliente> pess = new ArrayList<>();
         String sql = "select * from cliente where nome like ?";
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setString(1,"%" + clienteEntrada.getNome() + "%");          
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // criando o objeto Usuario
                    Cliente cliente = new Cliente(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4)
                            
                    );
                    // adicion
                    pess.add(cliente);
                }
                
                rs.close();
                stmt.close();
                return pess;
            }
        catch(SQLException ex){
              throw new RuntimeException(ex + "Algo aconteceu de errado com a conexão com a query, veja: ");
          
        
        }
        
      }
    
   } 
  
public List<Cliente> listarTudo(Cliente clienteEntrada) throws SQLException{
        // usus: array armazena a lista de registros
        List<Cliente> pess = new ArrayList<>();
         String sql = "select * from cliente";
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
                
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // criando o objeto Usuario
                    Cliente cliente = new Cliente(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4)
                            
                    );
                    // adicion
                    pess.add(cliente);
                }
                
                rs.close();
                stmt.close();
                return pess;
            }
        catch(SQLException ex){
              throw new RuntimeException(ex + "Algo aconteceu de errado com a conexão com a query, veja: ");
          
        
        }
        
      }
    
}

}
     