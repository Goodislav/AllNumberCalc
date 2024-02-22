package Calculator;

class Numbers {

    // проверка латинских цифр
    static boolean checkLatin(String number) throws Exception {
        String[] latinNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] overLatinNumbers = {"XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII",
                "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII",
                "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII",
                "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        for (String latinNumber : latinNumbers) {
            if (number.equals(latinNumber)) {
                return true;
            }
        }
        for (String overLatinNumber : overLatinNumbers) {
            if (number.equals(overLatinNumber)) {
                throw new Exception("Вводимые числа должны быть от I до X включительно");
            }
        }
        return false;
    }

    // проверка арабских чисел
    static boolean checkArabic(String number) throws Exception {
        String[] arabicNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (String arabicNumber : arabicNumbers) {
            if (number.equals(arabicNumber)) {
                return true;
            }
        }
        return false;
    }

    // конвертация латинского числа строчного типа в целочисленный тип
    static int fromLatin(String number) throws Exception {
        return switch (number) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new Exception("Ошибка. Ввод только положительных римских чисел от I до X");
        };
    }

    // обратная конвертация для получения результата расчёта выражений с латинскими числами - в формате латинских чисел
    static String toLatin(int number) throws IllegalStateException {
        return switch (number) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            case 10 -> "X";
            case 11 -> "XI";
            case 12 -> "XII";
            case 13 -> "XIII";
            case 14 -> "XIV";
            case 15 -> "XV";
            case 16 -> "XVI";
            case 17 -> "XVII";
            case 18 -> "XVIII";
            case 19 -> "XIX";
            case 20 -> "XX";
            case 21 -> "XXI";
            case 24 -> "XXIV";
            case 25 -> "XXV";
            case 27 -> "XXVII";
            case 28 -> "XXVIII";
            case 30 -> "XXX";
            case 32 -> "XXXII";
            case 35 -> "XXXV";
            case 36 -> "XXXVI";
            case 40 -> "XL";
            case 42 -> "XLII";
            case 45 -> "XLV";
            case 48 -> "XLVIII";
            case 49 -> "XLIX";
            case 50 -> "L";
            case 54 -> "LIV";
            case 56 -> "LVI";
            case 60 -> "LX";
            case 63 -> "LXIII";
            case 64 -> "LXIV";
            case 70 -> "LXX";
            case 72 -> "LXXII";
            case 80 -> "LXXX";
            case 81 -> "LXXXI";
            case 90 -> "XC";
            case 100 -> "C";
            default ->
                    throw new IllegalStateException("Ошибка. В римской системе нет числа \"0\" и отрицательных чисел: " + number);
        };
    }
}
