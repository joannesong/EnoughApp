package nyc.c4q.enough.holder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import nyc.c4q.enough.R;
import nyc.c4q.enough.model.WomenDataResults;

/**
 * Created by joannesong on 3/3/18.
 */

public class WomenHelpDataVH extends RecyclerView.ViewHolder {
    private TextView organizationName;
    private TextView organizationLink;
    private ImageButton organizationLocation;
    private LinearLayout callLayout;
    private Context context;


    public WomenHelpDataVH(View itemView) {
        super(itemView);
        context = itemView.getContext();
        organizationName = itemView.findViewById(R.id.organization_name);
        organizationLink = itemView.findViewById(R.id.organization_site);
        organizationLocation = itemView.findViewById(R.id.organization_location);
        callLayout = itemView.findViewById(R.id.press_call_layout);
    }


    public void onBind(final WomenDataResults womenDataResults) {

        organizationName.setText(womenDataResults.getOrganizationname());
        organizationLink.setText(womenDataResults.getUrl());

        organizationLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String yourLocationName = womenDataResults.getOrganizationname();
                String latitude = womenDataResults.getLatitude();
                String longitude = womenDataResults.getLongitude();
                String strUri = "http://maps.google.com/maps?q=loc:" + latitude + "," + longitude + " (" + yourLocationName + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                context.startActivity(intent);

            }
        });

        callLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //put womenDataResults.getPhone in here
                String phone = womenDataResults.getPhone();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phone));
                context.startActivity(intent);
            }
        });

    }
}
