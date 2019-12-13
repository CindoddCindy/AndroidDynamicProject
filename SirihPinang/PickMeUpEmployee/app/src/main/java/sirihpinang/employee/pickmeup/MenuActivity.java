package sirihpinang.employee.pickmeup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;

import com.ramotion.circlemenu.CircleMenuView;

public class MenuActivity extends AppCompatActivity {

    public ImageView imageView_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        imageView_location=findViewById(R.id.location);
        imageView_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });


    }


}
