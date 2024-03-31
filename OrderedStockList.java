import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class OrderedStockList {

    private int size;
    private Node front;
    private Node rear;

    private Iterator<Stock> iter;
    private Comparator<Stock> comp;

    public OrderedStockList(Comparator<Stock> compChoice) {
        size = 0;
        front = rear = null;
        comp = compChoice;
    }

    public Node getFront() {
        return front;
    }

    public Node getRear() {
        return rear;
    }

    public int getSize() {
        return size;
    }

    // This method insert the item into the list in the order
    // specified by the Comparator comp
    public void insert(Stock item) {

        Node current = front;
        Node prev = null;

        Node node = new Node(item);
        if (size == 0) {
            front = rear = node;
            size++;
            return;
        }
        if (size == 1) { // prev == null
            if (comp.compare(current.getData(), item) > 0) { // insert before front
                node.setNext(current);
                node.setPrev(null);
                current.setPrev(node);
                front = node;
            } else { // insert after front
                front.setNext(node);
                node.setPrev(front);
                rear = node;
            }
            size++;
            return;
        }
        // list size 2 or bigger
        while (current != null) {
            if (comp.compare(current.getData(), item) < 0) {
                prev = current;
                current = current.getNext();
            } else { // insert before this node
                if (prev == null) {
                    node.setNext(front);
                    front.setPrev(node);
                    front = node;
                } else {
                    node.setPrev(prev);
                    node.setNext(current);
                    prev.setNext(node);
                    current.setPrev(node);
                }
                size++;
                return;
            }
        }

        // insert at end of list
        rear.setNext(node);
        node.setPrev(rear);
        rear = node;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String result = "";
        iter = iterator();
        // Add code to create the string result from this list.
        // Use the iterator iter to traverse the list.

        StringBuilder sb = new StringBuilder();
        while (iter.hasNext()) {
            Stock stock = iter.next();
            sb.append(stock.getSymbol())
                    .append(" ")
                    .append(stock.getStockName())
                    .append(" ")
                    .append(stock.getDate())
                    .append(" ")
                    .append("$")
                    .append(stock.getClosingPrice())
                    .append(" ")
                    .append(stock.getVolume())
                    .append("\n");
        }
        // remove the last \n
        sb.deleteCharAt(sb.length() - 1);
        result = sb.toString();

        return result;
    }

    Iterator<Stock> iterator() {
        // Add the methods needed for a standard iterator
        Iterator<Stock> iterator = new Iterator<Stock>() {

            private Node cursor = front;
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
            private boolean firstCall = true;

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
        };

        return iterator;
    }
}
