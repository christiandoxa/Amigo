package id.sch.smktelkom_mlg.project.xirpl109182736.amigo;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl109182736.amigo.adapter.FoodAdapter;
import id.sch.smktelkom_mlg.project.xirpl109182736.amigo.model.Food;

public class MainActivityFood extends AppCompatActivity {
    ArrayList<Food> mlist = new ArrayList<>();
    FoodAdapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_food);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewFood);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        madapter = new FoodAdapter(mlist);
        recyclerView.setAdapter(madapter);

        fillData();

        setTitle("Food");
    }

    private void fillData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.food);
        String[] arDeskripsi = resources.getStringArray(R.array.desc_food);
        TypedArray a = resources.obtainTypedArray(R.array.picture_food);
        Drawable[] arFoto = new Drawable[a.length()];
        for (int i = 0; i < arFoto.length; i++) {
            arFoto[i] = a.getDrawable(i);
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++) {
            mlist.add(new Food(arJudul[i], arDeskripsi[i], arFoto[i]));
        }
        madapter.notifyDataSetChanged();
    }
}
