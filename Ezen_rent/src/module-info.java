module Ezen_rent {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.sql;
	requires mail; 					// mail 관련 라이브러리 
	requires activation;			// mail 관련 라이브러리 
	
	opens application to javafx.graphics, javafx.fxml;
	opens Day01 to javafx.graphics, javafx.fxml;
	opens app to javafx.graphics, javafx.fxml;
	opens controller to javafx.graphics, javafx.fxml;
	opens Day02 to javafx.graphics, javafx.fxml;
	opens dao to java.sql;
	opens domain to mail, activation, javafx.base;
}
