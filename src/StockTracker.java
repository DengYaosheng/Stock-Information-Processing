import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class StockTracker {
	
	public static void main(String[] args) throws FileNotFoundException {

		Comparator<Stock> comp = new StockComparator<Stock>();

		OrderedStockList stocks = new OrderedStockList(comp);
		

		FileReader fin = new FileReader(args[0]);
		Scanner filePtr = new Scanner(fin);
		filePtr.useDelimiter("[,\\n]"); // delimiters are commas, line feeds

		Scanner scan = new Scanner(System.in);
		// read the file and add values to stocks.
		// Use next() to read the strings, nextDouble() to read the price
		// and nextInt() to read the volume
	}
	
	// This method returns the minimum price for a given stock 
	// over all of there dates
	static double minPrice(OrderedStockList stocks, String symbol) {
		
		return 0.0;
	}
	
	// This method return the total value of all stocks in this that were sold 
	// on date.  This is the closing price time the volume.
	static double totalValueForDay( OrderedStockList stocks, String date) {
		return 0.0;
	}
	
	// This method finds the maximum increase from one day to the next 
	// for this stock for all of the days in the list
	static double maxIncrease( OrderedStockList stocks, String symbol) {
		return 0.0;
	}

}
