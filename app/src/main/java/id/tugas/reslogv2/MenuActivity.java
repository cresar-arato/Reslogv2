package id.tugas.reslogv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

        CardView Tugas=findViewById(R.id.card_tugas);
        Tugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tugas = new Intent(MenuActivity.this,MainTugasActivity.class);
                startActivity(tugas);
            }
        });

        CardView Absensi=findViewById(R.id.card_absensi);
        Absensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent absensi = new Intent(MenuActivity.this,AbsensiActivity.class);
                startActivity(absensi);
            }
        });

        CardView Home=findViewById(R.id.card_home);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(MenuActivity.this,HomeActivity.class);
                startActivity(home);
            }
        });

    }

    //mematikan tombol kembali
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Silahkan Tekan Tombol Keluar", Toast.LENGTH_SHORT).show();
    }
}
