package CurriculumDesign.MazeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

    //定义老鼠的数据结构
    private int mouseX;//老鼠的横坐标
    private int mouseY;//老鼠的纵坐标
    private String direction;//老鼠面朝方向
    final private int move = 60;//老鼠每次移动距离
    private boolean judge = true;//判断老鼠是否能走出下一步

    //奶酪的坐标
    final private int cheeseX = 60*14;
    final private int cheeseY = 60*11;

    //定义箱子的数据结构
    private int N;//创建箱子的个数
    private Box[] box;

    //定时器数据结构
    int num;//num的数字即表示当前秒数

    //定义定时器
    Timer timer = new Timer(1000,this);


    //能否通关的参数
    private int isWin = 2;//0代表失败，1代表成功，2代表游戏没结束
    //获取是否通关参数的方法
    public int getIsWin() {
        return isWin;
    }

    //设置地图参数
    public void CreatMaze(int n){//定义箱子的个数
        this.N = n;
        this.box = new Box[N];
    }
    public void SetMaze(int i, int[] X, int[] Y){//定义每个箱子的坐标，从MapInformation中获得
        box[i] = new Box();
        this.box[i].setBoxX(X[i]);
        this.box[i].setBoxY(Y[i]);
    }
    public void SetMaze(int i, int X, int Y){//重载，自定义关卡的时候用，从FreestylePanel中获得
        box[i] = new Box();
        this.box[i].setBoxX(X);
        this.box[i].setBoxY(Y);
    }

    //构造器
    public GamePanel(){
        init();
        this.setFocusable(true);//获得焦点事件
        this.addKeyListener(this);//获得键盘事件
    }

    //初始化(初始化老鼠位置)
    public void init(){
        isWin = 2;
        timer.start();
        num = 30;
        mouseX = 60*6;
        mouseY = 60*4;
        direction = "R";
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

        //绘制移动后的老鼠
        if(direction.equals("R")){
            Data.mouseRight.paintIcon(this,g,mouseX,mouseY);
        }else if (direction.equals("L")){
            Data.mouseLeft.paintIcon(this,g,mouseX,mouseY);
        }

        //绘制定时器
        if(num >= 0 && num <= 9){
            Data.num0.paintIcon(this,g,0,0);
            if(num == 0){Data.num0.paintIcon(this,g,60,0);}
            if(num == 1){Data.num1.paintIcon(this,g,60,0);}
            if(num == 2){Data.num2.paintIcon(this,g,60,0);}
            if(num == 3){Data.num3.paintIcon(this,g,60,0);}
            if(num == 4){Data.num4.paintIcon(this,g,60,0);}
            if(num == 5){Data.num5.paintIcon(this,g,60,0);}
            if(num == 6){Data.num6.paintIcon(this,g,60,0);}
            if(num == 7){Data.num7.paintIcon(this,g,60,0);}
            if(num == 8){Data.num8.paintIcon(this,g,60,0);}
            if(num == 9){Data.num9.paintIcon(this,g,60,0);}
        }else if(num >= 10 && num <= 19){
            Data.num1.paintIcon(this,g,0,0);
            if(num == 10){Data.num0.paintIcon(this,g,60,0);}
            if(num == 11){Data.num1.paintIcon(this,g,60,0);}
            if(num == 12){Data.num2.paintIcon(this,g,60,0);}
            if(num == 13){Data.num3.paintIcon(this,g,60,0);}
            if(num == 14){Data.num4.paintIcon(this,g,60,0);}
            if(num == 15){Data.num5.paintIcon(this,g,60,0);}
            if(num == 16){Data.num6.paintIcon(this,g,60,0);}
            if(num == 17){Data.num7.paintIcon(this,g,60,0);}
            if(num == 18){Data.num8.paintIcon(this,g,60,0);}
            if(num == 19){Data.num9.paintIcon(this,g,60,0);}
        }else if(num >= 20 && num <=29){
            Data.num2.paintIcon(this,g,0,0);
            if(num == 20){Data.num0.paintIcon(this,g,60,0);}
            if(num == 21){Data.num1.paintIcon(this,g,60,0);}
            if(num == 22){Data.num2.paintIcon(this,g,60,0);}
            if(num == 23){Data.num3.paintIcon(this,g,60,0);}
            if(num == 24){Data.num4.paintIcon(this,g,60,0);}
            if(num == 25){Data.num5.paintIcon(this,g,60,0);}
            if(num == 26){Data.num6.paintIcon(this,g,60,0);}
            if(num == 27){Data.num7.paintIcon(this,g,60,0);}
            if(num == 28){Data.num8.paintIcon(this,g,60,0);}
            if(num == 29){Data.num9.paintIcon(this,g,60,0);}
        }else if(num == 30){
            Data.num3.paintIcon(this,g,0,0);
            Data.num0.paintIcon(this,g,60,0);
        }

        //绘制通关失败或通关成功的界面
        if(isWin == 0){//绘制失败界面
            Data.Loose.paintIcon(this,g,0,0);
        }else if(isWin == 1){//绘制成功界面
            Data.Win.paintIcon(this,g,0,0);
        }
    }

    //键盘监听，通过改变老鼠坐标值控制老鼠移动
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_UP) {
            judge = true;
            if ((mouseY - move) >= 0) {//先判断老鼠下个位置是否越出窗体边界
                for (int i = 0; i < N; i++) {//再判断有没有和老鼠下个位置坐标相同的箱子（墙体）
                    if (60*box[i].getBoxY() == mouseY - move && 60*box[i].getBoxX() == mouseX) {
                        judge = false;
                    }
                }
                if(0 == mouseY - move && 0 == mouseX){//判断老鼠会不会撞上定时器
                    judge = false;
                }
                if(0 == mouseY - move && 60 == mouseX){//判断老鼠会不会撞上定时器
                    judge = false;
                }
                if(judge){//如果老鼠能移动
                    mouseY = mouseY - move;
                    repaint();
                }
            }
        }else if(keyCode == KeyEvent.VK_DOWN){
            judge = true;
            if((mouseY+move) <= 720) {
                for(int i=0; i<N; i++) {
                    if (60*box[i].getBoxY() == mouseY + move && 60*box[i].getBoxX() == mouseX) {
                        judge = false;
                    }
                }
                if(judge){
                    mouseY = mouseY + move;
                    repaint();
                }
            }
        }else if(keyCode == KeyEvent.VK_LEFT){
            judge = true;
            direction = "L";
            if((mouseX-move) >= 0){
                for(int i=0; i<N; i++) {
                    if (60*box[i].getBoxX() == mouseX - move && 60*box[i].getBoxY() == mouseY) {
                        judge = false;
                    }
                }
                if(60 == mouseX - move && 0 == mouseY){//判断老鼠会不会撞上定时器
                    judge = false;
                }
                if(judge){
                    mouseX = mouseX - move;
                    repaint();
                }

            }
        }else if(keyCode == KeyEvent.VK_RIGHT){
            judge = true;
            direction = "R";
            if((mouseX+move) <= 900){
                for(int i=0; i<N; i++) {
                    if (60 * box[i].getBoxX() == mouseX + move && 60 * box[i].getBoxY() == mouseY) {
                        judge = false;
                    }
                }
                if(judge){
                    mouseX = mouseX + move;
                    repaint();
                }
            }
        }else if(keyCode == KeyEvent.VK_ESCAPE){//游戏中弹出菜单的监听
            this.setFocusable(false);
        }else if(keyCode == KeyEvent.VK_SPACE && (isWin == 0 || isWin == 1)){//游戏结束后弹出菜单的监听
            this.setFocusable(false);
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}

    //事件监听，运用定时器，在界面中实现计时
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.isFocusOwner() == true){//当游戏关卡获得焦点后再对num进行减减
            num--;
            repaint();
            if(num == 0){
                timer.stop();
            }
        }
        if(num == 0 && (mouseX != cheeseX || mouseY != cheeseY)){//判定失败
            isWin = 0;
        }else if (num > 0 && mouseX == cheeseX && mouseY == cheeseY){//判定成功
            isWin = 1;
        }
    }

}
