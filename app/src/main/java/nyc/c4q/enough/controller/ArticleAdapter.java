package nyc.c4q.enough.controller;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import nyc.c4q.enough.R;
import nyc.c4q.enough.model.Results;

/**
 * Created by C4Q on 3/3/18.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    public Results[] getArticles() {
        return articles;
    }

    private Results[] articles;

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.nyt_itemview, parent, false);
        return new ArticleViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        holder.onBind(articles[position]);
    }

    @Override
    public int getItemCount() {
        return articles.length;
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        private TextView articleTitle;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            articleTitle =itemView.findViewById(R.id.title_view);

        }

        public void onBind(Results article) {
            articleTitle.setText(article.getTitle());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(), "News Article", Toast.LENGTH_SHORT).show();
                    //Intent intent= new Intent(itemView.getContext(),SecondActivity.class);
                    //intent.putExtra("title",articleModel.getTitle());

                }
            });

        }
    }
}
