import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class exe1 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            System.out.print(getPentagonalNumber(i) + " ");
            count++;
            if (count % 10 == 0)
                System.out.println();
        }
    }

    public static int getPentagonalNumber(int n) {
        return n * (3 * n - 1) / 2;
    }
}

class exe2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(sumDigits(n));

    }

    public static int sumDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}

class exe3 {
    public static void main(String[] args) {
        System.out.println("英尺\t\t米\t\t\t米\t\t英尺");
        System.out.println("-----------------------------------");
        for (double i = 1, j = 20; i <= 10; i++, j += 5) {
            System.out.printf("%4.1f\t%4.3f\t\t%4.1f\t%4.3f\n", i, footToMeter(i), j, meterTofoot(j));
        }
    }

    public static double footToMeter(double foot) {
        return foot * 0.305;
    }

    public static double meterTofoot(double meter) {
        return meter * 3.279;
    }
}

class exe4 {
    public static void main(String[] args) {
        printChars('1', 'Z', 10);
    }

    public static void printChars(char ch1, char ch2, int numberPerLine) {
        int count = 0;
        for (int i = ch1; i <= ch2; i++) {
            System.out.printf("%c ", i);
            count++;
            if (count % numberPerLine == 0)
                System.out.println();
        }
    }
}

class exe5 {
    public static void main(String[] args) {
        System.out.println("i\t\t\tm(i)");
        System.out.println("-------------------------");
        for (int i = 1; i <= 20; i++) {
            System.out.printf("%d\t\t\t%4.4f\n", i, m(i));
        }

    }

    public static double m(int n) {
        double sum = 0;
        for (double i = 1; i <= n; i++) {
            sum += i * 1.0 / (i + 1);
        }
        return sum;
    }
}

class exe6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printMatrix(n);
    }

    public static void printMatrix(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((int) (Math.random() * 2) + " ");
            }
            System.out.println();
        }
    }
}

class exe7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String pass = in.nextLine();
        if (checkpass(pass))
            System.out.println("Valid Password");
        else
            System.out.println("Invalid Password");
    }

    public static boolean checkpass(String pass) {
        int count = 0;
        boolean flag = false;
        if (pass.length() < 8)
            return false;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isLetter(pass.charAt(i)))
                flag = true;
            if (Character.isDigit(pass.charAt(i)))
                count++;
        }
        if (count <= 2 || count == 0 || !flag)
            return false;
        return true;
    }
}

class exe8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.println(sqrt(n));
    }

    public static double sqrt(long n) {
        double nextGuess = n, lastGuess = 1, e = 0.0001;
        while (Math.abs(nextGuess - lastGuess) >= e) {
            lastGuess = nextGuess;
            nextGuess = (lastGuess + n * 1.0 / lastGuess) / 2;
        }
        return nextGuess;
    }
}

class exe9 {
    public static void main(String[] args) {
        System.out.println("p\t\t\t2^p-1");
        System.out.println("---------------------------");
        for (int i = 2; i <= 31; i++) {
            double p = Math.log(i + 1) / Math.log(2);
            if (p % 1 == 0)
                System.out.printf("%4.0f\t\t%4d\n", p, i);
        }
    }
}

class exe10 {
    public static void main(String[] args) {
        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i) && isPrime(i + 2)) {
                System.out.printf("(%d,%d)\n", i, i + 2);
            }
        }
    }

    public static boolean isPrime(int num) {
        boolean flag = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                flag = false;
        }
        return flag;
    }
}

class exe11 {
    public static void main(String[] args) {
        int i = (int) (Math.random() * 6 + 1);
        int j = (int) (Math.random() * 6 + 1);
        int sum1 = i + j, sum2;
        if (sum1 == 2 || sum1 == 3 || sum1 == 12) {
            System.out.printf("You rolled %d+%d=%d\n", i, j, i + j);
            System.out.println("You lose");
        } else if (sum1 == 7 || sum1 == 11) {
            System.out.printf("You rolled %d+%d=%d\n", i, j, i + j);
            System.out.println("You win");
        } else {
            while (true) {
                i = (int) (Math.random() * 6 + 1);
                j = (int) (Math.random() * 6 + 1);
                sum2 = i + j;
                if (sum2 == 7) {
                    System.out.printf("You rolled %d+%d=%d\n", i, j, i + j);
                    System.out.println("You lose");
                    break;
                } else if (sum1 == sum2) {
                    System.out.printf("You rolled %d+%d=%d\n", i, j, i + j);
                    System.out.println("You win");
                    break;
                } else
                    System.out.printf("You rolled %d+%d=%d\n", i, j, i + j);
            }
        }
    }
}

class exe12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String cardnumber = in.nextLine();
        if (isVaild(cardnumber))
            System.out.println(cardnumber + " is valid");
        else
            System.out.println(cardnumber + " is invalid");
    }

    public static boolean isVaild(String number) {
        if ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0 && prefixMatched(number))
            return true;
        return false;
    }

    public static int sumOfDoubleEvenPlace(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += getDigit(number.charAt(i) - '0');
        }
        return sum;
    }

    public static int getDigit(int number) {
        int r = 2 * number, r1;
        if (r < 10)
            return r;
        else {
            r1 = r % 10;
            r1 += r / 10;
        }
        return r1;
    }

    public static int sumOfOddPlace(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i += 2)
            sum += number.charAt(i) - '0';
        return sum;
    }

    public static boolean prefixMatched(String number) {
        if (number.charAt(0) == '4' || number.charAt(0) == '5' || number.charAt(0) == '6' || number.charAt(0) == '3' && number.charAt(1) == '7')
            return true;
        return false;
    }
}

class exe13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int width = in.nextInt();
        System.out.println(format(num, width));
    }

    public static String format(int number, int width) {
        String r = "";
        r = Integer.toString(number);
        if (r.length() >= width)
            return r;
        else {
            for (int i = r.length(); i < width; i++)
                r = '0' + r;
        }
        return r;
    }
}

class exe14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[10];
        int num, count = 0;
        boolean flag = true;
        for (int i = 0; i < 10; i++) {
            flag = true;
            num = in.nextInt();
            for (int j : nums) {
                if (j == num) {
                    nums[i] = 0;
                    flag = false;
                    continue;
                }
            }
            if (flag) {
                count++;
                nums[i] = num;
            }
        }
        System.out.println("The number of distinct number is " + count);
        for (int i : nums) {
            if (i != 0)
                System.out.print(i + " ");
        }
    }
}

class exe15 {
    public static void main(String[] args) {
        int[] count = new int[10];
        Arrays.fill(count, 0);
        for (int i = 0; i < 100; i++) {
            count[(int) (Math.random() * 10)]++;
        }
        for (int i : count
        ) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

class exe16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[10];
        for (int i : nums) {
            i = in.nextInt();
        }
        System.out.println(indexOfSmallestElement(nums));
    }

    public static int indexOfSmallestElement(int[] array) {
        int min = array[0], index = 0;
        for (int i = 1; i < 10; i++) {
            if (array[i] <= min) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }
}

class exe17 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(getRandom(numbers));
    }

    public static int getRandom(int... numbers) {
        boolean flag = true;
        int num = 0;
        while (true) {
            flag = true;
            num = (int) (Math.random() * 54 + 1);
            for (int i : numbers) {
                if (i == num)
                    flag = false;
            }
            if (flag)
                break;
        }
        return num;
    }
}

class exe18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numbers = new int[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = in.nextInt();
        }
        System.out.print("The distinct numbers are:");
        for (int i : eliminateDuplicates(numbers)
        ) {
            if (i != 0)
                System.out.print(i + " ");
        }
    }

    public static int[] eliminateDuplicates(int[] list) {
        int[] numbers = new int[list.length];
        int k = 0;
        boolean flag;
        for (int i = 0; i < list.length; i++) {
            flag = true;
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] == list[j])
                    flag = false;
            }
            if (flag)
                numbers[k++] = list[i];
        }
        return numbers;
    }
}

class exe19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = in.nextInt();
        if (isSorted(nums))
            System.out.println("The list is already is already sorted.");
        else
            System.out.println("The list is not sorted.");
    }

    public static boolean isSorted(int[] list) {
        int[] list1 = Arrays.copyOf(list, list.length);
        Arrays.sort(list1);
        return Arrays.equals(list, list1);
    }
}

class exe20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of balls to drop:");
        int balls = in.nextInt();
        System.out.print("Enter the number of slots in the bean machine:");
        int slots_n = in.nextInt();
        char[] towards = new char[7];
        int[] slots = new int[slots_n];
        for (int m = 0; m < balls; m++) {
            int k = 0, count = 0;
            for (int i = 0; i < 7; i++) {
                int j = (int) (Math.random() * 2);
                if (j == 0)
                    towards[k++] = 'L';
                else
                    towards[k++] = 'R';
            }
            for (char i : towards) {
                System.out.print(i);
                if (i == 'R')
                    count++;
            }
            System.out.println();
            slots[++count]++;
        }
        int max = slots[0];//输出槽中球的储备情况
        for (int i = 0; i < balls; i++)
            if (slots[i] > max)
                max = slots[i];
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < slots_n; j++) {
                if (slots[j] >= max - i)
                    System.out.print("0");
                else
                    System.out.print(" ");
            }
            System.out.println("");
        }
    }
}

class exe21 {
    public static void main(String[] args) {
        boolean[] box = new boolean[100];
        for (int i = 0; i < 100; i++) {
            box[i] = false;
        }
        for (int m = 1; m <= 100; m++) {
            for (int n = m; n <= 100; n += m) {
                box[n - 1] = !box[n - 1];
            }
        }
        for (int t = 0; t < 100; t++) {
            if (box[t]) System.out.print(t + 1 + " ");
        }
    }
}

class exe22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int[] list1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            list1[i] = in.nextInt();
        }
        int n2 = in.nextInt();
        int[] list2 = new int[n1];
        for (int i = 0; i < n2; i++) {
            list2[i] = in.nextInt();
        }
        if (equals(list1, list2))
            System.out.println("Two lists are strictly identical");
        else
            System.out.println("Two lists are not strictly identical");
    }

    public static boolean equals(int[] list1, int[] list2) {
        return Arrays.equals(list1, list2);
    }
}

class exe23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        if (isConsecutiveFour(nums))
            System.out.println("The list has consecutive fours");
        else
            System.out.println("The list has no consecutive fours");
    }

    public static boolean isConsecutiveFour(int[] values) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == values[i + 1] && values[i] == values[i + 2] && values[i] == values[i + 3])
                return true;
        }
        return false;
    }

}

class exe24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int[] list1 = new int[n1];
        for (int i = 0; i < n1; i++)
            list1[i] = in.nextInt();
        int n2 = in.nextInt();
        int[] list2 = new int[n2];
        for (int i = 0; i < n2; i++)
            list2[i] = in.nextInt();
        System.out.print("The merged list is:");
        for (int i : merge(list1, list2)
        ) {
            System.out.print(i + " ");
        }
    }

    public static int[] merge(int[] list1, int[] list2) {
        int[] list = Arrays.copyOf(list1, list1.length + list2.length);
        System.arraycopy(list2, 0, list, list1.length, list2.length);
        Arrays.sort(list);
        return list;
    }
}

class exe25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] words = {"write", "me", "love", "that", "program", "java"};
        while (true) {
            int n = (int) (Math.random() * words.length);
            char[] input = new char[words[n].length()];
            for (int i = 0; i < words[n].length(); i++)
                input[i] = '*';
            int k = 0, miss = 0;
            while (k != words[n].length()) {
                System.out.print("(Guess) Enter a letter in word ");
                System.out.print(input);
                System.out.print(" > ");
                char ch = in.nextLine().charAt(0);
                boolean flag1 = false, flag2 = true;
                int index = 0;
                for (index = 0; index < words[n].length(); index++) {
                    if (words[n].charAt(index) == ch) {
                        flag1 = true;
                        break;
                    }
                }
                for (int i = 0; i < input.length; i++) {
                    if (ch == input[i]) {
                        flag2 = false;
                        break;
                    }
                }
                if (flag1 && flag2) {
                    k++;
                    input[index] = ch;
                } else if (flag1 && (!flag2)) {
                    miss++;
                    System.out.println(ch + " is already in the word.");
                } else
                    System.out.println(ch + " is not in the word.");
            }
            System.out.println("The word is " + words[n] + ". You missed " + miss + " time");
            System.out.println("Do you want to guess another word? Enter y or n");
            char c = in.nextLine().charAt(0);
            if (c == 'n')
                break;
        }

    }
}

class exe26 {
    public static void main(String[] args) {
        int[][] times = {{2, 4, 3, 4, 5, 8, 8}, {7, 3, 4, 3, 3, 4, 4}, {3, 3, 4, 3, 3, 2, 2}, {9, 3, 4, 7, 3, 4, 1}, {3, 5, 4, 3, 6, 3, 8}, {3, 4, 4, 6, 3, 4, 4}, {3, 7, 4, 8, 3, 8, 4}, {6, 3, 5, 9, 2, 7, 9}};
        int[] sums = new int[8];
        int sum;
        for (int i = 0; i < 8; i++) {
            sum = 0;
            for (int j = 0; j < 7; j++)
                sum += times[i][j];
            sums[i] = sum;
        }
        int max = sums[0];
        for (int i = 0; i < 8; i++)
            if (sums[i] >= max)
                max = sums[i];
        for (int j = max; j >= 0; j--) {
            for (int i = 0; i < 8; i++) {
                if (j == sums[i]) {
                    System.out.println("employee " + i + " " + sums[i]);
                }
            }
        }
    }
}

class exe27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] matrix1 = new double[9];
        double[] matrix2 = new double[9];
        double[] matrix3 = new double[9];
        for (int i = 0; i < 9; i++) {
            matrix1[i] = in.nextDouble();
        }
        for (int i = 0; i < 9; i++) {
            matrix2[i] = in.nextDouble();
        }
        matrix3 = addMatrix(matrix1, matrix2);
        System.out.println("The matrices are added as follows");
        for (int i = 0; i < 9; i++) {
            System.out.print(matrix1[i] + " ");
            if ((i + 1) % 3 == 0)
                System.out.println();
        }
        System.out.println("\t\t+");
        for (int i = 0; i < 9; i++) {
            System.out.print(matrix2[i] + " ");
            if ((i + 1) % 3 == 0)
                System.out.println();
        }
        System.out.println();
        System.out.println("\t\t=");
        for (int i = 0; i < 9; i++) {
            System.out.print(matrix3[i] + " ");
            if ((i + 1) % 3 == 0)
                System.out.println();
        }

    }

    public static double[] addMatrix(double[] a, double[] b) {
        double[] sum = new double[9];
        for (int i = 0; i < 9; i++)
            sum[i] = a[i] + b[i];
        return sum;

    }
}

class exe28 {
    public static void main(String[] args) {
        int[][] chess = new int[3][3];
        int k = 100000;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                chess[i][j] = k++;
            }
        }
        Scanner in = new Scanner(System.in);
        while (true) {
            for (int j = 0; j < 3; j++) {
                System.out.println("----------");
                System.out.print("|");
                for (int i = 0; i < 3; i++) {
                    if (chess[j][i] == 1)
                        System.out.print("X |");
                    else if (chess[j][i] == 2)
                        System.out.print("O |");
                    else
                        System.out.print("  |");
                }
                System.out.println();
            }
            System.out.println("----------");
            System.out.print("Enter a row for playX:");
            int m = in.nextInt();
            System.out.print("Enter a col for playX:");
            int n = in.nextInt();
            chess[m][n] = 1;
            for (int j = 0; j < 3; j++) {
                System.out.println("----------");
                System.out.print("|");
                for (int i = 0; i < 3; i++) {
                    if (chess[j][i] == 1)
                        System.out.print("X |");
                    else if (chess[j][i] == 2)
                        System.out.print("O |");
                    else
                        System.out.print("  |");
                }
                System.out.println();
            }
            System.out.println("----------");
            if (check(chess)) {
                System.out.println("X player won");
                break;
            }
            System.out.print("Enter a row for playO:");
            m = in.nextInt();
            System.out.print("Enter a col for playO:");
            n = in.nextInt();
            chess[m][n] = 2;
            for (int j = 0; j < 3; j++) {
                System.out.println("----------");
                System.out.print("|");
                for (int i = 0; i < 3; i++) {
                    if (chess[j][i] == 1)
                        System.out.print("X |");
                    else if (chess[j][i] == 2)
                        System.out.print("O |");
                    else
                        System.out.print("  |");
                }
                System.out.println();
            }
            System.out.println("----------");
            if (check(chess)) {
                System.out.println("O player won");
                break;
            }
        }
    }

    public static boolean check(int[][] chess) {
        for (int i = 0; i < 3; i++) {
            if (chess[i][0] == chess[i][1] && chess[i][0] == chess[i][2] || chess[0][i] == chess[1][i] && chess[0][i] == chess[2][i])
                return true;
        }
        if (chess[0][0] == chess[2][2] && chess[0][0] == chess[1][1] || chess[0][2] == chess[1][1] && chess[3][0] == chess[0][2])
            return true;
        return false;
    }
}

class exe29 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size for the matrix:");
        int n = in.nextInt();
        boolean flag = true;
        int[][] nums = new int[n][n];
        int j;
        for (int i = 0; i < n; i++) {
            flag = true;
            for (j = 0; j < n - 1; j++) {
                if (nums[i][j] != nums[i][j + 1])
                    flag = false;
            }
            if (flag)
                System.out.println("All " + nums[i][j] + "s on row " + i);
        }
        if (flag == false)
            System.out.println("No same numbers on a row");
        for (int i = 0; i < n; i++) {
            flag = true;
            for (j = 0; j < n - 1; j++) {
                if (nums[j][i] != nums[j + 1][i])
                    flag = false;
            }
            if (flag)
                System.out.println("All " + nums[j][i] + "s on row " + j);
        }
        if (flag == false)
            System.out.println("No same numbers on a column");
    }
}

class exe30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入银行的个数和要保持银行安全的最小总资产(整数): ");
        int bank = sc.nextInt();
        int limit = sc.nextInt();
        System.out.println();
        double[][] borrowers = new double[bank][bank];
        double[] balance = new double[bank];
        bankInput(borrowers, balance, bank);
        bankResult(borrowers, balance, bank, limit);
    }

    public static void bankInput(double[][] borrowers, double[] balance, int bank) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < bank; i++) {
            System.out.println("输入银行" + i + "的余额和从该银行借款的银行个数");
            System.out.print("和借款银行的编号和借款数额: ");
            balance[i] = sc.nextDouble();
            int num = sc.nextInt();
            for (int j = 0; j < num; j++) {
                int k = sc.nextInt();
                borrowers[i][k] = sc.nextDouble();
            }
            System.out.println();
        }
    }

    public static void bankResult(double[][] borrowers, double[] balance, int bank, int limit) {
        int[] result = new int[bank * (bank + 1) / 2 + bank];
        int num2 = 0;
        int num1 = 0;
        int num3;
        do {
            num3 = num1;
            num1 = 0;
            for (int i = 0; i < bank; i++) {
                double totalLoan = 0;
                for (int j = 0; j < bank; j++) {
                    totalLoan += borrowers[i][j];
                }
                double totalAssets = totalLoan + balance[i];
                if (totalAssets < limit) {
                    num2++;
                    num1++;
                    result[num2 - 1] = i;
                    for (int k = 0; k < bank; k++) {
                        borrowers[k][i] = 0;
                    }
                }
            }
        }
        while (num1 != num3);
        if (num2 == 0) {
            System.out.println("没有不安全的银行");
        } else {
            UnsafeBank(result, num2);
        }
    }

    public static void UnsafeBank(int[] result, int num2) {
        int[] j = new int[num2];
        int num;
        int d = 0;
        int i = 0;
        while (i < num2) {
            boolean c = true;
            num = result[i];
            for (int b = 1; b < d + 1; b++) {
                if (num == j[b - 1]) {
                    c = false;
                    break;
                }
            }
            if (c) {
                d++;
                j[d - 1] = num;
            }
            i++;
        }
        int[] e = new int[d];
        System.arraycopy(j, 0, e, 0, e.length);
        System.out.print("不安全的银行是: ");
        for (int f = 0; f < e.length; f++) {
            System.out.print(e[f] + " ");
        }
    }
}

class exe31 {
    public static void main(String[] args) {
        char[][] checkerboard = new char[6][15];
        char[][] chess = new char[6][7];
        checkerboardInput(checkerboard);
        int num = 0;
        do {
            System.out.println();
            checkerboardOutput(checkerboard);
            playChess(checkerboard, chess, num);
            num++;
        }
        while (fourLinks(chess, num) && num < 42);
        System.out.println();
        checkerboardOutput(checkerboard);
        if (fourLinks(chess, num)) {
            System.out.println("棋逢对手——平局");
        } else {
            if (num % 2 == 0) {
                System.out.println("执黄色棋的玩家获胜");
            } else {
                System.out.println("执红色棋的玩家获胜");
            }
        }
    }

    public static void checkerboardInput(char[][] checkerboard) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 15; j++) {
                if (j % 2 == 0) {
                    checkerboard[i][j] = '|';
                }
            }
        }
    }

    public static void checkerboardOutput(char[][] checkerboard) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(checkerboard[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void playChess(char[][] checkerboard, char[][] chess, int num) {
        Scanner sc = new Scanner(System.in);
        if (num % 2 == 0) {
            System.out.print("在0-6了列放下红色磁盘: ");
            int a = sc.nextInt();
            for (int j = 5; j >= 0; j--) {
                if (checkerboard[j][2 * a + 1] == 0) {
                    checkerboard[j][2 * a + 1] = 'R';
                    chess[j][a] = 'R';
                    break;
                }
            }
        } else {
            System.out.print("在0-6了列放下黄色磁盘: ");
            int a = sc.nextInt();
            for (int j = 5; j >= 0; j--) {
                if (checkerboard[j][2 * a + 1] == 0) {
                    checkerboard[j][2 * a + 1] = 'Y';
                    chess[j][a] = 'Y';
                    break;
                }
            }
        }
    }

    public static boolean fourLinks(char[][] chess, int num) {
        int num1;
        int num2;
        int num3;
        if (num > 5) {
            for (int i = 5; i >= 0; i--) {
                num1 = 0;
                for (int j = 1; j < 7; j++) {
                    if (chess[i][j] == chess[i][j - 1] && chess[i][j] != 0) {
                        num1++;
                        if (num1 == 3) {
                            return false;
                        }
                    } else {
                        num1 = 0;
                    }
                }
            }
            for (int j = 0; j < 7; j++) {
                num1 = 0;
                for (int i = 5; i > 0; i--) {
                    if (chess[i][j] == chess[i - 1][j] && chess[i][j] != 0) {
                        num1++;
                        if (num1 == 3) {
                            return false;
                        }
                    } else {
                        num1 = 0;
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                num3 = 0;
                num1 = 5;
                num2 = 3;
                num2 = num2 + i;
                for (int j = 0; j < i + 3; j++) {
                    if (chess[num1][num2] == chess[num1 - 1][num2 - 1] && chess[num1][num2] != 0) {
                        num3++;
                        if (num3 == 3) {
                            return false;
                        }
                    } else {
                        num3 = 0;
                    }
                    num1--;
                    num2--;
                }
            }
            for (int i = 0; i < 3; i++) {
                num3 = 0;
                num1 = 0;
                num2 = 1;
                num2 = num2 + i;
                for (int j = 5 - i; j > 0; j--) {
                    if (chess[num1][num2] == chess[num1 + 1][num2 + 1] && chess[num1][num2] != 0) {
                        num3++;
                        if (num3 == 3) {
                            return false;
                        }
                    } else {
                        num3 = 0;
                    }
                    num1++;
                    num2++;
                }
            }
            for (int i = 0; i < 3; i++) {
                num3 = 0;
                num1 = 0;
                num2 = 3;
                num2 = num2 + i;
                for (int j = 0; j < i + 3; j++) {
                    if (chess[num1][num2] == chess[num1 + 1][num2 - 1] && chess[num1][num2] != 0) {
                        num3++;
                        if (num3 == 3) {
                            return false;
                        }
                    } else {
                        num3 = 0;
                    }
                    num1++;
                    num2--;
                }
            }
            for (int i = 0; i < 3; i++) {
                num3 = 0;
                num1 = 5;
                num2 = 1;
                num2 = num2 + i;
                for (int j = 5 - i; j > 0; j--) {
                    if (chess[num1][num2] == chess[num1 - 1][num2 + 1] && chess[num1][num2] != 0) {
                        num3++;
                        if (num3 == 3) {
                            return false;
                        }
                    } else {
                        num3 = 0;
                    }
                    num1--;
                    num2++;
                }
            }
        }
        return true;
    }
}

class exe32 {
    public static void main(String[] argv) {
        double h = 0, p = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a 3-by-3 materix row by row:");
        double[][] a = new double[3][3];
        for (int b = 0; b < 3; b++) {
            for (int c = 0; c < 3; c++)
                a[b][c] = in.nextDouble();
        }
        for (int b = 0; b < 3; b++) {
            for (int c = 0; c < 3; c++)
                p += a[c][b];
            if (p != 1)
                h++;
            p = 0;
        }
        if (h != 0)
            System.out.println("it is not marks ");
        else
            System.out.println("it is marks ");

    }
}

class exe33 {
    public static void main(String[] argv) {

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();

        int[][] b = new int[a][a];
        int[][] c = new int[a][a];
        for (int h = 0; h < a; h++) {
            for (int e = 0; e < a; e++)
                b[h][e] = in.nextInt();
        }
        for (int h = 0; h < a; h++) {
            for (int e = 0; e < a; e++)
                c[h][e] = in.nextInt();
        }
        equals(b, c, a);
    }

    public static void equals(int[][] b, int[][] c, int a) {
        int h = 0;
        for (h = 0; h < a; h++) {
            for (int e = 0; e < a; e++) {
                if (b[h][e] != c[h][e]) {
                    h = 1;
                    break;
                }

            }
        }
        if (h == 1)
            System.out.println("不是严格相同 ");
        else
            System.out.println("是严格相同 ");

    }

}

class exe34 {
    public static void main(String[] argv) {

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();

        int[][] b = new int[a][a];
        int[][] c = new int[a][a];
        for (int h = 0; h < a; h++) {
            for (int e = 0; e < a; e++)
                b[h][e] = in.nextInt();
        }
        for (int h = 0; h < a; h++) {
            for (int e = 0; e < a; e++)
                c[h][e] = in.nextInt();
        }
        equals(b, c, a);
    }

    public static void equals(int[][] b, int[][] c, int a) {
        int h = 0;
        for (h = 0; h < a; h++) {
            for (int e = 0; e < a; e++) {
                if (b[h][e] != c[h][e]) {
                    h = 1;
                    break;
                }

            }
        }
        if (h == 1)
            System.out.println("不是严格相同 ");
        else
            System.out.println("是严格相同 ");

    }

}

class exe35 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入方阵维数n：");
        int n = input.nextInt();
        int[][] m = new int[n][n];
        int[] a = new int[3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = (int) (Math.random() * 10) % 2;
                System.out.print(m[i][j] + "\t");
            }
            System.out.print("\n");
        }
        a = findLargestBlock(m);
        System.out.print("\n");
        System.out.println("最大子方阵位于：(" + a[0] + "," + a[1] + ")");
        System.out.println("阶数：" + a[2]);
    }

    public static int[] findLargestBlock(int[][] m) {
        boolean t = true;
        int[] a = new int[3];
        int n = m.length;
        int i = 0, j = 0, l = 0;
        for (l = n; l >= 1; l--) {
            for (i = 0; i <= n - l; i++) {
                for (j = 0; j <= n - l; j++) {
                    t = true;
                    for (int x = i; x < i + l; x++) {
                        for (int y = j; y < j + l; y++) {
                            if (m[x][y] != 1) {
                                t = false;
                                break;
                            }
                        }
                        if (t == false) break;
                    }
                    if (t == true) break;
                }
                if (t == true) break;
            }
            if (t == true) break;
        }
        a[0] = i;
        a[1] = j;
        a[2] = l;
        return a;
    }
}

class exe36 {
    public static void main(String[] args) {
        int pp = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("请输入方阵维数n：");
        int n = in.nextInt();
        char[][] ch1 = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int ii = 0; ii < n; ii++) {
                ch1[i][ii] = in.next().charAt(0);
                while (ch1[i][ii] > ('A' + n - 1)) {
                    System.out.println("Wrong in put be from A to " + (char) ('A' + n - 1));
                    ch1[i][ii] = in.next().charAt(0);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int ii = 0; ii < n; ii++) {
                for (int iii = (ii + 1); iii < n; iii++)
                    if (ch1[i][ii] == ch1[i][iii]) {
                        pp = 1;
                    }
                for (int iii = (i + 1); iii < n; iii++)
                    if (ch1[i][ii] == ch1[iii][ii]) {
                        pp = 1;
                    }
            }
        }
        if (pp == 1)

            System.out.println("NO");

        else
            System.out.println("YES");


    }
}













