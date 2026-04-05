    // Mencari lagu berdasarkan judul menggunakan Linear Search
    public void cariLagu() {
        if (size == 0) {
            System.out.println("Playlist masih kosong, gak ada yang bisa dicari.");
            return;
        }

        System.out.print("Masukkan judul lagu yang dicari: ");
        String cari = input.nextLine();
        boolean ditemukan = false;

        for (int i = 0; i < size; i++) {
            // Pakai equalsIgnoreCase biar gak sensitif sama huruf kapital/kecil
            if (daftarLagu[i].getJudul().equalsIgnoreCase(cari)) {
                System.out.println("\nLagu ketemu!");
                daftarLagu[i].tampilkanInfo();
                ditemukan = true;
                break; // Stop loop kalau udah ketemu
            }
        }

        if (!ditemukan) {
            System.out.println("lagu '" + cari + "' gak ada di playlist.");
        }
    }
