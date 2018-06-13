package comhongjiaohu.httpsgithub.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Food
{
    private String name;
    private String description;
    private int imageResourceId;

    public static final Food[] foods = {
            new Food("Asain_Zucchini_Noodle", "egg, zucchini, and noodles. A great start for the morning!", R.drawable.asain_zucchini_noodle),
            new Food("Chicken_Noodles", "chicken with noodles, fast and delicious.", R.drawable.chicken_noodles),
            new Food("Red_Curry_Noodles_Soup", "red curry soup with noodles, a good soup to solve you from the heavy work.", R.drawable.red_curry_noodle_soup)
    };

    /**
     * Food is the constructor for objects of type food that stores
     * a name, a description, and an image resource ID for each Food
     *
     * @param foodName is the name of the Food
     * @param foodDescription is the description of the Food
     * @param foodImageResourceId is the image resource ID for the Food
     * @return an object of class Food
     */
    private Food( String foodName, String foodDescription, int foodImageResourceId)
    {
        name = foodName;
        description = foodDescription;
        imageResourceId = foodImageResourceId;
    }

    /**
     * getName returns the name of the food
     *
     * @param "" There are no parameters
     * @return a String representing the name of the food
     */
    public String getName()
    {
        return name;
    }

    /**
     * description returns the description of the food
     *
     * @param "" There are no parameters
     * @return a String representing the description of the food
     *
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * getImageResourceId return the image resource ID of the food
     *
     * @param "" There are no parameters
     * @return an int representing the image resource ID of the food
     */
    public int getImageResourceId()
    {
        return imageResourceId;
    }

    /**
     * toString return a String representation of the data held inside the Food class
     *
     * @param "" There are no parameters
     * @return a String representing the data with each food
     */
    public String toString()
    {
        return this.name;
    }
}
