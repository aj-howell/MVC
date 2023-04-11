package main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.AdditionModel;
import views.AdditionController;

public class Main extends Application {


	@Override
	public void start(Stage stage) throws Exception 
	{
		//set up fxml loader,its path, contents inside border pane
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/views/addition-view.fxml"));
		
		BorderPane view = loader.load();
		
		Scene s = new Scene(view);
		stage.setScene(s);
		
		//get correct controller
		AdditionController controller = loader.getController();
		AdditionModel model= new AdditionModel();
		controller.setModel(model);
		
		//display
		stage.show();

	}
	public static void main (String[] args)
	{
		launch(args);
		
	}

}
