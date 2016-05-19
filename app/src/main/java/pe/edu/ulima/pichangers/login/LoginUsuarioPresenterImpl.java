package pe.edu.ulima.pichangers.login;

import android.content.Context;
import android.util.Log;

import com.google.gson.annotations.SerializedName;

import pe.edu.ulima.pichangers.beans.LoginResponse;
import pe.edu.ulima.pichangers.beans.LoginUser;
import pe.edu.ulima.pichangers.remote.UsuarioService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CARLOS on 13/05/2016.
 */
public class LoginUsuarioPresenterImpl implements LoginUsuarioPresenter {
    @SerializedName("msg")
    String msg;
    Context context;
    LoginPase mPase;

    public LoginUsuarioPresenterImpl(LoginPase pase) {
        mPase = pase;
    }

    public void loginUsuario(final LoginUser alumno_user) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://1-dot-pichangers-1307.appspot.com/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final UsuarioService service = retrofit.create(UsuarioService.class);

        service.loginUsuario(alumno_user).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call call, Response response) {

                msg = ((LoginResponse) response.body()).getMsg();

                if ("ok".equalsIgnoreCase(msg)) {
                    mPase.loginCorrecto();
                } else {
                    mPase.loginIncorrecto();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("Pichangers", t.getMessage());

            }
        });
    }


}
