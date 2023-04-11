package views;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import models.AdditionModel;

public class AdditionController implements Initializable
{
    @FXML
    private TextField num1Text;

    @FXML
    private TextField num2Text;

    @FXML
    private Label resultLabel;
	
    @FXML
	private Button addButton;
    
    
    @FXML
    private Label ResultErrorHandle;

	
	private AdditionModel model;
	
	public void setModel(AdditionModel Model)
	{
		this.model=Model;
		StringConverter<Number> conv = new NumberStringConverter();
		Bindings.bindBidirectional(resultLabel.textProperty(), model.getResult(),conv);	
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		model=new AdditionModel();
		


		
	}

	@FXML
	void addAction() 
	{
		
		String number1 = num1Text.getText();
		String number2 = num2Text.getText();
		
		
		try
		{
			Double n1 = Double.parseDouble(num1Text.getText());
			Double n2 = Double.parseDouble(num2Text.getText());
		
			model.setNum1(n1);
			model.setNum2(n2);
		
			model.detlaAddition();
		}
		catch(Exception e)
		{
			ResultErrorHandle.setText("Error: Decimal Format");
			System.out.println("Change Format");
			e.printStackTrace();
		}
		
		
	}

	
	
	
}
