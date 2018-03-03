package nyc.c4q.enough.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.enough.R;
import nyc.c4q.enough.holder.WomenHolder;
import nyc.c4q.enough.model.Results;

/**
 * Created by joannesong on 3/3/18.
 */

public class WomenAdapter extends RecyclerView.Adapter<WomenHolder>{
    private List<Results> womenResourceList = new ArrayList<>();

    public WomenAdapter(List<Results> womenResourceList) {
        this.womenResourceList = womenResourceList;
    }

    @Override
    public WomenHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.resources_itemview, parent, false);
        return new WomenHolder(view);
    }

    @Override
    public void onBindViewHolder(WomenHolder holder, int position) {
        holder.onBind(womenResourceList.get(position));
    }

    @Override
    public int getItemCount() {
        return womenResourceList.size();
    }
}
