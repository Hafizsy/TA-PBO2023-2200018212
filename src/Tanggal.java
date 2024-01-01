import java.text.SimpleDateFormat;
import java.util.Date;

class Tanggal {

    static String getTanggal;
    java.util.Date date = new java.util.Date();

    void getTanggal() {
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yy");
        System.out.print(ft.format(date));
        System.out.println("");
    }

    void getWaktu() {
        SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss a");
        System.out.print(ft.format(date));
        System.out.println("");
    }
}
