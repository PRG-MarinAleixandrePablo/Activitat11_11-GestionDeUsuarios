package es.progcipfpbatoi;

import es.progcipfpbatoi.controladores.UsuarioController;
import es.progcipfpbatoi.modelo.repositorios.InMemoryUsuariosRepository;
import es.progcipfpbatoi.modelo.repositorios.UsuariosRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        InMemoryUsuariosRepository InMemoryUsuariosRepository = new InMemoryUsuariosRepository();
        UsuarioController userController = new UsuarioController( InMemoryUsuariosRepository );

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation( getClass().getResource( "/vistas/gestion_usuarios.fxml" ) );
        loader.setController( userController );

        AnchorPane rootLayout = loader.load();
        stage.setScene( new Scene( rootLayout ) );
        stage.setResizable( false );
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

