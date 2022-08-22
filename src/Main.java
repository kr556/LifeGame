import ui_Frame.mframe;

import javax.swing.*;

import static asset.jsonLoader.*;
import asset.jsonLoader;

public class Main {
    public static void main(String[] args) {
        new jsonLoader(LOAD_FILE);
        new jsonLoader(APP_SETTING);
        new jsonLoader(GAME_ASSET);
        if (jsFps < 1) {
            jsFps = 15;
        }
        System.out.println("1");
        JFrame mf = new mframe("LifeGame ~jashin edision~",jsFps);
        mf.setVisible(true);
    }
}