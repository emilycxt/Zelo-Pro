package com.dev.emilycxt.database;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;

import org.junit.jupiter.api.Test;

class DataBaseConfigTest {
	
	@Test
	void deveCriarDiretorioDoBanco() {
		String dbPath = DataBaseConfig.getDbPath();
		Path path = Paths.get(dbPath).getParent();
		
		assertTrue(Files.exists(path), "Diretório do banco deveria existir");
	}
	
	@Test
	void deveAbrirConexaoComSQLite() {
		try (Connection conn = DataBaseConfig.getConnection()){
			assertNotNull(conn);
			assertFalse(conn.isClosed());
		}catch (Exception e) {
			fail ("Falha ao conectar no banco: " + e.getMessage());
		}
	}
	
}
