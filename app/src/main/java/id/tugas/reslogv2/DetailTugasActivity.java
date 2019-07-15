package id.tugas.reslogv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import id.tugas.reslogv2.model.modelTugas;

public class DetailTugasActivity extends AppCompatActivity {

    private Button btSave;
    private EditText tvmatakuliah;
    private EditText tvdetailtugas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_tugas);
        tvmatakuliah = findViewById(R.id.txt_mtKuliah);
        tvdetailtugas = findViewById(R.id.txt_detTugas);
        btSave = findViewById(R.id.btn_simpan);

        tvmatakuliah.setEnabled(false);
        tvdetailtugas.setEnabled(false);
        btSave.setVisibility(View.GONE);

        modelTugas tugas = (modelTugas) getIntent().getSerializableExtra("data");
        if(tugas!=null){
            tvmatakuliah.setText(tugas.getMatakuliah());
            tvdetailtugas.setText(tugas.getDetailtugas());
        }
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, DetailTugasActivity.class);
    }
}
