package dev.lpa;

public class BigO {
    // Big O Notation: a way to express how well the operation performs.
    // I won't get too deep into it, but there are a couple of concepts that are fairly easy to grasp, and will help us
    // understand how cheap or expensive an operation is, in terms of time and memory usage, as the operation scales.

    // Big O approximates the cost of an operation, for a certain number of elements, called n.
    // Cost is usually determined by the time it takes, but it can include memory usage, and complexity for example.

    // As n (the number of elements) get bigger, an operation's cost can stay the same.
    // But the cost often grows, as the number of elements grow.
    // Costs can grow linearly, meaning the cost stays in step (步调一致), with the magnitude (量级) of the number of elements.

    // O(1): An operation's time and complexity would never change: O(1), called constant time.
    // O(n): An operation's cost is in direct correlation to the number of elements, called linear time.

    // O(n) is generally our worst case scenario for List operations, but there are Big O Notations, for worse performers.

    // O(1)* Constant Amortized Time Cost 均摊常数时间
    // In the majority cases, the cost is close to O(1), but at certain intervals, the cost is O(n).
    // If we add an element to ArrayList, where the capacity is already allocated and space is still available, the cost is the same each time,
    //   regardless how many element we add.
    // But as soon as we reach the capacity, all the elements need to be copied in memory (to the new ArrayList), the single add would have maximum cost of O(n)

    // More exactly definiton:
    // O(1) - constant time - operation's cost (time) should be constant regardless of the number of elements.
    // O(n) - linear time - operation's cost should increase linearly with the number of elements.
    // O(1)* - constant amortized time - somewhere between O(1) and O(n), but closer to O(1) as efficiencies are gained.

    // For contians method, it might not find a match until the last index, this is the worst case scenario, O(n)


    // Doubly linked list: an element is linked to the previous elements, and it's also linked to the next elements.

    // LinkedList: Retrieval of an element costs more than an ArrayList retrieval.
    // For ArrayList, retrieval is just a simple math (address of the first element + index)
    // For LinkedList, we have to start at the head or tail, and check if the element matches.
    //    or keep track of the number of elements traversed, if we are matching by an index, because the index isn't stored as part of the list.
    //    for example, I want ot find the 5th element, i would still have to traverse the chain this way to get that fifth element.

    // Inserting or removing an Element may be less costly than using an ArrayList.
    // We just want to break two links in the chain, and re-establishing two different links, no new array needs to be created and elements don't need to be shifted.

}
