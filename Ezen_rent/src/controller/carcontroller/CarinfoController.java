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
//�ӽ�
public class CarinfoController implements Initializable {
	
	
	@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
		
		
			
			ImageView[] imageViews = new ImageView[30];
			int x = 0;
			int y = 0;
			int xy = 0;
			int xy2 = 0;
			for( int i = 0 ; i<imageViews.length ; i++ ) {
				
				// ��ư ũ�� ���� �� ���� 
				imageViews[i] = new ImageView();
				imageViews[i].setFitWidth(30);
				imageViews[i].setFitHeight(30);
				imageViews[i].setId("img");
				
					 
//					Image image = new Image( ī���.get(i).get������� );
//					imageViews[i].setImage(image);
				
				// ��ư���� ��ġ ���� 
				xy = 30 + x*50;
				xy2 = 30 + y*50;
				imageViews[i].setLayoutX(xy);
				imageViews[i].setLayoutY(xy2);
				x++;
				
				// ��ư�� ������ 4�� �� �Ǹ� ���������� �Ѿ 
				if( i % 4 == 3  ) { 
					y++;
					x = 0;  // y ������ �Ѿ�� x�� �ʱ�ȭ �Ǿߵ� 
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
