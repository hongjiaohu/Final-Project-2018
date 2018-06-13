package comhongjiaohu.httpsgithub.finalproject;

import android.widget.ProgressBar;

/**
 * Created by h.hu on 6/4/2018.
 */

public class Contact
{
    private String name;
    private String phone;
    private String e_mail;

    /**
     * Contact sets class-level variables name, phone, and email to be empty strings
     *
     * @param "" There are no parameters
     * @return Nothing is returned
     */
    private Contact()
    {
        name = "";
        phone = "";
        e_mail = "";
    }

    /**
     * Contact sets class-level variables name, phone, and email to their corresponding parameters
     *
     * @param nameInput is the input of name
     * @param phoneInput is the input of phone
     * @param emailInput is the input of email
     * @return Nothing is returned
     */
    Contact(String nameInput, String phoneInput, String emailInput)
    {
        name = nameInput;
        phone = phoneInput;
        e_mail = emailInput;
    }

    /**
     * getName is the method used to get the name of a contact
     *
     * @param "" There are no parameters
     * @return a string of contacts' names
     */
    public String getName(){return name;}

    /**
     * getName is the method used to get the name of a contact
     *
     * @param "" There are no parameters
     * @return a string of contacts' names
     */
    public String getPhone(){return phone;}

    /**
     * getName is the method used to get the email of a contact
     *
     * @param "" There are no parameters
     * @return a string of contacts' emails
     */
    public String getEmail(){return e_mail;}
}
