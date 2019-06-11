/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ycodedictionary;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 *
 * @author YCODE
 */
public class DictionaryFormController implements Initializable {

    @FXML
    private ListView<String> listView;
    @FXML
    private Button kk;
    @FXML
    private Button ke;
    @FXML
    private Button ek;
    @FXML
    private Button ee;
    @FXML
    private Button pv;
    @FXML
    private Button pc;
    @FXML
    private TextField txtSearch;

    ObservableList list = FXCollections.observableArrayList();

    TreeMap<String, String> data;
    @FXML
    private TextFlow textDifinition;
    @FXML
    private Label lbl1;
    @FXML
    private VBox title1;
    @FXML
    private Button ac;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setBtnDictStyle();
        kk.setStyle("-fx-background-color:#AA00FF;-fx-background-radius:  20 0 0 20;");
        title1.setStyle("-fx-background-color:#AA00FF ;-fx-background-radius: 100");

        data = new KkDict().setData();
        txtSearch.setPromptText("ពាក្យមាន " + data.size());
        textDifinition.getChildren().clear();
        //data loaded in initAllData()
        for (Map.Entry m : data.entrySet()) {
            list.add(m.getKey());
        }
        listView.setItems(list);
    }

    @FXML
    private void kkClick(MouseEvent event) {
        setBtnDictStyle();
        reset();
        kk.setStyle("-fx-background-color:#AA00FF;-fx-background-radius:  20 0 0 20;");
        title1.setStyle("-fx-background-color:#AA00FF ;-fx-background-radius: 100");
        list.clear();
        data.clear();
        data = new KkDict().setData();
        for (Map.Entry m : data.entrySet()) {
            list.add(m.getKey());
        }
        listView.setItems(list);
        txtSearch.setPromptText("ពាក្យមាន " + data.size());
    }

    @FXML
    private void keClick(MouseEvent event) {
        reset();
        setBtnDictStyle();
        ke.setStyle("-fx-background-color:orange;-fx-background-radius: 0;");
        title1.setStyle("-fx-background-color:orange ;-fx-background-radius: 100");
        list.clear();
        data.clear();
        data = new KeDict().setKeData();
        for (Map.Entry m : data.entrySet()) {
            list.add(m.getKey());
        }
        listView.setItems(list);
        txtSearch.setPromptText("ពាក្យមាន " + data.size());
    }

    @FXML
    private void ekClick(MouseEvent event) {
        setBtnDictStyle();
        ek.setStyle("-fx-background-color:#00796B;-fx-background-radius: 0;");
        title1.setStyle("-fx-background-color:#00796B ;-fx-background-radius: 100");

    }

    @FXML
    private void eeClick(MouseEvent event) {
        setBtnDictStyle();
        ee.setStyle("-fx-background-color:#FF1744;-fx-background-radius: 0;");
        title1.setStyle("-fx-background-color:#FF1744 ;-fx-background-radius: 100");
    }

    @FXML
    private void pvClick(MouseEvent event) {
        setBtnDictStyle();
        pv.setStyle("-fx-background-color:#01579B;-fx-background-radius:  0;");
        title1.setStyle("-fx-background-color:#01579B ;-fx-background-radius: 100");
    }

    @FXML
    private void pcClick(MouseEvent event) {
        reset();
        setBtnDictStyle();
        pc.setStyle("-fx-background-color:#880E4F;-fx-background-radius:  0");
        title1.setStyle("-fx-background-color:#880E4F ;-fx-background-radius: 100");
        list.clear();
        data.clear();
        data = new PcDict().setData();
        for (Map.Entry m : data.entrySet()) {
            list.add(m.getKey());
        }
        listView.setItems(list);
        txtSearch.setPromptText("ពាក្យមាន " + data.size());
    }

    @FXML
    private void acClick(MouseEvent event) {
        reset();
        setBtnDictStyle();
        ac.setStyle("-fx-background-color:#581845;-fx-background-radius:  0");
        ac.setStyle("-fx-background-color:#581845 ;-fx-background-radius: 0 20 20 0");
        title1.setStyle("-fx-background-color:#581845 ;-fx-background-radius: 100");
        list.clear();
        data.clear();
        data = new AcDict().setData();
        for (Map.Entry m : data.entrySet()) {
            list.add(m.getKey());
        }
        listView.setItems(list);
        txtSearch.setPromptText("ពាក្យមាន " + data.size());
    }

    private void setBtnDictStyle() {
        kk.setStyle("-fx-background-radius:  20 0 0 20;");
        ke.setStyle(" -fx-background-radius: 0;");
        ek.setStyle("-fx-background-radius: 0;");
        ee.setStyle("-fx-background-radius: 0;");
        pv.setStyle("-fx-background-radius:  0;");
        pc.setStyle("-fx-background-radius:  0;");
        ac.setStyle("-fx-background-radius:  0 20 20 0;");
    }

    @FXML
    private void txtSearchClick(KeyEvent event) {
        String text = txtSearch.getText().trim().toLowerCase();
        if (!txtSearch.getText().trim().isEmpty()) {

            for (int i = 0; i < list.size(); i++) {
                String val = list.get(i) + "";
                val = val.toLowerCase();
                if (val.startsWith(text)) {
                    listView.getSelectionModel().select(i);
                    listView.scrollTo(i);
                    showDifinition();
                    return;
                }
                lbl1.setText("គ្មានទិន្នន័យ");
                textDifinition.getChildren().clear();
                listView.getSelectionModel().clearSelection();
                listView.scrollTo(0);
            }
        } else {
            reset();
        }
    }

    @FXML
    private void listClick(MouseEvent event) {
        if (listView.getSelectionModel().getSelectedIndex() >= 0) {
            txtSearch.setText(listView.getSelectionModel().getSelectedItem());
            showDifinition();
        }
    }

    private void showDifinition() {
        textDifinition.getChildren().setAll(new Text(listView.getSelectionModel().getSelectedItem() + data.get(listView.getSelectionModel().getSelectedItem())));
        lbl1.setText("ន័យនៃពាក្យ");
    }

    @FXML
    private void clearClick(MouseEvent event) {
        reset();
    }

    private void reset() {
        listView.scrollTo(0);
        listView.getSelectionModel().clearSelection();
        txtSearch.setText("");
        lbl1.setText("គ្មានទិន្នន័យ");
        textDifinition.getChildren().clear();
    }

}
