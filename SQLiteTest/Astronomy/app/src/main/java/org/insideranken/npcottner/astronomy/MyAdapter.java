package org.insideranken.npcottner.astronomy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    public Context context;
    Activity activity;
    public ArrayList constellation_id;
    public ArrayList constellation_name;
    public ArrayList constellation_family;
    public ArrayList constellation_latitude;
    public ArrayList constellation_month;

    public MyAdapter(Activity activity, Context context,
                     ArrayList constellation_id,
                     ArrayList constellation_name,
                     ArrayList constellation_family,
                     ArrayList constellation_latitude,
                     ArrayList constellation_month) {
        this.context = context;
        this.activity = activity;
        this.constellation_id = constellation_id;
        this.constellation_name = constellation_name;
        this.constellation_family = constellation_family;
        this.constellation_latitude = constellation_latitude;
        this.constellation_month = constellation_month;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.constellationId.setText(String.valueOf(constellation_id.get(position)));
        holder.constellationName.setText(String.valueOf(constellation_name.get(position)));
        holder.constellationFamily.setText(String.valueOf(constellation_family.get(position)));
        holder.constellationLatitude.setText(String.valueOf(constellation_latitude.get(position)));
        holder.constellationMonth.setText(String.valueOf(constellation_month.get(position)));
        holder.constellationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,UpdateConstellation.class);
                intent.putExtra("id",String.valueOf(constellation_id.get(holder.getAdapterPosition())));
                intent.putExtra("name",String.valueOf(constellation_name.get(holder.getAdapterPosition())));
                intent.putExtra("family", String.valueOf(constellation_family.get(holder.getAdapterPosition())));
                intent.putExtra("latitude",String.valueOf(constellation_latitude.get(holder.getAdapterPosition())));
                intent.putExtra("month",String.valueOf(constellation_month.get(holder.getAdapterPosition())));
                activity.startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return constellation_id.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView constellationId;
        TextView constellationName;
        TextView constellationFamily;
        TextView constellationLatitude;
        TextView constellationMonth;

        LinearLayout constellationLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            constellationId = itemView.findViewById(R.id.row_id);
            constellationName = itemView.findViewById(R.id.tvRowConstellationName);
            constellationFamily = itemView.findViewById(R.id.tvRowConstellationFamily);
            constellationLatitude = itemView.findViewById(R.id.tvRowConstellationLatitude);
            constellationMonth = itemView.findViewById(R.id.tvRowConstellationMonth);

            constellationLayout = itemView.findViewById(R.id.constellationLayout);

            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            constellationLayout.setAnimation(translate_anim);
        }
    }
}
