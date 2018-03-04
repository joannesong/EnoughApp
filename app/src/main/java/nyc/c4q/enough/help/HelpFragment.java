package nyc.c4q.enough.help;


import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.enough.R;
import nyc.c4q.enough.controller.ContactsAdapter;
import nyc.c4q.enough.data.ContactsDBHelper;
import nyc.c4q.enough.model.Contact;

/**
 * A simple {@link Fragment} subclass.
 */
public class HelpFragment extends Fragment implements View.OnClickListener {

    private final static String TAG = "RESULTS";
    private RecyclerView contactsRecycler;
    private LinearLayoutManager linearLayoutManager;
    private ContactsAdapter contactsAdapter;
    private ContactsDBHelper contactsDBHelper;
    private Button button;
    private List<Contact> contactList = new ArrayList<>();

    private EditText distressMessage;
    private String message;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String SHARED_PREFS_KEY = "womenSP";


    public HelpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_help, container, false);
        contactsRecycler = rootView.findViewById(R.id.timeswire_recycler);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        contactsRecycler.setHasFixedSize(true);
        contactsRecycler.setLayoutManager(linearLayoutManager);
        contactsAdapter = new ContactsAdapter(contactList);
        contactsRecycler.setAdapter(contactsAdapter);
        button = rootView.findViewById(R.id.start_addContact_button);
        button.setOnClickListener(this);
        contactsDBHelper = ContactsDBHelper.getDbInstance(getActivity());
        getContactsListFromDB();
        distressMessage = rootView.findViewById(R.id.distress_edit);
        message = distressMessage.getText().toString();

        sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("message", message);
        editor.apply();

        return rootView;
    }

    private void getContactsListFromDB() {
        List<Contact> contacts = new ArrayList<>();
        contacts.addAll(contactsDBHelper.getContacts());
        if (!contacts.isEmpty()) {
            contactsAdapter = new ContactsAdapter(contacts);
            initRecycler();
        }
    }

    private void initRecycler() {
        contactsRecycler.setAdapter(contactsAdapter);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.start_addContact_button:
                Intent intent = new Intent(getActivity(), AddContactActivity.class);
                startActivity(intent);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getContactsListFromDB();
    }
}
