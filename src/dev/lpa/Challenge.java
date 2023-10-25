package dev.lpa;

import java.util.*;

public class Challenge {

    private static ArrayList<String> itemList;

    public static void main(String[] args){
        ArrayList<String> itemList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);


        while (true){
            System.out.printf("Available actions:\n0 - to shutdown\n1 - to add item(s) to list (comma delimited list)\n2- to remove any items (comma delimited list)\n");
            int input = scanner.nextInt();
            if (input == 0){
                break;
            } else if (input == 1){
                //This line is used to consume the nextline character behind the nextInt();
                scanner.nextLine();
                System.out.println("Please enter the name of items delimited by comma for adding");
                String s = scanner.nextLine();
                addItem(itemList,s);
            } else if (input == 2){
                //This line is used to consume the nextLine character behind the nextInt();
                scanner.nextLine();
                System.out.println("Please enter the name of items delimited by comma for removing");
                String s = scanner.nextLine();
                removeItem(itemList,s);
            } else {
                System.out.println("ERROR: Invalid value!!");
            }
        }

    }

    private static void addItem(ArrayList<String> list, String s){
        // Split the input String
        String[] newArray = s.split(",");

        // Remove spaces
        for(int i = 0; i < newArray.length; i++){
            newArray[i] = newArray[i].trim();
            if (!list.contains(newArray[i])){
                list.add(newArray[i]);
            } else {
                System.out.println("Error: you are trying to add a duplicate element");
            }
        }

        sortItem(list);
        System.out.println(list);
    }

    private static void removeItem(ArrayList<String> list, String s){
        String[] newArray = s.split(",");
        // Remove spaces and check the items whether in the list...
        for(int i = 0; i < newArray.length; i++){
            newArray[i] = newArray[i].trim();
            // Check whether an item is already in the list
            if (list.contains(newArray[i])){
                list.remove(newArray[i]);
            }
        }
        sortItem(list);
        System.out.println(list);
    }

    private static void sortItem(ArrayList<String> list){
        // sort in alphabetical order
        list.sort(Comparator.naturalOrder());
    }
}
