package nyc.c4q.enough.holder;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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
    private LinearLayout callLayout;

    public WomenHelpDataVH(View itemView) {
        super(itemView);

        organizationName = itemView.findViewById(R.id.organization_name);
        organizationLink = itemView.findViewById(R.id.organization_site);
        callLayout = itemView.findViewById(R.id.press_call_layout);

    }

    public void onBind(final WomenDataResults womenDataResults){

        organizationName.setText(womenDataResults.getOrganizationname());
        organizationLink.setText(womenDataResults.getUrl());

        callLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //put womenDataResults.getPhone in here

            }
        });


    }
}
