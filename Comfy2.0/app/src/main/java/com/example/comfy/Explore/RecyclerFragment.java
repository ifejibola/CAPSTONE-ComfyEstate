package com.example.comfy.Explore;

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

import com.example.comfy.MainActivity;
import com.example.comfy.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerFragment extends Fragment {

    public static Fragment newInstance() {
        return new RecyclerFragment();
    }

    RecyclerView pRecyclerView;
    posts_obj postsobj1;
    List<posts_obj> myPostList;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.explore_recycler_view_fragment, container, false);


        pRecyclerView = view.findViewById(R.id.recycler_view);
        pRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        myPostList=new ArrayList<>();
        postsobj1 = new posts_obj("1 Storey House, with finished attic","ONE DESCRIPTION","$250,000",R.drawable.house1);
        myPostList.add(postsobj1);
        postsobj1 = new posts_obj("Two bedroom, 4 bath","TWO DESCRIPTION","$500,000",R.drawable.house2);
        myPostList.add(postsobj1);
        postsobj1 = new posts_obj("3800 Sq. Feet, 4 Car Parking","THREE DESCRIPTION","$750,000",R.drawable.house3);
        myPostList.add(postsobj1);
        postsobj1 = new posts_obj("Beautiful 5 Bedroom, 6 Bathroom House","FOUR DESCRIPTION","$650,000",R.drawable.house1);
        myPostList.add(postsobj1);
        postsobj1 = new posts_obj("Detached 4500sq. ft Lot, 5 Bedroom, 7 bath","FIVE DESCRIPTION", "$450,000",R.drawable.house2);
        myPostList.add(postsobj1);

        pRecyclerView.setAdapter(new RecyclerViewAdapter(RecyclerFragment.this.getContext(),myPostList));

        return view;
    }

    private class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private CardView pCardView;
        private TextView pTitleTextView;
        private TextView pPriceTextView;
        private ImageView pImageView;

        public RecyclerViewHolder(View itemView){

            super(itemView);


        }

        public RecyclerViewHolder(LayoutInflater inflater, ViewGroup container){
            super(inflater.inflate(R.layout.explore_card_view, container, false));

            pCardView=itemView.findViewById(R.id.card_container);
            pTitleTextView=itemView.findViewById(R.id.title);
            pPriceTextView=itemView.findViewById(R.id.price);
            pImageView = itemView.findViewById(R.id.house_img);
        }
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

        private List<posts_obj> pList;
        private Context pContext;

        public RecyclerViewAdapter(Context pContext, List<posts_obj> myPostList )
        {

            this.pList = myPostList ;
            this.pContext=pContext;
        }

        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());

            return new RecyclerViewHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, int position) {
                holder.pTitleTextView.setText(myPostList.get(holder.getAdapterPosition()).getTitle());
                holder.pPriceTextView.setText(myPostList.get(holder.getAdapterPosition()).getPrice());
                holder.pImageView.setImageResource(myPostList.get(holder.getAdapterPosition()).getItemImage());
                holder.pCardView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(pContext,explore_detailactivity.class);
                        intent.putExtra("Image", myPostList.get(holder.getAdapterPosition()).getItemImage());
                        intent.putExtra("Title", myPostList.get(holder.getAdapterPosition()).getTitle());
                        intent.putExtra("Price", myPostList.get(holder.getAdapterPosition()).getPrice());
                        intent.putExtra("Description", myPostList.get(holder.getAdapterPosition()).getDescription());
                        pContext.startActivity(intent);
                    }
                });
        }

        @Override
        public int getItemCount() {
            return pList.size();
        }
    }


}


