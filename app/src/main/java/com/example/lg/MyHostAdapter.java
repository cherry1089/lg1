package com.example.lg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lg.models.HostedV;

import java.util.ArrayList;

public class MyHostAdapter extends RecyclerView.Adapter<MyHostAdapter.MyViewHolder> {
    Context context;
    ArrayList<HostedV> hostedVArrayList;
    public MyHostAdapter(Context context,ArrayList<HostedV> hostVArrayList) {
        this.context = context;
        this.hostedVArrayList = hostVArrayList;
    }

    @NonNull
    @Override
    public MyHostAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.hosthistorycard,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHostAdapter.MyViewHolder holder,int position) {
        HostedV hostedV=hostedVArrayList.get(position);
        holder.vtype.setText(hostedV.vtype);
        holder.brandModel.setText(hostedV.brandModel);
        holder.location.setText(hostedV.location);
        // Glide.with(context).load(hostedV.image).into(holder.image);
        holder.rno.setText(hostedV.rno);
        holder.mail.setText(hostedV.mail);
        holder.fairPerHour.setText(String.valueOf(hostedV.fairPerHour));
        holder.seater.setText(String.valueOf(hostedV.seater));
         holder.username.setText(hostedV.username);
        holder.pnumber.setText(String.valueOf(hostedV.pnumber));
        holder.sdate.setText(hostedV.sdate);
        holder.edate.setText(hostedV.edate);
    }

    @Override
    public int getItemCount() {
        return hostedVArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView vtype,brandModel,location,fairPerHour,seater,rno,mail,sdate,edate,username,pnumber;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            vtype = itemView.findViewById(R.id.vehicleType1);
            username = itemView.findViewById(R.id.owner1);
            pnumber = itemView.findViewById(R.id.pno2);
            brandModel = itemView.findViewById(R.id.BrandModel1);
            location = itemView.findViewById(R.id.locationOfVehicle1);
            fairPerHour = itemView.findViewById(R.id.Cost1);
            // image = itemView.findViewById(R.id.hostedImage);
            seater = itemView.findViewById(R.id.seaterNo1);
            rno=itemView.findViewById(R.id.rno2);
            mail=itemView.findViewById(R.id.mail2);
            sdate=itemView.findViewById(R.id.sdate1);
            edate=itemView.findViewById(R.id.edate1);
        }
    }
}

