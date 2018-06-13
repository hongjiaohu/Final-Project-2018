package comhongjiaohu.httpsgithub.starbuzz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends AppCompatActivity {

    private ListView cDrinksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_catayour);

        cDrinksList = (ListView)findViewById(R.id.lv_drinks);

        ArrayAdapter<comhongjiaohu.httpsgithub.starbuzz.Drink> arrayAdapter = new ArrayAdapter<comhongjiaohu.httpsgithub.starbuzz.Drink>(this, android.R.layout.simple_list_item_1, comhongjiaohu.httpsgithub.starbuzz.Drink.drinks);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                Intent drinkIntent = new Intent( comhongjiaohu.httpsgithub.starbuzz.DrinkCategoryActivity.this, comhongjiaohu.httpsgithub.starbuzz.DrinkActivity.class);

                drinkIntent.putExtra( comhongjiaohu.httpsgithub.starbuzz.DrinkActivity.EXTRA_DRINKNO, position );

                startActivity( drinkIntent );
                overridePendingTransition( R.anim.slide_in_left,R.anim.slide_out_left );
            }
        };

        cDrinksList.setAdapter(arrayAdapter);
        cDrinksList.setOnItemClickListener( itemClickListener );


    }

    @Override
    public void onBackPressed()
    {
        //This line lets this method do everything that the back button is supposed do
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }
}
