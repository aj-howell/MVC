/**
 * 
 */
package models;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * @author glahens.paul
 *
 */
public class AdditionModel 
{

	/**
	 * 
	 */
	Double num1;
	Double num2;
	DoubleProperty result = new SimpleDoubleProperty();
	
	
	public AdditionModel() 
	{
		
	}
	

	
	
	/**
	 * @return the result
	 */
	public DoubleProperty getResult() 
	{
		return result;
	}


	/**
	 * @param result the result to set
	 */
	public void setResult(DoubleProperty result)
	{
		this.result = result;
	}


	/**
	 * @return the num1
	 */
	public Double getNum1() 
	{
		return num1;
	}




	/**
	 * @param num1 the num1 to set
	 */
	public void setNum1(Double num1) 
	{
		this.num1 = num1;
	}



	/**
	 * @return the num2
	 */
	public Double getNum2() 
	{
		return num2;
	}

	/**
	 * @param num2 the num2 to set
	 */
	public void setNum2(Double num2) 
	{
		this.num2 = num2;
	}
	
	
	public void detlaAddition()
	{
		double res = num1 + num2;
		
		result.set(res);
		
		
	}

}
