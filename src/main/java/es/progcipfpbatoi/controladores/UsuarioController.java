package es.progcipfpbatoi.controladores;

import es.progcipfpbatoi.exceptions.ContrasenyaNoValida;
import es.progcipfpbatoi.modelo.entidades.Usuario;
import es.progcipfpbatoi.modelo.repositorios.InMemoryUsuariosRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class UsuarioController {

    private InMemoryUsuariosRepository inMemoryUsuariosRepository;

    @FXML
    private ListView<Usuario> listaUsuarios;

    @FXML
    private TextField nombre;

    @FXML
    private TextField apellidos;

    @FXML
    private TextField email;

    @FXML
    private TextField telefono;

    @FXML
    private TextField Dni;

    @FXML
    private DatePicker birthday;

    @FXML
    private TextField codPostal;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField repetirPassword;

    @FXML
    private TextField buscarUsuario;

    public UsuarioController(InMemoryUsuariosRepository inMemoryUsuariosRepository) {
        this.inMemoryUsuariosRepository = inMemoryUsuariosRepository;
        this.listaUsuarios = new ListView<>();
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listaUsuarios.setItems( getData() );
    }


    private ObservableList<Usuario> getData() {
        return FXCollections.observableArrayList( this.inMemoryUsuariosRepository.findAll() );
        // ListView no trabaja con ArrayList solo con ObservableList
    }


    @FXML
    private void anyadirUsuario() {
        try {
            if (!(password.getText().equals(repetirPassword.getText()))) {
                throw new ContrasenyaNoValida();
            }
            Usuario usuario = new Usuario(nombre.getText(), apellidos.getText(), Dni.getText(), email.getText(), codPostal.getText(), telefono.getText(), birthday.getValue(), password.getText());
            if (this.inMemoryUsuariosRepository.guardarUsuario(usuario)) {
                this.listaUsuarios.getItems().add(usuario);
                nombre.setText("");
                apellidos.setText("");
                Dni.setText("");
                email.setText("");
                codPostal.setText("");
                telefono.setText("");
                birthday.cancelEdit();
                password.setText("");
                repetirPassword.setText("");
            }
        } catch (ContrasenyaNoValida e1) {
            System.out.println(e1.getMessage());
        }
    }

    @FXML
    private void buscarUsuario() {
        this.inMemoryUsuariosRepository.find(this.buscarUsuario.getText());
        this.listaUsuarios.setItems(FXCollections.observableList(this.inMemoryUsuariosRepository.find(this.buscarUsuario.getText())));
    }

    @FXML
    private void verDetalles() {
        Usuario usuario = listaUsuarios.getSelectionModel().getSelectedItem();

        this.nombre.setText(usuario.getNombre());
        this.apellidos.setText(usuario.getApellidos());
        this.Dni.setText(usuario.getDni());
        this.email.setText(usuario.getCorreoElectronico());
        this.telefono.setText(usuario.getTelefono());
        this.birthday.setValue(usuario.getBirthday());
        this.codPostal.setText(usuario.getCodigoPostal());
        this.password.setText(usuario.getPassword());
        this.repetirPassword.setText(usuario.getPassword());
    }
}
