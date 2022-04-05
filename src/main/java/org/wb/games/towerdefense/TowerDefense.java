package org.wb.games.towerdefense;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument

public class TowerDefense {

    public static final int SCREEN_WIDTH = 720;
    public static final int SCREEN_HEIGHT = 360;

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setIdleFPS(30);
        config.setWindowedMode(SCREEN_WIDTH, SCREEN_HEIGHT);
        config.setTitle("Tower Defense");
        config.setResizable(false);
        new Lwjgl3Application(new Scene(), config);
    }
}
