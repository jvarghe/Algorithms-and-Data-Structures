/* 1. THE INSERTION SORT CLASS
 * 
 * This class contains the code for the Insertion Sort algorithm. As Insertion Sort is a 
 * rather simple algorithm, the focus here will be on the fact that it is generic. The most 
 * interesting part of this class is that it is generic - it can sort objects of more than
 * one type. This implementation can accept and sort integers, doubles and other numeric 
 * types in ascending order. It can also sort strings in alphabetical order. This is made
 * possible by using a generic implementation of the Insertion Sort algorithm.
 * 
 * 
 * 2.1 INTRODUCTION TO THE COMPARABLE INTERFACE
 * 
 * If you look at InsertionSort's class heading (as well as the method headings), you will 
 * see that it contains a reference to the Comparable interface. Note that normally, you 
 * would declare the adding of interfaces to your class by using the `implements` keyword, 
 * like so: 
 * 
 * 
 *     public class InsertionSort implements Comparable<String>
 * 
 * 
 * This would create an Insertion Sort class that can only sort strings. However, in this 
 * implementation, I want to support multiple types, making it possible to sort strings, 
 * numbers and other objects. To support multiple types, the class heading in this 
 * implementation looks like this: 
 * 
 * 
 *     public class InsertionSort<T extends Comparable<T>>
 * 
 * 
 * This is a variation of the normal declaration of the Comparable interface. It says that 
 * the type parameter (T) must support comparison with other instances of its own type, via 
 * the Comparable interface (Comparable<T>). While the first class heading only supported 
 * the sorting of strings, altering the heading to the second one makes it possible to sort 
 * objects of multiple types, including types in the Java standard library as well as types
 * that you create.
 * 
 * Why do you need this interface? If you want to sort elements, being able to compare them 
 * is a mandatory pre-requisite. The Comparable interface has a single method called 
 * compareTo(T o). All classes that implement this interface must also provide an 
 * implementation for this method. compareTo() compares elements, determining which elements
 * in a list come first and which come later (the sort order).
 * 
 * Most classes built into Java implement Comparable; this includes classes like, for 
 * example, Integer, Double and String. These classes contain an implementation of 
 * compareTo(), which you can call to help sort lists of integers, doubles and strings, 
 * respectively. Comparable and compareTo() enable you sort a wide array of types. See this
 * comment from Oracle's tutorials on `Object Ordering`[1]:
 *
 *
 *     A List l may be sorted as follows.
 *
 *
 *         Collections.sort(l);
 *
 *
 *     If the List consists of String elements, it will be sorted into alphabetical order.
 *     If it consists of Date elements, it will be sorted into chronological order. How
 *     does this happen? String and Date both implement the Comparable interface. Comparable
 *     implementations provide a natural ordering for a class, which allows objects of
 *     that class to be sorted automatically.
 * 
 * 
 * That accounts for built-in types. But what about types that you define? How are those 
 * compared and sorted? Can it be done?  Yes. You can implement Comparable for any class
 * whose objects you may wish to sort. Once you enable your class to make comparisons, 
 * you can compare and sort all objects of a particular type to each other. See the next
 * section for more details on this.
 * 
 * 
 * 2.2 COMPARING ITEMS WITH COMPARABLE: WRITING YOUR OWN COMPARABLE TYPES
 * 
 * Now that we have a generic Comparable interface implemented, we can not only compare 
 * objects of a type to each other, our class can compare objects of multiple types, within 
 * the same type. However, this presents us with some problems. 
 * 
 * It's obvious that numbers are comparable and thus, sortable. It's also obvious that 
 * strings can be compared and sorted on the basis of alphabetical order. Java, and most 
 * other programming languages, have built in support for sorting numbers and strings. But 
 * how does one compare and sort Student or Product objects or any other objects peculiar
 * to your software project? To answer this question, let's take student objects. You could 
 * sort students alphabetically by name, or numerically by their student number, or the 
 * grade level (numerically) or their grades (numerically), or their course of study.
 * 
 * In other words, for objects with no single, obvious criteria for comparison, you must 
 * explicitly choose the characteristic(s) by which you want to sort the list. Once you 
 * decide on your criteria, this is where the compareTo() method comes in: You must write 
 * an implementation of this method that contains an algorithm that will sort objects of 
 * this type. The algorithm will use the criteria that you came up with. Typically, 
 * when you try to sort objects, you have one criterion in mind, but it's also possible 
 * that you have multiple criteria. These criteria are usually fields of the class being 
 * sorted. 
 * 
 * For this example, let's use Student objects. If you are a teacher/administrator, and you 
 * are worried that your students are doing poorly in class, you should write a sorting 
 * algorithm that sorts Student objects based on their marks. However, instead if you were 
 * interested in some other criteria, like their attendance, or student number, grade level
 * or name, you could write a compareTo() method that sorts on basis of any of these other 
 * criteria.
 * 
 * The compareTo() method is called like this:
 * 
 * 
 *     object1.compareTo(object2)
 * 
 * 
 * That is, to compare two objects, you call compareTo() on one object and pass in a second 
 * object of the same type. Internally, when the criteria of the first object is compared to 
 * the second object, compareTo() returns values like this:  
 * 
 * 
 *     The compareTo method compares the receiving object with the specified object and 
 *     returns a negative integer, 0, or a positive integer depending on whether the 
 *     receiving object is less than, equal to, or greater than the specified object. If the 
 *     specified object cannot be compared to the receiving object, the method throws a 
 *     ClassCastException.
 * 
 * 
 * Check the example below for details, but essentially, when you compare two or more 
 * criteria, compareTo() returns an integer less than 0 if the calling object's value is 
 * less than the called object's value, returns a positive value if the caller's value is 
 * greater than the callee's value, or lastly, 0 if the two values are equal.
 * 
 * Once you write the compareTo() method, you can call sort methods on your list. Let's look 
 * at an example of how to use Comparable interface with a Student class:
 * 
 * 
 *     public class Student implements Comparable<Student>
 *     {
 *         private string studentNumber;
 *         private string name;
 *         private Grade gradeLevel;
 *         private int averageMarks;
 * 
 *         // Constructors, getters and setters
 * 
 * 
 *         public int compareTo(Student Student2)
 *         {
 *             // If (student1 > student2) = return +ive value
 *             // If (student1 < student2) = return -ive value
 *             // If (student1 = student2) = return 0
 *             if(this.getaverageMarks > student2.getaverageMarks) { return 100; }
 *             else if(this.getaverageMarks < student2.getaverageMarks) { return -999; }
 *             else if(this.getaverageMarks == student2.getaverageMarks) { return 0; }
 *         }
 *     }
 * 
 * 
 *     public class Program
 *     {
 *         public static void main(String{} args)
 *         {
 *             // Create a list of students
 *             List<Student> students = new ArrayList<Student>();
 *         
 *             // Add students to the list.
 *             students.add(new student(83454, "Bob Jones", 8, 84.1));
 *             students.add(new student(84023, "Ram Das", 11, 76.2));
 *             students.add(new student(82582, "Sharon Wong", 12, 78.1));
 * 
 *             // Try to sort the list of students:
 *             // If you did not make Student class comparable, this line will fail because
 *             // sort() only takes object whose class implements the Comparable interface.
 *             Collections.sort(students);
 *         }
 *     }
 * 
 * 
 * 2.3 STRING CLASS: HOW ARE STRINGS COMPARED AND SORTED?
 * 
 * String is a class that comes with the Java standard library. It implements Comparable and
 * thus provides an implementation of compareTo(). Note that there is also a method called
 * compareToIgnoreCase(). Here is a comment from the documentation for this method[2]:
 * 
 * 
 *     public int compareTo​(String anotherString)
 * 
 *     Compares two strings lexicographically. The comparison is based on the Unicode value 
 *     of each character in the strings. The character sequence represented by this String 
 *     object is compared lexicographically to the character sequence represented by the 
 *     argument string. The result is a negative integer if this String object 
 *     lexicographically precedes the argument string. The result is a positive integer if 
 *     this String object lexicographically follows the argument string. The result is zero 
 *     if the strings are equal; compareTo returns 0 exactly when the equals(Object) method 
 *     would return true.
 * 
 *     This is the definition of lexicographic ordering... 
 * 
 * 
 * This article defines and explains all the implications of this order[3]:
 * 
 * 
 *     To put items in order, there must be a way to compare two items. With strings, the 
 *     usual order is Lexicographic Order. This is dictionary order, except that all the 
 *     uppercase letters precede all the lowercase letters. [`Zebra` comes before `ant`]. 
 *     This order is what the compareTo() method of class String uses.
 * 
 *     Two strings are lexicographically equal if they are the same length and contain the
 *     same characters in the same positions. In this case, stringA.compareTo(stringB) 
 *     returns 0.
 *     
 *     Otherwise, stringA.compareTo(stringB) returns a negative value if StringA comes 
 *     first and a positive value if StringB comes first.
 * 
 *     Memory Aid: think of the strings in a dictionary as arranged from smallest to 
 *     largest. Then stringA - stringB would produce a negative values if stringA came 
 *     before StringB.
 * 
 *     To determine which string comes first, compare corresponding characters of the two 
 *     strings from left to right. The first character where the two strings differ 
 *     determines which string comes first. Characters are compared using the Unicode 
 *     character set. All uppercase letters come before lower case letters. If two letters 
 *     are the same case, then alphabetic order is used to compare them.
 * 
 *     If two strings contain the same characters in the same positions, then the shortest 
 *     string comes first. 
 * 
 * 
 * See the article for more detail.
 * 
 * 
 * 3. COMPARATOR INTERFACE
 * 
 * I will mention the Comparator Interface for the sake of completeness. Comparator is an
 * alternative to the Comparable Interface. What happens if the Student class you used in
 * your project is from a third-party library? If it does not implement Comparable, you 
 * probably don't have the rights to modify it yourself. Therefore, you cannot make it 
 * implement Comparable, nor can you provide an implementation of compareTo(), making it 
 * difficult for you to compare objects of type Student.
 * 
 * An alternate possibility is that you have already made your Student class Comparable 
 * and implemented compareTo() - but now you need to compare your student objects with a 
 * second criteria. What do you do? Note that in either case, you cannot modify the Student
 * class. All your work must happen where you are using Student objects.
 * 
 * This is where the Comparator interface comes in. Comparator lets you specify comparison
 * logic in-line, right where you are working. It has a method called compare(), which 
 * returns values in the same way that compareTo() does (If the current object's value is 
 * less than the passed in object's value, the returned value is negative etc.). Unlike 
 * compareTo(), compare() takes both object's being compared as parameters. 
 * 
 *      
 *     List<Student> students = new ArrayList<Student>();
 * 
 *     // Note that because Comparator is an interface, you cannot instantiate it. Instead,
 *     // you must create an anonymous inner class to hold the comparison logic.
 *     Comparator<Student> studentComparison = new Comparator<Student>()
 *     {
 *         public int compare(Student student1, Student student2)
 *         {
 *             if(Student1.getStudentNumber() > Student2.getStudentNumber()) 
 *             { 
 *                 return 1000; 
 *             }
 *             else if(Student1.getStudentNumber() < Student2.getStudentNumber()) 
 *             { 
 *                 return -999; 
 *             }
 *             else 
 *             { 
 *                 return 0; 
 *             }
 *         }
 *     }
 * 
 *     // You can then pass comparators into the standard Collection.sort() method, like this:
 *     Collections.sort(students, comparator(student1, student2));
 * 
 * 
 * Just bear in mind, that Comparable is meant from primary use, and Comparator for secondary
 * use. 
 * 
 * 
 * SOURCES
 * 
 * 1: https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html
 * 2: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html
 * 3: https://chortle.ccsu.edu/java5/Notes/chap92/ch92_2.html
 */


package com.jvarghe;


// The class heading says that the type parameter (T) must support comparison with other 
// instances of its own type, via the Comparable interface (Comparable<T>).
public class InsertionSort<T extends Comparable<T>> 
{
    // Constructor
    public InsertionSort() { }

    
    // This method heading looks quite intimidating, but it's fairly simple: 
    // <T extends Comparable<T>>: The method implements the Comparable interface generically.
    // T[]: The method returns an array of type T. 
    // sortInAscendingOrder(T[] unsortedArray): The method takes an array of type T as a 
    //     parameter.
    public static <T extends Comparable<T>> T[] sortInAscendingOrder(T[] unsortedArray) 
    {
        // THE FIRST LOOP
        // 
        // This is the first loop in the Insertion Sort algorithm. This loop iterates 
        // from the second element to the last element. The second, inner loop, called 
        // sort(), iterates in reverse, from the current element to the first element. 
        // Thus, the first loop picks the current element, and the second loop compares 
        // this element to all previous elements in the list and swaps them, until it 
        // finds the final, correct position for the current element. 
        //
        // To get into a little bit more detail, when Insertion Sort is given a list to 
        // sort, it starts by creating a sorted and unsorted section of the list. In the 
        // first iteration, the process looks like this: Insertion Sort skips the first 
        // element and selects the second element as the first object of comparison. It then 
        // compares the second element to all previous elements, which in first iteration, 
        // means the first element. This will determine their sort order, and the algorithm
        // will swap elements if necessary. With the first two elements sorted, you have the 
        // beginnings of a sorted set. 
        // 
        // The rest of the list is as yet unsorted, but will be sorted in subsequent 
        // iterations. The next step is to compare the third element to the first two 
        // elements, and insert it into the correct place in the sorted set.
        for (int i = 1; i < unsortedArray.length; i++) 
        {
            sort(i, unsortedArray);
        }
        
        return unsortedArray;
    }

    
    private static <T extends Comparable<T>> void sort(int i, T[] unsorted) 
    {
        // THE SECOND LOOP
        // 
        // This is the second loop in Insertion Sort. It takes the current element, from 
        // here on called the primeElement, from the first loop. This is the first element
        // in the unsorted set. 
        //
        // The second loop compares primeElement to elements in the sorted set; essentially
        // all previous elements in the list. It does this by iterating over the sorted set
        // in reverse order. If primeElement is "less than" (in quotation marks, because 
        // strings are also measured this way) the previous element, the elements get 
        // swapped. This process continues until primeElement has been swapped into its 
        // correct, final position in the sorted set. If primeElement was added to the middle 
        // of the sorted set, this means that, in practical effect, all latter elements in 
        // the sorted sort were moved down by one element in order to make room for the new 
        // element.
        // 
        // primeElement = The element selected in the first loop. Is the first element in the
        //     unsorted portion of the list, and the current object of comparison. It will 
        //     be compared to all elements in the sorted set, in reverse order. 
        // primeIndex = The index of primeElement. 
        // primeMinusOneElement = The element that lives just before primeElement.
        for (int primeIndex = i; primeIndex > 0; primeIndex--) 
        {
            // Using the appropriate indices, select elements for the purpose of comparison.
            T primeElement = unsorted[primeIndex];
            T primeMinusOneElement = unsorted[primeIndex - 1];
            
            
            // When primeElement is compared to primeMinusOneElement, compareTo() will 
            // return one of three possible values: a negative integer, zero, or a positive
            // integer. If the element is a number, this check will return a negative 
            // integer if primeElement is less than primeMinusOneElement, zero if the two
            // digits are equal, or a positive integer if primeElement is greater than
            // primeMinusOneElement
            //
            // The same principle applies to strings. If primeElement precedes 
            // primeMinusOneElement in the lexicographical (dictionary) sense, the check 
            // would return a negative integer. If the reverse is true, the check will 
            // return a positive integer. If the two strings are the same, including case,
            // then the check will return zero. 
            if (primeElement.compareTo(primeMinusOneElement) < 0) 
            {
                // If the check returns a negative integer, primeElement is not in the 
                // right position. primeElement and primeMinusOneElement must swap 
                // positions.
                unsorted[primeIndex - 1] = primeElement;
                unsorted[primeIndex] = primeMinusOneElement;
            } 
            // If the check returns zero or a positive integer, primeElement is in its
            // correct final position. Break out of this iteration of the loop.
            else
            {    
                break;
            }
        }
    }
}
