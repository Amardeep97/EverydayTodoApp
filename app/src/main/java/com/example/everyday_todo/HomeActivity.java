package com.example.everyday_todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import adapters.TodoListAdapter;
import entities.Todo;
import todo_database.*;

import android.util.Log;
import android.view.View;
import android.widget.*;
import android.content.*;

import com.example.everyday_todo.fragment.FragmentActivity;


public class HomeActivity extends AppCompatActivity {

    private Button button_add;
    private ListView listview_todo;
    TodoDB todoDB;
    private Button button_logout;
    private Button button_about;
    private Button admindb;
    private Button ormtodo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.button_add = (Button) findViewById(R.id.button_add);
        this.button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Add Todos", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(HomeActivity.this, AddTodoActivity.class);
                startActivity(intent1);
            }
        });

        //use orm to-do
        this.ormtodo = (Button) findViewById(R.id.button_orm);
        this.ormtodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Opening orm Todo", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(HomeActivity.this, MvvmMainActivity.class);
                startActivity(intent1);
            }
        });

        //logout button function
        this.button_logout = (Button) findViewById(R.id.button_logout);
        this.button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Logged out Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });

        //admin dashboard button function
        this.admindb = (Button) findViewById(R.id.button_dashboard);
        this.admindb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Logged out Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(HomeActivity.this, FragmentActivity.class);
                startActivity(intent1);
            }
        });

        //about button function
        this.button_about = (Button) findViewById(R.id.button_about);
        this.button_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "App About page", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(HomeActivity.this, MvvmActivity.class);
                startActivity(intent1);
            }
        });


        todoDB = new TodoDB(this);
        this.listview_todo = (ListView) findViewById(R.id.listview_todo);
        TextView empty=(TextView)findViewById(R.id.empty);
        listview_todo.setEmptyView(empty);
        this.listview_todo.setAdapter(new TodoListAdapter(this, todoDB.findAll()));

        this.listview_todo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Todo todo = todoDB.findAll().get(i);
                Intent intent1 = new Intent(HomeActivity.this, TodoDetailActivity.class);
                intent1.putExtra("todo", todo);
                startActivity(intent1);
            }
        });
    }

    //life cycle components

    protected void onStart(){
        super.onStart();
        Log.i("testlifecycle", "on create event" );
    }

    protected void onResume(){
        super.onResume();
        Log.i("testlifecycle", "on resume event" );
    }

    protected void onPause(){
        super.onPause();
        Log.i("testlifecycle", "on pause event" );
    }

    protected void onStop(){
        super.onStop();
        Log.i("testlifecycle", "on stop event" );
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.i("testlifecycle", "on destroy event" );
    }
}
