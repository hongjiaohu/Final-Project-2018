package comhongjiaohu.httpsgithub.finalproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by h.hu on 5/25/2018.
 */

public class FoodActivity extends AppCompatActivity {

    public static final String EXTRA_FOODNO = "foodno";

    private ImageView fFoodPhoto;
    private TextView fFoodName;
    private TextView fFoodDescription;

    @Override
    /**
     * onCreate is the method that is executed when the Activity is created
     *
     * @param savedInstanceState is a Bundle of data use to restore
     *                           the Activity from a previous instance
     * @return "" Nothing is returned
     */
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        int foodNo = (int)getIntent().getExtras().get(EXTRA_FOODNO);

        Food food = Food.foods[foodNo];

        fFoodPhoto = (ImageView)findViewById(R.id.iv_food);
        fFoodName = (TextView)findViewById(R.id.tv_name);
        fFoodDescription = (TextView)findViewById(R.id.tv_description);

        fFoodPhoto.setImageResource(food.getImageResourceId() );
        fFoodPhoto.setContentDescription(food.getName() );

        fFoodName.setText( food.getName());

        fFoodDescription.setText( food.getDescription() );
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
