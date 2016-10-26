package jp.co.ogis_ri.optaplanner.vehiclerouting.mapsutil;

import java.util.Scanner;

/**
 * even(odd) + odd(even) + X %10 == 0
 * 1
 * 846087729128569X
 * Compute X
 */
public class CheckCreditCardNo {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N < 1 || N > 100) {
            System.exit(1);
        }

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            String[] ary = s.split("");

            if (s.length() > 16) {
                System.exit(1);
            }
            if (!s.endsWith("X")) {
                System.exit(1);
            }

            String sub = s.substring(0, s.length() - 1);
            if (!sub.matches("^\\d{15}$")) {
                System.exit(1);
            }

            // from index 0, so odd as even
            Integer even = 0;
            Integer odd = 0;
            for (int y = 0; y < 16; y = y + 2) {
                String ary2 = String.valueOf(Integer.valueOf(ary[y]) * 2);
                String rs;
                if (ary2.length() > 1) {
                    int m = Integer.valueOf(ary2.substring(0, 1));
                    int n = Integer.valueOf(ary2.substring(1, 2));
                    rs = String.valueOf(m + n);
                } else {
                    rs = ary2;
                }
                even += Integer.valueOf(rs);
            }
            // from index 1, so even as odd
            for (int z = 1; z < 16; z = z + 2) {
                if (z != 15) {
                    odd += Integer.valueOf(ary[z]);
                }
            }
            for (int r = 0; r < 10; r++) {
                if ((even + odd + r) % 10 == 0) {
                    System.out.println(r);
                    break;
                }
            }
        }
    }
}
