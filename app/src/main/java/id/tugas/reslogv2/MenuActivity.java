package id.tugas.reslogv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        CardView jadwalKuliah=findViewById(R.id.card_jdwl_kuliah);
        jadwalKuliah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jadwalkuliah = new Intent(MenuActivity.this,JadwalKuliahActivity.class);
                startActivity(jadwalkuliah);
            }
        });


    }
}
