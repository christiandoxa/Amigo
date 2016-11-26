package id.sch.smktelkom_mlg.project.xirpl109182736.amigo;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl109182736.amigo.adapter.DrinkAdapter;
import id.sch.smktelkom_mlg.project.xirpl109182736.amigo.model.Drink;

public class MainActivityDrink extends AppCompatActivity implements DrinkAdapter.IDrinkAdapter {


    public static final String DRINK = "drink";
    ArrayList<Drink> mlist = new ArrayList<>();
    DrinkAdapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drink);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewDrink);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        madapter = new DrinkAdapter(this, mlist);
        recyclerView.setAdapter(madapter);

        fillData();

        setTitle("Drink");
    }

    private void fillData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.drink);
        String[] arDeskripsi = resources.getStringArray(R.array.desc_drink);
        String[] arCara = resources.getStringArray(R.array.cara_drink);
        String[] arBahan = resources.getStringArray(R.array.bahan_drink);
        TypedArray a = resources.obtainTypedArray(R.array.picture_drink);
        String[] arFoto = new String[a.length()];
        for (int i = 0; i < arFoto.length; i++) {
            int id = a.getResourceId(i, 0);
            arFoto[i] = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + resources.getResourcePackageName(id) + '/'
                    + resources.getResourceTypeName(id) + '/'
                    + resources.getResourceEntryName(id);
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++) {
            mlist.add(new Drink(arJudul[i], arDeskripsi[i], arBahan[i], arCara[i], arFoto[i]));
        }
        madapter.notifyDataSetChanged();
    }

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this, DetailActivityDrink.class);
        intent.putExtra(DRINK, mlist.get(pos));
        startActivity(intent);
    }
}
