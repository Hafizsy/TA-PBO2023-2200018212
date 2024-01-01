import java.util.Random;
import java.util.Scanner;
class Transaksi {
    public static void transaksi() {
        Tanggal tgl = new Tanggal();
        Scanner userinput = new Scanner(System.in);

        int pesanan = 0;
        int jumlah = 0, bayar = 0, tagihan = 0, pajak, kembali;

        System.out.println("------------------------SELAMAT DATANG DI TIKET MURAH--------------------------");
        System.out.println("===============================================================================");
        System.out.print("Masukan Jumlah Pesanan : ");
        pesanan = userinput.nextInt();
        int[] tiket = new int[pesanan];
        int[] tujuan = new int[pesanan];
        String infotujuan = null, infoakhir = null;
        String[] namatujuan = new String[pesanan];
        Penumpang[] penumpang = new Penumpang[pesanan];

        for (int i = 0; i < pesanan; i++) {
            System.out.print("Masukan Nama Anda : ");
            String nama = userinput.next();
            System.out.print("Masukan Nomor Telepon Anda : ");
            String nomorTelepon = userinput.next();

            penumpang[i] = new Penumpang(nama, nomorTelepon);

            Penerbangan.list();
            System.out.println();
            System.out.print("Masukan No tujuan = ");
            tujuan[i] = userinput.nextInt();

            if (tujuan[i] >= 1 && tujuan[i] <= 5) {
                namatujuan[i] = getTujuanNama(tujuan[i]);
                tiket[i] = getHargaTiket(tujuan[i]);
                infotujuan = getInfotujuan(tujuan[i]);
                infoakhir = getInfoAkhir(tujuan[i]);
            } else {
                System.out.println("Tujuan Tidak Ditemukan");
                i--;  // Ulangi iterasi
                continue;
            }

            System.out.print("Masukan Jumlah Tiket = ");
            jumlah = userinput.nextInt();

            String maskapai = Maskapai.pilihMaskapai();

            pajak = tiket[i] * 10 / 100;
            tagihan = (tiket[i] * jumlah) + pajak;
            System.out.println("Membeli Dengan Jumlah " + jumlah + " tiket pesawat dengan tujuan " + namatujuan[i] + " dengan maskapai: " + maskapai);
            System.out.println("Tagihan anda adalah sebesar Rp. " + tagihan);
            System.out.println("Sudah termasuk PAJAK 10%");
            System.out.print("Jumlah yang Dibayar : Rp.");
            bayar = userinput.nextInt();
            System.out.println();

            while (bayar < tagihan) {
                System.out.println("Uang Anda Kurang");
                System.out.print("Masukan Uang Tambahan = Rp.");
                int tambahan = userinput.nextInt();
                bayar = bayar + tambahan;
            }
            kembali = bayar - tagihan;
            System.out.println("Kembalian Anda Sebesar Rp." + kembali);
            System.out.println("");
            System.out.println("===============================================================================");
        }

        for (int a = 0; a < pesanan; a++) {
            System.out.println("---------TERIMAKASIH TELAH MEMPERCAYAI KAMI----------");
            System.out.print("Kode Booking\t\t\t:");
            Random notrans = new Random();
            int b[];
            b = new int[5];
            for (int c = 0; c < b.length; c++) {
                char huruf = (char) (notrans.nextInt(26) + 'A');
                System.out.print(notrans.nextInt(9) + "-" + (notrans.nextInt(9)) + huruf);
            }
            System.out.println();
            System.out.println("Nama Pemesan\t\t\t:" + penumpang[a].getNama());
            System.out.println("Nomor Telepon\t\t\t:" + penumpang[a].getNomorTelepon());
            System.out.println("Tujuan Anda\t\t\t:" + namatujuan[a]);
            System.out.println("Jadwal Pemberangkatan\t\t:" + infotujuan);
            System.out.println("Jadwal Sampai Tujuan\t\t:" + infoakhir);
            System.out.print("Tanggal Pemesanan Anda\t\t:");
            tgl.getTanggal();
            System.out.print("Waktu Pemesanan Anda\t\t:");
            tgl.getWaktu();
            System.out.println("Jumlah yang Anda Beli\t\t:" + jumlah);
            System.out.println("Total Harga\t\t\t:" + tagihan);
            System.out.println("Total Tagihan yg anda bayar\t:" + bayar);
            System.out.println("----------------TIKET MURAH PALING OKE----------------");

        }
    }

    private static String getTujuanNama(int nomorTujuan) {
        String[] tujuanNama = {"TOKYO", "HARUJUKU", "KYOTO", "OSAKA", "SAPPORO"};
        return tujuanNama[nomorTujuan - 1];
    }

    private static int getHargaTiket(int nomorTujuan) {
        int[] hargaTiket = {3400000, 2000000, 5400000, 4300000, 1700000};
        return hargaTiket[nomorTujuan - 1];
    }

    private static String getInfotujuan(int nomorTujuan) {
        String[] infotujuan = {"JAKARTA/08:00", "JAKARTA/09:00", "JAKARTA/12:00", "JAKARTA/16:00", "JAKARTA/16:50"};
        return infotujuan[nomorTujuan - 1];
    }

    private static String getInfoAkhir(int nomorTujuan) {
        String[] infoAkhir = {"TOKYO/14:20", "HARUJUKU/15:00", "KYOTO/17:30", "OSAKA/22:00", "SAPPORO/23:40"};
        return infoAkhir[nomorTujuan - 1];
    }

}
