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

import id.sch.smktelkom_mlg.project.xirpl109182736.amigo.adapter.FoodAdapter;
import id.sch.smktelkom_mlg.project.xirpl109182736.amigo.model.Food;

public class MainActivityFood extends AppCompatActivity implements FoodAdapter.IFoodAdapter {


    public static final String FOOD = "food";
    ArrayList<Food> mlist = new ArrayList<>();
    FoodAdapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_food);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewFood);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        madapter = new FoodAdapter(this, mlist);
        recyclerView.setAdapter(madapter);

        fillData();

        setTitle("Food");
    }

    private void fillData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.food);
        String[] arDeskripsi = resources.getStringArray(R.array.desc_food);
        String[] arCara = resources.getStringArray(R.array.cara_food);
        String[] arBahan = resources.getStringArray(R.array.bahan_food);
        TypedArray a = resources.obtainTypedArray(R.array.picture_food);
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
            mlist.add(new Food(arJudul[i], arDeskripsi[i], arBahan[i], arCara[i], arFoto[i]));
        }
        madapter.notifyDataSetChanged();
    }

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(FOOD, mlist.get(pos));
        startActivity(intent);
    }
}
