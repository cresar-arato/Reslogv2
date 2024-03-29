package id.tugas.reslogv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText IdEmail, katasandi;
    Button btnDaftar;
    TextView tvLogin;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();
        IdEmail = findViewById(R.id.txt_user);
        katasandi = findViewById(R.id.txt_pass);
        btnDaftar = findViewById(R.id.btn_Register);
        tvLogin = findViewById(R.id.txt_Login);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = IdEmail.getText().toString();
                String pass = katasandi.getText().toString();
                //jika email kosong
                if(email.isEmpty()){
                    IdEmail.setError("Masukkan Email Anda");
                    IdEmail.requestFocus();
                }
                //jika email kosong
                else if(pass.isEmpty()) {
                    katasandi.setError("Masukkan Kata Sandi Anda");
                    katasandi.requestFocus();
                }
                //jika email dan pass kosong
                else if(email.isEmpty() && pass.isEmpty()) {
                    Toast.makeText(MainActivity.this,"Silahkan Isi Email dan Kata Sandi Anda",Toast.LENGTH_SHORT).show();
                }
                //jika email dan pass sudah terisi dan request ke firebase
                else if(!(email.isEmpty() && pass.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //jika user telah terdaftar kedalam firebase
                            if(!task.isSuccessful()){
                                Toast.makeText(MainActivity.this,"User Telah Terdaftar",Toast.LENGTH_SHORT).show();
                            }
                            //user dan pass yang belum terdaftar akan didaftarkan ke firebase
                            else {
                                startActivity(new Intent(MainActivity.this,HomeActivity.class));
                            }
                        }
                    });
                }
                //debug error jika semua opsi diatas tidak bisa berfungsi
                else{
                    Toast.makeText(MainActivity.this,"Error!1!1!1",Toast.LENGTH_SHORT).show();
                }
            }
        });
        // dari MainActivity ke LoginActivity
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
