module Ezen_rent {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.sql;
	requires mail; 					// mail 관련 라이브러리 
	requires activation;			// mail 관련 라이브러리 
	
	opens application to javafx.graphics, javafx.fxml;
	opens controller.boardcontroller to javafx.graphics, javafx.fxml;
	opens controller.membercontroller to javafx.graphics, javafx.fxml;
	opens controller.admincontroller to javafx.graphics, javafx.fxml;
	opens controller.reservationcontroller to javafx.graphics, javafx.fxml;
	opens controller.carcontroller to javafx.graphics, javafx.fxml;

//	opens dao to java.sql;
	opens domain to mail, activation, javafx.base;
}
