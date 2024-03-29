package id.tugas.reslogv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    Button btnKeluar;

    //mematikan tombol kembali
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Silahkan Tekan Tombol Keluar", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnKeluar = findViewById(R.id.btn_Logout);

        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                //Clear Semua Activity, dan memulai Activity baru
                Intent i = new Intent(HomeActivity.this, LoginActivity.class);        // Specify any activity here e.g. home or splash or login etc
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("EXIT", true);
                startActivity(i);
                finish();

                //code dibawah sengaja di disable untuk mencegah re-login tanpa masukan user dan pass
                //FirebaseAuth.getInstance().signOut();
                //Intent intentToMain = new Intent(HomeActivity.this, MainActivity.class);
                //startActivity(intentToMain);
            }
        });
    }
    public void imageClick(View view){
        Intent intenttomenu = new Intent(HomeActivity.this,MenuActivity.class);
        startActivity(intenttomenu);
        finish();
    }
}
