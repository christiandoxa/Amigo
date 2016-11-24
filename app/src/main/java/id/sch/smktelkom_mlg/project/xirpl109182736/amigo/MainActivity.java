package id.sch.smktelkom_mlg.project.xirpl109182736.amigo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton food, drink, cake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        food = (ImageButton) findViewById(R.id.ImageButtonFood);
        drink = (ImageButton) findViewById(R.id.ImageButtonDrink);
        cake = (ImageButton) findViewById(R.id.ImageButtonCake);

        View.OnClickListener listenerfood = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivityFood.class));
                Toast.makeText(MainActivity.this,
                        "Food telah dipilih",
                        Toast.LENGTH_SHORT).show();
            }
        };
        food.setOnClickListener(listenerfood);

        View.OnClickListener listenerdrink = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivityDrink.class));
                Toast.makeText(MainActivity.this,
                        "Drink telah dipilih",
                        Toast.LENGTH_SHORT).show();
            }
        };
        drink.setOnClickListener(listenerdrink);

        View.OnClickListener listenercake = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivityCake.class));
                Toast.makeText(MainActivity.this,
                        "Cake telah terpilih",
                        Toast.LENGTH_SHORT).show();
            }
        };
        cake.setOnClickListener(listenercake);
    }
}
