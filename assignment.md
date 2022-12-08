
Mobile Telephone Directory apps support searching and sorting using just a few characters of the search criteria. You can search by phone number, first-name, last-name, or even a portion of a name or portion of a phone number.   Search results can return one or multiple items and the list comes back in sorted order. 

You will implement such a system.  Your phone data will be stored in a DoublyLinkedList. 

Java program to create and display a doubly linked list

LInkedLists are convenient because it is easy and fast to insert and remove frequently modified items from the list.  A doubly-linked list is particularly nice because you can iterate and search from the front (head) or the end of the list(tail).  See Unit 6.  

But data items are NOT sorted in a linked list,  so what are we going to do about the requirement of sorting our search results? 

Our solution is to load your search results into a TreeSet (See Unit 8), where items are sorted "automatically".  This way your results will not only be automatically sorted,  but any duplicates in your linked list will not appear in your sort results, also automatically.  Sweet! 

Requirements: 

The Doubly Linked List (DLL) example in Unit 6 demonstrates uses a list of integers to demonstrate the data structure, a simple but not very interesting case.   In our more interesting case, our DLL will contain a list of The PhonebookData Download PhonebookData class is provided for you here Download here. PhonebookData entries, for simplicity just contain name and PhonebookData attributes.   
You will need to modify the DoublyLinked class implemented in Unit 6.  
 You will need to change addNode to accept PhonebookData as your data attribute:
addNode(PhonebookData data)
  The class Node's data attribute and its constructor should be modified as follows: 
    class Node {
       PhonebookData data;
       Node previous;
       Node next;

    public Node(PhonebookData data) {
        this.data = data;
     }
   }
3.  In main, you should add test nodes to your class something like this, but using your own data:   

dList = new DoublyLinkedListPhonebook();
//Add nodes to the list
dList.addNode(new PhonebookData("Miqun Robinson", "908-239-2222"));
dList.addNode(new PhonebookData("Michael Davis", "443-904-2332"));
dList.addNode(new PhonebookData("Jackson Evers", "484-904-2222"));
dList.addNode(new PhonebookData("Allison Whitehead", "650-455-2222"));
dList.addNode(new PhonebookData("David Lamm", "484-885-2222"));
dList.addNode(new PhonebookData("Zachary Whitehead", "484-223-1234")); 
//Displays the nodes present in the list
dList.display();
For extra credit,  create or download a list of names and phone numbers into an external file and export the PhonebookData records into your LinkedList.   You could also import a list to initialize your DLL as we have seen in previous assignments using CSV files and in  Unit 9.  

4.  Your app must implement a new search method in your DoublyLinkedList class that takes a String searchItem as an input parameter, and returns a SortedSet, for example: 

   SortedSet search(String searchItem) {}
 Inside this method,  declare a TreeSet as follows to hold your search result: 

SortedSet sortedSet = new TreeSet();

This method should iterate through your DLL  in a while loop as in the display method.  In this case, as you iterate, you can use the contains() method on strings to apply the search: 

 while (current != null) {
     //Checks each node by incrementing the pointer.
    if (current.data.name.contains(searchItem) || current.data.mobilePhone.contains(searchItem)) {
        sortedSet.add((PhonebookData) current.data);
    }
    current = current.next;
}
return sortedSet;

To make your search more user-friendly,  you may want to ignore case and spaces in your search criteria: 

          if (current.data.name.toLowerCase().contains(searchItem.toLowerCase().strip()) || current.data.mobilePhone.contains(searchItem)) {
In your main or testDriver method scan for your searchItem and send it to your new search method.  If results are found, loop through the SortedSet and print out the PhonebookData. 

if (sortedSet != null)
    for(Object node: sortedSet) {
        System.out.println(((PhonebookData) node).toString());
    }
}
else {
    System.out.println("No search results found...");
}
5.  Demonstrate your app running several tests, varying your search criteria as we have done in previous assignments.   Include a test where your search does not return results.  

System.out.println("\nStarting search from head test...");
System.out.print("Enter search item (or q to quit):");
searchItem = scanner.nextLine();
while (!searchItem.equals("q")) {
    SortedSet sortedSet = dList.search(searchItem);
    if (sortedSet.size() != 0) {
        for (Object node : sortedSet) {
            System.out.println(((PhonebookData) node).toString());
        }
    }
    else {
        System.out.println("No search results found...");
    }

    System.out.print("\nEnter search item (or q to quit):");
    searchItem = scanner.nextLine();
}
6.  Create a search from the tail-first search method to improve your understanding of how to iterate both directions.  This method will start from the tail and iterate backward using the previous attribute.  Your app should allow the user to choose whether to perform searches tail-first or head-first.  

public SortedSet searchTailFirst(String searchItem) {
    SortedSet sortedSet = new TreeSet();
    Node current = tail;
    if (tail == null) {
        System.out.println("List is empty");
        return null;
    }
    //    System.out.println("Nodes of doubly linked list: ");
    while (current != null) {
        //Checks each node by incrementing the pointer.
        if (current.data.name.toLowerCase().contains(searchItem.toLowerCase().strip()) || current.data.mobilePhone.contains(searchItem)) {
            sortedSet.add((PhonebookData) current.data);
        }
        current = current.previous;
    }
    return sortedSet;
}
Once you have added this new method, you can run two consecutive versions of your program, one using head-first search, the other using tail-first, or you could scan for a value from the user before you begin your test to let the program know which direction you want to search either from the tail or from the head.   Your test output should indicate at the beginning which search direction you are using. 

7.  PhonebookData implements the Comparable interface.  Why?  What happens if the implements comparable tag and the @Overrides annotation in this class are removed?  Why is there a user-defined compare method in PhonebookData?  Can we apply inequalities (<,>,<=,etc) to Java strings?  

Add a duplicate entry to your Phonebook list.   If you search for that item, is it printed twice?  Why or why not?    

Please provide answers to these questions in the comments of your submission.  

A Partial List of Suggested Test Cases:  

Test that search can retrieve multiple records
Test first name and last name search results including partial names. 
Test that phone numbers beginning with parentheses are retrieved. 
Test no results found case should present a message indicating this. 
Test search with leading/trailing space, the space should be ignored. 
Test case sensitivity  (should NOT  be case-sensitive)
Test positive search results with numbers in the middle
Should permit multiple searches before exit. 
Must allow searching forwards and backward in linkedList.  Should indicate which is being used.   
Demonstrate items are properly sorted and that duplicates are not displayed.   
Sorts apply only to names so if phone numbers are different, the duplicate name will be sorted out anyway.  
Include all test cases in the test output file included in your submission.  You will likely have too much test data to be included in a single image file.  Please use a txt, pdf, docx, rtf, or other formats that will allow longer test output files.   

Sample Test Output

Nodes of doubly linked list:
Miqun Robinson 908-239-4740
Michael Davis 443-904-2152
Michael Donellson 443-924-2153
Allison Whitehead 650-455-5076
David Lamm 484-885-0859
Madison Jackson 215-222-3359
Zachary Whitehead 484-223-1234

Starting search from head test...
Enter search item (or q to quit):215
Madison Jackson 215-222-3359
Michael Davis 443-904-2152
Michael Donellson 443-924-2153

Enter search item (or q to quit):443
Michael Davis 443-904-2152
Michael Donellson 443-924-2153

Enter search item (or q to quit): all
Allison Whitehead 650-455-5076

Enter search item (or q to quit):
