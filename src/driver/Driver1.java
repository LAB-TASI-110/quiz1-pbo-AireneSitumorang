package driver;

import java.util.Scanner;

public class Driver1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String kode;
        int harga = 0;
        int totalBayar = 0;

        System.out.println("--------------------------------------------------");
        System.out.println("             SISTEM WARUNG MAK ROBY               ");
        System.out.println("--------------------------------------------------");
        System.out.println("Masukkan Kode Menu dan Porsi");
        System.out.println("Ketik 0 untuk tampilkan TOTAL & selesai\n");

        System.out.printf("%-25s %-6s %-10s %-10s\n",
                "Menu", "Porsi", "Harga", "Total");
        System.out.println("--------------------------------------------------");

        while (true) {

            System.out.print("Kode Menu : ");
            kode = input.nextLine();

            // Tombol 0 untuk selesai dan tampilkan total
            if (kode.equals("0")) {
                break;
            }

            System.out.print("Porsi     : ");
            String porsiInput = input.nextLine();

            int porsi;

            try {
                porsi = Integer.parseInt(porsiInput);
            } catch (NumberFormatException e) {
                System.out.println("Porsi harus angka!\n");
                continue;
            }

            String namaMenu = "";

            switch (kode.toUpperCase()) {
                case "NGS":
                    namaMenu = "Nasi Goreng Spesial";
                    harga = 15000;
                    break;
                case "AP":
                    namaMenu = "Ayam Penyet";
                    harga = 20000;
                    break;
                case "SA":
                    namaMenu = "Sate Ayam (10 Tusuk)";
                    harga = 25000;
                    break;
                case "BU":
                    namaMenu = "Bakso Urat";
                    harga = 18000;
                    break;
                case "MAP":
                    namaMenu = "Mie Ayam Pangsit";
                    harga = 15000;
                    break;
                case "GG":
                    namaMenu = "Gado-Gado";
                    harga = 15000;
                    break;
                case "SAM":
                    namaMenu = "Soto Ayam";
                    harga = 17000;
                    break;
                case "RD":
                    namaMenu = "Rendang Daging";
                    harga = 25000;
                    break;
                case "IB":
                    namaMenu = "Ikan Bakar";
                    harga = 35000;
                    break;
                case "NUK":
                    namaMenu = "Nasi Uduk Komplit";
                    harga = 20000;
                    break;
                default:
                    System.out.println("Kode tidak ditemukan!\n");
                    continue;
            }

            int totalItem = harga * porsi;
            totalBayar += totalItem;

            // Tampilkan hanya item yang dipesan (bukan total akhir)
            System.out.printf("%-25s %-6d %-10d %-10d\n",
                    namaMenu, porsi, harga, totalItem);

            System.out.println("--------------------------------------------------");
        }

        // ================== PERHITUNGAN DISKON ==================
        double diskon = 0;
        String jenisKupon = "Tidak ada";

        if (totalBayar >= 200000) {
            diskon = 0.20;
            jenisKupon = "Kupon Hijau (20%)";
        } else if (totalBayar >= 150000) {
            diskon = 0.15;
            jenisKupon = "Kupon Merah (15%)";
        } else if (totalBayar >= 100000) {
            diskon = 0.10;
            jenisKupon = "Kupon Kuning (10%)";
        } else if (totalBayar >= 50000) {
            diskon = 0.05;
            jenisKupon = "Kupon Biru (5%)";
        }

        int potongan = (int) (totalBayar * diskon);
        int totalAkhir = totalBayar - potongan;

        // ================== TAMPILKAN TOTAL ==================
        System.out.println("\n--------------------------------------------------");
        System.out.println("                 RINCIAN PEMBAYARAN               ");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-25s : %d\n", "Total Pembayaran", totalBayar);
        System.out.printf("%-25s : %s\n", "Jenis Kupon", jenisKupon);
        System.out.printf("%-25s : %d\n", "Potongan", potongan);
        System.out.println("--------------------------------------------------");
        System.out.printf("%-25s : %d\n", "TOTAL BAYAR", totalAkhir);
        System.out.println("--------------------------------------------------");

        input.close();
    }
}
