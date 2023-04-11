package main.test;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.assertions.api.LabeledAssert;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.Main;
import models.AdditionModel;
import views.AdditionController;


@ExtendWith(ApplicationExtension.class)
public class TestAdditionView
{
	
	
	@Start
	private void start(Stage stage)
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/views/addition-view.fxml"));
		
		BorderPane view;
		try
		{
			view = loader.load();
			
			Scene s = new Scene(view);
			stage.setScene(s);
			
			AdditionController controller = loader.getController();
			AdditionModel model= new AdditionModel();
			controller.setModel(model);
			
			stage.show();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void insertNums(FxRobot robot, String num1, String num2)
	{
		robot.clickOn("#num1Text");
		robot.write(num1);
		
		robot.clickOn("#num2Text");
		robot.write(num2);	
		
		robot.clickOn("#addButton");
		
		
	}
	
	private void checkResult(FxRobot robot,String ans)
	{
		
		Assertions.assertThat(robot.lookup("#resultLabel")
				.queryAs(Label.class))
				.hasText(ans);
		
	}
	
	private void checkResultWrong(FxRobot robot,String ans)
	{
		
		 Assertions.assertThat(robot.lookup("#resultLabel")
				.queryAs(Label.class))
				.doesNotHaveText(ans);
		
	}
	
	@Test
	public void addNums(FxRobot robot) throws InterruptedException
	{
		insertNums(robot,"5","6");
		checkResult(robot, "11");
	}
	
	@Test
	public void addNums2(FxRobot robot)
	{
		insertNums(robot,"a","6"); // given the wrong type
		checkResultWrong(robot, "12");
	}

	@Test
	public void addNums3(FxRobot robot)
	{
		insertNums(robot, "6", "7"); 
		checkResultWrong(robot, "12"); // given wrong ans
	}

}
