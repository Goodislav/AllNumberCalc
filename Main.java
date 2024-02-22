package Calculator;


class Main {
    public static void main(String[] args) throws Exception, DifferentTypesException {

        System.out.println("Введите арифметическое выражение, исключительно в формате a + b, a - b, a * b или a / b, с пробелами между ними:");

        try {
            System.out.println("Ответ: " + calc(Calculator.read()));
        } catch (NumberFormatException e) {
            System.err.println("Поддерживается только ввод чисел от 1 до 10, буквы и символы, кроме знаков операций + - * /, не принимаются.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка. Cтрока не является математической операцией");
        } catch (DifferentTypesException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static String calc(String input) throws DifferentTypesException, Exception {
        String[] symbols = Calculator.deleteSpaces(input);

        if (symbols.length > 3) {
            throw new Exception("Ошибка. Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        String num1 = symbols[0];
        String num2 = symbols[2];
        String result = "ошибка";

        if (Calculator.checkMixedTypeOfNumbers(num1, num2)) {
            throw new DifferentTypesException("Ошибка. Используются одновременно разные системы счисления");
        }
        if (Calculator.checkLatinTypeOfNumbers(num1, num2)) {
            return Calculator.writeLatin(symbols);
        }
        if (Calculator.checkArabicTypeOfNumbers(num1, num2)) {
            return Calculator.writeArabic(symbols);
        }

        return result;
    }
}
/*
 * На 21.02.2024 написал 3 класса и 13 методов, которые выполняют функции сложения, вычитания, умножения, деления.
 * Но пока не выбрасывают все необходимые исключения.
 * Далее потребуется:
 * - (сделано 21.02)требуется добавить условные операторы для определения типа числа: арабское или римское. И включения подходящей ветки кода;
 * - (сделано 20.02) написать метод/класс, которые обрабатывает римские цифры и переводит их в int значения;
 * - (сделано 21.02) добавить к уже написанному коду эти методы/классы;
 * - На 22.02 всё сделано, кроме согласованности 2 ошибок: системы счисления и ввода чисел вне диапазона от 1 до 10, в обоих системах счисления.
 * */