import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.SortedSet;

public class Phonebook
{
    DoublyLinkedList doubleList;
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException
    {
        Phonebook main = new Phonebook();
        main.doubleList = main.loadPhoneData();
        try
        {
            main.promptSearch();
        }
        catch (IndexOutOfBoundsException Error)
        {
            System.out.println("Invalid search option");
            main.promptSearch();
        }

    }

    void promptSearch() {
        System.out.print("\nPress H:Head Search, T:Tail Search, Q:Quit\n");
        char option = scanner.nextLine().toLowerCase().charAt(0);

        while(option != 'q')
        {
            searchForItem(option);
            System.out.print("\nPress H:Head Search, T:Tail Search, Q:Quit\n");
            option = scanner.nextLine().toLowerCase().charAt(0);
        }
    }
    void searchForItem(char option) {
        if(option == 'h')
        {
            System.out.println("\nPerforming a Head Search. Please enter a search term");
            String searchItem = scanner.nextLine();

            SortedSet sortedSet = doubleList.searchHeadFirst(searchItem);
            if (sortedSet.size() != 0) {
                for (Object node : sortedSet) {
                    System.out.println(node.toString());
                }
            }
            else {
                System.out.println("No search results found...");
            }
        }
        else if(option == 't')
        {
            System.out.println("\nPerforming a Tail Search. Please enter a search term");
            String searchItem = scanner.nextLine();

            SortedSet sortedSet = doubleList.searchTailFirst(searchItem);
            if (sortedSet.size() != 0) {
                for (Object node : sortedSet) {
                    System.out.println(node.toString());
                }
            }
            else {
                System.out.println("No search results found...");
            }
        }
        else
        {
            System.out.println("Invalid search option");
        }
    }

    DoublyLinkedList loadPhoneData() throws IOException {
        DoublyLinkedList dlist = new DoublyLinkedList();

        BufferedReader reader = new BufferedReader(new FileReader("resources/PhonebookData.csv"));
        while(reader.ready())
        {
            String[] lineData = reader.readLine().split(",");
            if(lineData.length == 2)
            {
                dlist.addNode(new PhonebookData(lineData[0] , lineData[1]));
            }
            else
            {
                System.out.println("CSV Load Error");
            }
        }

        dlist.display();
        return dlist;
    }
}