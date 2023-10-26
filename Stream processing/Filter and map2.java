import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapAndFilter {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);
        List<Integer> squares = numbers.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println(squares);

        /*forEach */
        numbers.stream().map(x->x*x).forEach(x->System.out.println(x));

        /* sum */
        int evenSum = numbers.stream().filter(x->x%2==0).reduce(0,(ans,i)->ans+i);
        System.out.println("Sum of even number : " + evenSum);

        List<String> names = Arrays.asList("Reflection", "Collection", "Stream");
        List<String>show = names.stream().sorted().collect(Collectors.toList());
        System.out.println(show);

        //Convert Stream into an array
        Stream<String>names1 = Stream.of("Mahfuz","Sujan","Miraz","Aysha");
        String[] namesArray = names1.toArray(String[]::new);
        for(String str:namesArray)
        {
            System.out.println(str);
        }

        List<String>Names2 = new ArrayList<>();
        Names2.add("Mahfuzar");
        Names2.add("Miraz");
        Names2.add("Mahmudul");
        Names2.add("Hassan");

        List<String>result1 = Names2.stream()
                .filter(w->w.length()>6)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(result1);
        List<String>lowercaseName = Names2.stream().map(w->w.toLowerCase()).collect(Collectors.toList());
        System.out.println(lowercaseName);
        //remove vowel
        List<String>onlyConsonant = lowercaseName.stream().map(w->w.replaceAll("[aeiou]","")).collect(Collectors.toList());
        System.out.println("Only consonant = " + onlyConsonant);
        // create an infinite stream
       Stream<Integer> numbers1 = Stream.iterate(0,n->n+1);
       //store 10 numbers from infinite stream
       List<Integer> first10 = numbers1.limit(10).collect(Collectors.toList());
        System.out.println(first10);

        //distinct() and sortd()
        Stream<String>words = Stream.of("how much wood could a wood chuck chuck".split(" "));
        System.out.println("Words : "+words);
        Stream<String>DistinctWords = words.distinct();
        System.out.println("Distinct words : "+DistinctWords);
        Stream<String>sortedWords = DistinctWords.sorted();
        System.out.println("Sorted words : "+sortedWords.toList());


    }
}
