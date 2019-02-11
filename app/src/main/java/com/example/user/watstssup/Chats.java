package com.example.user.watstssup;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Chats extends Fragment {

    private RecyclerView vertical_recycler_view;
    private VerticalAdapter verticalAdapter;
    private ArrayList<String> nameList, contentList, dayList;

    private int[] images = {R.drawable.galileo, R.drawable.cvraman, R.drawable.albert, R.drawable.marie, R.drawable.charles, R.drawable.micheal, R.drawable.thomson,R.drawable.alexandrr,R.drawable.nicolous};


    public Chats() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_chats, container, false);
        vertical_recycler_view = (RecyclerView)v.findViewById(R.id.recycler2vw);

        nameList = new ArrayList<String>();
        nameList.add("Galileo ");
        nameList.add("C.V. ");
        nameList.add("Albert ");
        nameList.add("Marie ");
        nameList.add("Charles ");
        nameList.add("Michael ");
        nameList.add("Thomas ");
        nameList.add("Alexander ");
        nameList.add("Nicolaus ");


        contentList = new ArrayList<String>();

        contentList.add("Galilei");
        contentList.add("Raman");
        contentList.add("Einstein");
        contentList.add("Curie");
        contentList.add("Darwin");
        contentList.add("Faraday");
        contentList.add("Edison");
        contentList.add("Graham Bell");
        contentList.add("Copernicus");
        dayList = new ArrayList<String>();

        dayList.add("Today");
        dayList.add("Today");
        dayList.add("Today");
        dayList.add("Today");
        dayList.add("Today");
        dayList.add("Today");
        dayList.add("Today");
        dayList.add("Today");
        dayList.add("Today");
        verticalAdapter = new VerticalAdapter(nameList);

        LinearLayoutManager verticalLayoutmanager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        vertical_recycler_view.setLayoutManager(verticalLayoutmanager);
        vertical_recycler_view.setAdapter(verticalAdapter);
        return v;
    }
    public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.MyViewHolder> {

        private List<String> verticalList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView ttvw, ttvw1, ttvw2;
            public ImageView imgs;

            public MyViewHolder(View view) {
                super(view);
                imgs = (ImageView) view.findViewById(R.id.imgvw1);
                ttvw = (TextView) view.findViewById(R.id.nametxt);
                ttvw1 = (TextView) view.findViewById(R.id.contttxt);
                ttvw2 = (TextView) view.findViewById(R.id.daytxt);

            }
        }

        public VerticalAdapter(List<String> verticalList) {
            this.verticalList = nameList;

        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView1 = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chatts, parent, false);

            return new MyViewHolder(itemView1);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
            myViewHolder.imgs.setImageResource(images[i]);
            myViewHolder.ttvw.setText(nameList.get(i));
            myViewHolder.ttvw1.setText(contentList.get(i));
            myViewHolder.ttvw2.setText(dayList.get(i));

        }

        @Override
        public int getItemCount() {
            return nameList.size();
        }
    }

    }
