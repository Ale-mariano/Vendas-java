/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;



/**
 *
 * @author alema
 */
public class ConnectionFatory {
    
     public Connection getConnection() {
         
         try {
             return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdvendas", "usuariocurso", "123");
                     
         } catch (Exception erro) {
             throw new RuntimeException(erro);
         }
             
         }
         
     }

    
     

  

   

