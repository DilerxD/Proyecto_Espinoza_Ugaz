package pe.edu.ulima.pichangers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pe.edu.ulima.pichangers.beans.LoginUser;
import pe.edu.ulima.pichangers.login.LoginPase;
import pe.edu.ulima.pichangers.login.LoginUsuarioPresenter;
import pe.edu.ulima.pichangers.login.LoginUsuarioPresenterImpl;


public class LoginActivity extends AppCompatActivity implements LoginPase {

    EditText eteUsuario;
    EditText etePassword;
    LoginUsuarioPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eteUsuario = (EditText)findViewById(R.id.etUsuario);
        etePassword = (EditText)findViewById(R.id.etPassword);
    }

    @Override
    public void setPresenter(LoginUsuarioPresenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void loginCorrecto() {
        Toast.makeText(this, "Exito :) !", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,ListaEquipos.class);
        startActivity(intent);
    }
    
    @Override
    public void loginIncorrecto() {
        Toast.makeText(this, "La contraseña o el usuario es incorrecto", Toast.LENGTH_LONG).show();
    }

    public void loginAlumnoClick(View view){

        LoginUser alumno_user = new LoginUser(
                eteUsuario.getText().toString(),
                etePassword.getText().toString()
        );
        setPresenter(new LoginUsuarioPresenterImpl(this));
        presenter.loginUsuario(alumno_user);

    }


}
