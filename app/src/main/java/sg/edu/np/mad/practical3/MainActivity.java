package sg.edu.np.mad.practical3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent receivingEnd = getIntent();

        User user = new User();

        user.name = String.format("MAD %s", receivingEnd.getStringExtra("randomNumber"));
        user.followed = false;
        user.description = "Lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

        TextView name = findViewById(R.id.name);
        TextView description = findViewById(R.id.description);

        name.setText(user.name);
        description.setText(user.description);

        Button buttonFollow = findViewById(R.id.button_follow);
        buttonFollow.setOnClickListener(view -> {
            if (!user.followed) {
                buttonFollow.setText("UNFOLLOW");
                Toast.makeText(this, "Followed", Toast.LENGTH_SHORT).show();
            } else {
                buttonFollow.setText("FOLLOW");
                Toast.makeText(this, "Unfollowed", Toast.LENGTH_SHORT).show();
            }

            user.followed = !user.followed;
        });

        Button buttonMessage = findViewById(R.id.button_message);
        buttonMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityMessageGroup = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(activityMessageGroup);
            }
        });

    }

}