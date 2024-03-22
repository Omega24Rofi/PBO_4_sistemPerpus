import java.util.ArrayList;

public class Buku {
    int stok = 0;
    String Judul;
    String Penulis;
    boolean status = true;
    int lamaPinjam = 0;
    ArrayList<ArrayList<Object>> peminjam = new ArrayList<ArrayList<Object>>();

    // method untuk membuat buku baru
    public Buku(String Judul, String Penulis, int stok){
        this.Judul = Judul;
        this.Penulis = Penulis;
        this.stok = stok;
    }
    // method untuk meminjam buku
    public void isPinjam(User Pustakawan, String Pengunjung, int lamaPinjam){
        if(!this.status){
            System.out.println("Buku sedang dipinjam");
        } else{
            boolean sudahDipinjam = false;
            for(int i = 0; i < this.peminjam.size(); i++){
                if(this.peminjam.get(i).get(1).equals("Pengunjung")){
                    sudahDipinjam = true;
                }
            }
            if(sudahDipinjam){
                System.out.println("Anda sudah meminjam buku ini");
            } else{
                ArrayList<Object> dataPeminjam = new ArrayList<Object>();
                dataPeminjam.add(Pustakawan);
                dataPeminjam.add(Pengunjung);
                dataPeminjam.add(lamaPinjam);
                peminjam.add(dataPeminjam);
            }
            int stokSaatini = this.stok - this.peminjam.size();
            this.stok = this.stok - 1;
            System.out.println("Buku berhasil dipinjam");
            System.out.println("Stok Buku " + Judul + " tersisa : " + stokSaatini);
        }
    }
}
