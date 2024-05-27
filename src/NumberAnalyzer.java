public class NumberAnalyzer {

    public static int sumFirstAndLastDigit (int number) {

        if (number < 0) {
            return -1;
        }
        int end = number % 10;


        while (number >= 10) {
            number /= 10;
        }
        int start = number;
        return start + end;
    }

    public static boolean hasSharedDigit (int a, int b) {
        if (a >= 10 && a <= 99 && b >= 10 && b <= 99) {
            int startA = a / 10;
            int startB = b / 10;
            int endA = a % 10;
            int endB = b % 10;

            if (startA == startB || startA == endB || endA == startB || endA ==endB) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean hasSameLastDigit(int num1, int num2, int num3) {
        if (!isValid(num1) || !isValid(num2) || !isValid(num3)) {
            return false;
        }

        int lastDigitNum1 = num1 % 10;
        int lastDigitNum2 = num2 % 10;
        int lastDigitNum3 = num3 % 10;

        if (lastDigitNum1 == lastDigitNum2 || lastDigitNum1 == lastDigitNum3 || lastDigitNum2 == lastDigitNum3) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValid(int num) {
        if (num < 10 || num > 1000) {
            return false;
        } else {
            return true;
        }
    }

    public static void printFactors(int number) {
        if (number < 1) {
            System.out.println("Invalid Value");
        }

        for (int factor = 1; factor <= number; factor++) {
            if (number % factor == 0) {
                System.out.println(factor);
            }
        }
    }

    public static int getGreatestCommonDivisor(int first, int second) {

        if (first < 10 || second < 10) {
            return -1;
        }
        int min = first < second ? first : second;
        int gcd = 1;

        for (int divisor = 1; divisor <= min; divisor++) {

            if (first % divisor == 0 && second % divisor == 0) {
                gcd = divisor;
            }
        } return gcd;
    }

    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum+= i;
            }
        }
        if (sum == number) {
            return true;
        } else {
            return false;
        }
    }

    public static int reverse(int number) {

        int reverse = 0;
        while (number != 0) {
            // multiply by 10 then and add last digit (number % 10)
            reverse = reverse * 10 + number % 10;
            number /= 10; // discard last digit
        }
        return reverse;
    }

    public static int getDigitCount(int number) {

        if (number < 0) {
            return -1;
        }

        if (number == 0) {
            return 1;
        }

        int count = 0;
        // start from 1 and multiply by 10 each step so i goes 1, 10, 100, 1000
        // count how many times it was multiplied, and that's the digit count
        for (int i = 1; i <= number; i *= 10) {
            count++;
        }
        return count;
    }

    public static void numberToWords(int number) {

        if (number < 0) {
            System.out.println("Invalid Value");
            return;
        }

        // get reversed number
        int reverse = reverse(number);

        // subtract numberDigits and reverseDigits to get leading zeroes
        int leadingZeroes = getDigitCount(number) - getDigitCount(reverse);

        if (number == 0) {
            System.out.println("Zero");
            return;
        }

        // use loop to print words
        while (reverse != 0) {
            int lastDigit = reverse % 10;
            switch (lastDigit) {
                case 0 -> System.out.println("Zero");
                case 1 -> System.out.println("One");
                case 2 -> System.out.println("Two");
                case 3 -> System.out.println("Three");
                case 4 -> System.out.println("Four");
                case 5 -> System.out.println("Five");
                case 6 -> System.out.println("Six");
                case 7 -> System.out.println("Seven");
                case 8 -> System.out.println("Eight");
                case 9 -> System.out.println("Nine");
            }
            reverse /= 10;
        }

        // print zeroes if there are any leading zeroes in reversed number
        for (int i = 0; i < leadingZeroes; i++) {
            System.out.println("Zero");
        }
    }
}
