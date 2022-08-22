package ui_Frame;

import static asset.jsonLoader.*;

import asset.setCell;
import bin.sleep;
import ui_Frame.frameParts.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

import static bin.mainAsset.*;

public class mframe extends JFrame {

    public static final int wid = jsAppW,hid = jsAppH;
    private boolean[][] tf = new boolean[cellW][cellH];
    private static float fps;
    private static int mouseX0,mouseY0,mouseX1,mouseY1; //ドラッグを実装予定にゃ ฅ(^ω^ )ฅ
    private static final int cellW = jsW, cellH = jsH;
    /**ボタンの条件分岐 [1]=1000の時に何もしない*/
    private static final int[] bBn = {0,1000,0,0};
    private static int cellSize = 5;
    /**
     * trueでセルの境界を表示
     */
    private static boolean displayBr = false;

    //public static final ImageIcon imgIcn = new ImageIcon(Objects.requireNonNull(mframe.class.getResource("image/back_panel_2.png")));
    //public static final ImageIcon imgIcn = new ImageIcon(Objects.requireNonNull(mframe.class.getResource("image/back_panel_defo.png")));
    public static final ImageIcon imgIcn = new ImageIcon("image/back_panel_1.png"), app_icn = new ImageIcon("image/lfs_icon.png");
    private static final Image img =imgIcn.getImage().getScaledInstance(wid,hid,Image.SCALE_DEFAULT);
    public static final Color[] cr = {new Color(217, 239, 255)};
    public static final ImageIcon reImgIcn = new ImageIcon(img);
    private static final LineBorder[] lbd = {
            new mBorder(1,cr[0]),
            new mBorder(1,Color.DARK_GRAY)};

    public static final JButton[] bn = new JButton[12];
    public static final JPanel pl = new mPanel(jsAppX,jsAppY,wid,hid, Color.BLACK,null);
    public static final JLabel[] ll = {
            new mLabel(0,0,wid,hid),
            new mLabel(20,20,280,40+bn.length,Color.WHITE,false,"",lbd[0]),
            new mLabel(30,100,Color.WHITE,true,lbd[0],"fps")};
    public static final JLabel[][] cell = new JLabel[cellW][cellH];
    public static final JTextField td = new mTextField(20,320,60,30);

    public mframe(String title,long fps_) {
        System.out.println("\nload frame...[loading method]"); //deb
        setBounds(10,10,wid,hid);
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setIconImage(app_icn.getImage());

        System.out.println(" load panel..."); //deb
        ll[0].addMouseWheelListener(this::mouseWheelMoved);

        fps = fps_;

        add(pl);
        Container c = getContentPane();
        c.add(pl,BorderLayout.CENTER);

        pl.add(ll[0]);
        pl.add(ll[1]);
        System.out.println(" complete load panel"); //deb

        System.out.println(" load label..."); //deb
        ll[0].setIcon(reImgIcn);

        for (int i = 0; i< cellW; i++) {
            for (int j = 0; j< cellH; j++) {
                //ll0[i][j] = new mLabel((mSize)*i + (wid/2)-((mSize)*mW)/2,(mSize)*j + (hid/2)-((mSize)*mH)/2 - 20,mSize,mSize,new Color(0xC272DC),false,"",lbd[0]);
                cell[i][j] = new mLabel((cellSize)*j + (wid/2)-((cellSize)* cellW)/2,(cellSize)*i + (hid/2)-((cellSize)* cellH)/2 - 20, cellSize, cellSize,new Color(0xC272DC),false);
                ll[0].add(cell[i][j]);
            }
        }
        System.out.println(" complete load label"); //deb

        System.out.println(" load button..."); //deb
        for (int i=0;i<bn.length;i++) {
            bn[i] = new mButton(100,30,"",Color.WHITE,new mBorder(2,cr[0]));
            bn[i].setLocation(20,20+50*i);
            bn[i].addActionListener(this::actionPerformed);
            bn[i].setText(jsBnText[i]);
            if (true) {
                bn[i].setFont(new Font(jsFont, Font.PLAIN, jsFontSize));
            }
            ll[0].add(bn[i]);
        }
        ll[0].add(td);
        System.out.println(" def button..."); //deb
        /*
        bn[0].setText("全部埋める");
        bn[1].setText("全部空ける");
        bn[2].setText("開始");
        bn[3].setText("一時停止");
        bn[4].setText("再開");
        bn[5].setText("終了");
        bn[6].setText("fps");
        bn[7].setText("x0.5");
        bn[8].setText("x2");
        bn[9].setText("ゲームを終了");
        bn[10].setText("セルを表示");
        bn[11].setText("ガイドを表示");
         */
        bn[6].setBounds(80,bn[6].getY(),40,30);
        bn[7].setBounds(20,bn[7].getY()-20,50,30);
        bn[8].setBounds(70,bn[7].getY(),50,30);
        System.out.println(" complete load button"); //deb

        td.setText(String.valueOf((int)fps));
        System.out.println("complete load frame[complete load method]\n"); //deb
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (bBn[0] == 1) { //all fill
            for  (int i = 0; i< cellH; i++) {
                for (int j = 0; j< cellW; j++) {
                    try {
                        cell[j][i].setOpaque(true);
                    } catch (Exception ignored) {}
                }
            }
            repaint();
        } else { //all void
            for  (int i = 0; i< cellH; i++) {
                for (int j = 0; j< cellW; j++) {
                    try {
                        cell[j][i].setOpaque(false);
                    } catch (Exception ignored) {}
                }
            }
            repaint();
        }
        if(bBn[1]==0) {
            for  (int i = 0; i< cellH; i++) {
                for (int j = 0; j< cellW; j++) {
                    try {
                        cell[i][j].setOpaque(tf[i][j]);
                    } catch (Exception ignored) {}
                }
            }
            new sleep((long) (1000/fps));
            mainAsset();
            repaint();
        } else if(bBn[1]==1) {
            for  (int i = 0; i< cellH; i++) {
                for (int j = 0; j< cellW; j++) {
                    try {
                        cell[i][j].setOpaque(tf[i][j]);
                    } catch (Exception ignored) {}
                    xq = tf;
                }
            }
            repaint();
        } else if(bBn[1]==2) {
            for  (int i = 0; i< pubY; i++) {
                for (int j = 0; j< pubX; j++) {
                    try {
                        cell[i][j].setOpaque(tf[i][j]);
                    } catch (Exception ignored) {}
                }
            }
            new sleep(50L);
            mainAsset();
            repaint();
        } else if (bBn[2]==1) {
            new setCell();
            xq = tf;
            for  (int i = 0; i< pubY; i++) {
                for (int j = 0; j< pubX; j++) {
                    try {
                        cell[i][j].setOpaque(tf[i][j]);
                    } catch (Exception ignored) {}
                }
            }
            repaint();
        }
        if (bBn[3]==1) {
            for (int i=0;i<pubY;i++) {
                for (int j=0;j<pubX;j++) {
                    cell[j][i].setBorder(lbd[1]);
                }
            }
            repaint();
        } else if (bBn[3]==0) {
            for (int i=0;i<pubY;i++) {
                for (int j=0;j<pubX;j++) {
                    cell[j][i].setBorder(null);
                }
            }
            repaint();
        }
    }

    //ボタンの処理。bn[n]でボタンを区別。
    public void actionPerformed(ActionEvent e) {
        Object oj = e.getSource();

        if (bn[0] == oj) { //all fill
            bBn[0] = 1;
        } else if (bn[1] == oj) { //all void
            bBn[0] = 0;
        } else if (bn[2] == oj) {//開始
            bBn[1] = 0;
            //x軸の大きさ
            pubX = cellW;
            //y軸の大きさ
            pubY = cellH;

            reset(pubX, pubY);
            new setCell();
            tf = xq;
            new sleep(5);

        } else if (bn[3] == oj) { //一時停止
            bBn[1] = 1;
        } else if (bn[4] == oj) { //再開
            bBn[1] = 2;
            pubX = cellW;
            pubY = cellH;

            tf = xq;
        } else if (bn[5] == oj) { //終了
            bBn[1] = 1000;
        } else if (bn[6] == oj){ //fpsの設定
            try {
                if (Integer.parseInt(td.getText())<1||(Integer.parseInt(td.getText())>1000)) {
                    td.setText(String.valueOf((int)fps));
                    JOptionPane.showMessageDialog(this, "1~1000の整数を入力して下さい");
                } else {
                    fps = Integer.parseInt(td.getText());
                }
            } catch (Exception ignored) {
                td.setText(String.valueOf((int)fps));
                JOptionPane.showMessageDialog(this, "1~1000の整数を入力して下さい");
            }
        } else if (bn[7] == oj) {
            fps = fps * 0.5F;
            if (fps<1F) {
                fps = fps*2F;
                td.setText(String.valueOf((int)fps));
                JOptionPane.showMessageDialog(this, "1~1000の値にして下さい");
            }
            td.setText(String.valueOf((int)fps));
        } else if (bn[8] == oj) {
            fps = fps * 2F;
            if (fps>1024F) {
                fps = fps/2F;
                JOptionPane.showMessageDialog(this, "1~1000の値にして下さい");
            }
            td.setText(String.valueOf((int)fps));
        } else if (bn[9] == oj) { //システムの終了
            System.exit(0);
        } else if (bn[10] == oj) {
            if (bBn[2]==0) {
                bBn[2] = 1;
            } else {
                bBn[2] = 0;
            }
            reset(cellW,cellH);
            new setCell();
            xq = tf;
        } else if (bn[11] == oj) {
            if (bBn[3]==0) {
                bBn[3] = 1;
            } else {
                bBn[3] = 0;
            }
            displayBr = !displayBr;
        }
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        mouseX0 = e.getX();
        mouseY0 = e.getY();

        if ( e.getWheelRotation() == -1 ) { //セルを小さくする
            cellSize--;
            if (cellSize<1) {
                cellSize = 1;
            }

            for (int i = 0; i< cellW; i++) {
                for (int j = 0; j< cellH; j++) {
                    int x = cellSize*j + wid/2 - ((cellSize)*cellW)/2 - 20;
                    int y = cellSize*i + hid/2 - ((cellSize)*cellH)/2 - 20;
                    cell[i][j].setBounds( x, y, cellSize, cellSize);
                }
            }
        } else if (e.getWheelRotation() == 1) { //セルを大きくする
            cellSize++;
            if (cellSize>100) {
                cellSize = 100;
            }
            for (int i = 0; i< cellW; i++) {
                for (int j = 0; j< cellH; j++) {
                    int x = cellSize*j + wid/2 - ((cellSize)*cellW)/2 - 20;
                    int y = cellSize*i + hid/2 - ((cellSize)*cellH)/2 - 20;
                    cell[i][j].setBounds( x, y, cellSize, cellSize);
                }
            }
        }
    }

    public void repaint(long l) {
        super.repaint(l);
    }
}