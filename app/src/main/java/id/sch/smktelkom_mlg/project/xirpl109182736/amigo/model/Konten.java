package id.sch.smktelkom_mlg.project.xirpl109182736.amigo.model;

/**
 * Created by zhe on 03/12/2016.
 */

public class Konten {
    private String judul;
    private String deskripsi;
    private String bahan;
    private String cara;
    private String foto;

    public Konten() {
    }

    public Konten(String judul, String deskripsi, String bahan, String cara, String foto) {
        super();
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.bahan = bahan;
        this.cara = cara;
        this.foto = foto;
    }

    //getters and setters

    @Override
    public String toString() {
        return "Konten [judul=" + judul + ", deskripsi=" + deskripsi + ", bahan=" + bahan
                + ", cara=" + cara + ", foto=" + foto + "]";
    }
}
