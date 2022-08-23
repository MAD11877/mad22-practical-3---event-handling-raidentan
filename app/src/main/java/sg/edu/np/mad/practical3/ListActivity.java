package sg.edu.np.mad.practical3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView image_icon = findViewById(R.id.image_icon);
        image_icon.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Profile").setMessage("MADness")
                    .setPositiveButton("VIEW", (dialogInterface, i) -> {
                        Intent activityMain = new Intent(this, MainActivity.class);
                        activityMain.putExtra("randomNumber", String.valueOf((new Random()).nextInt(Integer.MAX_VALUE)));
                        startActivity(activityMain);
                    })
                    .setNegativeButton("CLOSE", (dialogInterface, i) -> {

                    });

            AlertDialog alert = builder.create();
            alert.show();
        });
    }
}