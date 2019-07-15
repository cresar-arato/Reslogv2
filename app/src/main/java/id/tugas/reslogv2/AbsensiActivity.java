package id.tugas.reslogv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class AbsensiActivity extends AppCompatActivity {

    Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absensi);

        Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://siamon.id/kelas.php"));
        startActivity(browserIntent);

        exit = findViewById(R.id.btn_keluar);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentweb = new Intent(AbsensiActivity.this,MenuActivity.class);
                startActivity(intentweb);
            }
        });
    }
}
