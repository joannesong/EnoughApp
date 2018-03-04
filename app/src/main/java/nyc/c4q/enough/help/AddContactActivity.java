package nyc.c4q.enough.help;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import nyc.c4q.enough.R;
import nyc.c4q.enough.data.ContactsDBHelper;
import nyc.c4q.enough.model.Contact;

public class AddContactActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText;
    private EditText phoneEditText;
    private ContactsDBHelper contactsDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nameEditText = findViewById(R.id.input_contact_name);
        phoneEditText = findViewById(R.id.input_contact_phone_number);
        Button saveButton = findViewById(R.id.add_contact_button);
        contactsDBHelper = ContactsDBHelper.getDbInstance(this);
        saveButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int ID = v.getId();
        switch (ID) {

            case R.id.add_contact_button:
                String name = nameEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                phone = phone.replace("-", "");
                if (!name.equals("") && !phone.equals("")) {
                    Contact contact = new Contact();
                    contact.setContactName(name);
                    contact.setContactNumber(phone);
                    contactsDBHelper.addContact(contact);
                    Toast.makeText(this, contact.getContactName() + " was added", Toast.LENGTH_SHORT).show();
                    this.finish();
                }
                break;
        }
    }
}
