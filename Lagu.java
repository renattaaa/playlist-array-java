class Lagu {

    private String judul;
    private String artis;
    private double durasi;

    public Lagu(String judul, String artis, double durasi) {
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }

    public String getJudul() {
        return judul;
    }

    public String getArtis() {
        return artis;
    }

    public double getDurasi() {
        return durasi;
    }

    /*
    Menampilkan informasi lagu
    Digunakan saat traversal / searching
    */
    public void tampilkanInfo() {
        System.out.println(judul + " - " + artis + " (" + durasi + " menit)");
    }
}