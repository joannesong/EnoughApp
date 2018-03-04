package nyc.c4q.enough.help;


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
import android.widget.EditText;

import nyc.c4q.enough.NewsActivity;
import nyc.c4q.enough.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HelpFragment extends Fragment {
    private final static String TAG = "RESULTS";
    private RecyclerView contactsRecycler;
    private LinearLayoutManager linearLayoutManager;

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

        distressMessage = rootView.findViewById(R.id.distress_edit);
        message = distressMessage.getText().toString();

        sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("message", message);


        return rootView;
    }

}
