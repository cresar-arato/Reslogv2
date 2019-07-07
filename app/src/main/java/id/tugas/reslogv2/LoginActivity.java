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
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    EditText IdEmail, katasandi;
    Button btnMasuk;
    TextView tvDaftar;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        IdEmail = findViewById(R.id.txt_user);
        katasandi = findViewById(R.id.txt_pass);
        btnMasuk = findViewById(R.id.btn_Login);
        tvDaftar = findViewById(R.id.txt_Daftar);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if(mFirebaseUser != null){
                    Toast.makeText(LoginActivity.this,"Anda Berhasil Login",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(LoginActivity.this,"Silahkan Login",Toast.LENGTH_SHORT).show();
                }
            }
        };

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = IdEmail.getText().toString();
                String pass = katasandi.getText().toString();
                if(email.isEmpty()){
                    IdEmail.setError("Masukkan Email Anda");
                    IdEmail.requestFocus();
                }
                else if(pass.isEmpty()) {
                    katasandi.setError("Masukkan Kata Sandi Anda");
                    katasandi.requestFocus();
                }
                else if(email.isEmpty() && pass.isEmpty()) {
                    Toast.makeText(LoginActivity.this,"Silahkan Isi Email dan Kata Sandi Anda",Toast.LENGTH_SHORT).show();
                }
                else if(!(email.isEmpty() && pass.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this,"Login Gagal, Silahkan Coba Lagi",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Intent intentToHome = new Intent(LoginActivity.this,HomeActivity.class);
                            startActivity(intentToHome);
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(LoginActivity.this,"Error!1!1!1",Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentdaftar = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intentdaftar);
            }
        });
    }

    @Override
    protected void onStart(){
    super.onStart();
    mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
