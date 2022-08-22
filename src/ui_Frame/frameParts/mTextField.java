package ui_Frame.frameParts;

import javax.swing.*;
import java.awt.*;

/**
 * &lt;mTextFried&gt;<br>
 * textFieldの作成と設定
 */
public class mTextField extends JTextField {

    public mTextField(int x, int y) {
        setSize(x, y);
    }
    public mTextField(int x, int y,Color color) {
        setSize(x, y);
        setBackground(color);
    }
    public mTextField(int x, int y,String text) {
        setSize(x, y);
        setText(text);
    }
    public mTextField(int x, int y,String text,Color color) {
        setSize(x, y);
        setText(text);
        setBackground(color);
    }
    public mTextField(int x, int y, int w, int h) {
        setBounds(x, y, w, h);
    }
    public mTextField(int x, int y, int w, int h, String text) {
        setBounds(x, y, w, h);
        setText(text);
    }
    public mTextField(int x, int y, int w, int h, String text, Color color) {
        setBounds(x, y, w, h);
        setBackground(color);
        setText(text);
    }
}
