import java.util.Scanner;


class MainProgram {
    public static void main(String[] args) {
        menu_awal();
    }

    static Scanner sc = new Scanner(System.in);
    static char ulang;

    public static void menu_awal() {
        int pilih_menu;
        ulang = 'S';
        do {
            System.out.println("========== MENU TIKET MURAH ==========");
            System.out.println("[1]\tList Penerbangan");
            System.out.println("[2]\tTransaksi");
            System.out.println("[3]\tExit");
            System.out.println("=====================================");
            System.out.print("Pilih : ");
            try {
                pilih_menu = sc.nextInt();
                System.out.println("");
                switch (pilih_menu) {
                    case 1:
                        Penerbangan.list();
                        break;

                    case 2:
                        Transaksi.transaksi();
                        break;
                    case 3:
                        System.exit(0);
                default:
                        System.out.println("Inputan salah!");
                }
            } catch (Exception e) {
                System.out.println("Hanya Masukan Angka");
                ulang = sc.next().charAt(0);
            }
            System.out.print("ingin kembali ke menu awal ?(Y/T) ");
            ulang = sc.next().charAt(0);
        } while (ulang == 'Y' || ulang == 'y');
    }
    public static void list() {
    }
    public static void transaksi() {
    }
}