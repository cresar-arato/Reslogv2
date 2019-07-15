package id.tugas.reslogv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainTugasActivity extends AppCompatActivity {

    private Button btCreateDB;
    private Button btViewDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tugas);

        btCreateDB = (Button) findViewById(R.id.btn_tambahTugas);
        btViewDB = (Button) findViewById(R.id.btn_lihatTugas);

        btCreateDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(InputTugasActivity.getActIntent(MainTugasActivity.this));
            }
        });

        btViewDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ReadTugasActivity.getActIntent(MainTugasActivity.this));
            }
        });
    }
}
