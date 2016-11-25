package id.sch.smktelkom_mlg.project.xirpl109182736.amigo;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl109182736.amigo.adapter.CakeAdapter;
import id.sch.smktelkom_mlg.project.xirpl109182736.amigo.model.Cake;

public class MainActivityCake extends AppCompatActivity {
    ArrayList<Cake> mlist = new ArrayList<>();
    CakeAdapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cake);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewCake);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        madapter = new CakeAdapter(mlist);
        recyclerView.setAdapter(madapter);

        fillData();
    }

    private void fillData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.cake);
        String[] arDeskripsi = resources.getStringArray(R.array.desc_cake);
        TypedArray a = resources.obtainTypedArray(R.array.picture_cake);
        Drawable[] arFoto = new Drawable[a.length()];
        for (int i = 0; i < arFoto.length; i++) {
            arFoto[i] = a.getDrawable(i);
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++) {
            mlist.add(new Cake(arJudul[i], arDeskripsi[i], arFoto[i]));
        }
        madapter.notifyDataSetChanged();
    }
}
