package ui_Frame.frameParts;

import javax.swing.*;
import java.awt.*;

/**
 * &lt;mPanel&gt;<br>
 * panelの作成と設定
 */
public class mPanel extends JPanel {

    public mPanel(int x, int y, int w, int h) {
        setBounds(x, y, w, h);
    }

    public mPanel(int x, int y, int w, int h, Color color) {
        setBounds(x, y, w, h);
        setBackground(color);
    }

    public mPanel(int x, int y, int w, int h, Color color, BorderLayout layout) {
        setBounds(x, y, w, h);
        setBackground(color);
        setLayout(layout);
    }
}
