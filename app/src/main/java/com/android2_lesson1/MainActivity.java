package com.android2_lesson1;

import android.content.Intent;
import android.os.Bundle;
import com.android2_lesson1.ui.home.HomeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;

import java.util.ArrayList;

public class MainActivity  extends AppCompatActivity {

    static final int CODE = 444;
    TaskAdapter adapter;
    RecyclerView recyclerView;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new TaskAdapter();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, FormActivity.class), CODE);
                Log.d("ololo", "startActivityForResult");
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send).setDrawerLayout(drawer).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE){
            if (resultCode == RESULT_OK){
                Task task = (Task) data.getSerializableExtra(FormActivity.MY_KEY);
                Log.d("ololo", "receive task");
                adapter.addNewTask(task);
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(resultCode == RESULT_OK && requestCode == CODE) {
//            Task task = (Task) data.getSerializableExtra(FormActivity.MY_KEY);
//            adapter.addNewTask(task);
            //HomeFragment fragment = new HomeFragment();
            //fragment.onActivityResult(CODE, RESULT_OK, task);
//        if(resultCode == RESULT_OK && requestCode == CODE) {
//            Task task = (Task) data.getSerializableExtra("task");
//            //HomeFragment fragment = new HomeFragment();
//            //fragment.onActivityResult(CODE, RESULT_OK, task);
//            Log.e("ololo", "task = " + task.getTitle());
//            //list.add(task);
//            //adapter.notifyDataSetChanged();
//            }
      //  }
   // }

//    public void showHomeFragment() {                                                      ////////////////////////////////////////////TODO:
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.replace(R.id.container, new HomeFragment());
//        transaction.commit();
//    }


}
//+// 1. Меняем иконки шторки
//+// 2. Нужно проверять поля на пустоту.
//-// 3. fragments onActivityResult
