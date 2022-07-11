package sg.edu.np.mad.week2madprac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DBHandler userDB = new DBHandler(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        UserAdapter mAdapter = new UserAdapter(userDB.getUsers());

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        createUsers();



        // Setting number to be sent to MainActivity
        // int number = new Random().nextInt(10000000 - 0);
        // String numberText = String.valueOf(number);

    }

    public void createUsers(){
        ArrayList<User> userList = new ArrayList<User>();
        for (int i=0;i<20;i++){
            Random r = new Random();
            User user = new User();
            user.name = "Name"+r.nextInt();
            user.description = "Description "+r.nextInt();
            user.id = i;
            user.followed = r.nextBoolean();
            userList.add(user);
        }

        DBHandler userDB = new DBHandler(this);
        for (User user : userList){
            userDB.addUser(user);
        }
    }




}