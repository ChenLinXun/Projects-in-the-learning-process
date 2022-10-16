package CurriculumDesign.MazeGame;

import javax.swing.*;
import java.awt.*;

public class GameOverPanel extends JPanel {

    //奶酪的坐标
    final private int cheeseX = 60*14;
    final private int cheeseY = 60*11;

    //定义箱子的数据结构
    private int N;//创建箱子的个数
    private Box[] box;

    //路线指示的坐标
    private int n;
    private Sign[] sign;

    //设置地图参数
    public void CreatMaze(int n){//定义箱子的个数
        this.N = n;
        this.box = new Box[N];
    }
    public void SetMaze(int i, int[] X, int[] Y){//定义每个箱子的坐标
        box[i] = new Box();
        this.box[i].setBoxX(X[i]);
        this.box[i].setBoxY(Y[i]);
    }


    //设置指示参数
    public void CreatSign(int n){
        this.n = n;
        this.sign = new Sign[n];
    }
    public void SetSign(int i, int[] X, int[] Y){
        sign[i] = new Sign();
        this.sign[i].setSignX(X[i]);
        this.sign[i].setSignY(Y[i]);
    }

    //绘制面板，所以东西用这支笔画
    @Override
    protected void paintComponent(Graphics g) {//每画一次为一帧画面
        //绘制背景板
        this.setBackground(Color.WHITE);

        //绘制地图（绘制出每一个箱子）
        for (int i = 0; i < N; i++) {
            Data.box.paintIcon(this, g, 60 * box[i].getBoxX(), 60 * box[i].getBoxY());
        }
        //绘制路线（绘制出每一个足迹）
        for (int i = 0; i < n; i++) {
            Data.sign.paintIcon(this, g, 60 * sign[i].getSignX(), 60 * sign[i].getSignY());
        }

        //绘制奶酪
        Data.cheese.paintIcon(this, g, cheeseX, cheeseY);

        //绘制定时器
        Data.num0.paintIcon(this, g, 0, 0);
        Data.num0.paintIcon(this, g, 60, 0);

    }
}
