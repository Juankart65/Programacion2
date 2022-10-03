package ch.samapp;

import java.io.IOException;

import ch.samapp.model.Person;
import ch.samapp.view.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;

	private BorderPane rootLayout;

	/**
	 * The data as an observable list of Persons.
	 */

	private ObservableList<Person> personData = FXCollections.observableArrayList();


	/**
	 * Constructor
	 */

	public MainApp(){

		// Add some sample data

		personData.add(new Person("James", "Grint"));

		personData.add(new Person("Lía", "Brown"));

		personData.add(new Person("Emma", "Stone"));

		personData.add(new Person("Christ", "White"));

		personData.add(new Person("Danna", "Grint"));
	}


	/**
	 * Returns the data as an observable list of Persons.
	 *
	 * @return
	 */

	public ObservableList<Person> getPersonData(){

		return personData;
	}

	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;

		this.primaryStage.setTitle("SamApp");

		initRootLayout();

		showPersonOverview();
	}

	/**
	 * Initialize root layout
	 *
	 */

	public void initRootLayout(){
		try {

			// Load root layout from fxml file

			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));

			rootLayout = (BorderPane) loader.load();

			//Show the scene containing the root layout.

			Scene scene = new Scene(rootLayout);

			primaryStage.setScene(scene);

			primaryStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}


	/**
	 * Show the person overview inside the root layout
	 */

	public void showPersonOverview(){

		try {

			// Load person overview.

			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));

			AnchorPane personOverview = (AnchorPane) loader.load();


			// Set person overview into the center of root layout

			rootLayout.setCenter(personOverview);

			// Give the controller access to the main app.

			PersonOverviewController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}


	/**
	 * Returns the main stage
	 */

	public Stage getPrimaryStage() {

		return primaryStage;
	}

	public static void main(String[] args) {

		launch(args);
	}


}
