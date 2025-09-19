package Random;

public class tesitng {
    public static void main (String args[]) {
        int sum = 0;
        for (int i = 0; i < 10000000; i++) {
            double num1 = (i * i) - (4 * i) + 2;
            double num2 = (i*i)-(5*i)+2;
            double x = Math.pow(num1, num2);
            if (x == 1.0) {
                System.out.println(i);
                sum = (int) (sum + i);
            }
        }
        System.out.println(sum);
    }
}
