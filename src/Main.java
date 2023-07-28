import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        // Вводим строку
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        // Необходимо проверить строку по условиям ТЗ
        proverkaStroki(s);
        proverkaStroki2(s);
        proverkaStroki3(s);

        // Необходимо разделить строку на два операнда по знаку +-*/
        // Создадим две переменные для срок и массив для их хранения
        String[] parts = razdelenieStroki(s);
        String s1 = parts[0];
        String s2 = parts[1];


        // Необходимо проверить входящие числа на попадание в интервал от 1 до 10 (I - X)
        if ((proverkaVhoda(s1) == true) & (proverkaVhoda(s2) == true)) {
            proverkaOperandov(s, s1, s2);
        } else try {
            throw new IOException();
        } catch (IOException e) {
            System.out.println("Введите значение от 1 до 10 или от I до X");
        }


    }

    // Метод проверки вводимой строки
    public static void proverkaStroki(String s) {
        if ((s.length() > 2) & (s.charAt(0) != '+') & (s.charAt(0) != '-') &             //Проверка длины строки и наличия +-*/ на первом
                (s.charAt(0) != '*') & (s.charAt(0) != '/') &                            // или последнем месте (Пример: 55+ или *67 - не допускаются)
                (s.charAt(s.length() - 1) != '+') & (s.charAt(s.length() - 1) != '-') &
                (s.charAt(s.length() - 1) != '*') & (s.charAt(s.length() - 1) != '/')) {

        } else try {
            throw new IOException();
        } catch (IOException e) {
            System.out.println("Строка не является математической операцией");
            System.exit(0);
        }

    }

    //Метод поиска второго (лишнего) оператора
    public static void proverkaStroki2(String s) {
        if ((s.contains("+")) & (s.contains("-")) | ((s.contains("+")) & (s.contains("*"))) |
                ((s.contains("+")) & (s.contains("/"))) | ((s.contains("-")) & (s.contains("*"))) |
                ((s.contains("-")) & (s.contains("/"))) | ((s.contains("*")) & (s.contains("/")))) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Только один оператор!");
                System.exit(0);
            }
        }
    }

    public static void proverkaStroki3(String s) {
        if (s.contains(".") | s.contains(",")) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Только целые числа");
            }
        }
    }


    //Метод разделения строки на две и возвращения их в виде массива
    public static String[] razdelenieStroki(String s) {
        String s1 = null;
        String[] parts = new String[0];
        if (s.contains("+")) {
            parts = s.split("\\+");
        } else if (s.contains("-")) {
            parts = s.split("-");
        } else if (s.contains("*")) {
            parts = s.split("\\*");
        } else if (s.contains("/")) {
            parts = s.split("/");
        } else try {
            throw new IOException();
        } catch (IOException e) {
            System.out.println("Строка не является математической операцией");
            System.exit(0);
        }
        if (parts.length > 2) {            // Если длина массива больше 2, то строка S содержит более одного оператора
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Только один оператор!");
                System.exit(0);
            }
        }
        return parts;
    }

    public static boolean proverkaVhoda(String s) {
        String[] spisokChisel = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        Rome rome = Rome.I;

        for (String string : spisokChisel) {
            if (s.equals(string)) {
                return true;
            } else for (Rome elements : Rome.values()) {
                if (s.equals(elements.getZnachenieStroki())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void proverkaOperandov(String s, String s1, String s2) {
        String[] spisokChisel = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        Rome rome = Rome.I;
        int x1 = 0, x2 = 0;
        int y1 = 0, y2 = 0;

        for (String elements : spisokChisel) {
            if (s1.equals(elements)) {
                for (String elements2 : spisokChisel) {
                    if (s2.equals(elements2)) {
                        x1 = Integer.parseInt(s1);
                        x2 = Integer.parseInt(s2);
                        if (s.contains("+")) {
                            sum(Integer.parseInt(s1), Integer.parseInt(s2));
                        }
                        if (s.contains("-")) {
                            dif(Integer.parseInt(s1), Integer.parseInt(s2));
                        }
                        if (s.contains("*")) {
                            mult(Integer.parseInt(s1), Integer.parseInt(s2));
                        }
                        if (s.contains("/")) {
                            div(Integer.parseInt(s1), Integer.parseInt(s2));
                        }
                    } else for (Rome elements5 : Rome.values()) {
                        if (s2.equals(elements5.getZnachenieStroki())) {
                            System.out.println("Разные системы счисления");
                            System.exit(0);
                        }
                    }
                }
            } else for (Rome elements3 : Rome.values()) {
                if (s1.equals(elements3.getZnachenieStroki())) {
                    for (Rome elements4 : Rome.values()) {
                        if (s2.equals(elements4.getZnachenieStroki())) {
                            if (s.contains("+")) {
                                Rome.podschetSumRome(elements3.getZnachenie(), elements4.getZnachenie());
                                System.exit(0);
                            }
                            if (s.contains("-")) {
                                Rome.podschetDifRome(elements3.getZnachenie(), elements4.getZnachenie());
                                System.exit(0);
                            }
                            if (s.contains("*")) {
                                Rome.podschetMultRome(elements3.getZnachenie(), elements4.getZnachenie());
                                System.exit(0);
                            }
                            if (s.contains("/")) {
                                Rome.podschetDivRome(elements3.getZnachenie(), elements4.getZnachenie());
                                System.exit(0);
                            }
                        } else for (String elements6 : spisokChisel) {
                            if (s2.equals(elements6)) {
                                System.out.println("Разные системы счисления!");
                                System.exit(0);
                            }
                        }
                    }
                }
            }
        }


    }


    public static void sum(int x1, int x2) {
        System.out.println(x1 + x2);
    }

    public static void dif(int x1, int x2) {
        System.out.println(x1 - x2);
    }

    public static void mult(int x1, int x2) {
        System.out.println(x1 * x2);
    }

    public static void div(int x1, int x2) {
        System.out.println(x1 / x2);
    }


}