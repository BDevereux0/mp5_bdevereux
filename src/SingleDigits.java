import java.util.Random;
import java.util.stream.Collectors;

public class SingleDigits {

    public static void main(String[] args) {

        new Random().ints(100,0,101)
                .boxed()
                .collect(Collectors.groupingBy(e->e, Collectors.counting()))
                .forEach((k,v)-> System.out.println(k+":"+v));

    }
}
