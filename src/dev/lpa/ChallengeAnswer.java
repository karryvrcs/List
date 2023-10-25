package dev.lpa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ChallengeAnswer {
    private static Scanner scanner = new Scanner(System.in);

    // It needs to be static because it is called from static method.
    public static void main(String[] args) {
        boolean flag = true;
        ArrayList<String> groceries = new ArrayList<>();
        while (flag) {
            printActions();
            switch (Integer.parseInt(scanner.nextLine())){ // If user enter anything that's non an integer, the code will crash
                case 1:
                    addItem(groceries);
                    break;
                default: flag = false;
            }
            groceries.sort(Comparator.naturalOrder());
            System.out.println(groceries);
        }
    }

    public static void addItem(ArrayList<String> groceries){
        System.out.println("Add items(s) [separate items by comma]");
        String[] items = scanner.nextLine().split(",");
        for (String i : items){
            String trimmed = i.trim();
            if(groceries.indexOf(trimmed) < 0){
                groceries.add(trimmed);
            }
        }

    }

    private static void printActions(){
        String textBlock = """
            Available actions:
            
            0 - to shutdown
            
            1 - to add item(s) to list (comma delimited list)
            
            2- to remove any items (comma delimited list)
            
            Enter a number for which action you want to do:""";
        //
        System.out.println(textBlock + " ");
    }


}
