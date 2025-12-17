package com.dev.emilycxt.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ZeloProApp extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
	Label label = new Label ("Olá, o JavaFX está funcioando!");
	
	StackPane root = new StackPane();
	root.getChildren().add(label);
	
	Scene scene = new Scene (root, 400, 300);
	
	primaryStage.setTitle("ZeloPro");
	primaryStage.setScene(scene);
	
	primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
