package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoreLists {
    public static void main(String[] args) {
        String[] items = {"apples", "bananas", "milk", "eggs"};
        // List.of is a Factory method: it calls a static method on List and returns a new instance of the class.
        // So it returns an unmodifiable/immutable (不可修改的） list of String element (instance of List Class) back.
        List<String> list = List.of(items);
        System.out.println(list);
        System.out.println(list.getClass().getName());

//        list.add("orange"); // java.lang.UnsupportedOperationException

        // the arrayList populated with the element from immutable list we pass to the method
        ArrayList<String> arrayList = new ArrayList<>(list);

        arrayList.add("orange");
        System.out.println(arrayList);


        ArrayList<String> nextList = new ArrayList<>(List.of("pickles", "mustard", "cheese"));
        System.out.println(nextList);
        // All the elements in nextList list is added to the end of arrayList.
        // addAll: 用于将一个集合中的所有元素添加到另一个集合中,这个方法是 java.util.Collection 接口的一部分
        // ArrayList in Java implements the Collection interface indirectly through the List interface.
        arrayList.addAll(nextList);
        System.out.println(arrayList);

        System.out.println("-".repeat(25));
        // Retrieve the elements from arrayList:
        System.out.println("The elements at index 3: " + arrayList.get(3));
        if (arrayList.contains("milk")){
            System.out.println("The arrayList contains milk");
        }

        System.out.println();
        arrayList.add("bananas");
        System.out.println(arrayList);
        System.out.println("indexOf/ lastIndexOf: return the index position of the element in the list if it finds it (return -1 if the elements isn't found in the list");
        System.out.println("first bananas is at index " +arrayList.indexOf("bananas"));
        System.out.println("last bananas is at index " + arrayList.lastIndexOf("bananas"));
        System.out.println("remove the element at index 7.....");
        arrayList.remove(7);
        System.out.println(arrayList);
        System.out.println();
        System.out.println("remove the bananas.....(remove the first occurrence of the specified element from the list)");
        arrayList.remove("bananas");
        System.out.println(arrayList);

        System.out.println();
        // create a temporary list using list.of static method, and remove all the elements that appear in the given list from the arrayList
        arrayList.removeAll(List.of("apples", "milk", "eggs"));
        System.out.println(arrayList);

        System.out.println();
        // Retain all the elements that appear in the given list, and remove others.
        arrayList.retainAll(List.of("pickles", "bananas"));
        System.out.println(arrayList);

        System.out.println();
        System.out.println("clear method...");
        arrayList.clear();
        System.out.println(arrayList);
        System.out.println("isEmpty? " + arrayList.isEmpty());

        System.out.println(" -------");
        arrayList.addAll(Arrays.asList("eggs", "pickles", "mustard", "ham"));
        System.out.println(arrayList);

        System.out.println("sort:");
        // Comparator: this special type allows the instances to be compared to one another (允许实例相互比较).
        // We will talk more about comparator in interface.
        arrayList.sort(Comparator.naturalOrder());
        System.out.println(arrayList);
        // sort in inverse alphabetical order.
        arrayList.sort(Comparator.reverseOrder());
        System.out.println(arrayList);

        System.out.println();
        // Convert an arraylist to array:
        //这个方法调用传递了一个长度为 k 的字符串数组作为参数。
        // 当数组的大小小于 ArrayList 的大小时，toArray() 方法会自动创建一个新的数组，大小恰好足够容纳列表中的所有元素。
        // 当提供的数组大小大于或等于 ArrayList 的大小时，toArray() 方法会使用这个数组，将列表中的元素复制到这个数组中。
        // 如果数组的大小大于列表的大小，数组中剩余的元素将被设置为 null。
        var array = arrayList.toArray(new String[arrayList.size()]);

        // return an array of String with length 'arrayList.size()' ----- 4.
        System.out.println(Arrays.toString(array));
    }
}
