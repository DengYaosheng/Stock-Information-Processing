import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class StockComparator<T> implements Comparator<Stock> {
    // Add the code for a comparator put the stock objects in order by date,
    // from early to later. For those stock objects on the same date,
    // you should put these in order by stock symbol.
    private static final String DATE_PATTERN = "MM/dd/yy";
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(DATE_PATTERN);

    @Override
    public int compare(Stock stock1, Stock stock2) {
        try {
            Date date1 = SIMPLE_DATE_FORMAT.parse(stock1.getDate());
            Date date2 = SIMPLE_DATE_FORMAT.parse(stock2.getDate());
            int compare1 = date1.compareTo(date2);
            return compare1 == 0
                    ? stock1.getSymbol().compareTo(stock2.getSymbol())
                    : compare1;

        } catch (ParseException e) {
            throw new ClassCastException();
        }

    }
}
