package com.example.myapplication;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adapter_class extends RecyclerView.Adapter<adapter_class.ViewHolder>{
    private List<model_class>listData;
    private Context context;
    public adapter_class(Context applicationContext, List<model_class> listData) {
        this.listData = listData;
        this.context=applicationContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_subject_ui, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        model_class ld=listData.get(position);
        holder.subject.setText(ld.getSubject());
        Picasso.get().load(ld.getImglink()).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0){
                    Intent intent=new Intent(context,pass_subject.class);
                    intent.putExtra("pass","his");
                    v.getContext().startActivity(intent);
                }
                if(position==1){
                    Intent intent=new Intent(context,pass_subject.class);
                    intent.putExtra("pass","sci");
                    v.getContext().startActivity(intent);
                }
                if(position==2){
                    Intent intent=new Intent(context,pass_subject.class);
                    intent.putExtra("pass","isl");
                    v.getContext().startActivity(intent);
                }
                if(position==3){
                    Intent intent=new Intent(context,pass_subject.class);
                    intent.putExtra("pass","mat");
                    v.getContext().startActivity(intent);
                }
                if(position==4){
                    Intent intent=new Intent(context,pass_subject.class);
                    intent.putExtra("pass","ani");
                    v.getContext().startActivity(intent);
                }
                if(position==5){
                    Intent intent=new Intent(context,pass_subject.class);
                    intent.putExtra("pass","spo");
                    v.getContext().startActivity(intent);
                }
                if(position==6){
                    Intent intent=new Intent(context,pass_subject.class);
                    intent.putExtra("pass","com");
                    v.getContext().startActivity(intent);
                }
                if(position==7){
                    Intent intent=new Intent(context,pass_subject.class);
                    intent.putExtra("pass","foo");
                    v.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView subject;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img);
            subject=itemView.findViewById(R.id.subject);
        }
    }

}
