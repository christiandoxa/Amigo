package id.sch.smktelkom_mlg.project.xirpl109182736.amigo.model;

import java.io.Serializable;

/**
 * Created by MANNAR on 25/11/2016.
 */

public class Cake implements Serializable {
    public String judul;
    public String deskripsi;
    public String bahan;
    public String cara;
    public String foto;

    public Cake(String judul, String deskripsi, String bahan, String cara, String foto) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.bahan = bahan;
        this.cara = cara;
        this.foto = foto;
    }
}
