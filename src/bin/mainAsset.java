package bin;

public class mainAsset {

    public static int pubY = 30;
    public static int pubX = 30;
    /**
     * xq[y座標][x座標]
     */
    public static boolean[][] xq;
    private static int[][] lifePoint;


    public static void reset(int x,int y) {

        pubY = x;
        pubX = y;

        xq = new boolean[x][y];
        lifePoint = new int[x][y];

        for (int i = 0; i < pubY; i++) {
            for (int j = 0; j < pubX; j++) {
                xq[i][j] = false;
            }
        }
    }

    public static boolean[][] mainAsset() {
        reColor(pubY, pubX);
        ans(pubY, pubX);
        return xq;
    }

    //コマンドプロンプトに表示する。//out put command purompte
    public static void mainAssetPrint() {
        for (int i = 0; i < pubX; i++) {
            for (int j = 0; j < pubY; j++) {
                if (xq[i][j]) {
                    System.out.print("■ ");
                } else {
                    System.out.print("□ ");
                }
            }
            System.out.print("\n");
        }
        System.out.print("""
                                           
                                           
                   """);
        reColor(pubY, pubX);
        ans(pubY, pubX);
    }

    public static void reColor(int x,int y) {
        //マスごとに調べる
        for (int i = 0;i<x; i++) {
            for (int j = 0;j<y; j++) {
                lifePoint[i][j] = 0;
                //周囲8マスの生存しているマスを数える
                for (int k=-1;k<=1;k++) {
                    for (int l=-1;l<=1;l++) {
                        try {
                            if (xq[i+k][j+l]) {
                                lifePoint[i][j]++;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignored) {
                            lifePoint[i][j]+=0;
                        }
                    }
                }
            }
        }
    }
//ここで昼休み。お茄子おいしい。とてもおいしい
    public static void ans (int x,int y) {
        for (int i=0;i<x;i++) {
            for (int j=0;j<y;j++) {
                if (xq[i][j]) {
                    //セルが生きてる時の処理
                    if (lifePoint[i][j]<=2) {
                        xq[i][j] = false;
                    } else if (lifePoint[i][j]==3||(lifePoint[i][j]==4)) {
                        xq[i][j] = true;
                    } else if (lifePoint[i][j]>=5) {
                        xq[i][j] = false;
                    }
                } else {
                    //セルが死んでいる時の処理
                    if (lifePoint[i][j]==3) {
                        xq[i][j] = true;
                    }
                }
            }
        }
    }
}