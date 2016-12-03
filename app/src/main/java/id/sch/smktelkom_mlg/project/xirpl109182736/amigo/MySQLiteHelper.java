package id.sch.smktelkom_mlg.project.xirpl109182736.amigo;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zhe on 03/12/2016.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {
    // Versi Database
    private static final int DATABASE_VERSION = 1;
    // Nama Database
    private static final String DATABASE_NAME = "db_konten";

    public MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Query SQL untuk membuat tabel
        String CREATE_KONTEN_TABLE = "CREATE TABLE tb_konten ( " +
                "judul VARCHAR, " + "deskripsi VARCHAR, " + "bahan VARCHAR, " +
                "cara VARCHAR, " + "foto VARCHAR )";

        // Membuat tabel
        sqLiteDatabase.execSQL(CREATE_KONTEN_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versiLama, int versiBaru) {
        // Menghapus konten lama jika tabel telah ada
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST tb_konten");

        // Membuat tabel konten yang fresh
        this.onCreate(sqLiteDatabase);
    }
}