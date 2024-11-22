/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sevvalbilginmainclass;

import com.sun.tools.javac.Main;

/**
 *
 * @author hp
 */
public class SevvalBilginCard<T> {

    public int bingo_counter;

    public SevvalBilginNode<T> head;

    public SevvalBilginCard() {
        this.bingo_counter = bingo_counter;
        this.head = null;

    }

    public void Add(T data) {


        SevvalBilginNode<T> newNode = new SevvalBilginNode<>(data);
        SevvalBilginNode<T> temp = head;
        int row_counter = 1;
        int col_counter = 1;

        if (head == null) {
            head = newNode;
        } else {
            while (temp.next != null) {
                temp = temp.next;
                col_counter++;
            }

            if (head.down != null && col_counter == 5) {
                temp = head.down;

                row_counter++;
                col_counter = 1;
            }

            while (temp.next != null) {
                temp = temp.next;
                col_counter++;
            }

            if (head.down != null && head.down.down != null) {
                temp = head.down.down;
                while (temp.next != null) {
                    temp = temp.next;
                }
                row_counter++;
                col_counter = 1;
            }
            if (col_counter == 5 && row_counter == 1) {
                head.down = newNode;
                newNode.up = head;
                row_counter++;

            } else if (col_counter == 5 && row_counter == 2) {
                head.down.down = newNode;
                newNode.up = head.down;

            } else {
                temp.next = newNode;
                newNode.prev = temp;
                if (temp.up != null && temp.up.next != null) {
                    newNode.up = temp.up.next;
                    temp.up.next.down = newNode;
                }

            }
        }
    }

    public void insertAfter(T data, T search) {

        SevvalBilginNode<T> temp = head;
        while (temp.data.equals(search) && temp.next != null) {
            temp = temp.next;
        }
        if (temp != null) {
            SevvalBilginNode<T> newNode = new SevvalBilginNode<>(data);
            newNode.next = temp.next;
            temp.next = newNode;
        } else {
           
            Add(data);
        }
    }

    public void insertAfter(SevvalBilginNode node, T data) {
        SevvalBilginNode<T> temp = head;

        
        while (temp != null && !temp.data.equals(node.data)) {
            temp = temp.next;
        }

        if (temp != null) {

            SevvalBilginNode<T> newNode = new SevvalBilginNode<>(data);

            newNode.next = temp.next;
            temp.next = newNode;
        } else {

            Add(data);
        }
    }

    public boolean remove(T data) {

        if (head == null) {
            System.out.println("Empty List!");

        } else {
            if (head.data.equals(data)) {
                head.next.prev=null;
                head = head.next;
                return true;
            }
        }
        SevvalBilginNode<T> temp = head.next;
        SevvalBilginNode<T> prev = temp;
        while (temp.next != null && !temp.data.equals(data)) {
            prev = temp;
            temp = temp.next;
        }
        if (temp != null) {
            prev.next = temp.next;
            return true;
        } else {
            System.out.print("Data could not found");
            return false;
        }
    }

    public void printList() {
        SevvalBilginNode<T> row_temp = head;
        SevvalBilginNode<T> col_temp = head;
        int counter = 0;
        while (row_temp != null) {
            col_temp = row_temp;
            while (col_temp != null) {
                if (col_temp.sign == SevvalBilginNode.Sign.plus) {
                    System.out.printf("%10s ", col_temp.data + "(+)");
                }
                if (col_temp.sign == SevvalBilginNode.Sign.minus) {
                    System.out.printf("%10s", col_temp.data + "(-)");
                }
                col_temp = col_temp.next;
            }
            System.out.println();
            row_temp = row_temp.down;
        }
        System.out.println();
    }

    
    public void printCard() {
        SevvalBilginNode<T> row_temp = head;
        SevvalBilginNode<T> col_temp = head;
        int counter = 0;
        while (row_temp != null) {
            col_temp = row_temp;
            if ((counter == 9)) {
                System.out.println();
                counter = 0;
            }
            while (col_temp != null && counter != 9) {

                counter++;
              if (counter == 1 && (0 <= (int) col_temp.data) && ((int) col_temp.data < 10)) {
                    printNodeData(col_temp);
                    col_temp = col_temp.next;
                } else if (counter == 2 && (10 <= (int) col_temp.data) && ((int) col_temp.data < 20)) {
                    printNodeData(col_temp);
                    col_temp = col_temp.next;
                } else if (counter == 3 && (20 <= (int) col_temp.data) && ((int) col_temp.data < 30)) {
                    printNodeData(col_temp);
                    col_temp = col_temp.next;
                } else if (counter == 4 && (30 <= (int) col_temp.data) && ((int) col_temp.data < 40)) {
                    printNodeData(col_temp);
                    col_temp = col_temp.next;
                } else if (counter == 5 && (40 <= (int) col_temp.data) && ((int) col_temp.data < 50)) {
                    printNodeData(col_temp);
                    col_temp = col_temp.next;
                } else if (counter == 6 && (50 <= (int) col_temp.data) && ((int) col_temp.data < 60)) {
                    printNodeData(col_temp);
                    col_temp = col_temp.next;
                } else if (counter == 7 && (60 <= (int) col_temp.data) && ((int) col_temp.data < 70)) {
                    printNodeData(col_temp);
                    col_temp = col_temp.next;
                } else if (counter == 8 && (70 <= (int) col_temp.data) && ((int) col_temp.data < 80)) {
                    printNodeData(col_temp);
                    col_temp = col_temp.next;
                } else if (counter == 9 && (80 <= (int) col_temp.data) && ((int) col_temp.data < 90)) {
                    printNodeData(col_temp);
                    col_temp = col_temp.next;
                } else {
                    System.out.printf("%10s ", "-1");
                }
            }

            if (counter == 9) {
                row_temp = row_temp.down;
            }

        }
        System.out.println();

    }

    private void printNodeData(SevvalBilginNode node) {
        if (node.sign == SevvalBilginNode.Sign.plus) {
            System.out.printf("%10s ", node.data + "(+)");
        } else if (node.sign == SevvalBilginNode.Sign.minus) {
            System.out.printf("%10s", node.data + "(-)");
        }
    }
}
