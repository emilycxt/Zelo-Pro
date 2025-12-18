package com.dev.emilycxt.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

	public static void init() {

		// melhor utilizar em Array para que não tenha muito DRY
		String[] tabelas = { """
				CREATE TABLE IF NOT EXISTS usuarios (
				    id INTEGER PRIMARY KEY AUTOINCREMENT,
				    nome TEXT NOT NULL,
				    email TEXT UNIQUE
				);
				""", """
				CREATE TABLE IF NOT EXISTS clientes (
				    id INTEGER PRIMARY KEY AUTOINCREMENT,
				    nome TEXT NOT NULL,
				    email TEXT,
				    telefone TEXT,
				    endereco TEXT,
				    observacoes TEXT
				);
				"""

		};

		try (Connection conn = DataBaseConfig.getConnection(); Statement stmt = conn.createStatement()) {

			for (String sql : tabelas) {
				stmt.execute(sql);
			}

			System.out.println("[Database] Infraestrutura verificada com sucesso.");

		} catch (SQLException e) {
			System.err.println("[Database] Erro crítico na inicialização: " + e.getMessage());
		}
	}
}