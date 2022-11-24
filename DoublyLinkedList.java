import java.util.SortedSet;
import java.util.TreeSet;

public class DoublyLinkedList
{
    public void add(PhonebookData phonebookData) {
    }

    static class Node{
        PhonebookData data;
        Node previous;
        Node next;

        public Node(PhonebookData data) {
            this.data = data;
        }
    }

    Node head, tail = null;
    public void addNode(PhonebookData  data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            head.previous = null;
        }
        else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        tail.next = null;
    }

    public void display() {
        Node current = head;
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while(current != null) {

            System.out.print(current.data + " ");
            System.out.println();
            current = current.next;
        }
    }

    SortedSet<PhonebookData> searchHeadFirst(String searchItem) {
        Node current = head;
        SortedSet<PhonebookData> sortedSet = new TreeSet<>();
        while (current != null)
        {
            if (current.data.name.toLowerCase().contains(searchItem.toLowerCase()) || current.data.mobilePhone.contains(searchItem)) {
                sortedSet.add(current.data);
            }
            current = current.next;
        }
        return sortedSet;
    }
    public SortedSet<PhonebookData> searchTailFirst(String searchItem) {
        SortedSet<PhonebookData> sortedSet = new TreeSet<>();
        Node current = tail;
        if (tail == null) {
            System.out.println("List is empty");
            return null;
        }

        while (current != null) {

            if (current.data.name.toLowerCase().contains(searchItem.toLowerCase()) || current.data.mobilePhone.contains(searchItem)) {
                sortedSet.add(current.data);
            }
            current = current.previous;
        }
        return sortedSet;
    }
}