module com.closednotes.proctr {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.desktop;


    opens com.closednotes.proctr to javafx.fxml;
    exports com.closednotes.proctr;
    exports com.closednotes.proctr.objects;
    opens com.closednotes.proctr.objects to javafx.fxml;
    exports com.closednotes.proctr.objects.enemy;
    opens com.closednotes.proctr.objects.enemy to javafx.fxml;
    exports com.closednotes.proctr.objects.enemy.variants;
    opens com.closednotes.proctr.objects.enemy.variants to javafx.fxml;
    exports com.closednotes.proctr.objects.map;
    opens com.closednotes.proctr.objects.map to javafx.fxml;
    exports com.closednotes.proctr.objects.tower;
    opens com.closednotes.proctr.objects.tower to javafx.fxml;
}
