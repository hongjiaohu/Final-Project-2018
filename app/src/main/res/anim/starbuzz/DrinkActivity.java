package comhongjiaohu.httpsgithub.starbuzz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKNO = "drinkno";

    private ImageView dDrinkPhoto;
    private TextView dDrinkName;
    private TextView dDrinkDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        int drinkNo = (Integer) getIntent().getExtras().get(EXTRA_DRINKNO);

        comhongjiaohu.httpsgithub.starbuzz.Drink drink = comhongjiaohu.httpsgithub.starbuzz.Drink.drinks[drinkNo];

        dDrinkPhoto = (ImageView)findViewById(R.id.iv_drink);
        dDrinkName = (TextView)findViewById(R.id.tv_name);
        dDrinkDescription = (TextView)findViewById(R.id.tv_description);

        dDrinkPhoto.setImageResource(drink.getImageResourceId() );
        dDrinkPhoto.setContentDescription(drink.getName() );

        dDrinkName.setText( drink.getName());

        dDrinkDescription.setText( drink.getDescription() );

    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }
}
