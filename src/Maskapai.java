import java.util.Scanner;

class Maskapai {
    static String pilihMaskapai() {
        Scanner sc = new Scanner(System.in);
        String maskapaiTerpilih = null;

        System.out.println("==========================================");
        System.out.println("=======Pilih Maskapai Penerbangan:========");
        System.out.println("==========================================");
        System.out.println();
        System.out.println("1. Garuda Indonesia");
        System.out.println("2. Lion Air");
        System.out.println("3. AirAsia");
        System.out.print("Masukkan nomor maskapai (1-3): ");

        int nomorMaskapai = sc.nextInt();
        switch (nomorMaskapai) {
            case 1:
                maskapaiTerpilih = "Garuda Indonesia";
                break;
            case 2:
                maskapaiTerpilih = "Lion Air";
                break;
            case 3:
                maskapaiTerpilih = "AirAsia";
                break;
            default:
                System.out.println("Nomor maskapai tidak valid.");
        }

        return maskapaiTerpilih;
    }
}
