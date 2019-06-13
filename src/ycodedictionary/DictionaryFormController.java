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
import ycodedictionary.animate.Shake;
import ycodedictionary.data.AcDict;
import ycodedictionary.data.ElDict;
import ycodedictionary.data.LanDict;
import ycodedictionary.data.MathDict;
import ycodedictionary.data.PcDict;
import ycodedictionary.data.StDict;

/**
 * FXML Controller class
 *
 * @author YCODE
 */
public class DictionaryFormController implements Initializable {

    @FXML
    private ListView<String> listView;
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
    @FXML
    private VBox title2;
    @FXML
    private Button math;
    @FXML
    private Button st;
    @FXML
    private Button el;
    @FXML
    private Button lan;
    @FXML
    private Button pc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setBtnDictStyle();
        lan.setStyle("-fx-background-color:orange;-fx-background-radius:  20 0 0 20;");
        title1.setStyle("-fx-background-color:#AA00FF ;-fx-background-radius: 100");
        data = new LanDict().setData();
        txtSearch.setPromptText("មានចំនួន" + data.size() + "ពាក្យ");
        textDifinition.getChildren().clear();
        for (Map.Entry m : data.entrySet()) {
            list.add(m.getKey());
        }
        listView.setItems(list);
        listView.scrollTo(0);
    }

    @FXML
    private void pcClick(MouseEvent event) {
        list.clear();
        data.clear();
        setBtnDictStyle();
        pc.setStyle("-fx-background-color:#880E4F;-fx-background-radius:  0");
        title1.setStyle("-fx-background-color:#880E4F ;-fx-background-radius: 100");
        data = new PcDict().setData();
        for (Map.Entry m : data.entrySet()) {
            list.add(m.getKey());
        }
        listView.setItems(list);
        reset();
        txtSearch.setPromptText("មានចំនួន" + data.size() + "ពាក្យ");
    }

    @FXML
    private void acClick(MouseEvent event) {
        list.clear();
        data.clear();
        setBtnDictStyle();
        ac.setStyle("-fx-background-color:blue;-fx-background-radius: 0 20 20 0");
        title1.setStyle("-fx-background-color:blue;-fx-background-radius: 100");
        data = new AcDict().setData();
        for (Map.Entry m : data.entrySet()) {
            list.add(m.getKey());
        }
        listView.setItems(list);
        reset();
        txtSearch.setPromptText("មានចំនួន" + data.size() + "ពាក្យ");
    }

    private void setBtnDictStyle() {
        lan.setStyle("-fx-background-radius:  20 0 0 20;");
        el.setStyle("-fx-background-radius: 0;");
        math.setStyle("-fx-background-radius: 0;");
        st.setStyle("-fx-background-radius:  0;");
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

                textDifinition.getChildren().clear();
                listView.getSelectionModel().clearSelection();
                listView.scrollTo(0);

            }
        } else {
            reset();
        }
        new Shake(title1).play();
    }

    @FXML
    private void listClick(MouseEvent event) {
        if (listView.getSelectionModel().getSelectedIndex() >= 0) {
            txtSearch.setText(listView.getSelectionModel().getSelectedItem());
            showDifinition();
            new Shake(title1).play();
        }
    }

    private void showDifinition() {
        textDifinition.getChildren().setAll(new Text(listView.getSelectionModel().getSelectedItem() + data.get(listView.getSelectionModel().getSelectedItem())));
        new Shake(title1).play();

    }

    @FXML
    private void clearClick(MouseEvent event) {
        reset();
    }

    private void reset() {
        listView.scrollTo(0);
        listView.getSelectionModel().clearSelection();
        txtSearch.setText("");
        textDifinition.getChildren().clear();
        new Shake(title1).play();
    }

    @FXML
    private void mouseEnterAbout(MouseEvent event) {
        new Shake(title2).play();
    }

    @FXML
    private void mathClick(MouseEvent event) {
        list.clear();
        data.clear();
        reset();
        setBtnDictStyle();
        math.setStyle("-fx-background-color:#FF1744;-fx-background-radius: 0;");
        title1.setStyle("-fx-background-color:#FF1744 ;-fx-background-radius: 100");
        new Shake(title1).play();
        data = new MathDict().setData();
        for (Map.Entry m : data.entrySet()) {
            list.add(m.getKey());
        }
        listView.setItems(list);
        reset();
        txtSearch.setPromptText("មានចំនួន" + data.size() + "ពាក្យ");
    }

    @FXML
    private void stClick(MouseEvent event) {
        list.clear();
        data.clear();
        reset();
        setBtnDictStyle();
        st.setStyle("-fx-background-color:#01579B;-fx-background-radius:  0;");
        title1.setStyle("-fx-background-color:#01579B ;-fx-background-radius: 100");
        new Shake(title1).play();
        data = new StDict().setData();
        for (Map.Entry m : data.entrySet()) {
            list.add(m.getKey());
        }
        listView.setItems(list);
        reset();
        txtSearch.setPromptText("មានចំនួន" + data.size() + "ពាក្យ");
    }

    @FXML
    private void elClick(MouseEvent event) {
        list.clear();
        data.clear();
        reset();
        setBtnDictStyle();
        el.setStyle("-fx-background-color:#00796B;-fx-background-radius: 0;");
        title1.setStyle("-fx-background-color:#00796B ;-fx-background-radius: 100");
        new Shake(title1).play();
        data = new ElDict().setData();
        for (Map.Entry m : data.entrySet()) {
            list.add(m.getKey());
        }
        listView.setItems(list);
        reset();
        txtSearch.setPromptText("មានចំនួន" + data.size() + "ពាក្យ");
    }

    @FXML
    private void LanClick(MouseEvent event) {
        list.clear();
        data.clear();
        reset();
        setBtnDictStyle();
        lan.setStyle("-fx-background-color:orange;-fx-background-radius: 20 0 0 20;");
        title1.setStyle("-fx-background-color:orange ;-fx-background-radius: 100");
        data = new LanDict().setData();
        for (Map.Entry m : data.entrySet()) {
            list.add(m.getKey());
        }
        listView.setItems(list);
        reset();
        txtSearch.setPromptText("មានចំនួន" + data.size() + "ពាក្យ");
    }

    @FXML
    private void listClickArrow(KeyEvent event) {
        event.consume();
    }

}
