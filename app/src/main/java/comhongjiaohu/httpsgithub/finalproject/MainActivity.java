/**
 * Name:Hongjiao Hu
 * Course:CS40S
 * Teacher:Mr.Hardman
 * Lab #final,Program# 1
 * Date Last Modified: 6/15/2018
 */
package comhongjiaohu.httpsgithub.finalproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView mOptionsList;

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
        setContentView(R.layout.activity_main);

        mOptionsList = (ListView) findViewById(R.id.lv_option);

        String[] options = new String[]{"Preorder", "Food", "Stores", "Share Your Experience", "Recursion game"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                Intent foodIntent = new Intent(MainActivity.this, FoodCategoryActivity.class);

                Intent mapsIntent;
                Intent ShareIntent;

                Intent chooser;

                Uri mapsIntentUri = Uri.parse("geo:49.8998, -97.1375?z=10&q=" + Uri.encode("small_noodles") );

                Intent recursion = new Intent(MainActivity.this, Recursion.class);

                Intent contackBook = new Intent(MainActivity.this, ContactbookActivity.class);

                if( position == 0 )
                {
                    startActivity(contackBook);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                }
                else if ( position == 1 )
                {
                    startActivity(foodIntent);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                }
                else if( position == 2 )
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

                    ShareIntent.putExtra( Intent.EXTRA_TEXT, "I want to say this about small_noodles: \n" );
                    ShareIntent.putExtra( Intent.EXTRA_EMAIL, "info@chongqing_small_noodles.com");

                    chooser = Intent.createChooser( ShareIntent, "Please select an app..." );

                    startActivity(chooser);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left );
                }
                else if( position == 4)
                {
                    startActivity(recursion);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                }

            }

        };
        mOptionsList.setAdapter(arrayAdapter);
        mOptionsList.setOnItemClickListener(itemClickListener);
    }

}