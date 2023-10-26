package dev.lpa;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Link {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();

        // appends the element to the end of the linkedList.
        placesToVisit.add("Sydney");
        placesToVisit.add(0,"Canberra");
        System.out.println(placesToVisit);

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);

/*        removeElements(placesToVisit);*/
        System.out.println(placesToVisit);


        gettingElements(placesToVisit);
        printItinerary(placesToVisit);
        System.out.println("---------------------------------------");
        testIterator(placesToVisit);
        testListIterator(placesToVisit);
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

    private static void gettingElements(LinkedList<String> list){

        // Retrieve the element:
        System.out.println(list.get(3));
        // Retrieval of the element from linkedList using get method costs more than that from arrayList.
        // The Big O Notation is O(1) for arrayList, and O(n) for LinkedList ( in the worst case)

        // It's actually not as bad as that on a LinkedList. Since it's a double-ended queue,
        // Java will decide where to start searching. The retrieval will start moving from one link to the next,
        // either from the start or the end of the list, whichever is closer to the specified index.
        // So it would never traverse the entire number of elements.

        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());

        // The worst case is O(n) if the element retrieved is the element of the last position to be checked.
        System.out.println("Darwin is at position: " + list.indexOf("Darwin"));
        System.out.println(list.lastIndexOf("Darwin"));

        // Queue method: return the first element out of the list.
        System.out.println("Element from element(): " + list.element());

        // Stack:
        System.out.println("-----");
        System.out.println(list);
        System.out.println(list.peek());
        System.out.println(list.peekFirst());
        System.out.println(list.peekLast());


    }

    public static void printItinerary(LinkedList<String> list){
        System.out.println("Trip starts at " + list.getFirst());
        for (int i = 1; i < list.size(); i++){
            System.out.println("--> From " + list.get(i-1) + " to " + list.get(i));
        }
        System.out.println("Trip ends at " + list.getLast());

        System.out.println();
        // More efficient but print a error information (first line)
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        for (String town : list){
            System.out.println("--> From " + previousTown + " to " + town);
            previousTown = town;
        }

        // The output still includes problematic first line that we don't really want!
        System.out.println();
        String previousTown2 = list.getFirst();

        // The parameter 1 signifies that the iterator will start the traversal from the element at index position 1 in the list.
        ListIterator<String> iterator = list.listIterator(1);


        //When the iterator has traversed to the last element, it will return false and stop printing.
        while (iterator.hasNext()){ // return true if there are more elements to process

            // The next() method is used to retrieve and next the element, and then move the iterator forward by one position.
            // 当你创建一个迭代器时，它的位置被设置在集合的第一个元素之前。这意味着第一次调用 next() 方法会让迭代器前进到第一个元素
            // When an iterator is created, its cursor position is pointed at a postion before the first element
            // The first call to the next method gets the first element, and moves the cursor position, to be between the first and second elements.
            // Sbusequent calss to the next method... until there are no elements left, meaning hasNext = false.
            var town = iterator.next();
            System.out.println("--> From " + previousTown2 + " to " + town);
            previousTown2 = town;
        }
    }

    // Iterator and ListIterator:
    // 1. Iterator
    private static void testIterator(LinkedList<String> list){
        Iterator<String> iterator = list.iterator();

        while(iterator.hasNext()){
//            System.out.println(iterator.next());
            if(iterator.next().equals("Brisbane")){
                // Only the remove method is available to manipulate the elements in iterator.
                iterator.remove();
                //list的remove方法确实可以Remove第一个元素，但在迭代中是不能的，这是为了防止产生不可预期的行为。
//                当你使用迭代器遍历列表时，迭代器内部会维护一些状态来跟踪遍历的进度。
//                这些状态通常包括对当前元素的引用，以及可能的下一个或上一个元素的引用。
//                当你直接调用列表的修改方法（如 remove()）时，列表的结构会改变，但迭代器内部的状态并不会相应地更新。
//                list.remove();
            }
        }
        System.out.println(list);
    }

    // ListIterator:
    // A ListIterator can be used to go both forwards and backwards, and in addition to the remove method,
    // [!!!] it also supports the add and set methods.
    private static void testListIterator(LinkedList<String> list){
//        ListIterator<String> listIterator = list.listIterator();
//        while (listIterator.hasNext()){
//            System.out.println(listIterator.next());
//            listIterator.add("INSERT");
//        }
//        System.out.println(list);
//
//        // 一旦迭代器完成了对集合的遍历，它就不能被重置；你必须创建一个新的迭代器来重新开始遍历。这是因为迭代器通常被设计为一次性使用的。
//        ListIterator<String> newListIterator = list.listIterator();
//        while (newListIterator.hasNext()){
//            System.out.println(newListIterator.next());
//            newListIterator.set("SET");
//        }
//        System.out.println(list);


        // traverse forward
        ListIterator<String> newListIterator2 = list.listIterator();
        while (newListIterator2.hasNext()){
            System.out.println(newListIterator2.next());
        }
        System.out.println(list);

        // traverse backward
        while (newListIterator2.hasPrevious()){
            System.out.println(newListIterator2.previous());
        }
        System.out.println(list);
    }
}
