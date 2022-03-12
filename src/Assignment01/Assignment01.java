package Assignment01;
import java.io.*;

public class Assignment01 {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    static boolean compare_lists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        while((head1!=null && head2!=null) && head1.data == head2.data){
            head1 = head1.next;
            head2 = head2.next;
        }
        return (head1 == null && head2 == null);
    }


    public static void main(String[] args) throws IOException {

        FileWriter filewriter = new FileWriter( "Resultat01.txt");

        // Creates a BufferedWriter
        BufferedWriter bufferedWriter = new BufferedWriter(filewriter);

        FileReader filereader = new FileReader("Assignment01-1.txt");
        BufferedReader bufferedReader = new BufferedReader(filereader);

        String test_case;
        while(  (test_case = bufferedReader.readLine()) != null) {
            //  t  the number of test cases.
            for (int t = 0; t < Integer.parseInt(test_case); t++) {
                SinglyLinkedList llist1 = new SinglyLinkedList();

                // n  number of nodes in the first linked list.
                int n = Integer.parseInt (bufferedReader.readLine().trim());

                for (int i = 0; i < n; i++) {

                    int llist1Item =  Integer.parseInt (bufferedReader.readLine().trim());

                    llist1.insertNode(llist1Item);
                }

                SinglyLinkedList llist2 = new SinglyLinkedList();

                 // m  number of nodes in the first linked list.
                int m =  Integer.parseInt (bufferedReader.readLine().trim());  //scanner.nextInt();

                for (int i = 0; i < m; i++) {
                    int list2Item = Integer.parseInt (bufferedReader.readLine().trim());
                    llist2.insertNode(list2Item);
                }

                boolean result = compare_lists(llist1.head, llist2.head);
                System.out.println("The case n° "+(t+1)  +"  linked lists are = "+ String.valueOf(result ? 1 : 0));
                bufferedWriter.write(String.valueOf(result ? 1 : 0));
                bufferedWriter.newLine();
            }

        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}