package com.dev.emilycxt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.emilycxt.database.DataBaseConfig;
import com.dev.emilycxt.model.Cliente;

public class ClienteDAO {
	
	/* Esse DAO salva novo cliente para o banco de dados! */
	
	public void insert (Cliente cliente) {
		String sql = "INSERT INTO clientes (nome, telefone, email, endereco, observacoes)"
				+ " VALUES (?, ?, ?, ?, ?)";
		
		try (Connection conn = DataBaseConfig.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, cliente.getNome());
			pstmt.setString(2, cliente.getTelefone());
			pstmt.setString(3, cliente.getEmail());
			pstmt.setString(4, cliente.getEndereco());
			pstmt.setString(5, cliente.getObservacoes());
			
			pstmt.executeUpdate();
			
			System.out.println("Cliente salvo com sucesso!");
		
		}	catch (SQLException e) {
				System.err.println("Houve um erro ao salvar o cliente: " + e.getMessage());
		}
		
	}
	
	/* retornando uma lista de todos os clientes */
	
	public List <Cliente> listarTodos(){
		String sql = "SELECT * FROM clientes";
		List<Cliente> clientes = new ArrayList<>();
		
		try (Connection conn = DataBaseConfig.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			while (rs.next()) {
				Cliente cliente = new Cliente(
					    rs.getLong("id"),
					    rs.getString("nome"),
					    rs.getString("telefone"),
					    rs.getString("endereco"),
					    rs.getString("observacoes"),
					    rs.getString("email")
						);
				clientes.add(cliente);
			}
		} catch (SQLException e) {
			System.err.println("Erro ao listar clientes: " + e.getMessage());
		}
		return clientes;
	}

}
