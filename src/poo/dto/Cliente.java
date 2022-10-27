package poo.dto;

public class Cliente {
    private int id;
    private String nome;
    private String celular;
    private String email;
    
    /**
     *
     * @param id
     */
    public Cliente(int id) {
        this.id = id;
    }
    //pesquisa 
    public Cliente() {
       
    }
    
    // para inserir pessoa
    public Cliente(String nome, String celular, String email) {
        this.nome = nome;
        this.celular = celular;
        this.email = email;
    }
    // para alterar dados de pessoa
    public Cliente(int id, String nome, String celular, String email) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.email = email;
    }

    // get e set para valorização de variaveis
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    // para impressao
    @Override
    public String toString() {
        return "Cliente{" + "\nid=" + id + ", \nnome=" + nome + ",  \ncelular=" + celular + ", \nemail=" + email + '}';
    }
    
    
    
    
}
