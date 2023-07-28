import java.io.IOException;

public enum Rome {
    I(1, "I"), II(2, "II"), III(3, "III"), IV(4, "IV"), V(5, "V"), VI(6, "VI"),
    VII(7, "VII"), VIII(8, "VIII"), IX(9, "IX"), X(10, "X");

    private int znachenie;
    private String znachenieStroki;

    Rome(int znachenie, String znachenieStroki) {
        this.znachenie = znachenie;
        this.znachenieStroki = znachenieStroki;
    }

    public int getZnachenie() {
        return znachenie;
    }

    public String getZnachenieStroki() {
        return znachenieStroki;
    }


    public static void podschetSumRome(int x1, int x2) {
        int sum = x1 + x2;
        perevod(sum);
    }

    public static void podschetDifRome(int x1, int x2) {
        int dif = 0;
        if (x2 > x1) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("В римской системе нет отрицательных чисел");
            }
        } else dif = x1 - x2;
        perevod(dif);

    }

    public static void podschetMultRome(int x1, int x2) {
        int mult = x1 * x2;
        perevod(mult);
    }

    public static void podschetDivRome(int x1, int x2) {
        System.out.println(x1 / x2);
    }

    public static void perevod(int x) {
        String s = Integer.toString(x);
        RomeOtvet romeOtvet = RomeOtvet.II;
        char s1 = 0;
        char s2 = 0;
        String pervIndex;
        String vtIndex;

        if (s.length() == 3) {
            System.out.println("C");
        } else if (s.charAt(s.length() - 1) == '0') {
            for (RomeOtvet elements : RomeOtvet.values()) {
                if (s.equals(elements.getZnachenieOtvet())) {
                    System.out.println(elements.getZnachenieStrokiOtvet());
                }
            }
        } else if (s.length() == 1) {
            for (RomeOtvet elements : RomeOtvet.values()) {
                if (s.equals(elements.getZnachenieOtvet())) {
                    System.out.println(elements.getZnachenieStrokiOtvet());
                }
            }
        } else if (s.length() == 2) {
            s1 = s.charAt(0);
            s2 = s.charAt(1);
            pervIndex = s1 + "0";
            vtIndex = s2 + "";
            for (RomeOtvet elements : RomeOtvet.values()) {
                if (pervIndex.equals(elements.getZnachenieOtvet())) {
                    pervIndex = elements.getZnachenieStrokiOtvet();
                    for (RomeOtvet elements1 : RomeOtvet.values()) {
                        if (vtIndex.equals(elements1.getZnachenieOtvet())) {
                            vtIndex = elements1.getZnachenieStrokiOtvet();
                        }
                    }
                }

            }
            System.out.println(pervIndex + vtIndex);
        }

    }


}


