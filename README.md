# Stock-Information-Processing

## Introduction
This program involves manipulation of information about stocks, including the name of the company, the stock symbol, and, for a specific date, the closing price and the number of that company’s stock sold (the volume). You can download the Program#3.zip file. This zip file contains the following files:

•	Node.java. – this contains the Node class declaration
•	OrderedStockList.java – this contains the code for a linked list class that keeps the list in order
•	Stock.java – this contains the class definition for each stock including fields for the name, symbol, date, closing price, and volume for that day. Note that the name, symbol, and date are treated as Strings. (There is no need to parse the date into month, day, and year.) The closing price is stored as a double and the volume as an int.
•	StockListIterator.java – this is a class to hold an iterator for the OrderedStockList class.
•	StockComparator.java – this is a file to hold a comparator for the OrderedStockList class.
•	StockTracker.java. – this is the file that includes the main() method. You will add code to this file to read in the file StockQuotes.txt.
•	StockQuotes.txt – this file contains the information about the stocks for several companies over a recent month. This is stored in the order company name, stock symbol, date, closing price, and volume.

## How to bulid up
You will need to add to several of these files.
1.	To the OrderedStockList.java file, you will need to:
a.	Compete the iterator() that returns an iterator for this class.
b.	complete the toString() method. Complete this using the private iterator class that you complete in 1a, not by using the traversal pattern that we have been using. The toString() method should print out the stocks in the list with the information for one stock for one particular day on a separate line. The data should be listed in the order: symbol, name, date, price, volume. These should be separated by exactly one space. An example is displayed at the end of this document
c.	Note that the constructor for this class has a Comparator as a parameter. That is a Comparator that you will create separately. This is described below.
2.	In the StockIterator.java file, you will need to create an external iterator for the OrderedStockList class. This is the iterator that you will use in the StockTracker.java file as describe below.
3.	In the StockComparator.java file, you will need to add a Comparator that will be used to compare stock objects in the insert() method of the OrderedStockList class. This Conparator should put the stock objects in order by date, from early to later. For those stock objects on the same date, you should put these in order by stock symbol.
 
4.	In the StockTracker.java, you will find a main() method and some other methods. You should:
a.	Add code to the main method, to read the file and insert it into the OrderedStockList. The file name should be a command line argument so that we could read another file if we wanted. (Remember that you can set this in Eclipse in the configuration that you get when you right click and choose “Run as”).
b.	Complete the other methods in this file. These methods explore various aspects of the stock data.
5.	Do not change the files Node.java, Stock.java, and StockQuotes.txt. Also, do not change the names of any of the methods or of the files; do not add a package statement.
6.	Turn in the files that you modify: OrderedStockList.java, StockIterator.java, StockComparator.java, and StockTracker.java. Put all four of these into one zip file called Program3.zip. Do not add your name to the zip file or any of the other files. (Canvas adds your name automatically.). Do not call your file program3.zip or Program#3.zip or any other combination. Note the capital P and that there are no embedded spaces. We will not grade your program if you do not follow these directions.

## Result
Here is a sample of a portion what the toString() method should produce.

GOOG Alphabet 9/25/20 $1444.95 1323000
MSFT Microsoft 9/25/20 $207.82 29437310 SBUX Starbucks 9/25/20 $84.3 5981463 TSLA Tesla 9/25/20 $407.34 67208460


https://github.com/DengYaosheng/Stock-Information-Processing/assets/41530023/02942346-4c94-48c7-bf49-d882d6d2ce5b

