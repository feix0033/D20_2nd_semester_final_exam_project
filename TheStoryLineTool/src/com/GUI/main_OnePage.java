package com.GUI;


import com.Application.opration.create.App_Opr_CreateNewEventCard;
import com.Domain.eventcard.Dom_EventCard;
import com.Domain.story.Dom_EventList;
import com.Domain.user.Dom_LoginedUser;

import com.GUI.User.GUI_UserLogin;
import com.GUI.controlbar.GUI_ControlBar;
import com.GUI.eventcard.*;
import com.GUI.eventlist.GUI_EventList;
import com.GUI.eventmap.GUI_EventMap;
import com.GUI.eventmap.GUI_TimeLine;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Text;


/**
 * @ author Andrej Simionenko, Raheela Tasneem, Fei Gu, Ibraheem Swaidan
 * @ create 2021-05-31-01.20
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description This is the EASV D20 2nd semester final exam project
 * @ Supervisors Karsten Skov, Tommy Haugaard, Frank Østergaard Hansen
 * @ Version 0.1
 */
public class main_OnePage extends Application {
    private Dragboard dragboard;
    Dom_EventCard selectedEventCard;
    private final DataFormat buttonFormat = new DataFormat("com.example.myapp.formats.button");

    @Override
    public void start(Stage primaryStage) throws Exception {

        // *************** Controller Bar ******************
        GUI_ControlBar GUIControlBar = new GUI_ControlBar();
        AnchorPane anP_ControlBar = GUIControlBar.showControlBar(primaryStage);

        // ****************************** Event List *****************************

        GUI_EventList gui_eventList = new GUI_EventList();
        AnchorPane anP_EventList = gui_eventList.showEventList();
        ListView<Dom_EventCard> lv_EventList = gui_eventList.getLv_EventList();

        // ************************ Event Card ******************************

        GUI_EventCard gui_eventCard = new GUI_EventCard();
        AnchorPane anP_EventCard = gui_eventCard.showEventCard();

        // ********************* Event Map **********************************

        GUI_EventMap gui_eventMap = new GUI_EventMap();
        AnchorPane anP_EventMap = gui_eventMap.showEventMap();

        // *********************** Time Line **************************

        GUI_TimeLine gui_timeLine = new GUI_TimeLine();
        AnchorPane anP_TimeLine = gui_timeLine.showTimeLine();


        // *********************** Root *********************

        BorderPane bp_Root = new BorderPane();
        bp_Root.setTop(anP_ControlBar);
        bp_Root.setCenter(anP_EventMap);
        bp_Root.setLeft(anP_EventList);
        bp_Root.setBottom(anP_TimeLine);
        bp_Root.setRight(anP_EventCard);
        bp_Root.setStyle("-fx-background-color: gray");

        BorderPane.setMargin(anP_EventCard, new Insets(1));
        BorderPane.setMargin(anP_ControlBar, new Insets(1));
        BorderPane.setMargin(anP_EventList, new Insets(1));
        BorderPane.setMargin(anP_EventMap, new Insets(1));
        BorderPane.setMargin(anP_TimeLine, new Insets(1));


        AnchorPane anp_Root = new AnchorPane();
        anp_Root.getChildren().add(bp_Root);
        anp_Root.setPadding(new Insets(5));
        AnchorPane.setTopAnchor(bp_Root, 0.0);
        AnchorPane.setLeftAnchor(bp_Root, 0.0);
        AnchorPane.setBottomAnchor(bp_Root, 0.0);
        AnchorPane.setRightAnchor(bp_Root, 0.0);

        Scene scene = new Scene(anp_Root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("The Story Line Tool");
        primaryStage.setHeight(800);
        primaryStage.setWidth(1000);
        primaryStage.show();

        // show the login window
        GUI_UserLogin.showLoginStage(primaryStage);

        gui_eventCard.getGui_eventCardTitle().getTf_EventTitleEventName().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                selectedEventCard.setEventName(newValue);
                lv_EventList.getSelectionModel().getSelectedItem().setEventName(newValue);
            }
        });

        // ****************** Event List application ***********************
        lv_EventList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Dom_EventCard>() {
            @Override
            public void changed(ObservableValue<? extends Dom_EventCard> observable, Dom_EventCard oldValue, Dom_EventCard newValue) {
                lv_EventList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                selectedEventCard = newValue;
                if (selectedEventCard != null) {
                    gui_eventCard.getGui_eventCardTitle().getLb_EventCardTitle().setText("Event Card : " + selectedEventCard.getEventName());
                    gui_eventCard.getGui_eventCardTitle().getTf_EventTitleEventName().setText(selectedEventCard.getEventName());
                    gui_eventCard.getGui_eventCardTitle().getTf_EventTitleAuthor().setText(selectedEventCard.getAuthorName());
                    gui_eventCard.getGui_eventCardTitle().getTf_EventTitleDate().setText(String.valueOf(selectedEventCard.getLocalDate()));

                    /*
                     * right here remember to set the text for event and comment and note
                     * and remember to change the node of each three to text field for input.
                     */

                }
            }
        });
        lv_EventList.setCellFactory(TextFieldListCell.forListView(new StringConverter<Dom_EventCard>() {
            @Override
            public String toString(Dom_EventCard object) {
                String s = object.getEventName();
                return s;
            }

            @Override
            public Dom_EventCard fromString(String string) {
                Dom_EventCard selectedItem = lv_EventList.getSelectionModel().getSelectedItem();

                int selectedIndex = lv_EventList.getSelectionModel().getSelectedIndex();
                String eventNumber = String.valueOf(selectedIndex + 1);

                selectedItem.setEventName("Event " + eventNumber + " : " + string);
                return selectedItem;
            }
        }));


        // ***************** Event card application *************************
        // right here is the event card use the login user's name put on the author name testified



        // ********************* list view button **************************
        App_Opr_CreateNewEventCard app_opr_createNewEventCard = new App_Opr_CreateNewEventCard();
        app_opr_createNewEventCard.setLv_EventList(lv_EventList);
        gui_eventList.getBu_EventList_Add().setOnAction(app_opr_createNewEventCard);

        // ******************** listview drag *********************

        lv_EventList.setOnDragDetected(event ->  {
                dragboard = anP_EventMap.startDragAndDrop(TransferMode.ANY);
                dragboard.setDragView(new Text(lv_EventList.getSelectionModel().getSelectedItem().getEventName()).snapshot(null, null), event.getX(), event.getY());
                ClipboardContent cc = new ClipboardContent();
                cc.putString(lv_EventList.getSelectionModel().getSelectedItem().getEventName());
                dragboard.setContent(cc);
                lv_EventList.startFullDrag();
            });
        anP_EventMap.setOnDragDropped(event ->{
                Dom_EventCard selectedItem = lv_EventList.getSelectionModel().getSelectedItem();
                String eventName = selectedItem.getEventName();
                Button button = new Button(eventName);
                gui_eventMap.getTp_EventMap().getChildren().add(button);

            });
        anP_EventMap.setOnDragOver(event -> {
            event.acceptTransferModes(TransferMode.MOVE);
            System.out.println("over the Event Map!");
        });


    }
}
