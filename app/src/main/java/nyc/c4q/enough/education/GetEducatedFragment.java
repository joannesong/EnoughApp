package nyc.c4q.enough.education;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.enough.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GetEducatedFragment extends Fragment implements View.OnClickListener{
    CardView cardView;
    CardView cardView2;
    CardView cardView3;
    CardView cardView4;


    public GetEducatedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_get_educated, container, false);

        //cardView.getRootView().findViewById(R.id.card1);
        cardView = rootView.findViewById(R.id.card1);
        cardView2 = rootView.findViewById(R.id.card2);
        cardView3 = rootView.findViewById(R.id.card3);
        cardView4 = rootView.findViewById(R.id.card4);

        cardView.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
        cardView4.setOnClickListener(this);

        return rootView;
    }

   /* public void someMethod(View view) {


        switch (view.getId()) {
            case R.id.firstlink_holder:
                Uri uri = Uri.parse("http://www.google.com"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

                break;

            case R.id.secondlink_holder:
                Uri uri2 = Uri.parse("http://www.google.com"); // missing 'http://' will cause crashed
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                startActivity(intent2);

                break;

            case R.id.thirdlink_holder:
                Uri uri3 = Uri.parse("http://www.google.com"); // missing 'http://' will cause crashed
                Intent intent3 = new Intent(Intent.ACTION_VIEW, uri3);
                startActivity(intent3);

                break;

            case R.id.fourthlink_holder:
                Uri ur4 = Uri.parse("http://www.google.com"); // missing 'http://' will cause crashed
                Intent intent4 = new Intent(Intent.ACTION_VIEW, ur4);
                startActivity(intent4);

                break;

        }
*/


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.card1:
                Uri uri = Uri.parse("http://http://www.loveisrespect.org/for-someone-else/is-my-relationship-healthy-quiz/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

                break;

            case R.id.card2:
                Uri uri2 = Uri.parse("http://http://www.loveisrespect.org/healthy-relationships/"); // missing 'http://' will cause crashed
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                startActivity(intent2);

                break;

            case R.id.card3:
                Uri uri3 = Uri.parse("http://ncdsv.org/ncd_linkshotlines.html"); // missing 'http://' will cause crashed
                Intent intent3 = new Intent(Intent.ACTION_VIEW, uri3);
                startActivity(intent3);

                break;

            case R.id.card4:
                Uri ur4 = Uri.parse("https://www.drphil.com/advice/an-exit-action-plan-guidelines-for-leaving-an-abusive-relationship/"); // missing 'http://' will cause crashed
                Intent intent4 = new Intent(Intent.ACTION_VIEW, ur4);
                startActivity(intent4);

                break;

        }

    }
}