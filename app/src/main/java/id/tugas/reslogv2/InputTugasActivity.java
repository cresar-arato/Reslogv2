package id.tugas.reslogv2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import id.tugas.reslogv2.model.modelTugas;

import static android.text.TextUtils.isEmpty;

public class InputTugasActivity extends AppCompatActivity {

    // variable yang merefers ke Firebase Realtime Database
    private DatabaseReference database;

    private Button btSave,btKembali;
    private EditText tvmatakuliah;
    private EditText tvdetailtugas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_tugas);

        tvmatakuliah = (EditText) findViewById(R.id.txt_mtKuliah);
        tvdetailtugas = (EditText) findViewById(R.id.txt_detTugas);
        btSave = (Button) findViewById(R.id.btn_simpan);

        // mengambil referensi ke Firebase Database
        database = FirebaseDatabase.getInstance().getReference();

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isEmpty(tvmatakuliah.getText().toString()) && !isEmpty(tvdetailtugas.getText().toString()))
                    submitTugas(new modelTugas(tvmatakuliah.getText().toString(), tvdetailtugas.getText().toString()));
                else
                    Snackbar.make(findViewById(R.id.btn_simpan), "Silahkan Diisi", Snackbar.LENGTH_LONG).show();

                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(
                        tvmatakuliah.getWindowToken(), 0);
            }
        });

    }

    private boolean isEmpty(String s) {
        // Cek apakah ada fields yang kosong, sebelum disubmit
        return TextUtils.isEmpty(s);
    }

    private void updateTugas(modelTugas tugas) {
        /**
         * Baris kode yang digunakan untuk mengupdate data tugas
         * yang sudah dimasukkan di Firebase Realtime Database
         */
        database.child("barang") //akses parent index, ibaratnya seperti nama tabel
                .child(tugas.getKey()) //select barang berdasarkan key
                .setValue(tugas) //set value barang yang baru
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        /**
                         * Baris kode yang akan dipanggil apabila proses update tugas sukses
                         */
                        Snackbar.make(findViewById(R.id.btn_simpan), "Tugas Berhasil diperbaharui", Snackbar.LENGTH_LONG).setAction("Oke", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                finish();
                            }
                        }).show();
                    }
                });
    }

    private void submitTugas(modelTugas tugas) {
        /**
         * Ini adalah kode yang digunakan untuk mengirimkan data ke Firebase Realtime Database
         * dan juga kita set onSuccessListener yang berisi kode yang akan dijalankan
         * ketika data berhasil ditambahkan
         */
        database.child("tugas").push().setValue(tugas).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                tvmatakuliah.setText("");
                tvdetailtugas.setText("");
                Snackbar.make(findViewById(R.id.btn_simpan), "Tugas berhasil ditambahkan", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, InputTugasActivity.class);
    }
}
