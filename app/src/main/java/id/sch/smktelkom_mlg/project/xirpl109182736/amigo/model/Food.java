package id.sch.smktelkom_mlg.project.xirpl109182736.amigo.model;

import java.io.Serializable;

/**
 * Created by Qoriatul Masfufah on 11/25/2016.
 */

public class Food implements Serializable {
    public String judul;
    public String deskripsi;
    public String bahan;
    public String cara;
    public String foto;

    public Food(String judul, String deskripsi, String cara, String bahan, String foto) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.bahan = bahan;
        this.cara = cara;
        this.foto = foto;
    }

}
