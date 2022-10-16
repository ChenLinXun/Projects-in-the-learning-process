package CurriculumDesign.MazeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class FreestylePanel extends JPanel implements KeyListener, ActionListener {
    //定义建造框的数据结构
    private int maderX;//建造框的横坐标
    private int maderY;//建造框的纵坐标
    final private int move = 60;//建造框每次移动距离
    private boolean judge = true;//判断建造框是否能走出下一步
    private boolean isY = true;//判断建造框处是否能创建一个箱子

    //奶酪的坐标
    final private int cheeseX = 60*14;
    final private int cheeseY = 60*11;

    //定义箱子的数据结构
    private int N;//创建箱子的个数
    private Box[] box;


    //设置地图参数(传入原关卡参数，先还原关卡样貌)
    public void CreatMaze(int n){//定义箱子的个数
        this.N = n;
        this.box = new Box[N];
    }
    public void SetMaze(int i, int[] X, int[] Y){//定义每个箱子的坐标
        box[i] = new Box();
        this.box[i].setBoxX(X[i]);
        this.box[i].setBoxY(Y[i]);
    }

    //传出地图参数（将新的地图参数传出保存，用于替换原来的地图）
    public int getN() {
        return N;
    }//传出新地图的箱子总数
    public int getBoxX(int i ){//传出每个箱子的横坐标
        return this.box[i].getBoxX();
    }
    public int getBoxY(int i ){//传出每个箱子的纵坐标
        return this.box[i].getBoxY();
    }

    //构造器
    public FreestylePanel(){
        init();
        this.setFocusable(true);//获得焦点事件
        this.addKeyListener(this);//获得键盘事件
    }

    //初始化(初始化建造框的位置)
    public void init(){
        maderX = 60*6;
        maderY = 60*4;
    }

    //绘制面板，所以东西用这支笔画
    @Override
    protected void paintComponent(Graphics g) {//每画一次为一帧画面
        super.paintComponent(g);//清屏
        //绘制背景板
        this.setBackground(Color.WHITE);

        //绘制地图（绘制出每一个箱子）
        for (int i = 0; i < N; i++) {
            Data.box.paintIcon(this,g,60*box[i].getBoxX(),60*box[i].getBoxY());
        }

        //绘制奶酪
        Data.cheese.paintIcon(this,g,cheeseX,cheeseY);

        //绘制建造框
        Data.sign.paintIcon(this, g, maderX , maderY);

        //绘制定时器
        Data.num0.paintIcon(this,g,0,0);
        Data.num0.paintIcon(this,g,60,0);


    }

    //键盘监听，通过改变建造框坐标值控制建造框移动，同时通过改变box坐标值，改变箱子的绘制
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_UP) {
            judge = true;
            if ((maderY - move) >= 0) {//先判断建造框下个位置是否越出窗体边界
                if(0 == maderY - move && 0 == maderX){//判断建造框会不会撞上定时器
                    judge = false;
                }
                if(0 == maderY - move && 60 == maderX){//判断建造框会不会撞上定时器
                    judge = false;
                }
                if(judge){//如果建造框能移动
                    maderY = maderY - move;
                    repaint();
                }
            }
        }else if(keyCode == KeyEvent.VK_DOWN){
            judge = true;
            if((maderY+move) <= 720) {
                if(cheeseY == maderY+move && cheeseX == maderX){//判断建造框会不会撞上奶酪
                    judge = false;
                }
                if(cheeseY == maderY+move && cheeseX+60 == maderX){//判断建造框会不会撞上奶酪
                    judge = false;
                }
                if(judge){
                    maderY = maderY + move;
                    repaint();
                }
            }
        }else if(keyCode == KeyEvent.VK_LEFT){
            judge = true;
            if((maderX-move) >= 0){
                if(60 == maderX - move && 0 == maderY){//判断建造框会不会撞上定时器
                    judge = false;
                }
                if(judge){
                    maderX = maderX - move;
                    repaint();
                }
            }
        }else if(keyCode == KeyEvent.VK_RIGHT){
            judge = true;
            if((maderX+move) <= 900){
                if(cheeseX == maderX+move && cheeseY == maderY){//判断建造框会不会撞上奶酪
                    judge = false;
                }
                if(cheeseX == maderX+move && cheeseY+60 == maderY){//判断建造框会不会撞上奶酪
                    judge = false;
                }
                if(judge){
                    maderX = maderX + move;
                    repaint();
                }
            }
        }else if(keyCode == KeyEvent.VK_N){//当按下N键，表示消除这个箱子
            for (int i = 0; i < N; i++) {//判断有没有和建造框位置坐标相同的箱子（墙体）
                if (60 * box[i].getBoxY() == maderY && 60 * box[i].getBoxX() == maderX) {
                    //将这个箱子和最后一个箱子交换
                    box[i] = box[box.length - 1];
                    //再将箱子组缩容，即消除最后一个箱子，也就是刚刚想要消除的那个箱子
                    box = Arrays.copyOf(box, box.length - 1);
                    N--;
                    repaint();
                }
            }
        }else if(keyCode == KeyEvent.VK_Y){//当按下Y键，表示在此创建一个箱子
            for (int i = 0; i < N; i++) {
                if (60 * box[i].getBoxY() == maderY && 60 * box[i].getBoxX() == maderX) {
                    isY = false;
                }
            }
            if(isY){
                //先将箱子组扩容
                box = Arrays.copyOf(box, box.length + 1);
                //注意！此时必须对新加入的箱子进行初始化，否则会出现空指针异常
                box[box.length - 1] = new Box();
                //再在箱子组末尾加上想要创建的这个箱子
                box[box.length - 1].setBoxX(maderX / move);
                box[box.length - 1].setBoxY(maderY / move);
                N++;
                repaint();
            }
        }else if(keyCode == KeyEvent.VK_ESCAPE){//游戏中弹出菜单的监听
            this.setFocusable(false);
        }else if(keyCode == KeyEvent.VK_ENTER){//自定义关卡确认键
            this.setFocusable(false);
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}


    //事件监听
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
