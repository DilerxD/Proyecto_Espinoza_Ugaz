package pe.edu.ulima.pichangers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import java.util.List;

import pe.edu.ulima.pichangers.adapters.ListaEquiposAdapter;
import pe.edu.ulima.pichangers.beans.Equipo;
import pe.edu.ulima.pichangers.mostarequipos.MostrarEquiposPresenter;
import pe.edu.ulima.pichangers.mostarequipos.MostrarEquiposPresenterImpl;
import pe.edu.ulima.pichangers.mostarequipos.MostrarEquiposView;

public class ListaEquipos extends AppCompatActivity implements MostrarEquiposView {

    MostrarEquiposPresenter mPresenter;
    GridView gridView;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_equipos);

        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            this.getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        gridView = (GridView)findViewById(R.id.gridview);
        setPresenter(new MostrarEquiposPresenterImpl(this));
        mPresenter.obtenerEquipos();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void setPresenter(MostrarEquiposPresenter presenter) {
        this.mPresenter=presenter;
    }

    @Override
    public void mostrarEquipos(List<Equipo> equipos) {
        ListaEquiposAdapter adapter = new ListaEquiposAdapter(this,equipos);
        gridView.setAdapter(adapter);
    }


    public void mostrarInfo(View view){

        Intent intent = new Intent(this,InformacionEnquipo.class);
        startActivity(intent);
    }

    public void agregarJugador(View view){
        Toast.makeText(this, "", Toast.LENGTH_LONG).show();
    }


}
