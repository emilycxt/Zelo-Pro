package com.dev.emilycxt.database;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConfig {
	
	/*
	 * Aqui teremos uma pasta que será criada (ela será oculta) e será indenpendente
	 * do src
	 */
	
	private static final String APP_DATA_DIR = ".zelopro";
	private static final String DB_NAME = "dbfile.db";
	
	public static String getDbPath() {
		//O caminho será C:\Users\Nome\.zelopro (Windows) ou /home/nome/.zelopro (Linux/Mac)
		String userHome = System.getProperty("user.home");
		Path path = Paths.get(userHome, APP_DATA_DIR);
		
		try {
			if (Files.notExists(path)) {
				Files.createDirectories(path);
			}
		} catch (Exception e) {
			throw new RuntimeException ("Não foi possível criar a pasta do banco de dados", e);
		}
		return path.resolve(DB_NAME).toAbsolutePath().toString();
	}
	
	//Conexão centralizada
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:sqlite:" + getDbPath();
		return DriverManager.getConnection(url);
	}

}
