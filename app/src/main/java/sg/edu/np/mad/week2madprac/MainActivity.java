package sg.edu.np.mad.week2madprac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<User> data = UserAdapter.data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHandler userDB = new DBHandler(this);

        ToggleButton followbtn = findViewById(R.id.followbtn);
        Button messagebtn = findViewById(R.id.messagebtn);
        TextView iconName = findViewById(R.id.iconName);
        TextView iconDesc = findViewById(R.id.iconDesc);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("name");
        String userDesc = intent.getStringExtra("description");
        Integer position = intent.getIntExtra("position", 0);
        String text = intent.getStringExtra(Intent.EXTRA_TEXT);

        messagebtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent navigateToMG = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(navigateToMG);
            }
        });

        iconName.setText(userName);
        iconDesc.setText(userDesc);
        if(data.get(position).followed){
            followbtn.setText("Unfollow");
        }

        followbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.get(position).followed){
                    data.get(position).followed = false;
                    userDB.updateUser(data.get(position));
                    followbtn.setText("Follow");
                    Toast.makeText(MainActivity.this,"Unfollowed",Toast.LENGTH_SHORT).show();
                }
                else{
                    data.get(position).followed = true;
                    userDB.updateUser(data.get(position));
                    followbtn.setText("Unfollow");
                    Toast.makeText(MainActivity.this,"Followed",Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Creating new user from user class

        // User newUser = new User("Ernest Tan " + text, "For testing purposes, user class imported.", 12345, false);
        // Syncing followed status
        // if (userDB.followed == true){
        //     followbtn.setText("Unfollow");
        //     newUser.followed = false;
        // }
        // else if (userDB.followed == false){
        //     followbtn.setText("Follow");
        //     newUser.followed = true;
        }

        // Syncing name and description
        //iconName.setText(userName);
        //iconDesc.setText(userDesc);

        // Creating follow functions
        // followbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        //     public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //        if (isChecked) {
        //            Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
        //        }
        //        else {
        //            Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
        //        }
        //    }
        //});

    //}
}