package nyc.c4q.enough.education;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import nyc.c4q.enough.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GetEducatedFragment extends Fragment implements View.OnClickListener{
    ImageView cardView;
    ImageView cardView2;
    ImageView cardView3;
    ImageView cardView4;


    public GetEducatedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_get_educated, container, false);

        //cardView.getRootView().findViewById(R.id.card1);
        cardView = rootView.findViewById(R.id.one);
        cardView2 = rootView.findViewById(R.id.two);
        cardView3 = rootView.findViewById(R.id.three);
        cardView4 = rootView.findViewById(R.id.four);

        cardView.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
        cardView4.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.one:
                Uri uri = Uri.parse("http://www.thehotline.org/is-this-abuse/abuse-defined/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

                break;

            case R.id.two:
                Uri uri2 = Uri.parse("https://www.drphil.com/pages/rhpt/"); // missing 'http://' will cause crashed
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                startActivity(intent2);

                break;

            case R.id.three:
                Uri uri3 = Uri.parse("https://www.helpguide.org/articles/abuse/domestic-violence-and-abuse.htm"); // missing 'http://' will cause crashed
                Intent intent3 = new Intent(Intent.ACTION_VIEW, uri3);
                startActivity(intent3);

                break;

            case R.id.four:
                Uri ur4 = Uri.parse("https://www.drphil.com/advice/an-exit-action-plan-guidelines-for-leaving-an-abusive-relationship/"); // missing 'http://' will cause crashed
                Intent intent4 = new Intent(Intent.ACTION_VIEW, ur4);
                startActivity(intent4);

                break;

        }

    }
}