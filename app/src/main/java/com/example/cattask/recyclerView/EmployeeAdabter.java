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
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new EmployeeHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {
        final EmployeePojo employee = EmployeeList.get(position);
        // that is a good practice
        holder.bind(employee);

        // we will learn about some thing called (CallBack) to make this looks better
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Details_Activity.class);
                intent.putExtra("name", employee.getName());
                intent.putExtra("describtion", employee.getDescribtion());
                intent.putExtra("image", employee.getImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return EmployeeList.size();
    }


    // static to avoid the outer class from leaks
    public static class EmployeeHolder extends RecyclerView.ViewHolder {

        TextView employeeName, employeeDescribtion;
        ImageView employeeImage;
        LinearLayout linearLayout;

        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);
            // No need for casting views
            employeeName = itemView.findViewById(R.id.name);
            employeeDescribtion = itemView.findViewById(R.id.describtion);
            employeeImage = itemView.findViewById(R.id.image);
            linearLayout = itemView.findViewById(R.id.list_item_selected);

        }

        public void bind(EmployeePojo employee) {
            employeeName.setText(employee.getName());
            employeeDescribtion.setText(employee.getDescribtion());
            employeeImage.setImageResource(employee.getImage());
        }
    }
}
