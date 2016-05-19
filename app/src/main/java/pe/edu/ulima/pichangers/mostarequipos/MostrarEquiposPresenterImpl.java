package pe.edu.ulima.pichangers.mostarequipos;

import android.util.Log;

import java.util.List;

import pe.edu.ulima.pichangers.beans.Equipo;
import pe.edu.ulima.pichangers.remote.UsuarioService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CARLOS on 13/05/2016.
 */
public class MostrarEquiposPresenterImpl implements MostrarEquiposPresenter{
    String id;
    MostrarEquiposView mView;
    Equipo team;

    public MostrarEquiposPresenterImpl(MostrarEquiposView view){
        mView=view;
    }

    @Override
    public void obtenerEquipos() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://1-dot-pichangers-1307.appspot.com/rest/").addConverterFactory(GsonConverterFactory.create())
                .build();

        UsuarioService service = retrofit.create(UsuarioService.class);
        service.obtenerEquipos().enqueue(new Callback<List<Equipo>>() {
            @Override
            public void onResponse(Call<List<Equipo>> call, Response<List<Equipo>> response) {
                    List<Equipo> equipos = response.body();
                    mView.mostrarEquipos(equipos);

            }

            @Override
            public void onFailure(Call<List<Equipo>> call, Throwable t) {
                    Log.e("Pichangers",t.getMessage());
            }
        });

    }
}
