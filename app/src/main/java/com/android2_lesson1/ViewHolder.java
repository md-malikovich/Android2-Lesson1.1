package com.android2_lesson1;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView vhTitle;
    TextView vhDesc;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        vhTitle = itemView.findViewById(R.id.vh_title);
        vhDesc = itemView.findViewById(R.id.vh_desc);
    }

    public void onBind(Task task) {
        vhTitle.setText(task.getTitle());
        vhDesc.setText(task.getDesc());
    }
}