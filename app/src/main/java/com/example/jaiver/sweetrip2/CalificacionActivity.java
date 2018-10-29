package com.example.jaiver.sweetrip2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CalificacionActivity extends AppCompatActivity {

    private TextView mensajeTextView;
    private RatingBar valoracion;
    String valorGuardaIdUserGoogle;
    String value, value2;
    Integer x;
    String calificador;
    String nombreMarcador = "";

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    DatabaseReference sitiosInteres = ref.child(nombreMarcador);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificacion);
        getSupportActionBar().hide();

        String valorGuardaMarkerId = getIntent().getStringExtra("name");
        TextView textViewName = (TextView) findViewById(R.id.textViewName);

        calificador = getIntent().getStringExtra("idUserGoogle");
        //valorGuardaIdUserGoogle = getIntent().getStringExtra("idUserGoogle");
        TextView textViewId = (TextView) findViewById(R.id.textViewIdGoogle);

        textViewName.setText(valorGuardaMarkerId);
        textViewId.setText(valorGuardaIdUserGoogle);

        nombreMarcador= valorGuardaMarkerId;

        mensajeTextView=(TextView) findViewById(R.id.mensajeTextView);
        valoracion=(RatingBar) findViewById(R.id.ratingBar);


    }

    @Override
    protected void onStart(){
        super.onStart();

        sitiosInteres.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                value = String.valueOf(dataSnapshot.child(nombreMarcador).getChildrenCount());
                mensajeTextView.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void calificar(View view){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference sitiosInteres = ref.child(nombreMarcador);
        DatabaseReference valor = sitiosInteres.child(calificador);
        Float mensaje = valoracion.getRating();
        valor.setValue(mensaje);

        onReturn();
    }

    public void onReturn() {
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
        Toast.makeText(this, "Gracias por la calificación", Toast.LENGTH_SHORT).show();
    }

}
