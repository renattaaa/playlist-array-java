import java.util.Scanner;

public class PlaylistArray {

    // ATTRIBUTES 
    private Lagu[] daftarLagu = new Lagu[10];
    private int size = 0;
    private Scanner input = new Scanner(System.in);

    // INSERTION METHOD 
    public void tambahLagu() {

        if (size == daftarLagu.length) {
            System.out.println("Playlist is full! Maximum 10 songs.");
            return;
        }

        System.out.print("Enter song title: ");
        String judul = input.nextLine();

        System.out.print("Enter artist name: ");
        String artis = input.nextLine();

        System.out.print("Enter duration (minutes): ");
        double durasi = input.nextDouble();
        input.nextLine();

        daftarLagu[size] = new Lagu(judul, artis, durasi);
        size++;

        System.out.println("Song added successfully!");
    }

    public void tampilkanSemuaLagu() {

        if (size == 0) {
            System.out.println("Playlist kosong!");
            return;
        }

        System.out.println("\n=== DAFTAR LAGU ===");

        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + ". ");
            daftarLagu[i].tampilkanInfo();
        }
    }

    //DELETION METHOD 
    public void hapusLagu() {

        if (size == 0) {
            System.out.println("Playlist kosong, tidak ada lagu yang bisa dihapus.");
            return;
        }

        System.out.print("Masukkan judul lagu yang ingin dihapus: ");
        String judulHapus = input.nextLine();

        boolean ditemukan = false;

        for (int i = 0; i < size; i++) {
            if (daftarLagu[i].getJudul().equalsIgnoreCase(judulHapus)) {

                for (int j = i; j < size - 1; j++) {
                    daftarLagu[j] = daftarLagu[j + 1];
                }

                daftarLagu[size - 1] = null;
                size--;

                System.out.println("Lagu berhasil dihapus!");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Lagu tidak ditemukan di playlist.");
        }
    }
}
