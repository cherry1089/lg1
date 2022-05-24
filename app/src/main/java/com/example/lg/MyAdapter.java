package com.example.lg;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lg.models.HostedV;


import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<HostedV> hostedVArrayList;
    private onItemClickListener listener;
    public interface onItemClickListener{
       // void onItemClicked(long documentReference,int position);
        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(onItemClickListener listener){
        this.listener=listener;
    }


    public MyAdapter(Context context,ArrayList<HostedV> hostedVArrayList) {
        this.context = context;
        this.hostedVArrayList = hostedVArrayList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
         View v= LayoutInflater.from(context).inflate(R.layout.hostedve,parent ,false);


        return new MyViewHolder(v,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {
          HostedV hostedV=hostedVArrayList.get(position);
       // String DocID = hostedVArrayList.requireNonNull(getCurrentList()).snapshot().get(position).getId();

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
       holder.bi.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


               Intent intent=new Intent(context,loading.class);
               intent.putExtra("vtype1",hostedV.vtype);
               intent.putExtra("brandModel1",hostedV.brandModel);
               intent.putExtra("location1",hostedV.location);
               intent.putExtra("rno1",hostedV.rno);
               intent.putExtra("mail1",hostedV.mail);
               intent.putExtra("fairPerHour1",hostedV.fairPerHour);
               intent.putExtra("seater1",hostedV.seater);
               intent.putExtra("username1",hostedV.username);
               intent.putExtra("pnumber1",hostedV.pnumber);
               intent.putExtra("sdate1",hostedV.sdate);
               intent.putExtra("edate1",hostedV.edate);
               context.startActivity(intent);

           }
       });


    }


    @Override
    public int getItemCount() {
        return hostedVArrayList.size();
    }

  public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView vtype,brandModel,location,fairPerHour,seater,username,pnumber,rno,mail,sdate,edate;
      //  ImageView image;
        Button bi;


       public MyViewHolder(@NonNull View itemView,onItemClickListener listener) {

           super(itemView);
           vtype = itemView.findViewById(R.id.vehicleType);
           brandModel = itemView.findViewById(R.id.BrandModel);
           location = itemView.findViewById(R.id.locationOfVehicle);
           fairPerHour = itemView.findViewById(R.id.Cost);
          // image = itemView.findViewById(R.id.hostedImage);
             bi=itemView.findViewById(R.id.biq);
           seater = itemView.findViewById(R.id.seaterNo);
           username=itemView.findViewById(R.id.owner);
           pnumber=itemView.findViewById(R.id.pno1);
           rno=itemView.findViewById(R.id.rno1);
           mail=itemView.findViewById(R.id.mail1);
           sdate=itemView.findViewById(R.id.sdate);
           edate=itemView.findViewById(R.id.edate);
           int position=getAdapterPosition();

           bi.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                   if(listener!=null){

                      int position=getAdapterPosition();
                      if(position!= RecyclerView.NO_POSITION)
                       {
                           //DocumentReference ref = getItem(position).getReference();

                           // String uiid=hostedVArrayList.get(position).getUid();
                           listener.onDeleteClick(position);
                          // String DocID = hostedVArrayList.ggetCurrentList()).snapshot().get(position).getId();
                          // listener.onItemClicked(MyAdapter.this.getItemId(position),position);
                       }
                   }

               }
           });
       }



  }
}
