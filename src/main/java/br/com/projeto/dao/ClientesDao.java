/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFatory;
import br.com.projeto.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author alema
 */
public class ClientesDao {
    
    private Connection con;
    
     public ClientesDao(){
         this.con=new ConnectionFatory().getConnection();
     }
    
    public void cadastrarCliente(Clientes obj){
        try {
        String sql = "Insert into tb_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                          +"values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getRg());
            stmt.setString (3,obj.getCpf());
            stmt.setString (4,obj.getEmail());
            stmt.setString(4,obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());

            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog (null, "Cadastrado com Sucesso!");
            
                      
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
        
    }
   
    //Método AlterarCliente
    
    public void alterarCliente(){
    
}
    
   // Método ExcluirCliente
    
    public void excluirCliente() {
        
    
    
   // Método Listar Todos os Clientes
    
      public List<Clientes> listarClientes(){
        try {

            //Criar a lista
            List<Clientes> lista = new ArrayList<>();

            //Criar o sql , e executar.
            String sql = "select * from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clientes obj = new Clientes();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                
                lista.add(obj);
            }
            
            return lista;
             
         } catch (SQLException erro) {
             
              JOptionPane.showMessageDialog(null, "Erro:" + erro);
            
            return null;
         }
         }
}
       

