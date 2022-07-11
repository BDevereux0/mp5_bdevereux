import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sort2DArray {

    public static void main(String[] args) {
        int[][] numArr = {{34,89}, {56,3}, {27,61}, {45,8}, {45,89}};

        System.out.print(
        Stream.of(numArr)
                .flatMapToInt(e-> IntStream.of(e))
                .distinct()
                .sorted()
                .mapToObj(e ->e+ " ")
                .reduce((e1,e2)-> (e1+" "+e2)).get());

    }
}
