package com.android2_lesson1.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android2_lesson1.FormActivity;
import com.android2_lesson1.MainActivity;
import com.android2_lesson1.R;
import com.android2_lesson1.Task;
import com.android2_lesson1.TaskAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class HomeFragment extends Fragment {

    static final int CODE = 444;
    private RecyclerView recyclerView;
    private TaskAdapter adapter;
    private List<Task> list;

    private HomeViewModel homeViewModel;
    MainActivity activity;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        recyclerView = root.findViewById(R.id.recyclerView);

        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        initList();                                                     ////////////////////////////////////////////TODO:
        return root;
    }

    private void initList() {
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TaskAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getActivity();                                                               ////////////////////////////////////////////TODO:
        if(resultCode == RESULT_OK && requestCode == CODE) {
                Task task = (Task) data.getSerializableExtra("task");
                Log.d("ololo", "receive task");
                list.add(task);
                adapter.notifyDataSetChanged();
        }
    }
}