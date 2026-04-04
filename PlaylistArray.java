import java.util.Scanner;

public class PlaylistArray {

    // ATTRIBUTES 
    private Lagu[] daftarLagu = new Lagu[10];
    private int size = 0;
    private Scanner input = new Scanner(System.in);

    // INSERTION METHOD 
    // Method to add a new song into the array
    public void tambahLagu() {

        // Check if array is full
        if (size == daftarLagu.length) {
            System.out.println("Playlist is full! Maximum 10 songs.");
            return;
        }

        // Input from user
        System.out.print("Enter song title: ");
        String judul = input.nextLine();

        System.out.print("Enter artist name: ");
        String artis = input.nextLine();

        System.out.print("Enter duration (minutes): ");
        double durasi = input.nextDouble();
        input.nextLine(); // clear buffer

        // Insert data into array
        daftarLagu[size] = new Lagu(judul, artis, durasi);

        // Increase size
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
}
