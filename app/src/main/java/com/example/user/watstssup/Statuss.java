package com.example.user.watstssup;


import android.app.AlertDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Statuss extends Fragment {

    private RecyclerView recycler_statusp;
    private ArrayList<String> nameList, contentList, dayList;

    private int[] images = {R.drawable.galileo, R.drawable.cvraman, R.drawable.albert, R.drawable.marie, R.drawable.charles, R.drawable.micheal, R.drawable.thomson,R.drawable.alexandrr,R.drawable.nicolous};
   private Verticadapt adapt;

    VideoView s_video;
    public Statuss() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vs= inflater.inflate(R.layout.fragment_statuss, container, false);
        recycler_statusp=vs.findViewById(R.id.recycler_status);
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

        adapt = new Verticadapt(nameList);

        LinearLayoutManager verticalLayoutmanager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recycler_statusp.setLayoutManager(verticalLayoutmanager);
        recycler_statusp.setAdapter(adapt);
        return vs;
    }
    public class Verticadapt extends RecyclerView.Adapter<Verticadapt.MyViewHolder> {

        private List<String> verticalList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView ttvw, ttvw1, ttvw2;
            public ImageView imgs;
            public ConstraintLayout lin_layp;

            public MyViewHolder(View view) {
                super(view);
                imgs = (ImageView) view.findViewById(R.id.status_image);
                ttvw = (TextView) view.findViewById(R.id.status_name);
                ttvw1 = (TextView) view.findViewById(R.id.status_message);
                ttvw2 = (TextView) view.findViewById(R.id.status_time);
                lin_layp=(ConstraintLayout) view.findViewById(R.id.lin_layout);
            }
        }

        public Verticadapt(List<String> verticalList) {
            this.verticalList = nameList;

        }

        @Override
        public Verticadapt.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView1 = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.statusss, parent, false);

            return new Verticadapt.MyViewHolder(itemView1);
        }

        @Override
        public void onBindViewHolder(@NonNull Verticadapt.MyViewHolder myViewHolder, final int i) {
            myViewHolder.imgs.setImageResource(images[i]);
            myViewHolder.ttvw.setText(nameList.get(i));
            myViewHolder.ttvw1.setText(contentList.get(i));
            myViewHolder.ttvw2.setText(dayList.get(i));
            myViewHolder.lin_layp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {


                    LayoutInflater l=LayoutInflater.from(getContext());
                    View vv=l.inflate(R.layout.stattus_video,null);
                    s_video=(VideoView)vv.findViewById(R.id.s_videoView);

                    AlertDialog.Builder AB=new AlertDialog.Builder(getContext());
                    AB.setView(vv);

                    AlertDialog A=AB.create();
                    A.show();

                    if (i==0)
                    {

                        String video_path = "android.resource://com.example.user.watstssup/"
                                + R.raw.song;
                        s_video.setVideoURI(Uri.parse(video_path));
                        s_video.start();



                    }
                }
            });

        }



        @Override
        public int getItemCount() {
            return nameList.size();
        }
    }

}
