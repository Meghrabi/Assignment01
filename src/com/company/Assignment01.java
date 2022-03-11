package com.company;
import java.io.*;
import java.util.*;


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

    //private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        FileWriter filewriter = new FileWriter( "Output.txt");

        // Creates a BufferedWriter
        BufferedWriter bufferedWriter = new BufferedWriter(filewriter);

        FileReader filereader = new FileReader("Assignment01-1.txt");
        BufferedReader buffer = new BufferedReader(filereader);

         String tests;
        while(  (tests = buffer.readLine()) != null) {


            for (int testsItr = 0; testsItr < Integer.parseInt(tests); testsItr++) {
                SinglyLinkedList llist1 = new SinglyLinkedList();

                // int llist1Count = scanner.nextInt();
                int llist1Count = Integer.parseInt (buffer.readLine());
                System.out.println(llist1Count);
               // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int i = 0; i < llist1Count; i++) {

                    int llist1Item =  Integer.parseInt (buffer.readLine());            //scanner.nextInt();
                //    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    llist1.insertNode(llist1Item);
                }

                SinglyLinkedList llist2 = new SinglyLinkedList();

                int llist2Count =  Integer.parseInt (buffer.readLine());  //scanner.nextInt();
              //  scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                System.out.println(llist2Count);
                for (int i = 0; i < llist2Count; i++) {
                    int llist2Item = Integer.parseInt (buffer.readLine()); // scanner.nextInt();
                   // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    llist2.insertNode(llist2Item);
                }



                boolean result = compare_lists(llist1.head, llist2.head);
                System.out.println(String.valueOf(result ? 1 : 0));
                bufferedWriter.write(String.valueOf(result ? 1 : 0));

                // bufferedWriter.write(String.valueOf(result ? 1 : 0));
                bufferedWriter.newLine();

            }




        }





    // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUT_PATH")));

        //int tests = scanner.nextInt();

       // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

       buffer.close();
        bufferedWriter.close();

      //  scanner.close();
    }
}