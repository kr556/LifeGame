package asset;

import static asset.jsonLoader.*;
import static bin.mainAsset.xq;

public class setCell {

    /**
     * セルを設置する座標を決める
     */
    public setCell() {
        new jsonLoader(GAME_ASSET);
        try {
            for (int i=0;i<jsForLength;i++) {
                defXq(jsObjX,jsObjX + jsForW[i],jsObjY,jsObjY + jsForH[i],jsSetFill[i]);
            }

            for (int i=0;i<jsSetLength;i++) {
                xq[jsSetY[i] + jsObjX][jsSetX[i] + jsObjY] = jsSetFill[i];
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }

    /**
     *
     * @param x0 x座標の始点
     * @param x1 x座標の終点
     * @param y0 y座標の始点
     * @param y1 y座標の終点
     * @param b 埋めるか否か
     */
    public static void defXq(int x0,int x1,int y0,int y1,boolean b) {
        for (int i = y0; i < y1+1; i++) {
            for (int j = x0; j < x1+1; j++) {
                xq[i][j] = b;
            }
        }
    }
}
