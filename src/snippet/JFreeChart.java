//Garth Adcock
//IT-313 
///////////////////////////////////////////////////////////////////////////////////////////////
//This application will read from keyboard a currency to convert and then open the barchart file created
//The barchart file will then display the exchange rate in a single bar
//The currencies to select from are found in the currencies.txt file
//any other entered currency will return a message stating to choosee a correct currency
//the exchange rates originate from the used data fixer links
///////////////////////////////////////////////////////////////////////////////////////////////
package snippet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
///////////////////////////////////////////////////////////////////////////////////////////////
public class JFreeChart {
    public static void main(String[] args)
    {
    	try 
    	{
    		getExchangeRate(getUrlString(getCurrency()));
    	}
    	catch (java.lang.NumberFormatException e)
    	{
    		System.out.println("You have Entered an Incorrect Currency.  Please Try Again.");
    	}
		} //end of main method  
    public static String getCurrency() 
    {
    	File file = new File("C:\\Users\\gadcock\\eclipse-workspace\\JFreeChart Graphs Proj3B\\bin\\snippet\\currencies.txt");
    	  BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error. Please Try Again.");
		}   	 
    	  String st = ""; 	 
    	  try {
    		System.out.print("Enter a Currency Type to Convert to EUR: ");   	
			while ((st = br.readLine()) != null)
			    System.out.print(st + " ");	
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error. Please Try Again.");
		}   	  
    	  Scanner in = new Scanner(System.in);  	  
    	  String selectedCurrency = in.nextLine();
    	  selectedCurrency = selectedCurrency.toUpperCase();
      	 String result = selectedCurrency;
    	 System.out.println("You have selected " + selectedCurrency + " as your currency type to be converted.");
    	 in.close();
    	// String result ="";
		return result; 
    }  
    public static String getUrlString(String result)
    {
    String myCurrency = result.toUpperCase();
    	if (myCurrency.equals("PLN"))
    		{
    	Scanner zloty = null;
		try {
			zloty = new Scanner((new URL(
					"http://data.fixer.io/api/latest?access_key=9581c0fae2c6aa990231a12aab2a3192&symbols=PLN")).
			            openStream( ));
		} catch (IOException e) {
			e.printStackTrace();
		}       
		String exchangeRate = "";
    	        while (zloty.hasNextLine( )) {
    	            String line = zloty.nextLine( );
    	            //System.out.println(line);
    	            exchangeRate = line.substring(line.length() - 10, line.length()-2);
    	            System.out.println(line.substring(line.length() - 10, line.length()-2) + " is the exchange rate");
    	        }
    	        myCurrency = exchangeRate;
    	        zloty.close( );  		}   
///////////////////////////////////////////////////////////////////
    	if (myCurrency.equals("HUF"))
		{
	Scanner forint = null;
	try {
		forint = new Scanner((new URL(
				"http://data.fixer.io/api/latest?access_key=9581c0fae2c6aa990231a12aab2a3192&symbols=HUF")).
		            openStream( ));
	} catch (IOException e) {
		e.printStackTrace();
	}           	
			String exchangeRate = "";

	        while (forint.hasNextLine( )) {
	            String line = forint.nextLine( );
	            //System.out.println(line);
	            exchangeRate = line.substring(line.length() - 12, line.length()-2);
	            System.out.println(line.substring(line.length() - 12, line.length()-2) + " is the exchange rate");
	        }
	        myCurrency = exchangeRate;
	        forint.close( );
		}  
/////////////////////////////////////////////////////////////////// 	 	
       	if (myCurrency.equals("USD"))
    		{
    	Scanner dollar = null;
    	try {
    		dollar = new Scanner((new URL(
    				"http://data.fixer.io/api/latest?access_key=9581c0fae2c6aa990231a12aab2a3192&symbols=USD")).
    		            openStream( ));
    	} catch (IOException e) {
    		e.printStackTrace();
    	}       
    	String exchangeRate = "";
    	        while (dollar.hasNextLine( )) {
    	            String line = dollar.nextLine( );
    	            //System.out.println(line);
    	            exchangeRate = line.substring(line.length() - 10, line.length()-2);
    	            System.out.println(line.substring(line.length() - 10, line.length()-2) + " is the exchange rate");             
    	        }
    	        myCurrency = exchangeRate;
    	        //System.out.println(exchangeRate + "this is the exchange rate val outside of the loop");
    	        dollar.close( );
    		}  
        	//return exchangeRate;
/////////////////////////////////////////////////////////////////// 	
       	if (myCurrency.equals("RUB"))
    		{
    	Scanner ruble = null;
    	try {
    		ruble = new Scanner((new URL(
    				"http://data.fixer.io/api/latest?access_key=9581c0fae2c6aa990231a12aab2a3192&symbols=RUB")).
    		            openStream( ));
    	} catch (IOException e) {
    		e.printStackTrace();
    	}       
    	String exchangeRate = "";

    	        while (ruble.hasNextLine( )) {
    	            String line = ruble.nextLine( );
    	            //System.out.println(line);
    	            exchangeRate = line.substring(line.length() - 10, line.length()-2);
    	            System.out.println(line.substring(line.length() - 10, line.length()-2) + " is the exchange rate");
    	        }
    	        myCurrency = exchangeRate;
    	        ruble.close( );
    		}  		
///////////////////////////////////////////////////////////////  	
       	if (myCurrency.equals("GBP"))
    		{
    	Scanner pound = null;
    	try {
    		pound = new Scanner((new URL(
    				"http://data.fixer.io/api/latest?access_key=9581c0fae2c6aa990231a12aab2a3192&symbols=GBP")).
    		            openStream( ));
    	} catch (IOException e) {
    		e.printStackTrace();
    	}           	
    	String exchangeRate = "";
    	        while (pound.hasNextLine( )) {
    	            String line = pound.nextLine( );
    	            //System.out.println(line);
    	            exchangeRate = line.substring(line.length() - 9, line.length()-2);

    	            System.out.println(line.substring(line.length() - 9, line.length()-2) + " is the exchange rate");
    	        }
    	        myCurrency = exchangeRate;

    	        pound.close( );
    		}  	   	
///////////////////////////////////////////////////////////////////    	
		return myCurrency;     
/////////////////////////////////////////////////////////////////// 	   	        
    } 
    public static void getExchangeRate(String myCurrency)
    { 	
	Scanner euro = null;
	try {
		euro = new Scanner((new URL(
				"http://data.fixer.io/api/latest?access_key=9581c0fae2c6aa990231a12aab2a3192&symbols=EUR")).
		            openStream( ));
	} catch (IOException e) {
		e.printStackTrace();
	}       
	String baseCurrencyValue = "";
	        while (euro.hasNextLine( )) {
	            String line = euro.nextLine( );
	            //System.out.println(line);            
	            baseCurrencyValue = line.substring(line.length() - 3, line.length()-2);
	        }       
	        //System.out.println(baseCurrencyValue); //base currency val  (EUR) 
	        euro.close( );       
    	    double exchangeRateofCurrency = Double.parseDouble(myCurrency); //exchange rate
	        double convertCurrency = Double.parseDouble(baseCurrencyValue); //base currency val
	        double answer = ( (convertCurrency) / (exchangeRateofCurrency));
	        String finalResult = Double.toString(answer);
	        System.out.println("---------------------------");
	        System.out.println(finalResult + " Euro");
	        System.out.println("---------------------------");       
			//////////////////////////////////////////////////////////////////////////////////////
			try
			{
			// Define the data for line chart.
				DefaultCategoryDataset barChartDataset = 
				new DefaultCategoryDataset();
				barChartDataset.addValue(exchangeRateofCurrency, "total", myCurrency + " is the exchange rate for this currency." );		
				org.jfree.chart.JFreeChart barChartObject = ChartFactory.createBarChart(
				"Exchange Rate", "", "", barChartDataset,
				PlotOrientation.VERTICAL, 
				false, false, false);              	
				// Write the line chart to file.               
				int imageWidth = 640;
				int imageHeight = 480;                
				File barChart = new File("currencyConversion.png");              
				ChartUtilities.saveChartAsPNG(
				barChart, barChartObject, imageWidth, imageHeight); 
			}
			catch (Exception i)
			{
				System.out.println(i);
			}
			JFrame frame = new JFrame();
			ImageIcon icon = new ImageIcon("currencyConversion.png");
			JLabel label = new JLabel(icon);
			frame.add(label);
			frame.setDefaultCloseOperation
			(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);	
//////////////////////////////////////////////////////////////////////////////////////	            
    }
} //end class