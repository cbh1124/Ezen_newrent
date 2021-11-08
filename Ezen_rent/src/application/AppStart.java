package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppStart extends Application{
	
	@Override
	public void start(Stage stage) throws Exception {
	try {
		Parent parent = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
			stage.setResizable(false); // 스테이지 크기고정
			stage.show();
	} catch (Exception e) {}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
