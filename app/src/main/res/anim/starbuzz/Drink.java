package comhongjiaohu.httpsgithub.starbuzz;

/**
 * Created by h.hu on 5/3/2018.
 */

public class Drink
{
    private String name;
    private String description;
    private int imageResourceId;

    public static final comhongjiaohu.httpsgithub.starbuzz.Drink[] drinks = {
            new comhongjiaohu.httpsgithub.starbuzz.Drink("Latte", "A couple of espresso shots with steamed milk", R.drawable.latte),
            new comhongjiaohu.httpsgithub.starbuzz.Drink("cappuccino", "Espresso, hot milk, and steamed milk foam", R.drawable.cappuccino),
            new comhongjiaohu.httpsgithub.starbuzz.Drink("filter", "Highest quality beans roasted and brewed fresh", R.drawable.filter)
    };

    /**
     * Drink is the constructor for objects of type drink that stores
     * a name, a description, and an image resource ID for each Drink
     *
     * @param drinkName is the name of the drink
     * @param drinkDescription is the description of the drink
     * @param drinkImageResourceId is the image resource ID for the Drink
     * @return an object of class Drink
     */
    private Drink( String drinkName, String drinkDescription, int drinkImageResourceId)
    {
        name = drinkName;
        description = drinkDescription;
        imageResourceId = drinkImageResourceId;
    }

    /**
     * getName returns the name of the drink
     *
     * @param "" There are no parameters
     * @return a String representing the name of the drink
     */
    public String getName()
    {
        return name;
    }

    /**
     * description returns the description of the drink
     *
     * @param "" There are no parameters
     * @return a String representing the description of the drink
     *
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * getImageResourceId return the image resource ID of the Drink
     *
     * @param "" There are no parameters
     * @return an int representing the image resource ID of the Drink
     */
    public int getImageResourceId()
    {
        return imageResourceId;
    }

    /**
     * toString return a String representation of the data held inside the Drink class
     *
     * @param "" There are no parameters
     * @return a String representing the data with each Drink
     */
    public String toString()
    {
        return this.name;
    }
}
