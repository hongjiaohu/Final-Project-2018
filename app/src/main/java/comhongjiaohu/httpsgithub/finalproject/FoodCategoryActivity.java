package comhongjiaohu.httpsgithub.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FoodCategoryActivity extends AppCompatActivity {

    private ListView fFoodList;

    @Override
    /**
     * onCreate is the method that is executed when the Activity is created
     *
     * @param savedInstanceState is a Bundle of data use to restore
     *                           the Activity from a previous instance
     * @return "" Nothing is returned
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_category);

        fFoodList = (ListView)findViewById(R.id.lv_food1);

        ArrayAdapter<Food> arrayAdapter = new ArrayAdapter<Food>(this, android.R.layout.simple_list_item_1, Food.foods);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                Intent foodIntent = new Intent( FoodCategoryActivity.this, FoodActivity.class);

                foodIntent.putExtra( FoodActivity.EXTRA_FOODNO, position );

                startActivity( foodIntent );
                overridePendingTransition( R.anim.slide_in_left,R.anim.slide_out_left );
            }
        };
        fFoodList.setAdapter(arrayAdapter);
        fFoodList.setOnItemClickListener( itemClickListener );
    }

    @Override
    /**
     * onBackPressed is the method that is control the Activity shifts
     *
     * @param no parameters
     * @return "" Nothing is returned
     */
    public void onBackPressed()
    {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }
}
