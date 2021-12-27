package com.example.demo2;

//import
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

//Main Class
public class HelloApplication extends Application {

    //data members
    int plr;    //player value

    //scenes
    Scene scene1;
    Scene scene2;
    Scene scene3;
    Scene scene4;
    Scene scene5;

    @Override // Override the start method in the Application class
    public void start(Stage stage)
    {
        //Scene 1
        //start button
        {
            Button startb = new Button("Start!");
            Font font = Font.font("Courier New", FontWeight.BOLD, 36);
            startb.setFont(font);

            //action - move to scene 2
            startb.setOnAction(actionEvent -> {
                stage.setScene(scene2);
            });
            scene1 = new Scene(startb, 450, 500);
        }

        //Scene 2
        //Magic Cube Generation
        {
            GridPane grd = new GridPane();
            grd.setHgap(50);
            grd.setVgap(10);
            grd.setPadding(new Insets(10, 10, 10, 10));

            //HBox
            HBox hbox = new HBox();
            hbox.setPadding(new Insets(15, 12, 15, 12));
            hbox.setSpacing(10);
            hbox.setStyle("-fx-background-color: #336699;");
            Font genfo = Font.font("Comic Sans-ms", FontWeight.BOLD, 15);
            Label gen = new Label("Click the button to Generate Magic cube");
            gen.setPrefSize(300, 20);
            gen.setFont(genfo);
            Button genb = new Button("Generate");
            genb.setPrefSize(100, 20);
            Button next = new Button("Next");
            hbox.getChildren().addAll(gen, genb);

            grd.add(hbox, 0, 0, 6, 1);
            grd.setHgap(50);
            grd.setVgap(10);
            //to display the magic cube
            Label temp1[] = new Label[9];
            Label temp2[] = new Label[9];
            Label temp3[] = new Label[9];
            scene2 = new Scene(grd, 600, 600);

            //To generate the Magic cube when Generate is clicked
            genb.setOnAction(actionEvent ->
            {
                MagicCube.createCube();
                MagicCube.display();
                MagicCube.initmc();




                //For Magic cube
                GridPane g2a = new GridPane();
                Font genf = Font.font("Comic Sans-ms", FontWeight.BOLD, 15);
                int k = 0;
                g2a.setPadding(new Insets(10, 10, 10, 10));

                //Plane 1 of the magic cube
                {
                    GridPane tile1 = new GridPane();
                    tile1.setPadding(new Insets(10, 10, 10, 10));
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            temp1[k] = new Label("" + MagicCube.mc[0][i][j][0]);
                            if (k % 2 == 0)
                                temp1[k].setStyle("-fx-border-color: black;");
                            temp1[k].setFont(genf);
                            temp1[k].setPrefHeight(40);
                            temp1[k].setPrefWidth(40);
                            temp1[k].setPadding(new Insets(10, 10, 10, 10));
                            tile1.add(temp1[k], j, i);
                            k++;

                        }
                    }
                    g2a.add(tile1, 0, 0, 2, 2);
                }
                //Plane 2 of the magic cube
                {
                    GridPane tile2 = new GridPane();
                    tile2.setPadding(new Insets(10, 10, 10, 10));
                    k = 0;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            temp2[k] = new Label("" + MagicCube.mc[1][i][j][0]);
                            if (k % 2 == 0)
                                temp2[k].setStyle("-fx-border-color: black;");
                            //aligning
                            temp2[k].setFont(genf);
                            temp2[k].setPrefHeight(40);
                            temp2[k].setPrefWidth(40);
                            temp2[k].setPadding(new Insets(10, 10, 10, 10));
                            tile2.add(temp2[k], j, i);

                            k++;

                        }
                    }
                    g2a.add(tile2, 2, 2, 2, 2);
                }

                //Plane 3
                {
                    GridPane tile3 = new GridPane();
                    tile3.setPadding(new Insets(10, 10, 10, 10));
                    k = 0;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            temp3[k] = new Label("" + MagicCube.mc[2][i][j][0]);
                            if (k % 2 == 0)
                                temp3[k].setStyle("-fx-border-color: black;");
                            temp3[k].setFont(genf);
                            temp3[k].setPrefHeight(40);
                            temp3[k].setPrefWidth(40);
                            temp3[k].setPadding(new Insets(10, 10, 10, 10));
                            tile3.add(temp3[k], j, i);

                            k++;

                        }
                    }

                    g2a.add(tile3, 4, 4, 2, 2);
                }

                hbox.getChildren().add(next);
                grd.add(g2a, 0, 1, 6, 6);
            });
            //next for scene 3
            next.setOnAction(actionEvent ->
            {
                stage.setScene(scene3);
            }
            );

        }

        //Scene 3
        /**
         * Player selection.
         * Choose between X and O
         */
        {
            GridPane grid = new GridPane();
            grid.setHgap(50);
            grid.setVgap(10);
            grid.setPadding(new Insets(10, 10, 10, 10));
            grid.setAlignment(Pos.CENTER);
            scene3 = new Scene(grid, 400, 200);

            Font font1 = Font.font("Courier New", FontWeight.BOLD, 64);
            //Button for X
            Button Xb = new Button("X");
            Xb.setFont(font1);
            Xb.setStyle("-fx-base: green;");
            grid.add(Xb, 0, 0);
            //Button for O
            Button Ob = new Button("O");
            Ob.setFont(font1);
            Ob.setStyle("-fx-base: red;");
            grid.add(Ob, 1, 0);

            //Actions
            {
                //X for player to b player 1
                Xb.setOnAction(actionEvent -> {
                    plr = 1;

                    stage.setScene(scene4);
                });
                //O for player to be player 2
                Ob.setOnAction(actionEvent -> {
                    XObot.trackm.add(new Coordinate(1, 1, 1));
                    MagicCube.mc[1][1][1][1] = 2;
                    plr = 2;
                    stage.setScene(scene4);
                });
            }
        }

        //Scene 4
        /**
         * Start of game
         */
        //game grid
        {
            GridPane g4 = new GridPane();
            g4.setPadding(new Insets(10, 10, 10, 10));
            g4.setAlignment(Pos.CENTER);
            HBox h4 = new HBox();
            Button sb = new Button("START!");
            Label sl = new Label("Press START! to start the game");
            h4.getChildren().addAll(sl, sb);
            g4.add(h4, 0, 0, 9, 1);
            Font fx = Font.font("Courier New", FontWeight.BOLD, 15);
            scene4 = new Scene(g4, 800, 800);
            int k = 0;

            Button b1[] = new Button[9];
            Button b2[] = new Button[9];
            Button b3[] = new Button[9];

            //Setting up and aligning buttons
            {
                //Plane 1
                GridPane pane1 = new GridPane();
                pane1.setPadding(new Insets(10, 10, 10, 10));
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        b1[k] = new Button( ""+MagicCube.mc[0][i][j][0]);
                        if (k % 2 == 0)
                            b1[k].setStyle("-fx-border-color: black;");
                        b1[k].setPrefHeight(100);
                        b1[k].setPrefWidth(100);
                        b1[k].setPadding(new Insets(10, 10, 10, 10));
                        pane1.add(b1[k], j, i);
                        b1[k].setFont(fx);
                        b1[k].setDisable(true);
                        k++;

                    }
                }
                g4.add(pane1, 0, 1, 2, 2);

                //Plane 2
                GridPane pane2 = new GridPane();
                pane2.setPadding(new Insets(10, 10, 10, 10));
                k = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        b2[k] = new Button("" + MagicCube.mc[1][i][j][0] + "");
                        if (k % 2 == 0)
                            b2[k].setStyle("-fx-border-color: black;");
                        b2[k].setPrefHeight(100);
                        b2[k].setPrefWidth(100);
                        b2[k].setPadding(new Insets(10, 10, 10, 10));
                        b2[k].setFont(fx);
                        pane2.add(b2[k], j, i);
                        b2[k].setDisable(true);
                        k++;

                    }
                }
                g4.add(pane2, 2, 3, 2, 2);

                //Plane 3
                GridPane pane3 = new GridPane();
                pane3.setPadding(new Insets(10, 10, 10, 10));
                k = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        b3[k] = new Button("" + MagicCube.mc[2][i][j][0] + "");
                        if (k % 2 == 0)
                            b3[k].setStyle("-fx-border-color: black;");
                        b3[k].setPrefHeight(100);
                        b3[k].setPrefWidth(100);
                        b3[k].setPadding(new Insets(10, 10, 10, 10));
                        b3[k].setFont(fx);
                        pane3.add(b3[k], j, i);
                        b3[k].setDisable(true);
                        k++;

                    }
                }
                g4.add(pane3, 4, 5, 2, 2);
            }
            //actions
            //start
            {
                sb.setOnAction(actionEvent -> {
                    int l = 0;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            b1[l].setDisable(false);
                            b1[l].setText("" + MagicCube.mc[0][i][j][0] + "\n ["+0+i+j+"]" );
                            l++;
                        }
                    }

                    l = 0;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (MagicCube.mc[1][i][j][1] == 2) {
                                b2[l].setStyle("-fx-base: red;");
                                l++;
                                continue;
                            }
                            b2[l].setText("" + MagicCube.mc[1][i][j][0] + "\n ["+1+i+j+"]" );
                            b2[l].setDisable(false);
                            l++;
                        }
                    }
                    l = 0;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            b3[l].setDisable(false);
                            b3[l].setText("" + MagicCube.mc[2][i][j][0] + "\n ["+2+i+j+"]" );
                            l++;
                        }
                    }
                });

            }

            //action for each button
            /**
             * WHEN A BUTTON IS PRESSED, THE COORDINATE ACTS AS THE INPUT
             * AND BOTS TURN GETS TRIGGERED
             * THE BUTTON GETS DISABLED WHEN PRESSED SO THAT THE SAME BUTTON CANT BE PRESSED TWICE
             */
            //b1 - batch
            {
                b1[0].setOnAction(actionEvent -> {
                    b1[0].setDisable(true);
                    b1[0].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(0, 0, 0);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[0][0][0][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {
                            stage.setScene(scene5);
                        }
                    }
                });

                b1[1].setOnAction(actionEvent -> {
                    b1[1].setDisable(true);
                    b1[1].setStyle("-fx-base: green;");
                    System.out.println("Working now");
                    Coordinate c = new Coordinate(0, 0, 1);
                    MagicCube.mc[0][0][1][1] = 1;
                    XObot.trackp.add(c);
                    if (haswon(c)) {
                        XObot.status = 2;
                        stage.setScene(scene5);
                    }
                    else {
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {
                            stage.setScene(scene5);
                        }
                    }
                });

                b1[2].setOnAction(actionEvent -> {
                    b1[2].setDisable(true);
                    b1[2].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(0, 0, 2);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[0][0][2][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });

                b1[3].setOnAction(actionEvent -> {
                    b1[3].setDisable(true);
                    b1[3].setStyle("-fx-base: green;");
                    System.out.println("Working now");
                    Coordinate c = new Coordinate(0, 1, 0);
                    if (haswon(c)) {
                        XObot.status = 2;
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[0][1][0][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {
                            stage.setScene(scene5);
                        }
                    }

                });

                b1[4].setOnAction(actionEvent -> {
                    b1[4].setDisable(true);
                    b1[4].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(0, 1, 1);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[0][1][1][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });

                b1[5].setOnAction(actionEvent -> {
                    b1[5].setDisable(true);
                    b1[5].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(0, 1, 2);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[0][1][2][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });

                b1[6].setOnAction(actionEvent -> {
                    b1[6].setDisable(true);
                    b1[6].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(0, 2, 0);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[0][2][0][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });

                b1[7].setOnAction(actionEvent -> {
                    b1[7].setDisable(true);
                    b1[7].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(0, 2, 1);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[0][2][1][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });

                b1[8].setOnAction(actionEvent -> {
                    b1[8].setDisable(true);
                    b1[8].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(0, 2, 2);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[0][2][2][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });
            }
            //b2 - batch
            {
                b2[0].setOnAction(actionEvent -> {
                    b2[0].setDisable(true);
                    b2[0].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(1, 0, 0);
                    if (haswon(c)) {
                        XObot.status = 2;
                        stage.setScene(scene5);
                    }
                    else
                    {
                        MagicCube.mc[1][0][0][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });

                b2[1].setOnAction(actionEvent -> {
                    b2[1].setDisable(true);
                    b2[1].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(1, 0, 1);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[1][0][1][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });

                b2[2].setOnAction(actionEvent -> {
                    b2[2].setDisable(true);
                    b2[2].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(1, 0, 2);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[1][0][2][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });

                b2[3].setOnAction(actionEvent -> {
                    b2[3].setDisable(true);
                    b2[3].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(1, 1, 0);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[1][1][0][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });

                b2[4].setOnAction(actionEvent -> {
                    b2[4].setDisable(true);
                    b2[4].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(1, 1, 1);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[1][1][1][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });

                b2[5].setOnAction(actionEvent -> {
                    b2[5].setDisable(true);
                    b2[5].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(1, 1, 2);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[1][1][2][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });

                b2[6].setOnAction(actionEvent -> {
                    b2[6].setDisable(true);
                    b2[6].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(1, 2, 0);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[1][2][0][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });

                b2[7].setOnAction(actionEvent -> {
                    b2[7].setDisable(true);
                    b2[7].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(1, 2, 1);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[1][2][1][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });

                b2[8].setOnAction(actionEvent -> {
                    b2[8].setDisable(true);
                    b2[8].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(1, 2, 2);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[1][2][2][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });
            }
            //b3 - batch
            {
                b3[0].setOnAction(actionEvent -> {
                    b3[0].setDisable(true);
                    b3[0].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(2, 0, 0);
                    if (haswon(c)) {
                        XObot.status = 2;
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[2][0][0][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {
                            stage.setScene(scene5);
                        }
                    }
                });

                b3[1].setOnAction(actionEvent -> {
                    b3[1].setDisable(true);
                    b3[1].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(2, 0, 1);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[2][0][1][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });

                b3[2].setOnAction(actionEvent -> {
                    b3[2].setDisable(true);
                    b3[2].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(2, 0, 2);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[2][0][2][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });

                b3[3].setOnAction(actionEvent -> {
                    b3[3].setDisable(true);
                    b3[3].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(2, 1, 0);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[2][1][0][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });

                b3[4].setOnAction(actionEvent -> {
                    b3[4].setDisable(true);
                    b3[4].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(2, 1, 1);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[2][1][1][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });

                b3[5].setOnAction(actionEvent -> {
                    b3[5].setDisable(true);
                    b3[5].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(2, 1, 2);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[2][1][2][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });

                b3[6].setOnAction(actionEvent -> {
                    b3[6].setDisable(true);
                    b3[6].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(2, 2, 0);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[2][2][0][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });

                b3[7].setOnAction(actionEvent -> {
                    b3[7].setDisable(true);
                    b3[7].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(2, 2, 1);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[2][2][1][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });

                b3[8].setOnAction(actionEvent -> {
                    b3[8].setDisable(true);
                    b3[8].setStyle("-fx-base: green;");
                    Coordinate c = new Coordinate(2, 2, 2);
                    if (haswon(c)) {
                        XObot.status = 2;
                         
                        stage.setScene(scene5);
                    }
                    else {
                        MagicCube.mc[2][2][2][1] = 1;
                        XObot.trackp.add(c);
                        XObot.move(b1, b2, b3);
                        if (XObot.status != 0) {

                            stage.setScene(scene5);
                        }
                    }
                });
            }
        }

        //Scene 5
        {
            GridPane g5 = new GridPane();
            g5.setHgap(50);
            g5.setVgap(10);
            g5.setPadding(new Insets(10, 10, 10, 10));
            g5.setAlignment(Pos.CENTER);
            Font fx5 = Font.font("Courier New", FontWeight.BOLD, 25);
            Font fx6 = Font.font("Lucida Sans Unicode", FontWeight.BOLD, 25);
            Label msg = new Label("GAME OVER ");
            msg.setFont(fx5);
            Button results = new Button("Result");
            results.setFont(fx5);
            Label win = new Label("");
            win.setFont(fx6);

            //action
            results.setOnAction(actionEvent -> {
                String s = "";
                if (XObot.status == 1) {
                    s = " BOT Wins";
                    win.setText(s);
                }
                else if (XObot.status == 2) {
                    s = " You Win";
                    win.setText(s);
                }
                else if (XObot.status == 3) {
                    s = "Its a Draw";
                    win.setText(s);
                }
            });
            g5.add(msg, 0, 0, 4, 1);
            g5.add(win, 0, 1, 4, 1);
            g5.add(results, 5, 0, 2, 1);
            scene5 = new Scene(g5, 400, 200);

        }
        stage.setScene(scene1);
        stage.setResizable(false);
        stage.show();
    }

    public static boolean haswon(Coordinate p)  //TO CHECK IF THE PLAYER HAS WON
    {
        int n = XObot.trackp.size();
        if(n<=1)    //AS ITS IMPOSSIBLE TO WIN WITHIN TWO ROUNDS
        {
            return false;
        }

        //TO CHECK IF THERE ARE ANY COLLINEAR LINES
        for (int i = 0; i < n-1; i++) {
            for (int j = i; j < n; j++) {
                Coordinate c1 = XObot.trackp.get(i);
                Coordinate c2 = XObot.trackp.get(j);

                int sum =  MagicCube.mc[c1.x][c1.y][c1.z][0] + MagicCube.mc[c2.x][c2.y][c2.z][0]  + MagicCube.mc[p.x][p.y][p.z][0];
                if(sum == 42)
                {
                    if(XObot.coll(p,c2,c1)) {
                        return true;        //RETURNS TRUE IF THE POINTS ADD UP TO 42 AND THEY ARE COLLINEAR
                    }
                }
            }

        }
        return false;

    }

    public static void main(String[] args)
    {
        launch();




    }
}