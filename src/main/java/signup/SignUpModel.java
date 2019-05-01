package signup;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SignUpModel {
    private StringProperty errorMailDistinto;
    private StringProperty errorContrasena;
    private StringProperty errorLongitud;
    private StringProperty camposVacios;
    private StringProperty usuario;
    private StringProperty contrasena;
    private StringProperty checkContrasena;
    private StringProperty email;
    private StringProperty checkEmail;
    private ListProperty<String> preguntas;
    private StringProperty respuesta;
    private BooleanProperty nuevoUserPermitido;

    public SignUpModel() {
        errorMailDistinto = new SimpleStringProperty(this, "errorMailDistinto");
        errorContrasena = new SimpleStringProperty(this, "errorContrasena");
        errorLongitud = new SimpleStringProperty(this, "errorLongitud");
        camposVacios = new SimpleStringProperty(this, "camposVacios");
        usuario = new SimpleStringProperty(this, "usuario");
        contrasena = new SimpleStringProperty(this, "contrasena", "");
        checkContrasena = new SimpleStringProperty(this, "checkContrasena", "");
        email = new SimpleStringProperty(this, "email", "");
        checkEmail = new SimpleStringProperty(this, "checkEmail", "");
        preguntas = new SimpleListProperty<>(this, "preguntas", FXCollections.observableArrayList());
        respuesta = new SimpleStringProperty(this, "respuesta");
        nuevoUserPermitido = new SimpleBooleanProperty(this, "nuevoUserPermitido", false);
    }

    public String getCamposVacios() {
        return camposVacios.get();
    }

    public StringProperty camposVaciosProperty() {
        return camposVacios;
    }

    public void setCamposVacios(String camposVacios) {
        this.camposVacios.set(camposVacios);
    }

    public boolean isNuevoUserPermitido() {
        return nuevoUserPermitido.get();
    }

    public BooleanProperty nuevoUserPermitidoProperty() {
        return nuevoUserPermitido;
    }

    public void setNuevoUserPermitido(boolean nuevoUserPermitido) {
        this.nuevoUserPermitido.set(nuevoUserPermitido);
    }

    public String getErrorLongitud() {
        return errorLongitud.get();
    }

    public StringProperty errorLongitudProperty() {
        return errorLongitud;
    }

    public void setErrorLongitud(String errorLongitud) {
        this.errorLongitud.set(errorLongitud);
    }

    public String getErrorMailDistinto() {
        return errorMailDistinto.get();
    }

    public StringProperty errorMailDistintoProperty() {
        return errorMailDistinto;
    }

    public void setErrorMailDistinto(String errorMailDistinto) {
        this.errorMailDistinto.set(errorMailDistinto);
    }

    public String getErrorContrasena() {
        return errorContrasena.get();
    }

    public StringProperty errorContrasenaProperty() {
        return errorContrasena;
    }

    public void setErrorContrasena(String errorContrasena) {
        this.errorContrasena.set(errorContrasena);
    }

    public String getUsuario() {
        return usuario.get();
    }

    public StringProperty usuarioProperty() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario.set(usuario);
    }

    public String getContrasena() {
        return contrasena.get();
    }

    public StringProperty contrasenaProperty() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena.set(contrasena);
    }

    public String getCheckContrasena() {
        return checkContrasena.get();
    }

    public StringProperty checkContrasenaProperty() {
        return checkContrasena;
    }

    public void setCheckContrasena(String checkContrasena) {
        this.checkContrasena.set(checkContrasena);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getCheckEmail() {
        return checkEmail.get();
    }

    public StringProperty checkEmailProperty() {
        return checkEmail;
    }

    public void setCheckEmail(String checkEmail) {
        this.checkEmail.set(checkEmail);
    }

    public ObservableList<String> getPreguntas() {
        return preguntas.get();
    }

    public ListProperty<String> preguntasProperty() {
        return preguntas;
    }

    public void setPreguntas(ObservableList<String> preguntas) {
        this.preguntas.set(preguntas);
    }

    public String getRespuesta() {
        return respuesta.get();
    }

    public StringProperty respuestaProperty() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta.set(respuesta);
    }
}
