package com.example.mytunes;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MyTunesController {
    @FXML
    private Label welcomeText;
    @FXML
    private TableView<Song> t1;
    @FXML
    public TableView<PlayList> t2;
    @FXML
    private ListView<String> songsOnPlaylist;
    @FXML
    private Button newPlaylist;
    @FXML
    private Button cancelButtonId;


    public static class Song {
        private final String songName;
        private final String songArtist;
        private final String songCategory;

        private final String songTime;

        public Song(String name, String artist, String category, String time) {
            this.songName = name;
            this.songArtist = artist;
            this.songCategory = category;
            this.songTime = time;
        }

        // Property getters for JavaFX PropertyValueFactory
        public StringProperty nameProperty() {
            return new SimpleStringProperty(songName);
        }

        public StringProperty artistProperty() {
            return new SimpleStringProperty(songArtist);
        }


        public StringProperty categoryProperty() {
            return new SimpleStringProperty(songCategory);
        }

        public StringProperty timeCategory() {
            return new SimpleStringProperty(songTime);
        }
    }


    public static class PlayList {
        private final String playlistSongName;
        private final String playlistSongsCount;
        private final String playlistSongsTime;


        public PlayList(String playlistSongName, String playlistSongsCount, String playlistSongsTime) {
            this.playlistSongName = playlistSongName;
            this.playlistSongsCount = playlistSongsCount;
            this.playlistSongsTime = playlistSongsTime;
        }

        // Property getters for JavaFX PropertyValueFactory
        public StringProperty nameProperty() {
            return new SimpleStringProperty(playlistSongName);
        }

        public SimpleStringProperty countProperty() {
            return new SimpleStringProperty(playlistSongsCount);
        }

        public SimpleStringProperty timeCategory() {
            return new SimpleStringProperty(playlistSongsTime);
        }
    }


    @FXML
    public void onHelloButtonClick() {

        final Random random = new Random();

        TableColumn<Song, String> nameCol = new TableColumn<>("Title");
        nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        nameCol.setPrefWidth(130);

        TableColumn<Song, String> artistCol = new TableColumn<>("Artist");
        artistCol.setCellValueFactory(cellData -> cellData.getValue().artistProperty());
        artistCol.setPrefWidth(130);

        TableColumn<Song, String> categoryCol = new TableColumn<>("Category");
        categoryCol.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
        categoryCol.setPrefWidth(100);

        TableColumn<Song, String> timeCol = new TableColumn<>("Time");
        timeCol.setCellValueFactory(cellData -> cellData.getValue().timeCategory());
        timeCol.setPrefWidth(72);


        t1.getColumns().addAll(nameCol, artistCol, categoryCol, timeCol);


        // Adding random data to the table
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Ella", "Frank");
        List<String> families = Arrays.asList("Eminem", "Michael Jackson", "SixNine");
        List<String> category = Arrays.asList("Pop", "Classic", "Rap", "Jazz");
        List<String> time = Arrays.asList("01:12", "00:52", "10:10");


        for (int i = 0; i < 20; i++) {

            String randomName = names.get(random.nextInt(names.size()));
            String randomFamily = families.get(random.nextInt(families.size()));
            String randomCategory = category.get(random.nextInt(category.size()));
            String randomTime = time.get(random.nextInt(time.size()));
            t1.getItems().add(new Song(randomName, randomFamily, randomCategory, randomTime));
        }


        t1.getItems().add(new Song("kos", "sher", "jende", "pedar"));


        TableColumn<PlayList, String> playlistNameCol = new TableColumn<>("Name");
        playlistNameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        playlistNameCol.setPrefWidth(100);

        TableColumn<PlayList, String> playlistCountCol = new TableColumn<>("Songs");
        playlistCountCol.setCellValueFactory(cellData -> cellData.getValue().countProperty());
        playlistCountCol.setPrefWidth(100);

        TableColumn<PlayList, String> playlistTimeCol = new TableColumn<>("Time");
        playlistTimeCol.setCellValueFactory(cellData -> cellData.getValue().timeCategory());
        playlistTimeCol.setPrefWidth(54);


        t2.getColumns().addAll(playlistNameCol, playlistCountCol, playlistTimeCol);


        t2.getItems().add(new PlayList("kos", "sher", "jende"));
        System.out.println("another " + t2.getColumns());


        ObservableList<String> items = FXCollections.observableArrayList(
                "Item 1", "Item 2", "Item 3", "Item 4", "Item 5");
        songsOnPlaylist.setItems(items);


        songsOnPlaylist.setOnMouseClicked(event -> {
            String item = songsOnPlaylist.getSelectionModel().getSelectedItem();
            if (item != null) {
                System.out.println(item);
            }
        });

        welcomeText.setText("Welcome to JavaFX Application!");
    }


    @FXML
    private void newPlaylistClicked() throws IOException {

        Stage newStage = new Stage();

        // Create a new scene for the new program (you should replace NewProgram with your actual new program class)
        FXMLLoader fxmlLoader = new FXMLLoader(MyTunes.class.getResource("new-playlist.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        newStage.setTitle("Hello!");
        newStage.setScene(scene);
        newStage.show();
    }


    public static class addItemToPlaylist {
        @FXML
        public TableView<String> t2;

        public TableView<String> getT2TableView() {

            return t2;
        }
    }


    @FXML
    private void cancelButton(){

        closeWindows();

    }


    @FXML
    private void saveButton(){

        closeWindows();
    }

    private void closeWindows(){
        System.out.println("Here");
        cancelButtonId.setOnMouseClicked(event -> {
            Stage stage = (Stage) cancelButtonId.getScene().getWindow();
            stage.close();
        });
    }



}
