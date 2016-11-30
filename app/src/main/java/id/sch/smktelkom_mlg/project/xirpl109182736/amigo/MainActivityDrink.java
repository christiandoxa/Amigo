package id.sch.smktelkom_mlg.project.xirpl109182736.amigo;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl109182736.amigo.adapter.DrinkAdapter;
import id.sch.smktelkom_mlg.project.xirpl109182736.amigo.model.Drink;

public class MainActivityDrink extends AppCompatActivity implements DrinkAdapter.IDrinkAdapter {


    public static final String DRINK = "drink";
    ArrayList<Drink> mlist = new ArrayList<>();
    DrinkAdapter madapter;

    ArrayList<Drink> mListAll = new ArrayList<>();
    boolean isFiltered;
    ArrayList<Integer> mListMapFilter = new ArrayList<>();
    String mQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drink);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        String[] arBahan = resources.getStringArray(R.array.bahan_drink);
        String[] arCara = resources.getStringArray(R.array.cara_drink);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView serView = (SearchView)
                MenuItemCompat.getActionView(searchItem);

        serView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        mQuery = newText.toLowerCase();
                        doFilter(mQuery);
                        return true;
                    }
                }
        );
        return true;
    }

    private void doFilter(String query) {
        if (!isFiltered) {
            mListAll.clear();
            mListAll.addAll(mlist);
            isFiltered = true;
        }

        mlist.clear();
        if (query == null || query.isEmpty()) {
            mlist.addAll(mListAll);
            isFiltered = false;
        } else {
            mListMapFilter.clear();
            for (int i = 0; i < mListAll.size(); i++) {
                Drink drink = mListAll.get(i);
                if (drink.judul.toLowerCase().contains(query) ||
                        drink.deskripsi.toLowerCase().contains(query) ||
                        drink.cara.toLowerCase().contains(query)) {
                    mlist.add(drink);
                    mListMapFilter.add(i);
                }
            }
        }
        madapter.notifyDataSetChanged();
    }

}
