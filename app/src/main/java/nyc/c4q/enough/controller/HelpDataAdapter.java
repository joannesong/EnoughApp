package nyc.c4q.enough.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.enough.R;
import nyc.c4q.enough.holder.WomenHelpDataVH;
import nyc.c4q.enough.model.Results;

/**
 * Created by joannesong on 3/3/18.
 */

public class HelpDataAdapter extends RecyclerView.Adapter<WomenHelpDataVH> {
    private List<Results> womenResourceList = new ArrayList<>();

    public HelpDataAdapter(List<Results> womenResourceList) {
        this.womenResourceList = womenResourceList;
    }

    @Override
    public WomenHelpDataVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.help_data_itemview, parent, false);
        return new WomenHelpDataVH(view);
    }

    @Override
    public void onBindViewHolder(WomenHelpDataVH holder, int position) {
        holder.onBind(womenResourceList.get(position));
    }

    @Override
    public int getItemCount() {
        return womenResourceList.size();
    }
}
