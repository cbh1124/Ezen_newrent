package controller.carcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
//임시
public class CarinfoController implements Initializable {
	
	
	@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
		
		
			
			ImageView[] imageViews = new ImageView[30];
			int x = 0;
			int y = 0;
			int xy = 0;
			int xy2 = 0;
			for( int i = 0 ; i<imageViews.length ; i++ ) {
				
				// 버튼 크기 지정 및 생성 
				imageViews[i] = new ImageView();
				imageViews[i].setFitWidth(30);
				imageViews[i].setFitHeight(30);
				imageViews[i].setId("img");
				
					 
//					Image image = new Image( 카목록.get(i).get사진경로 );
//					imageViews[i].setImage(image);
				
				// 버튼시작 위치 지정 
				xy = 30 + x*50;
				xy2 = 30 + y*50;
				imageViews[i].setLayoutX(xy);
				imageViews[i].setLayoutY(xy2);
				x++;
				
				// 버튼의 개수가 4개 가 되면 다음행으로 넘어감 
				if( i % 4 == 3  ) { 
					y++;
					x = 0;  // y 값으로 넘어가면 x는 초기화 되야됨 
					imageViews[i].setLayoutX(xy );
					imageViews[i].setLayoutY(xy2);
				}
				
				an.getChildren().add(imageViews[i]);
				
			}
			
		
			
		
		}
	

    @FXML
    private AnchorPane an;
    @FXML
    private ScrollPane sp;

	

    @FXML
    private AnchorPane cp;

}
