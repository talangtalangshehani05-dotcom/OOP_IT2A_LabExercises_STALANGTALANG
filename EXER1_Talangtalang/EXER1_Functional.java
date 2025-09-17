import java.util.Arrays;
import java.util.List;

public class EXER1_Functional {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 40, 60, 70);

        int sum = numbers.stream()
                         .map(n -> n * 2)              // Double each number
                         .reduce(0, Integer::sum);     // Sum all numbers

        System.out.println("Functional Programming Result (sum of doubled numbers): " + sum);
    }
}
