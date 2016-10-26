package jp.co.ogis_ri.optaplanner.vehiclerouting.mapsutil;

import java.util.Scanner;
public class CheckIpv4 {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        if ( M < 1 || M > 100) {
            System.exit(1);
        }
        for (int i = 0; i < M; i++) {
            String s = sc.next();
            if (s.matches("^(([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]).){3}([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$")) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }
}
