package asset;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class jsonLoader {

    /*
    gameAsset->翡翠色[#38b48b]
    appSetting->鳩羽色[#95859c]
    readConfig->紺碧色[#007bbbc]
     */
    /**
     * <h3><font color="#38b48b">gameAsset</font></h3>
     * フィールドの幅
     */
    public static int jsW;
    /**
     * <h3><font color="#38b48b">gameAsset</font></h3>
     * フィールドの高さ
     */
    public static int jsH;
    /**
     * <h3><font color="#38b48b">gameAsset</font></h3>
     * オブジェクトのx座標
     */
    public static int jsObjX;
    /**
     * <h3><font color="#38b48b">gameAsset</font></h3>
     * オブジェクトのy座標
     */
    public static int jsObjY;
    /**
     * <h3><font color="#38b48b">gameAsset</font></h3>
     * @for.lengt 自動設置の数
     */
    public static int jsForLength;
    /**
     * <h3><font color="#38b48b">gameAsset</font></h3>
     * @set.length 手動設置の数
     */
    public static int jsSetLength;
    /**
     * <h3><font color="#38b48b">gameAsset</font></h3>
     * オブジェクトの幅
     */
    public static int[] jsForW;
    /**
     * <h3><font color="#38b48b">gameAsset</font></h3>
     * オブジェクトの高さ
     */
    public static int[] jsForH;
    /**
     * <h3><font color="#38b48b">gameAsset</font></h3>
     * セルのx座標
     */
    public static int[] jsSetX;
    /**
     * <h3><font color="#38b48b">gameAsset</font></h3>
     * セルのy座標
     */
    public static int[] jsSetY;
    /**
     * <h3><font color="#38b48b">gameAsset</font></h3>
     * 自動設置で埋めるか否か
     */
    public static boolean[] jsForFill;
    /**
     * <h3><font color="#38b48b">gameAsset</font></h3>
     * 手動設置で埋めるか否か
     */
    public static boolean[] jsSetFill;
    /**
     * <h3><font color="#95859c">appSetting</font></h3>
     * fps
     */
    public static long jsFps;
    /**
     * <h3><font color="#95859c">appSetting</font></h3>
     * frameのx座標
     */
    public static int jsAppX;
    /**
     * <h3><font color="#95859c">appSetting</font></h3>
     * frameのy座標
     */
    public static int jsAppY;
    /**
     * <h3><font color="#95859c">appSetting</font></h3>
     * frameの幅
     */
    public static int jsAppW;
    /**
     * <h3><font color="#95859c">appSetting</font></h3>
     * frameの高さ
     */
    public static int jsAppH;
    /**
     * <h3><font color="#95859c">appSetting</font></h3>
     * ボタンのフォントの大きさ
     */
    public static int jsFontSize;
    /**
     * <h3><font color="#95859c">appSetting</font></h3>
     * ボタンのフォント
     */
    public static String jsFont;
    /**
     * <h3><font color="#95859c">appSetting</font></h3>
     * 背景の画像のパス
     */
    public static String jsImagePath;
    /**
     * <h3><font color="#95859c">appSetting</font></h3>
     * ボタンに表示する文字列
     */
    public static final String[] jsBnText = new String[12];
    /**
     * <h3><font color="#007bbbc">readSetting</font></h3>
     *どのconfig(アプリの設定)を読むか
     */
    public static String jsReadConfig;
    /**
     * <h3><font color="#007bbbc">readSetting</font></h3>
     * どのasset(設置するセルやフィールドの大きさ)を読むか
     */
    public static String jsReadAsset;

    /**
     * オブジェクトを置くモード
     */
    public static final int GAME_ASSET = 0;
    /**
     * アプリの設定を読むモード
     */
    public static final int APP_SETTING = 1;
    /**
     * どの設定を読むか決めるモード
     */
    public static final int LOAD_FILE = 2;

    public jsonLoader(int loadMode) {
        File _path = null;
        Path path = null;

        try {
            //get path
            if (loadMode == GAME_ASSET) {
                _path = new File("./resource/" + jsReadAsset + ".lcel");
            } else if (loadMode == APP_SETTING) {
                _path = new File("./setting/config/" + jsReadConfig + ".lfs");
            } else if (loadMode == LOAD_FILE) {
                _path = new File("./setting/setting.lfs");
            }
            assert _path != null;
            path = Path.of(_path.getAbsolutePath());
        } catch (Exception ignored) {}

        ObjectMapper omr = new ObjectMapper();
        JsonNode jn;

        try {
            assert path != null;
            jn = omr.readTree(path.toFile());

            if ( loadMode == GAME_ASSET ) {
                //gameAsset
                jsObjX = jn.get("point").get("x").asInt();
                jsObjY = jn.get("point").get("y").asInt();
                jsW = jn.get("size").get("w").asInt();
                jsH = jn.get("size").get("h").asInt();
                jsForLength = jn.get("cell").get("lengthFor").asInt();
                jsSetLength = jn.get("cell").get("lengthSet").asInt();
                System.out.println("jso"); //del

                jsForW = new int[jsForLength];
                jsForH = new int[jsForLength];
                jsForFill = new boolean[jsForLength];
                jsSetX = new int[jsSetLength];
                jsSetY = new int[jsSetLength];
                jsSetFill = new boolean[jsSetLength];
                System.out.println("jsf"); //del

                for (int i = 0; i < jsForLength; i++) {
                    jsForW[i] = jn.get("cell").get("for").get(i).get("w").asInt();
                    jsForH[i] = jn.get("cell").get("for").get(i).get("h").asInt();
                    jsForFill[i] = jn.get("cell").get("for").get(i).get("fill").asBoolean();
                }
                System.out.println("jsfl"); //del

                for (int i = 0; i < jsSetLength; i++) {
                    jsSetX[i] = jn.get("cell").get("set").get(i).get("x").asInt();
                    jsSetY[i] = jn.get("cell").get("set").get(i).get("y").asInt();
                    jsSetFill[i] = jn.get("cell").get("set").get(i).get("fill").asBoolean();
                }
                System.out.println("jssl"); //del
            } else if (loadMode == APP_SETTING) {
                //panel
                jsFps = jn.get("fps").asLong();
                jsAppX = jn.get("appBound").get("x").asInt();
                jsAppY = jn.get("appBound").get("y").asInt();
                jsAppW = jn.get("appBound").get("w").asInt();
                jsAppH = jn.get("appBound").get("h").asInt();

                //label
                String rPath = jn.get("back").get("image").textValue();
                File file = new File("image/panel/" + rPath);
                Path path1 = Path.of(file.getAbsolutePath());
                jsImagePath = path1.toString();
                System.out.println(jsImagePath);

                //button
                jsFontSize = jn.get("font-size").asInt();
                jsFont  = jn.get("font").textValue();

                for (int i=0;i<jsBnText.length;i++) {
                    try {
                        jsBnText[i] = jn.get("text").get(i).get("text").textValue();
                        System.out.println(jsBnText[i]); //del
                    } catch (ArrayIndexOutOfBoundsException ignored) {}
                }
            } else {
                jsReadConfig = jn.get("config").textValue();
                jsReadAsset = jn.get("asset").textValue();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
