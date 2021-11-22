package controller.carcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.CarDao;
import domain.Car;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

//임시
public class CarinfoController implements Initializable {

	//1. DB에서 목록 가져오기
	 public void cartableload() {
	
	 }
	 
	//ObservableList<Car> carloads = CarDao.getCarDao().cartableloading();
	
	 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
			ObservableList<Car> carloads = CarDao.getCarDao().cartableloading();
			
			//ImageView[] imageViews = new ImageView[carloads.size()];
			Button[] buttons = new Button[carloads.size()];
			int x = 0;
			int y = 0;
			int xy = 0;
			int xy2 = 0;
			for( int i = 0 ; i<buttons.length ; i++ ) {
				
				// 버튼 크기 지정 및 생성 
				buttons[i] = new Button();
				buttons[i].setPrefWidth(300);
				buttons[i].setPrefHeight(300);
				buttons[i].setId("img");
				System.out.println("오류 체크");
				System.out.println(carloads.get(i).getC_img());
				// 이미지객체로 이미지 경로 저장 및 이미지생성 
				// 이미지 뷰를 통해서 이미지 삽입 
				// 버튼에 이미지 뷰 삽입 
					Image image = new Image( carloads.get(i).getC_img());
					ImageView imageView = new ImageView(image);
					imageView.setFitWidth(170);
					imageView.setFitHeight(100);
					
				buttons[i].setGraphic(imageView);
				buttons[i].setMaxSize(170, 100);
				
				// 버튼시작 위치 지정 
				xy = 50 + x*200;
				xy2 = 30 + y*150;
				buttons[i].setLayoutX(xy);
				buttons[i].setLayoutY(xy2);
				x++;
				
				// 버튼의 개수가 4개 가 되면 다음행으로 넘어감 
				if( i % 4 == 3  ) { 
					y++;
					x = 0;  // y 값으로 넘어가면 x는 초기화 되야됨 
					buttons[i].setLayoutX(xy);
					buttons[i].setLayoutY(xy2);
				}
				
				
				an.getChildren().add(buttons[i]);
				
			}

	}
	
    @FXML
    private AnchorPane an;

    @FXML
    private ScrollPane sp;



			
		
		


}
