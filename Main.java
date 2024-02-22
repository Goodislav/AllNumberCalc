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

    // принимает строку с арифметическим выражением между двумя числами и возвращает строку с результатом их выполнения
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
