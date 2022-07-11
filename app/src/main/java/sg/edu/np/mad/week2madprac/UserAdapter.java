package sg.edu.np.mad.week2madprac;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder>{
    public static ArrayList<User> data;
    public UserAdapter(ArrayList<User> input) { data = input;}

    @Override
    public int getItemViewType(int position) {
        Character lastDigit = ((data.get(position).name).charAt((data.get(position).name).length() - 1)); //get last character
        if (lastDigit == '7'){
            return 1;
        }
        else{
            return 0;
        }
    } // 1 returns big layout since the last digit ends with '7', otherwise it would be using a normal layout

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = null;
        if(viewType == 1){
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row_layout_big,parent,false);
        }
        else{
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row_layout,parent,false);
        }
        return new UserViewHolder(item);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = data.get(position);
        holder.userName.setText(user.name);
        holder.userDesc.setText(user.description);
        holder.userItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.userItem.getContext());
                builder.setTitle("Profile");
                builder.setMessage(user.name);
                builder.setCancelable(false);
                // Setting button to view user
                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Random r = new Random();
                        Intent i = new Intent(holder.userItem.getContext(),MainActivity.class);
                        i.putExtra("name",holder.userName.getText().toString());
                        i.putExtra("description",holder.userDesc.getText().toString());
                        i.putExtra("position",holder.getAdapterPosition());

                        holder.userItem.getContext().startActivity(i);
                    }
                });
                // Setting button to close dialog
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){

                    }
                });
                builder.show();
            }
        });
    }

    public int getItemCount() {
        return data.size();
    }
}

