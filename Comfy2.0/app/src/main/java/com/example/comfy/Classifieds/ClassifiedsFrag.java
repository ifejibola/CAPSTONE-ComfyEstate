package com.example.comfy.Classifieds;

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

public class ClassifiedsFrag extends Fragment {

    public static Fragment newInstance() {
        return new ClassifiedsFrag();
    }

    RecyclerView cRecyclerView;
    classifieds_obj postsobj1;
    List<classifieds_obj> myPostList;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ads_recycler_view_fragment, container, false);


        cRecyclerView = view.findViewById(R.id.ads_recycler_view);
        cRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));




        myPostList=new ArrayList<>();
        postsobj1 = new classifieds_obj("Plumber","Plumber data fields.",R.drawable.plumber);
        myPostList.add(postsobj1);
        postsobj1 = new classifieds_obj("Carpenter","Carpenter data fields.",R.drawable.carpentry);
        myPostList.add(postsobj1);
        postsobj1 = new classifieds_obj("Lawyer","Lawyer data fields.",R.drawable.lawyer);
        myPostList.add(postsobj1);
        postsobj1 = new classifieds_obj("Real Estate Agent","Real Estate Agent data fields",R.drawable.realestateagent);
        myPostList.add(postsobj1);
        postsobj1 = new classifieds_obj("HVAC Technician","HVAC Tech data fields",R.drawable.hvac);
        myPostList.add(postsobj1);

        cRecyclerView.setAdapter(new RecyclerViewAdapter(ClassifiedsFrag.this.getActivity(),myPostList));

        return view;
    }

    private class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private CardView cCardView;
        private TextView cTitleTextView;

        private ImageView cImageView;

        public RecyclerViewHolder(View itemView){

            super(itemView);


        }

        public RecyclerViewHolder(LayoutInflater inflater, ViewGroup container){
            super(inflater.inflate(R.layout.ads_cardview, container, false));

            cCardView=itemView.findViewById(R.id.card_container3);
            cTitleTextView=itemView.findViewById(R.id.ads_title);

            cImageView = itemView.findViewById(R.id.ads_img);


        }
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

        private List<classifieds_obj> pList;
        private Context cContext;

        public RecyclerViewAdapter(Context cContext, List<classifieds_obj> myPostList )
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

            holder.cImageView.setImageResource(pList.get(holder.getAdapterPosition()).getItemImage());



                        holder.cCardView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(cContext, classifieds_detailactivity.class);
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



