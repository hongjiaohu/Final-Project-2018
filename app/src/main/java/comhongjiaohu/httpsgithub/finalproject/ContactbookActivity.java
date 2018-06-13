package comhongjiaohu.httpsgithub.finalproject;

import android.content.Context;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class ContactbookActivity extends AppCompatActivity {

    private static Contact[] contactsArray;
    private static int numContactsAdded;
    private EditText mNameInput;
    private EditText mPhoneInput;
    private EditText mEmailInput;
    private TextView mErrorMessage;
    private TextView mSortedList;

    String name;
    String phone;
    String e_mail;

    private int quickSteps = 0;

    @Override
    /**
     * onCreate is the method that is run when we create an instance of this activity
     *
     * @param savedInstanceState is a Bundle object that allows the Activity to restore
     *                           itself to a previously saved instance
     * @return Nothing is returned
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactbook);

        mNameInput = (EditText) findViewById(R.id.et_name);
        mPhoneInput = (EditText) findViewById(R.id.et_phone);
        mEmailInput = (EditText) findViewById(R.id.et_e_mail);
        mErrorMessage = (TextView) findViewById(R.id.tv_error_message);
        mSortedList = (TextView) findViewById(R.id.tv_sorted_lists);

        contactsArray = new Contact[50];
        numContactsAdded = 0;

    }

    /**
     * addContact adds a new contact to the array of contacts we will need to sort
     *
     * @param vw is the View that is related to this method
     * @return Nothing is returned
     */
    public void addTheContact (View vw)
    {
        InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        Contact userInput;

        if (mNameInput.getText().toString() == "")
        {
            mErrorMessage.setText("You must enter at least a name to add a contact");
        }
        else
        {
            if (numContactsAdded >= contactsArray.length)
            {
                mErrorMessage.setText("You cannot add any more contacts to this contact book.");
            }
            else
            {
                name = mNameInput.getText().toString();
                phone = mPhoneInput.getText().toString();
                e_mail = mEmailInput.getText().toString();

                userInput = new Contact(name, phone, e_mail);
                contactsArray[numContactsAdded] = userInput;
                numContactsAdded += 1;

                mNameInput.setText("");
                mPhoneInput.setText("");
                mEmailInput.setText("");

                if (inputManager != null) {
                    inputManager.hideSoftInputFromWindow(vw.getApplicationWindowToken(), 0);
                }
                mErrorMessage.setText("Contact added successfully");
            }
        }
    }

    /**
     * sortContacts sorts the contacts that the user entered and displays them in order of their names
     *
     * @param vw is the View that is related to this method
     * @return Nothing is returned
     */
    public void sortContacts(View vw)
    {
        String storeList = "";

        quickSteps( contactsArray, 0, numContactsAdded - 1);

        for( int i = 0; i < numContactsAdded; i++ )
        {
            if( contactsArray != null)
            {
                storeList += String.format("Name: %15s\nPhone: %15s\nE-mail: %15s\n\n", contactsArray[i].getName(), contactsArray[i].getPhone(), contactsArray[i].getEmail() );
            }
        }

        mErrorMessage.setText("");
        mSortedList.setText(storeList);
    }

    /**
     * quickSort uses the Quick Sort algorithm to sort a list of contacts in an ascending order of their names
     *
     * @param low is the beginning index of the section of the array we would like to sort
     * @param high is the ending index of the section of the array we would like to sort
     * @return Nothing is returned
     */
    private void quickSteps(Contact[] contactsArray, int low, int high)
    {
        int middle;
        int i;
        int j;

        Contact pivot;
        Contact toSwap;

        if (low < high) {
            middle = low + (high - low) / 2;
            pivot = contactsArray[middle];

            i = low;
            j = high;

            while (i <= j) {
                while ((contactsArray[i].toString()).compareTo(pivot.toString()) < 0) {
                    i++;
                }

                while ((contactsArray[i].toString()).compareTo(pivot.toString()) > 0) {
                    j--;
                }

                if (i <= j) {
                    toSwap = contactsArray[i];
                    contactsArray[i] = contactsArray[j];
                    contactsArray[j] = toSwap;
                    i++;
                    j++;
                }
            }

            if (low < j) {
                quickSteps(contactsArray, low, j);
            }

            if (high > i) {
                quickSteps(contactsArray, i, high);
            }
        }
    }
}









