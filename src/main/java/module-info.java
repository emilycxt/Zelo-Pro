module zelo.pro {

    requires javafx.controls;
    requires javafx.fxml;
    

    requires java.sql;

    opens com.dev.emilycxt.app to javafx.graphics, javafx.fxml;
    
    exports com.dev.emilycxt.app;
}