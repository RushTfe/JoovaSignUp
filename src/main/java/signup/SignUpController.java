package signup;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanExpression;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController extends BorderPane implements Initializable {

    @FXML
    private BorderPane rootLogin;

    @FXML
    private HBox erroresHbox;

    @FXML
    private Label errorMailDistintoLabel;

    @FXML
    private Label errorContrasenas;

    @FXML
    private Label errorLongitud;

    @FXML
    private Label camposVacios;

    @FXML
    private ScrollPane scrollPaneRoot;

    @FXML
    private VBox textFieldsVbox;

    @FXML
    private TextField userTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField passwordCheck;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField emailCheck;

    @FXML
    private VBox accederVbox;

    @FXML
    private Button crearUsuarioButton;

    @FXML
    private VBox seguridadVbox;

    @FXML
    private ComboBox<String> preguntasComboBox;

    @FXML
    private TextField respuestaTextField;

    //Modelo
    private SignUpModel model;

    public SignUpController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginSignUp.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Modelo
        model = new SignUpModel();

        /*************************************************************
         *
         * Bindings
         *
         *************************************************************/

        model.usuarioProperty().bind(userTextField.textProperty());
        model.contrasenaProperty().bind(passwordTextField.textProperty());
        model.checkContrasenaProperty().bind(passwordCheck.textProperty());
        model.emailProperty().bind(emailTextField.textProperty());
        model.checkEmailProperty().bind(emailCheck.textProperty());
        model.respuestaProperty().bind(respuestaTextField.textProperty());
        preguntasComboBox.itemsProperty().bind(model.preguntasProperty());

        // Errores
        errorMailDistintoLabel.textProperty().bind(model.errorMailDistintoProperty());
        errorContrasenas.textProperty().bind(model.errorContrasenaProperty());
        errorLongitud.textProperty().bind(model.errorLongitudProperty());
        camposVacios.textProperty().bind(model.camposVaciosProperty());

        //Dando valor a los errores
        model.setErrorMailDistinto("Los email no coinciden, por favor reviselos");
        model.setErrorContrasena("Las contraenas no coinciden, reviselas por favor");
        model.setErrorLongitud("La contrasena debe contener mas de 4 letras");
        model.setCamposVacios("No puedes dejar campos sin rellenar");

        //Error en el que los dos correos no coinciden
        BooleanExpression correosNoIguales = Bindings.when(model.emailProperty().isNotEqualTo(model.checkEmailProperty())).then(true).otherwise(false);
        errorMailDistintoLabel.visibleProperty().bind(correosNoIguales);
        errorMailDistintoLabel.managedProperty().bind(correosNoIguales);

        //Error en el que las dos password no coinciden
        BooleanExpression passwordNoIguales = Bindings.when(model.contrasenaProperty().isNotEqualTo(model.checkContrasenaProperty())).then(true).otherwise(false);
        errorContrasenas.visibleProperty().bind(passwordNoIguales);
        errorContrasenas.managedProperty().bind(passwordNoIguales);

        //Error la contrasena tiene menos de 4 letras
        BooleanExpression longitudPassMenor = Bindings.when(model.contrasenaProperty().length().lessThan(4)).then(true).otherwise(false);
        errorLongitud.managedProperty().bind(longitudPassMenor);
        errorLongitud.visibleProperty().bind(longitudPassMenor);

        //Error campos vacios
        BooleanExpression camposExpr = Bindings.when(model.usuarioProperty().length().lessThan(1).or(model.contrasenaProperty().length().lessThan(1).or(model.checkContrasenaProperty().length().lessThan(1).or(model.emailProperty().length().lessThan(1).or(model.checkEmailProperty().length().lessThan(1).or(model.respuestaProperty().length().lessThan(1))))))).then(true).otherwise(false);
        camposVacios.visibleProperty().bind(camposExpr);
        camposVacios.managedProperty().bind(camposExpr);

        //Bindeamos los errores a el booleano de creacion. Solo cuando todos los errores esten resueltos, este se pondra a true.
        model.nuevoUserPermitidoProperty().bind(Bindings.when(longitudPassMenor.or(passwordNoIguales).or(correosNoIguales).or(camposExpr)).then(true).otherwise(false));

        //Combobox de preguntas.
        model.getPreguntas().addAll("¿Cuál fue tu primer animal?", "¿Como se llama tu padre?", "Cuál es tu libro favorito?");
        preguntasComboBox.getSelectionModel().selectFirst();


    }

    public SignUpModel getModel() {
        return model;
    }
}
