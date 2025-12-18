package com.dev.emilycxt.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

	public static void init() {
		// SQLs de criação das tabelas (Exemplo inicial)
		String tableUsuarios = """
				CREATE TABLE IF NOT EXISTS usuarios (
				    id INTEGER PRIMARY KEY AUTOINCREMENT,
				    nome TEXT NOT NULL,
				    email TEXT UNIQUE
				);
				""";
		// Espaço para mais strings...

		try (Connection conn = DataBaseConfig.getConnection(); Statement stmt = conn.createStatement()) {
			// exec stmt
			stmt.execute(tableUsuarios);
			System.out.println("Infra de banco de dados verificada/criada com sucesso.");
		} catch (SQLException e) {
			System.out.println("Erro crítico ao inicializar o banco de dados: " + e.getMessage());
		}
	}

}
