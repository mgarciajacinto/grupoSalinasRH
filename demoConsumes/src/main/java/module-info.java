module com.exam.test.democonsumes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.exam.test.democonsumes to javafx.fxml;
    exports com.exam.test.democonsumes;
}