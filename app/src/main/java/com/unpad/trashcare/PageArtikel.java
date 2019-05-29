package com.unpad.trashcare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

public class PageArtikel extends AppCompatActivity {

    TextView tvJudul, tvSumber, tvIsi;
    ImageView ivArtikel;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_artikel);

        tvJudul = findViewById(R.id.tvJudulArt);
        tvSumber = findViewById(R.id.tvSumber);
        tvIsi = findViewById(R.id.tvIsiArt);



        Toolbar toolbar = findViewById(R.id.toolbarPageArtikel);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
