package Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Calculator {

// чтение строки с консоли
    static String read() throws IOException {
        BufferedReader reader = null;
        String input = null;

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            input = reader.readLine();
        } catch (IOException e) {
            e.getStackTrace();
        } catch (NullPointerException e) {
            e.getStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return input;
    }

    // удаление лишних пробелов из считанной строки
    static String[] deleteSpaces(String input) {
        return input.split(" ");
    }

    // проверка на ввод разных систем счисления
    static boolean checkMixedTypeOfNumbers(String num1, String num2) throws DifferentTypesException, Exception {
        return ((Numbers.checkArabic(num1) && Numbers.checkLatin(num2)) || (Numbers.checkLatin(num1) && Numbers.checkArabic(num2)));
    }

    // проверка строк на наличие латинских чисел
    static boolean checkLatinTypeOfNumbers(String num1, String num2) throws Exception {
        return Numbers.checkLatin(num1) && Numbers.checkLatin(num2);
    }

    // проверка строк на наличие арабских чисел
    static boolean checkArabicTypeOfNumbers(String num1, String num2) throws Exception {
         if (Numbers.checkArabic(num1) && Numbers.checkArabic(num2)) {
             return true;
         }
         if (!Numbers.checkArabic(num1) || !Numbers.checkArabic(num2)) {
             throw new Exception("Вводимые числа должны быть от 1 до 10 включительно");
         }
        return false;
    }

    // запись в строку выражений арабскими числами
    static String writeArabic(String[] array) throws Exception {
        String operator = array[1];

        int number1 = Integer.parseInt(array[0]);
        int number2 = Integer.parseInt(array[2]);

        return String.valueOf(calculateArabic(number1, operator, number2));
    }

    // запись выражений латинскими числами
    static String writeLatin(String[] array) throws Exception {
        String operator = array[1];

        int number1 = Numbers.fromLatin(array[0]);
        int number2 = Numbers.fromLatin(array[2]);

        return Numbers.toLatin(calculateLatin(number1, operator, number2));
    }

    // расчёт выражений с арабскими числами
    static int calculateArabic(int number1, String operator, int number2) throws Exception {
        int result;

        if ((number1 >= 1 && number1 <= 10) && (number2 >= 1 && number2 <= 10)) {
            switch (operator) {
                case "+" -> result = number1 + number2;
                case "-" -> result = number1 - number2;
                case "*" -> result = number1 * number2;
                case "/" -> result = number1 / number2;
                default -> throw new IllegalStateException("Недопустимое выражение: " + operator);
            }
            return result;
        } /*else if ((number1 <= 0 || number1 > 10) || (number2 <= 0 || number2 > 10)) {
            throw new Exception("Вводимые числа должны быть от 1 до 10 включительно.");
        }*/

        return 0;
    }

    // расчёт выражений с латинсикими цифрами
    static int calculateLatin(int number1, String operator, int number2) throws IllegalStateException {
        int result;

        if ((number1 >= 1 && number1 <= 10) && (number2 >= 1 && number2 <= 10)) {
            switch (operator) {
                case "+" -> result = number1 + number2;
                case "-" -> result = number1 - number2;
                case "*" -> result = number1 * number2;
                case "/" -> result = number1 / number2;
                default -> throw new IllegalStateException("Недопустимое выражение: " + operator);
            }
            return result;
        }

        return 0;
    }
}
