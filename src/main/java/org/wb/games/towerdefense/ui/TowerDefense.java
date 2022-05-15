package org.wb.games.towerdefense.ui;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument

public class TowerDefense {

    public static final int SCREEN_WIDTH = 1024;
    public static final int SCREEN_HEIGHT = 768;
    public static final float ASPECT_RATIO = (float) SCREEN_HEIGHT / (float) SCREEN_WIDTH;
    public static final int FRAME_RATE = 30;

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setIdleFPS(FRAME_RATE);
        config.setForegroundFPS(FRAME_RATE);
        config.setWindowedMode(SCREEN_WIDTH, SCREEN_HEIGHT);
        config.setTitle("Tower Defense");
        config.setResizable(false);
        new Lwjgl3Application(new Scene(), config);
        System.exit(0);
    }
}
