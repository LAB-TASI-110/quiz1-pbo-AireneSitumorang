package driver;

import java.util.Scanner;

public class Driver3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input jumlah data
        System.out.print("Jumlah data: ");
        int N = sc.nextInt();

        int[] nilai = new int[N];

        // Input nilai siswa
        System.out.println("Masukkan nilai:");
        for (int i = 0; i < N; i++) {
            nilai[i] = sc.nextInt();
        }

        // Input ukuran kelompok
        System.out.print("Jumlah siswa per kelompok: ");
        int ukuran = sc.nextInt();

        // Input kode kelompok
        System.out.print("Kode kelompok yang dihitung: ");
        int kode = sc.nextInt();

        // Hitung batas kelompok
        int mulai = (kode - 1) * ukuran;
        int akhir = mulai + ukuran;

        int total = 0;

        for (int i = mulai; i < akhir && i < N; i++) {
            total += nilai[i];
        }

        // Output
        System.out.println("Total nilai kelompok " + kode + " = " + total);
    }
}
