package sg.edu.np.mad.week2madprac;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView userName, userDesc;
    ImageView userPic;
    ConstraintLayout userItem;
    public UserViewHolder(View View){
        super (View);
        userName = View.findViewById(R.id.userName);
        userDesc = View.findViewById(R.id.userDesc);
        userPic = View.findViewById(R.id.userPic);
        userItem = View.findViewById(R.id.userItem);
    }
}
