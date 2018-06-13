package comhongjiaohu.httpsgithub.starbuzz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeScreenActivity extends AppCompatActivity {

    private ListView hOptionsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        hOptionsList = (ListView)findViewById(R.id.lv_option);

        String[] options = new String[]{"Drinks","Food","Stores","Share Your Experience"};

        //To use an array as the options for a ListView, we need an ArrayAdapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                Intent drinksIntent = new Intent(comhongjiaohu.httpsgithub.starbuzz.HomeScreenActivity.this, DrinkCategoryActivity.class);

                Intent mapsIntent;
                Intent ShareIntent;

                Intent chooser;

                Uri mapsIntentUri = Uri.parse("geo:49.8998, -97.1375?z=10&q=" + Uri.encode("Second Cup") );

                if(position == 0 )
                {
                    startActivity( drinksIntent);
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_left);

                }
                else if(position == 2 )
                {
                    mapsIntent = new Intent(Intent.ACTION_VIEW, mapsIntentUri);

                    if(mapsIntent.resolveActivity(getPackageManager()) != null)
                    {
                        startActivity( mapsIntent );
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left );
                    }
                }
                else if(position == 3 )
                {
                    ShareIntent =new Intent(Intent.ACTION_SEND);

                    ShareIntent.setType("text/plain");

                    ShareIntent.putExtra( Intent.EXTRA_TEXT, "I want to this about Startbuzz: \n" );
                    ShareIntent.putExtra( Intent.EXTRA_EMAIL, "Starbuzz.com");

                    chooser = Intent.createChooser( ShareIntent, "Please select an app..." );

                    startActivity(chooser);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left );
                }
            }
        };

        hOptionsList.setAdapter(arrayAdapter);
        hOptionsList.setOnItemClickListener(itemClickListener);

    }
}
