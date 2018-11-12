package pl.moja.wypozyczalnia;

import java.util.Locale;

import com.sun.javafx.application.LauncherImpl;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.moja.wypozyczalnia.controllers.MainController;
import pl.moja.wypozyczalnia.database.dbuitls.DbManager;
import pl.moja.wypozyczalnia.utils.FillDatabase;
import pl.moja.wypozyczalnia.utils.FxmlUtils;
import pl.splash.screen.MyPreloader;


public class Main extends Application {

    private static final String BORDER_PANE_MAIN_FXML = "/fxml/BorderPaneMain.fxml";
    private static final int COUNT_LIMIT = 10;


    
    public static void main(String[] args) {
    	
    	LauncherImpl.launchApplication(Main.class, MyPreloader.class, args);
      //  launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
    	
    	Locale.setDefault(new Locale("en"));
        Pane borderPane = FxmlUtils.fxmlLoader(BORDER_PANE_MAIN_FXML);
        Scene scene = new Scene(borderPane);
        scene.getStylesheets().add("/CSS/CSS/mycss.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle(FxmlUtils.getResourceBundle().getString("tittle.application"));
        primaryStage.show();

        DbManager.initDatabase();
    //    FillDatabase.fillDatabase(); // w tym miejscu uruchamiam dodatkowy kod, który wypełnia bazę danych
    }
    

    @Override
  public void init() throws Exception {       
      
      // Perform some heavy lifting (i.e. database start, check for application updates, etc. )
      for (int i = 1; i <= COUNT_LIMIT; i++) {
          double progress =(double) i/10;
          System.out.println("progress: " +  progress);            
          LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress));
          Thread.sleep(50);
          
      }
      
    
    }   
    
    
    
    
    
}
