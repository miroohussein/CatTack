package com.example.cattask.recyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cattask.Details_Activity;
import com.example.cattask.R;

import java.util.List;

public class EmployeeAdabter extends RecyclerView.Adapter<EmployeeAdabter.EmployeeHolder> {
    private List<EmployeePojo> EmployeeList;
    private Context context;

    public EmployeeAdabter(List<EmployeePojo> employeeList, Context context) {
        this.EmployeeList = employeeList;
        this.context = context;
    }

    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        EmployeeHolder employeeHolder = new EmployeeHolder(viewItem);
        return employeeHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {
        final EmployeePojo employee =EmployeeList.get(position);
        holder.employeeName.setText(employee.getName());
        holder.employeeDescribtion.setText(employee.getDescribtion());
        holder.employeeImage.setImageResource(employee.getImage());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , Details_Activity.class );
                intent.putExtra("name",employee.getName());
                intent.putExtra("describtion",employee.getDescribtion());
                intent.putExtra("image",employee.getImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return EmployeeList.size();
    }


    public class EmployeeHolder extends RecyclerView.ViewHolder {
        TextView employeeName, employeeDescribtion;
        ImageView employeeImage;
        LinearLayout linearLayout ;
        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);
            employeeName = (TextView) itemView.findViewById(R.id.name);
            employeeDescribtion = (TextView) itemView.findViewById(R.id.describtion);
            employeeImage = (ImageView) itemView.findViewById(R.id.image);
            linearLayout= (LinearLayout) itemView.findViewById(R.id.list_item_selected);

        }
    }
}
