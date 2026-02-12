package com.dev.emilycxt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.emilycxt.database.DataBaseConfig;
import com.dev.emilycxt.model.Role;
import com.dev.emilycxt.model.Usuario;

public class UsuarioDAO {

    /* Salva um novo usuário no banco */
    public void insert(Usuario usuario) {
        
        String sql = "INSERT INTO usuarios (nome, senha_hash, role) VALUES (?, ?, ?)";

        try (Connection conn = DataBaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getSenhaHash());
            
            // Convertendo o ENUM para String para salvar no banco
            pstmt.setString(3, usuario.getRole().name()); 
            
            if (usuario.getRole() == null) {
                throw new IllegalArgumentException("Role não pode ser null");
            }


            pstmt.executeUpdate();

            System.out.println("Usuário salvo com sucesso!");

        } catch (SQLException e) {
            System.err.println("Houve um erro ao salvar o usuário: " + e.getMessage());
        }
    }

    /* Retorna lista de usuários */
    public List<Usuario> listarTodos() {
        String sql = "SELECT * FROM usuarios";
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection conn = DataBaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenhaHash(rs.getString("senha_Hash"));
                
                // Convertendo String do banco de volta para ENUM
                // Se o banco tiver "ADMIN", transforma em Role.ADMIN
                String roleString = rs.getString("role");
                if (roleString != null) {
                    usuario.setRole(Role.valueOf(roleString));
                }

                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar usuários: " + e.getMessage());
        }
        return usuarios;
    }
}