package ui_Frame.frameParts;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * &lt;mLabel&gt;<br>
 * labelの作成と設定
 */
public class mLabel extends JLabel {

    public mLabel(int w, int h) {
        setSize(w, h);
    }

    public mLabel(int w, int h, String text) {
        setSize(w, h);
        setText(text);
    }

    public mLabel(int w, int h, Color color, boolean b) {
        setSize(w, h);
    }

    public mLabel(int w, int h, String text, Color color, boolean b) {
        setSize(w, h);
        setBackground(color);
        setOpaque(b);
    }

    public mLabel(int w, int h, Color color, boolean b, LineBorder border) {
        setSize(w, h);
        setBackground(color);
        setOpaque(b);
        setBorder(border);
    }

    public mLabel(int w, int h, Color color, boolean b, LineBorder border, String text) {
        setSize(w, h);
        setBackground(color);
        setOpaque(b);
        setBorder(border);
        setText(text);
    }

    public mLabel(int x, int y, int w, int h) {
        setBounds(x, y, w, h);
    }

    public mLabel(int x, int y, int w, int h, String text) {
        setBounds(x, y, w, h);
        setText(text);
    }


    public mLabel(int x, int y, int w, int h, Color color, boolean b) {
        setBounds(x, y, w, h);
        setBackground(color);
        setOpaque(b);
    }

    public mLabel(int x, int y, int w, int h, Color color, boolean b, String text) {
        setBounds(x, y, w, h);
        setBackground(color);
        setOpaque(b);
        setText(text);
    }

    public mLabel(int x, int y, int w, int h, Color color, boolean b, String text, LineBorder border) {
        setBounds(x, y, w, h);
        setBackground(color);
        setOpaque(b);
        setText(text);
        setBorder(border);
    }
}