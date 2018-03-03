package nyc.c4q.enough.controller;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.enough.R;
import nyc.c4q.enough.holder.NYTViewHolder;
import nyc.c4q.enough.model.Results;

/**
 * Created by C4Q on 3/3/18.
 */

public class NYTadapter extends RecyclerView.Adapter<NYTViewHolder>{
    public List<Results> articleList;

    public NYTadapter(List<Results> articleList) {
        this.articleList = articleList;
    }

    @Override
    public NYTViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.nyt_itemview, parent, false);

        return new NYTViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(final NYTViewHolder holder, final int position) {
        Results nytStories = articleList.get(position);
        holder.onBind(nytStories);

        holder.article_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = articleList.get(position).getUrl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                holder.itemView.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}
