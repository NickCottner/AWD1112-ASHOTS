package org.insideranken.npcottner.employeedatabase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class rvEmployeeAdapter extends RecyclerView.Adapter<rvEmployeeAdapter.MyViewHolder> {
    List<EmployeeModel> employeeList;
    Context context;
    //  Constructor
    public rvEmployeeAdapter(List<EmployeeModel> employeeList, Context context)
    {
        this.employeeList = employeeList;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.tvEmployeeName.setText(employeeList.get(position).getEmployeeName());
        holder.tvEmployeeDepartment.setText(employeeList.get(position).getEmployeeDepartment());
        holder.tvEmployeeId.setText(employeeList.get(position).getEmployeeId());
        holder.ivEmployeeImage.setImageResource(employeeList.get(position).getEmployeeImage());
        holder.parentLayout.setOnClickListener(v -> {
            Intent intent = new Intent(context, AddEmployee.class);
            intent.putExtra("employeeId", employeeList.get(holder.getAdapterPosition()).getEmployeeId());
            context.startActivity(intent);
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivEmployeeImage;
        TextView tvEmployeeName;
        TextView tvEmployeeDepartment;
        TextView tvEmployeeId;
        ConstraintLayout parentLayout;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            // Define click listener for the ViewHolder's View
            ivEmployeeImage     = itemView.findViewById(R.id.ivEmployeeImage);
            tvEmployeeName   = itemView.findViewById(R.id.tvEmployeeName);
            tvEmployeeDepartment    = itemView.findViewById(R.id.tvEmployeeDepartment);
            tvEmployeeId     = itemView.findViewById(R.id.tvEmployeeId);
            parentLayout    = itemView.findViewById(R.id.oneEmployee);
        }
    }
}
