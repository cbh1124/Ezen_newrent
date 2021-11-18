package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppStart extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/fxml/loginpage.fxml"));



			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setResizable(false); // 스테이지 크기고정
			stage.setTitle("EzenRentCar");
			stage.show();
			
			// 폰트적용
//			Font.loadFont(getClass().getResourceAsStream("GmarketSansTTFLight.ttf"), 14);
//			Font.loadFont(getClass().getResourceAsStream("GmarketSansTTFMedium.ttf"), 14);
//			Font.loadFont(getClass().getResourceAsStream("GmarketSansTTFBold.ttf"), 14);

			// 외부 폰트css적용
			scene.getStylesheets().add(getClass().getResource("font_gmarketL.css").toExternalForm());
			scene.getStylesheets().add(getClass().getResource("font_gmarketM.css").toExternalForm());
			scene.getStylesheets().add(getClass().getResource("font_gmarketB.css").toExternalForm());
			
			
			
			
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

