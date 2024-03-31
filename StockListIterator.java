import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StockListIterator implements Iterator<Stock> {
    // Add code to implement an iterator for Stocks.
    // This will be similar to the iterator in OrderedStockList
    // with a few small changes.

    private Node cursor;
    /**
     * first call next() flag.
     * <p>
     * If first call next(),
     * then will return front stock of the OrderedStockList,
     * otherwise, return the real next stock.
     * <p>
     * So you could use it for iterate like this:
     * while(iterator.hasNext()){
     * System.out.println(iterator.next());
     * }
     */
    private boolean firstCall;

    public StockListIterator(OrderedStockList stockList) {
        this.cursor = stockList.getFront();
        this.firstCall = true;
    }

    @Override
    public boolean hasNext() {
        if (this.cursor == null) {
            return false;
        }
        return this.cursor.getNext() != null;
    }

    @Override
    public Stock next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        if (this.firstCall) {
            firstCall = false;
            return this.cursor.getData();
        }
        this.cursor = this.cursor.getNext();
        return this.cursor.getData();
    }


}