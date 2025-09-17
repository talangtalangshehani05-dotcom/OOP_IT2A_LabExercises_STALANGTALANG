public class EXER1_Imperative {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8, 10};
        int sum = 0;

        // Imperative: tell exactly HOW to do it
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        System.out.println("Sum of numbers: " + sum);
    }
}
