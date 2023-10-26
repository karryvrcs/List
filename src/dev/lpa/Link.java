package dev.lpa;

import java.util.LinkedList;

public class Link {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();

        // appends the element to the end of the linkedList.
        placesToVisit.add("Sydney");
        placesToVisit.add(0,"Canberra");
        System.out.println(placesToVisit);

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);

        removeElements(placesToVisit);
        System.out.println(placesToVisit);
    }

    public static void addMoreElements(LinkedList<String> list){
        // LinkedList implements the Deque interface.
        list.addFirst("Darwin");
        list.addLast("Hobart");

        // Offer is used to add an element to the tail of the queue.
        list.offer("Melbourne");
        System.out.println(list);
        list.offerFirst("Brisbane");
        list.offerLast("Toowoomba");

        // Stack methods:
        // Push the new elements at the head.
        list.push("Alice Springs");

    }

    private static void removeElements(LinkedList<String> list){
        list.remove(4);
        list.remove("Brisbane");

        // Remove the first element
        list.remove();
        list.removeFirst();

        list.removeLast();
        System.out.println(list);
        System.out.println("---");

        // Queue/Deque:
        list.poll(); // retrieve and remove the head (the first element) of the queue.
        list.pollFirst();
        list.pollLast();



    }
}
