# Event-driven-programming-Java-Swing
**Objectives:** To practice event-driven programming using Java-based GUIs.

**Description:** Develop a Java program that creates a standalone GUI application that simulates an e-store which allows the user to add items (books) to a shopping cart and once all items are included, total all costs (including tax), produces an invoice, and append a transaction log file.

**The Program Contains:**
1. A main GUI containing the following components:
    * An area that allows the user to input data into the application along with the descriptive text that describes each     input area.
    ![alt text](Project 1/Screenshots/GUI (1).png)
    * A total of six buttons. The various buttons on the interface are only accessible at certain points during a user’s interaction with the e-store.
2. An input file named “inventory.txt”. This is a comma separated file which contains the data that will be read by the application when the user makes a selection. Each line in this file contains three items; a book id, a quoted string containing the book title and author’s name, and the price for one copy of the book. 
3. An output file (append only) named “transactions.txt” is created by the program that uniquely logs each user transaction with the e-store. The unique transaction id will be generated as a permutation of the date/time string when the transaction occurred.
