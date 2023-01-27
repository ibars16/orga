package com.example.orga;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class PuntuacioActivity extends AppCompatActivity {

    private GestorBDPartida gbdRest = new GestorBDPartida(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.list_view_puntuacio);

        ArrayList<Ronda> rondas = gbdRest.getRondes();
        TextView title = (TextView) findViewById(R.id.textViewPunHist);
        title.setText("Puntuació");

        ListView incidenciasMostrar = (ListView) findViewById(R.id.list);

        PuntuacioAdapter incidenciasAdapter = new PuntuacioAdapter(PuntuacioActivity.this, rondas);
        incidenciasMostrar.setAdapter(incidenciasAdapter);

        Button reiniciarPuntuacio = (Button)findViewById(R.id.reiniciarPuntuacio);

        reiniciarPuntuacio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gbdRest.eliminarRondes();
                gbdRest.getPanatalles();
                Intent i = new Intent(PuntuacioActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        incidenciasMostrar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                lanzarModificarEstadoIncidencia(null, position);
            }
        });

    }

    public void lanzarModificarEstadoIncidencia(View view, int id) {
        Intent i = new Intent(this, MostrarInformacio.class);
        i.putExtra("id", String.valueOf(id));
        startActivity(i);
    }
}
