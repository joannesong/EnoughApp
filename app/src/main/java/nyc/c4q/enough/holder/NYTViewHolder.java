package nyc.c4q.enough.holder;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import nyc.c4q.enough.R;
import nyc.c4q.enough.model.NYTResults;
import nyc.c4q.enough.model.Results;

import static android.content.ContentValues.TAG;

/**
 * Created by C4Q on 3/3/18.
 */

//Adapter

public class NYTViewHolder extends RecyclerView.ViewHolder{

    public ImageView article_Image;
    private TextView article_Title;


    public NYTViewHolder(View itemView) {
        super(itemView);
        article_Title = itemView.findViewById(R.id.title_view);
        article_Image = itemView.findViewById(R.id.image_view);
    }
    public void onBind(Results results) {

        article_Title.setText(results.getTitle());

        if (!results.getMultimedia().isEmpty())   {
            String imgURL = results.getMultimedia().get(4).getUrl();
            Glide.with(article_Image.getContext())
                    .load(imgURL)
                    //try to resize the image to make more visible
                    .into(article_Image);
        }

        Log.d(TAG, String.valueOf(article_Title));

    }
}
