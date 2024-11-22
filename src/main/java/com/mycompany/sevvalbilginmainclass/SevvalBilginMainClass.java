/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.sevvalbilginmainclass;

/**
 *
 * @author hp
 */
public class SevvalBilginMainClass {
//your random array will come here
    static int[] arr = {5, -1, 22, -1, 45, -1, 60, 73, -1,
        -1, 10, -1, 31, 47, 58, 68, -1, -1,
        -1, 17, 26, 38, -1, -1, -1, 79, 86};

    public static void main(String[] args) {
//your card array will come here
        int[][] card1 = {{5, -1, 22, -1, 45, -1, 60, 73, -1},
        {-1, 10, -1, 31, 47, 58, 68, -1, -1},
        {-1, 17, 26, 38, -1, -1, -1, 79, 86}};
        SevvalBilginCard<Integer> first_card = generateCard(card1);
        SevvalBilginCard<Integer> second_card = generateCard();
        SevvalBilginGameFrame frame = new SevvalBilginGameFrame(first_card, second_card);
    }

    public static SevvalBilginCard generateCard(int[][] arr) {

        SevvalBilginCard<Integer> card = new SevvalBilginCard<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == -1) {
                    continue;
                } else {
                    card.Add(arr[i][j]);

                }
            }

        }
        card = sortCard(card);
        return card;
    }

    public static SevvalBilginCard generateCard() {

        SevvalBilginCard<Integer> card = new SevvalBilginCard<>();
        SevvalBilginNode<Integer> temp = card.head;

        for (int j = 0; j < 3; j++) {
            int[] rand = generatePermutation(9);
            for (int i = 0; i < 5; i++) {
                int num = 0;

                int randomNum = (int) ((Math.random() * 9) + 1);

                if (rand[i] == 0) {
                    num = randomNum;
                } else if (rand[i] == 1) {
                    num = randomNum + 10;
                } else if (rand[i] == 2) {
                    num = randomNum + 20;
                } else if (rand[i] == 3) {
                    num = randomNum + 30;
                } else if (rand[i] == 4) {
                    num = randomNum + 40;
                } else if (rand[i] == 5) {
                    num = randomNum + 50;
                } else if (rand[i] == 6) {
                    num = randomNum + 60;
                } else if (rand[i] == 7) {
                    num = randomNum + 70;
                } else if (rand[i] == 8) {
                    num = randomNum + 79;
                }
                card.Add(num);
            }
        }
        card = sortCard(card);

        return card;
    }

    public static SevvalBilginCard checkNumbers(SevvalBilginCard card) {

        SevvalBilginNode<Integer> col_temp1 = card.head;
        SevvalBilginNode<Integer> row_temp1 = card.head;
        SevvalBilginNode<Integer> col_temp2 = col_temp1.next;
        SevvalBilginNode<Integer> row_temp2 = row_temp1.next;
        while (col_temp1 != null) {
            col_temp1 = row_temp1;
            while (col_temp1 != null) {
                int number_itself = 1;
                while (col_temp2 != null) {
                    col_temp2 = row_temp2;
                    while (col_temp2 != null) {
                        if (col_temp1.data == col_temp2.data) {
                            number_itself++;
                            
                            if ((col_temp1.data + 1) % 10 != 0 && number_itself == 2) {

                                col_temp2 = new SevvalBilginNode<>(col_temp1.data + 1);
                                if (col_temp1.prev != null) {
                                    card.insertAfter(col_temp1.prev, col_temp2.data);
                                } else {
                                    card.remove(col_temp1);
                                }
                                //card.remove(col_temp1);
                                //System.out.println("after: " + col_temp1.data + " " + col_temp2.data);

                            } else if (number_itself == 2) {
                                col_temp2 = new SevvalBilginNode<>(col_temp1.data - 1);
                                //System.out.println("after: " + col_temp1.data + " " + col_temp2.data);

                            }

                        }
                        col_temp2 = col_temp2.next;
                    }
                    row_temp2 = row_temp2.down;
                }
                col_temp1 = col_temp1.next;
                //

            }
            row_temp1 = row_temp1.down;
        }
        return card;
    }

    public static SevvalBilginCard sortCard(SevvalBilginCard card) {
        SevvalBilginNode<Integer> currentRow = card.head;
        SevvalBilginNode<Integer> currentCol = card.head;

        while (currentRow != null) {
            while (currentCol != null) {

                SevvalBilginNode<Integer> nextNode = currentCol.next;

                while (nextNode != null) {
                    if (currentCol.data > nextNode.data) {
                        int temp = currentCol.data;
                        currentCol.data = nextNode.data;
                        nextNode.data = temp;
                    }
                    nextNode = nextNode.next;
                }

                currentCol = currentCol.next;
            }

            currentRow = currentRow.down;
            currentCol = currentRow;

        }
        card = checkNumbers(card);
        return card;

    }

    public static int[] generatePermutation(int i) {
        int[] random_array = new int[i];
        for (int j = 0; j < i; j++) {
            random_array[j] = -1;
        }
        for (int j = 0; j < i; j++) {
            int random = (int) (Math.random() * i);
            if (checkArray(random_array, random)) {
                random_array[j] = random;
            } else {
                j--;

            }

        }
        return random_array;
    }

    private static boolean checkArray(int[] array, int data) {
        for (int i = 0; i < array.length; i++) {

            if (array[i] == data) {

                return false;
            }
        }
        return true;
    }
}
