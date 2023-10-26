import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExample1 {
    public static void main(String[] args) {
        List<Integer>numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer>evenNumbers = numbers.stream().filter(n->n%2==0).collect(Collectors.toList());
        System.out.println(evenNumbers);

        int sum = evenNumbers.stream().reduce(0,Integer::sum);
        System.out.println("Sum of even number : "+sum);

        List<String>words = Arrays.asList("apple","banana","anchor","anis","book","bee");
        List<String> startA = words.stream().filter(w->w.startsWith("a")).collect(Collectors.toList());
        System.out.println(startA);

        words.stream().filter(w->w.startsWith("b")).forEach(System.out::println);
        long A = words.stream().filter(w->w.startsWith("a")).count();
        System.out.println(A);

        List<String>shortWords = words.stream().filter(w->w.length()<6).collect(Collectors.toList());
        System.out.println(shortWords);
        /* Map Method */
        //convert word from lowercase to uppercase words
        List<String>uppercaseWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("Uppercase words : " + uppercaseWords);

        /* count lenth of every words*/
        List<Integer>length = words.stream().map(String::length).collect(Collectors.toList());
        System.out.println("Lenth of every words : " + length);

        /* String concatenation  */

        String concatenated = words.stream().map(String::toUpperCase).collect(Collectors.joining(","));
        System.out.println(concatenated);



    }
}
