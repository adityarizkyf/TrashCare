package com.unpad.trashcare;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class ProfileActivity extends AppCompatActivity {


    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String idUser;
    TextView dispNama, dispAlamat, dispPhone, dispEmail;

    private DatabaseReference databaseReference;

    public static  final  String COLLECTION_NAME_KEY = "warga";
    public static  final  String USERNAME_KEY = "nama";
    public static  final  String ADDRESS_KEY = "alamat";
    public static  final  String PHONE_KEY = "no_telp";
    public static  final  String EMAIL_KEY = "email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView textNoTelp = findViewById(R.id.noTelp);
        final String TAG = ProfileActivity.class.getSimpleName();

        Toolbar toolbar = findViewById(R.id.toolbarProfil);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        idUser = getSharedPreferences("id", MODE_PRIVATE).getString("userId", "0");
        dispNama = findViewById(R.id.tvNama);
        dispAlamat = findViewById(R.id.tvAlamat);
        dispPhone = findViewById(R.id.noTelp);
        dispEmail = findViewById(R.id.tvEmail);

        DocumentReference docRef = db.collection(COLLECTION_NAME_KEY).document(idUser);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    StringBuilder fields1 = new StringBuilder("");
                    StringBuilder fields2 = new StringBuilder("");
                    StringBuilder fields3 = new StringBuilder("");
                    StringBuilder fields4 = new StringBuilder("");
                    fields1.append(doc.get("nama"));
                    fields2.append(doc.get("alamat"));
                    fields3.append(doc.get("no_telp"));
                    fields4.append(doc.get("email"));
                    dispNama.setText(fields1.toString());
                    dispAlamat.setText(fields2.toString());
                    dispPhone.setText(fields3.toString());
                    dispEmail.setText(fields4.toString());
                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });

     /*    DocumentReference docRef = db.collection("warga").document("SF");
       docRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Log.d(TAG, document.getId() + " => " + document.getData());
                        }
                    } else {
                        Log.w(TAG, "Error getting documents.", task.getException());
                    }

                }
            }

        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }*/
    }
}
