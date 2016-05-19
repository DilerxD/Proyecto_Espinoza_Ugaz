package pe.edu.ulima.pichangers.remote;


import java.util.List;

import pe.edu.ulima.pichangers.beans.LoginResponse;
import pe.edu.ulima.pichangers.beans.LoginUser;
import pe.edu.ulima.pichangers.beans.Equipo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by CARLOS on 13/05/2016.
 */
public interface UsuarioService {
    @POST("alumnos/login")
    Call<LoginResponse> loginUsuario(@Body LoginUser alumno_user);

    @GET("equipos")
    Call<List<Equipo>> obtenerEquipos();

    @GET("equipos/{id}")
    Call<Equipo> mostrarInfo(@Path("id")int id);

}
