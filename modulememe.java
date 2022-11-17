package com.example.memegenerator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class modulememe extends AppCompatActivity {
    ImageView rImage;
    Button up;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulememe);
        rImage = findViewById(R.id.rImage);
        Intent intent = getIntent();
        String query = intent.getStringExtra("query");
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();
        DatabaseReference getImage = databaseReference.child(query);
        getImage.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(rImage);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(modulememe.this,"Error Loading Image",Toast.LENGTH_SHORT).show();
            }
        });
        up=findViewById(R.id.upload);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(modulememe.this,Uploadactivity.class);
                startActivity(i);
            }
        });
    }
}
