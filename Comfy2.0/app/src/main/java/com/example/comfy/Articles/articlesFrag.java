package com.example.comfy.Articles;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comfy.Explore.posts_obj;
import com.example.comfy.R;

import java.util.ArrayList;
import java.util.List;

public class articlesFrag extends Fragment {

    public static Fragment newInstance() {
        return new articlesFrag();
    }

    RecyclerView cRecyclerView;
    articles_obj postsobj1;
    List<articles_obj> myPostList;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.articles_recycler_view_fragment, container, false);


        cRecyclerView = view.findViewById(R.id.articles_recycler_view);
        cRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));




        myPostList=new ArrayList<>();
        postsobj1 = new articles_obj("Tips on properly staging your home for a quick and high sale.",getString(R.string.sampleparagraph),R.drawable.ad1);
        myPostList.add(postsobj1);
        postsobj1 = new articles_obj("What do I need to have inspected before I purchase a home?",getString(R.string.sampleparagraph),R.drawable.ad2);
        myPostList.add(postsobj1);
        postsobj1 = new articles_obj("Commercial unit mortgage rates to see decline.",getString(R.string.sampleparagraph),R.drawable.ad3);
        myPostList.add(postsobj1);
        postsobj1 = new articles_obj("Top 5 cities with the most expensive real estate.",getString(R.string.sampleparagraph),R.drawable.ad4);
        myPostList.add(postsobj1);
        postsobj1 = new articles_obj("Essential heating/cooling system components that require your attention.",getString(R.string.sampleparagraph),R.drawable.ad5);
        myPostList.add(postsobj1);

        cRecyclerView.setAdapter(new RecyclerViewAdapter(articlesFrag.this.getActivity(),myPostList));

        return view;
    }

    private class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private CardView cCardView;
        private TextView cTitleTextView;
        private TextView cDescriptionTextView;
        private TextView c2TitleTextView;
        private ImageView cImageView;

        public RecyclerViewHolder(View itemView){

            super(itemView);


        }

        public RecyclerViewHolder(LayoutInflater inflater, ViewGroup container){
            super(inflater.inflate(R.layout.articles_cardview, container, false));

            cCardView=itemView.findViewById(R.id.card_container4);
            cTitleTextView=itemView.findViewById(R.id.articles_title);

            cImageView = itemView.findViewById(R.id.articles_img);

            c2TitleTextView=itemView.findViewById(R.id.articles_detail_title);
            cDescriptionTextView=itemView.findViewById(R.id.articles_detail_description);
        }
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

        private List<articles_obj> pList;
        private Context cContext;

        public RecyclerViewAdapter(Context cContext, List<articles_obj> myPostList )
        {

            this.pList = myPostList ;
            this.cContext=cContext;
        }

        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());

            return new RecyclerViewHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, int position) {
            holder.cTitleTextView.setText(pList.get(holder.getAdapterPosition()).getTitle());
            //holder.cDescriptionTextView.setText(pList.get(holder.getAdapterPosition()).getDescription());
            holder.cImageView.setImageResource(pList.get(holder.getAdapterPosition()).getItemImage());
            //holder.c2TitleTextView.setText(pList.get(holder.getAdapterPosition()).getTitle());


                        holder.cCardView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(cContext, articles_detailactivity.class);
                        intent.putExtra("Image", myPostList.get(holder.getAdapterPosition()).getItemImage());
                        intent.putExtra("Title", myPostList.get(holder.getAdapterPosition()).getTitle());
                        intent.putExtra("Description", myPostList.get(holder.getAdapterPosition()).getDescription());

                        cContext.startActivity(intent);
                    }
                });
        }

        @Override
        public int getItemCount() {
            return pList.size();
        }
    }


}



