import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class ScrabbleScore {
    public static int wordScore(String word){
        int score=0;
        char [] iterator = word.toLowerCase().toCharArray();
        Map<Character, Integer> letterValues = new HashMap();
        letterValues.put('a', 1);
        letterValues.put('b', 3);
        letterValues.put('c', 3);
        letterValues.put('d', 2);
        letterValues.put('e', 1);
        letterValues.put('f', 4);
        letterValues.put('g', 2);
        letterValues.put('h', 4);
        letterValues.put('i', 1);
        letterValues.put('j', 8);
        letterValues.put('k', 5);
        letterValues.put('l', 1);
        letterValues.put('m', 3);
        letterValues.put('n', 1);
        letterValues.put('o', 1);
        letterValues.put('p', 3);
        letterValues.put('q', 10);
        letterValues.put('r', 1);
        letterValues.put('s', 1);
        letterValues.put('t', 1);
        letterValues.put('u', 1);
        letterValues.put('v', 8);
        letterValues.put('w', 4);
        letterValues.put('x', 8);
        letterValues.put('y', 4);
        letterValues.put('z', 10);

        for (char a : iterator){
            if (letterValues.containsKey(a)){
                score = score + letterValues.get(a);
            }
        }
        return  score;
    }

    public static void main(String[] args) {
        String [] words = {"Java", "program", "list", "string", "unix", "hours", "syntax", "error"};

        Map<String, Integer> myMap = Stream.of(words)
                .collect(Collectors.toMap(e->e, e->wordScore(e)));

        System.out.println("Top three words are:");
        myMap.entrySet().stream()
                .sorted((e1,e2)->
                    e2.getValue()-e1.getValue()
                )
                .limit(3).forEach(System.out::println);

        double average = myMap.entrySet().stream()
                .mapToInt(e->e.getValue()).average().getAsDouble();

        System.out.println("Average scrabble value is " + average);

        System.out.println("words below average:"+
        Arrays.toString(Stream.of(words).filter(e->wordScore(e) < average).toArray()));

        System.out.println("words above average:"+
                Arrays.toString(Stream.of(words).filter(e -> wordScore(e) > average).toArray()));
    }
}
