 import java.util.Arrays;

public class EXER1_Declarative {
    public static void main(String[] args) {
        int[] numbers = {75, 80, 85, 90, 95, 100};

        
        double average = Arrays.stream(numbers)
                               .average()
                               .orElse(0.0);

        System.out.println("Average value: " + average);
    }
}