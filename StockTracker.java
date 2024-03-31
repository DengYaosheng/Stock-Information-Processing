import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class StockTracker {

    public static void main(String[] args) throws FileNotFoundException {
        Comparator<Stock> comp = new StockComparator<Stock>();

        OrderedStockList stocks = new OrderedStockList(comp);

//        String fileName = "StockQuotes.txt";
//        FileReader fin = new FileReader(fileName);
        FileReader fin = new FileReader(args[0]);
        Scanner filePtr = new Scanner(fin);
        filePtr.useDelimiter("[,\\n]"); // delimiters are commas, line feeds

//		Scanner scan = new Scanner(System.in);
        // read the file and add values to stocks.
        // Use next() to read the strings, nextDouble() to read the price
        // and nextInt() to read the volume
        while (filePtr.hasNext()) {
            Stock stock = new Stock(filePtr.next(), filePtr.next(), filePtr.next(), filePtr.nextDouble(), filePtr.nextInt());
            // Actually the first column is name, and the second column is symbol,
            // but I'm not allowed to modify the Stock constructor
            String name = stock.getStockName();
            stock.setStockName(stock.getSymbol());
            stock.setSymbol(name);

            stocks.insert(stock);
        }

        System.out.println(stocks);
//        System.out.println(minPrice(stocks, "MSFT"));
//        System.out.println(totalValueForDay(stocks, "9/02/20"));
//        System.out.println(maxIncrease(stocks, "MSFT"));
    }

    // This method returns the minimum price for a given stock
    // over all of there dates
    static double minPrice(OrderedStockList stocks, String symbol) {
        double minPrice = Double.MAX_VALUE;
        StockListIterator iterator = new StockListIterator(stocks);

        while (iterator.hasNext()) {
            Stock stock = iterator.next();
            if (stock.getSymbol().equals(symbol)) {
                minPrice = Math.min(stock.getClosingPrice(), minPrice);
            }
        }

        return minPrice;
    }

    // This method return the total value of all stocks in this that were sold
    // on date.  This is the closing price time the volume.
    static double totalValueForDay(OrderedStockList stocks, String date) {
        double totalValueForDay = 0.0;
        StockListIterator iterator = new StockListIterator(stocks);

        while (iterator.hasNext()) {
            Stock stock = iterator.next();
            if (stock.getDate().equals(date)) {
                totalValueForDay += stock.getClosingPrice() * stock.getVolume();
            }
        }

        return totalValueForDay;
    }

    // This method finds the maximum increase from one day to the next
    // for this stock for all of the days in the list
    static double maxIncrease(OrderedStockList stocks, String symbol) {
        double maxIncrease = 0.0;
        StockListIterator iterator = new StockListIterator(stocks);
        List<Stock> stockList = new ArrayList<>();

        while (iterator.hasNext()) {
            Stock stock = iterator.next();
            if (stock.getSymbol().equals(symbol)) {
                stockList.add(stock);
            }
        }

        if (stockList.size() == 0 || stockList.size() == 1) {
            return maxIncrease;
        }

        Comparator<Stock> comp = new StockComparator<Stock>();
        // sort by date
        stockList.sort(comp);
        Stock lastStock = stockList.get(0);
        for (int i = 1; i < stockList.size(); i++) {
            Stock stock = stockList.get(i);
            try {
                Date date1 = StockComparator.SIMPLE_DATE_FORMAT.parse(lastStock.getDate());
                Date date2 = StockComparator.SIMPLE_DATE_FORMAT.parse(stock.getDate());
                // greater than one day
                if (date2.getTime() - date1.getTime() > 24 * 60 * 60 * 1000) {
                    lastStock = stock;
                    continue;
                }
            } catch (ParseException e) {
                lastStock = stock;
                continue;
            }
            double diff = stock.getClosingPrice() - lastStock.getClosingPrice();
            maxIncrease = Math.max(diff, maxIncrease);
        }
        return maxIncrease;
    }

}
