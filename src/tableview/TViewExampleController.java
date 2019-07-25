
package tableview;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TViewExampleController implements Initializable {

    @FXML
    private TableView<Person> dataTable;
    @FXML
    private TextField tName;
    @FXML
    private TextField tPhone;
    @FXML
    private TableColumn<Person, String> nameColumn;
    @FXML
    private TableColumn<Person, String> phoneColumn;
    
    private ObservableList<Person> dataList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dataList = FXCollections.observableArrayList();
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
    }

    @FXML
    private void addData(ActionEvent event) {
        String name = tName.getText();
        String phone = tPhone.getText();
        Person p = new Person(name, phone);
        dataTable.getItems().add(p);
    }

    @FXML
    private void removeData(ActionEvent event) {
        Person p = dataTable.getSelectionModel().getSelectedItem();
        dataTable.getItems().remove(p);
    }

    @FXML
    private void readData(ActionEvent event) {
        dataList.clear();
        for (int i = 0; i < dataTable.getItems().size(); i++) {
            Person p = new Person();
            p = dataTable.getItems().get(i);
            dataList.add(p);
        }
        dataList.forEach((p) -> {
            System.out.println(p.toString());
        });
    }

}
