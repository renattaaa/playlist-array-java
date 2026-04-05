/*
 * ============================================================
 *  Tugas Kelompok 2 - Week 4: Arrays and Its Operations
 *  Mata Kuliah: Data Structures and Algorithm Analysis
 * 
 *  Anggota Kelompok:
 *  1. DAFFA FATHUR RAHMAN - 2902692586 - Searching
 *  2. HENDRIKUS AVERO WIDARTO - 2902734664 - Insertion
 *  3. DUSTIN BALLQIS SAPUTRA - 2902730445 - Traversal
 *  4. RENATA RAMADHANYANDRA - 2902696426 - Main Program + Sorting + Class Lagu
 *  5. NAZIF ALFARIZI - 2902726914 - Deletion
 * ============================================================
 */

import java.util.Scanner;

public class PlaylistArray {

    // -------------------------------------------------------
    // ATRIBUT
    // Array statis dengan kapasitas maksimum 10 lagu.
    // 'size' melacak jumlah lagu yang saat ini tersimpan.
    // -------------------------------------------------------
    private Lagu[] playlist = new Lagu[10];
    private int size = 0;
    private Scanner input = new Scanner(System.in).useLocale(java.util.Locale.US);

    // -------------------------------------------------------
    // INSERTION — Kompleksitas Waktu: O(1)
    //
    // Penjelasan:
    // Penambahan lagu selalu dilakukan di posisi akhir array
    // (indeks 'size'). Tidak ada perulangan yang bergantung
    // pada jumlah data, sehingga waktu eksekusi konstan
    // terlepas dari berapa banyak lagu yang sudah ada.
    // -------------------------------------------------------
    public void tambahLagu() {
        if (size == playlist.length) {
            System.out.println("Playlist penuh! Maksimal 10 lagu.");
            return;
        }

        System.out.print("Masukkan judul lagu  : ");
        String judul = input.nextLine();

        System.out.print("Masukkan artis       : ");
        String artis = input.nextLine();

        System.out.print("Masukkan durasi (menit): ");
        double durasi = input.nextDouble();
        input.nextLine();

        playlist[size] = new Lagu(judul, artis, durasi);
        size++;

        System.out.println("Lagu berhasil ditambahkan!");

        System.out.println("\nDaftar lagu saat ini:");
        tampilkanSemuaLagu();
    }

    // -------------------------------------------------------
    // TRAVERSAL — Kompleksitas Waktu: O(n)
    //
    // Penjelasan:
    // Program mengunjungi setiap elemen array satu per satu
    // dari indeks 0 hingga size-1. Jika ada n lagu, loop
    // berjalan sebanyak n kali, sehingga kompleksitasnya
    // berbanding lurus dengan jumlah data → O(n).
    // -------------------------------------------------------
    public void tampilkanSemuaLagu() {

        if (size == 0) {
            System.out.println("Playlist kosong!");
            return;
        }

        System.out.println("\n=== DAFTAR LAGU ===");

        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + ". ");
            playlist[i].tampilkanInfo();
        }
    }

    // -------------------------------------------------------
    // SEARCHING — Kompleksitas Waktu: O(n)
    //
    // Penjelasan:
    // Menggunakan Linear Search: program memeriksa setiap
    // elemen dari indeks 0 ke kanan satu per satu sampai
    // menemukan lagu yang cocok atau mencapai akhir array.
    // Pada kasus terburuk (lagu tidak ada atau berada di
    // akhir), semua n elemen diperiksa → O(n).
    // -------------------------------------------------------
    public void cariLagu() {

        if (size == 0) {
            System.out.println("Playlist masih kosong, tidak ada yang bisa dicari.");
            return;
        }

        System.out.print("Masukkan judul lagu yang dicari: ");
        String cari = input.nextLine();
        boolean ditemukan = false;

        for (int i = 0; i < size; i++) {
            // Pakai equalsIgnoreCase biar gak sensitif sama huruf kapital/kecil
            if (playlist[i].getJudul().equalsIgnoreCase(cari)) {
                System.out.println("\nLagu ditemukan!");
                playlist[i].tampilkanInfo();
                ditemukan = true;
                break; // Stop loop kalau udah ketemu
            }
        }

        if (!ditemukan) {
            System.out.println("Lagu '" + cari + "' tidak ada di playlist.");
        }
    }

    // -------------------------------------------------------
    // DELETION — Kompleksitas Waktu: O(n)
    //
    // Penjelasan:
    // Ada dua tahap yang masing-masing O(n):
    //   1. Pencarian posisi lagu yang akan dihapus (linear search)
    //   2. Pergeseran elemen setelah indeks penghapusan ke kiri
    //      agar array tetap rapat tanpa "lubang" kosong.
    // Pada kasus terburuk, keduanya menyentuh semua n elemen
    // → total tetap O(n).
    // -------------------------------------------------------
    public void hapusLagu() {

        if (size == 0) {
            System.out.println("Playlist kosong, tidak ada lagu yang bisa dihapus.");
            return;
        }

        System.out.print("Masukkan judul lagu yang ingin dihapus: ");
        String judulHapus = input.nextLine();

        boolean ditemukan = false;

        for (int i = 0; i < size; i++) {
            if (playlist[i].getJudul().equalsIgnoreCase(judulHapus)) {

                for (int j = i; j < size - 1; j++) {
                    playlist[j] = playlist[j + 1];
                }

                playlist[size - 1] = null;
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

    // -------------------------------------------------------
    // SORTING: Bubble Sort — Kompleksitas Waktu: O(n²)
    //
    // Penjelasan mengapa O(n²):
    // Bubble Sort menggunakan dua loop bersarang:
    //   - Loop luar berjalan sebanyak (n-1) kali (pass)
    //   - Loop dalam berjalan hingga (n-1-i) kali per pass
    // Total perbandingan ≈ (n-1) + (n-2) + ... + 1 = n(n-1)/2
    // Dalam notasi Big O, konstanta diabaikan → O(n²).
    //
    // Cara kerja:
    // Setiap pass membandingkan dua elemen berdekatan dan
    // menukarnya jika durasi kiri > durasi kanan, sehingga
    // elemen terbesar "menggelembung" ke posisi paling akhir.
    // -------------------------------------------------------
    public void urutkanLaguBerdasarkanDurasi() {

        if (size == 0) {
            System.out.println("Playlist kosong, tidak ada yang bisa diurutkan.");
            return;
        }

        System.out.println("\n--- Sebelum Diurutkan ---");
        tampilkanSemuaLagu();

        // Bubble Sort: bandingkan pasangan berdekatan, tukar jika perlu
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (playlist[j].getDurasi() > playlist[j + 1].getDurasi()) {
                    // Tukar posisi lagu[j] dan lagu[j+1]
                    Lagu temp = playlist[j];
                    playlist[j] = playlist[j + 1];
                    playlist[j + 1] = temp;
                }
            }
        }

        System.out.println("\n--- Setelah Diurutkan (Ascending) ---");
        tampilkanSemuaLagu();
    }

    // -------------------------------------------------------
    // MENU INTERAKTIF
    // Menampilkan menu pilihan dan mengarahkan ke fungsi
    // yang sesuai berdasarkan input pengguna.
    // Loop do-while memastikan menu tampil minimal sekali
    // dan terus berulang sampai user memilih "Keluar" (6).
    // -------------------------------------------------------
    public void jalankanMenu() {

        int pilihan;

        do {
            System.out.println("\n=== MENU PLAYLIST MUSIK ===");
            System.out.println("1. Tampilkan semua lagu");
            System.out.println("2. Tambah lagu baru");
            System.out.println("3. Hapus lagu berdasarkan judul");
            System.out.println("4. Cari lagu berdasarkan judul");
            System.out.println("5. Urutkan berdasarkan durasi");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tampilkanSemuaLagu();
                    break;
                case 2:
                    tambahLagu();
                    break;
                case 3:
                    hapusLagu();
                    break;
                case 4:
                    cariLagu();
                    break;
                case 5:
                    urutkanLaguBerdasarkanDurasi();
                    break;
                case 6:
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Masukkan angka 1-6.");
            }

        } while (pilihan != 6);
    }

    // -------------------------------------------------------
    // MAIN METHOD — Entry point program
    // -------------------------------------------------------
    public static void main(String[] args) {
        PlaylistArray app = new PlaylistArray();
        app.jalankanMenu();
    }
}
