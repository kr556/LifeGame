package ui_Frame.frameParts;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * &lt;mButton&gt;<br>
 * buttonの作成と設定
 */
public class mButton extends JButton {

    public mButton(String text) {
        setText(text);
    }

    public mButton(String text, Color color) {
        setText(text);
        setBackground(color);
    }

    public mButton( int w, int h,String text, Color color) {
        setSize(w, h);
        setText(text);
        setBackground(color);
    }

    public mButton( int w, int h,String text, Color color,LineBorder l) {
        setSize(w, h);
        setText(text);
        setBackground(color);
        setBorder(l);
    }

    public mButton(int x, int y, int w, int h) {
        setBounds(x, y, w, h);
    }

    public mButton(int x, int y, int w, int h, String text) {
        setBounds(x, y, w, h);
        setText(text);
    }

    public mButton(int x, int y, int w, int h, String text, Color color) {
        setBounds(x, y, w, h);
        setBackground(color);
        setText(text);
    }

    public mButton(int x, int y, int w, int h, String text, Color color, LineBorder lineBorder) {
        setBounds(x, y, w, h);
        setBackground(color);
        setText(text);
        setBorder(lineBorder);
    }
}
