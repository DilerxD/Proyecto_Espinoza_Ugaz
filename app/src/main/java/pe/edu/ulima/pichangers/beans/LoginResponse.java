package pe.edu.ulima.pichangers.beans;

public class LoginResponse {
    private String msg;

    public LoginResponse(String msg) {
        this.msg = msg;
    }

    public LoginResponse() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
