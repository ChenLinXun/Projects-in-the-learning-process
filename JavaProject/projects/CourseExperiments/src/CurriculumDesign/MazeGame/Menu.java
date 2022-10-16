package CurriculumDesign.MazeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Menu extends JFrame implements KeyListener,ActionListener {

    //当前积分
    private int score;

    //地图数据
    MapInformation M;

    //当前关卡编号
    int gameNum;

    //关卡面板，一个关卡就是一个面板
    GamePanel gamePanel1;//按序号分，这个是第一关
    GamePanel gamePanel2;
    GamePanel gamePanel3;
    GamePanel gamePanel4;
    GamePanel gamePanel5;


    //通关面板，每一个关卡都有一个通关面板
    GameOverPanel gameOverPanel1;
    GameOverPanel gameOverPanel2;
    GameOverPanel gameOverPanel3;
    GameOverPanel gameOverPanel4;
    GameOverPanel gameOverPanel5;

    //积分板，用于展现当前积分
    ScorePanel scorePanel;

    //自定义面板，用于对一个关卡进行自定义设置
    FreestylePanel freestylePanel;

    //showPanel,用于搭载需要显示出来的面板，如菜单，关卡等
    JPanel showPanel = new JPanel();

    //设置卡片，将showPanel上的所有面板设置为一个卡片组，需要显示出来的为卡片组的最上面那张
    CardLayout card = new CardLayout();

    JPanel mainMenu;//游戏的最初界面，一个主菜单
    JPanel viceMenu;//游戏过程中按下Esc键出现的副菜单1
    JPanel gameOverMenu;//游戏关卡结束后按下空格键出现的副菜单2
    JPanel freestyleTips;//按下自定义关卡键出现的提示界面

    //关于按钮
    JButton button1;//主菜单中开始游戏按钮
    JButton button2;//主菜单中的查看当前积分按钮
    JButton button3;//副菜单1中的继续游戏按钮
    JButton button4;//副菜单1中的返回主菜单按钮
    JButton button5;//副菜单2中的下一关游戏按钮
    JButton button6;//副菜单2中的返回主菜单按钮
    JButton button7;//副菜单2中的查看本关正确游戏路径按钮
    JButton button8;//副菜单2中的自定义关卡按钮
    JButton button9;//自定义关卡提示界面的确认按钮
    JButton button10;//副菜单1中恢复关卡原貌的按钮
    JButton button11;//积分板界面上的返回主菜单按钮
    JButton button12;//主菜单中的继续游戏按钮

    //关于标签(freestyleTips的操作提示)
    JLabel lable;


    //构造器
    public Menu() {
        //建立窗体
        setBounds(200, 0, 973, 817);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //建立各个关卡面板
        //第一关
        gamePanel1 = new GamePanel();
        M = new MapInformation();
        gamePanel1.CreatMaze(M.getX1().length);
        for(int i = 0;i<M.getX1().length;i++) {//传入关卡数据
            gamePanel1.SetMaze(i,M.getX1(),M.getY1());
        }
        //第二关
        gamePanel2 = new GamePanel();
        gamePanel2.CreatMaze(M.getX2().length);
        for(int i = 0;i<M.getX2().length;i++) {//传入关卡数据
            gamePanel2.SetMaze(i,M.getX2(),M.getY2());
        }
        //第三关
        gamePanel3 = new GamePanel();
        gamePanel3.CreatMaze(M.getX3().length);
        for(int i = 0;i<M.getX3().length;i++) {//传入关卡数据
            gamePanel3.SetMaze(i,M.getX3(),M.getY3());
        }
        //第四关
        gamePanel4 = new GamePanel();
        gamePanel4.CreatMaze(M.getX4().length);
        for(int i = 0;i<M.getX4().length;i++) {//传入关卡数据
            gamePanel4.SetMaze(i,M.getX4(),M.getY4());
        }
        //第五关
        gamePanel5 = new GamePanel();
        gamePanel5.CreatMaze(M.getX5().length);
        for(int i = 0;i<M.getX5().length;i++) {//传入关卡数据
            gamePanel5.SetMaze(i,M.getX5(),M.getY5());
        }


        //建立各个通关面板
        //第一关
        gameOverPanel1 = new GameOverPanel();
        gameOverPanel1.CreatMaze(M.getX1().length);
        for(int i = 0;i<M.getX1().length;i++) {//传入关卡数据
            gameOverPanel1.SetMaze(i,M.getX1(),M.getY1());
        }
        gameOverPanel1.CreatSign(M.getSX1().length);
        for(int i = 0;i<M.getSX1().length;i++) {//传入关卡数据
            gameOverPanel1.SetSign(i,M.getSX1(),M.getSY1());
        }
        //第二关
        gameOverPanel2 = new GameOverPanel();
        gameOverPanel2.CreatMaze(M.getX2().length);
        for(int i = 0;i<M.getX2().length;i++) {//传入关卡数据
            gameOverPanel2.SetMaze(i,M.getX2(),M.getY2());
        }
        gameOverPanel2.CreatSign(M.getSX2().length);
        for(int i = 0;i<M.getSX2().length;i++) {//传入关卡数据
            gameOverPanel2.SetSign(i,M.getSX2(),M.getSY2());
        }
        //第三关
        gameOverPanel3 = new GameOverPanel();
        gameOverPanel3.CreatMaze(M.getX3().length);
        for(int i = 0;i<M.getX3().length;i++) {//传入关卡数据
            gameOverPanel3.SetMaze(i,M.getX3(),M.getY3());
        }
        gameOverPanel3.CreatSign(M.getSX3().length);
        for(int i = 0;i<M.getSX3().length;i++) {//传入关卡数据
            gameOverPanel3.SetSign(i,M.getSX3(),M.getSY3());
        }
        //第四关
        gameOverPanel4 = new GameOverPanel();
        gameOverPanel4.CreatMaze(M.getX4().length);
        for(int i = 0;i<M.getX4().length;i++) {//传入关卡数据
            gameOverPanel4.SetMaze(i,M.getX4(),M.getY4());
        }
        gameOverPanel4.CreatSign(M.getSX4().length);
        for(int i = 0;i<M.getSX4().length;i++) {//传入关卡数据
            gameOverPanel4.SetSign(i,M.getSX4(),M.getSY4());
        }
        //第五关
        gameOverPanel5 = new GameOverPanel();
        gameOverPanel5.CreatMaze(M.getX5().length);
        for(int i = 0;i<M.getX5().length;i++) {//传入关卡数据
            gameOverPanel5.SetMaze(i,M.getX5(),M.getY5());
        }
        gameOverPanel5.CreatSign(M.getSX5().length);
        for(int i = 0;i<M.getSX5().length;i++) {//传入关卡数据
            gameOverPanel5.SetSign(i,M.getSX5(),M.getSY5());
        }


        //设置按钮
        button1 = new JButton("开始游戏");
        button1.setBounds(380,120,190,60);
        button1.addActionListener(this);
        button1.setActionCommand("开始游戏");

        button2 = new JButton("查看当前积分");
        button2.setBounds(380,200,190,60);
        button2.addActionListener(this);
        button2.setActionCommand("查看当前积分");

        button3 = new JButton("继续游戏");
        button3.setBounds(380,200,190,60);
        button3.addActionListener(this);
        button3.setActionCommand("继续游戏");

        button4 = new JButton("返回主菜单");
        button4.setBounds(380,280,190,60);
        button4.addActionListener(this);
        button4.setActionCommand("返回主菜单");

        button5 = new JButton("下一关");
        button5.setBounds(380,120,190,60);
        button5.addActionListener(this);
        button5.setActionCommand("下一关");

        button6 = new JButton("返回主菜单");
        button6.setBounds(380,200,190,60);
        button6.addActionListener(this);
        button6.setActionCommand("返回主菜单");

        button7 = new JButton("查看路径");
        button7.setBounds(380,280,190,60);
        button7.addActionListener(this);
        button7.setActionCommand("查看路径");

        button8 = new JButton("自定义该关卡");
        button8.setBounds(380,360,190,60);
        button8.addActionListener(this);
        button8.setActionCommand("自定义该关卡");

        button9 = new JButton("好");
        button9.setBounds(380,360,190,60);
        button9.addActionListener(this);
        button9.setActionCommand("好");

        button10 = new JButton("恢复原貌");
        button10.setBounds(380,440,190,60);
        button10.addActionListener(this);
        button10.setActionCommand("恢复原貌");

        button11 = new JButton("返回主菜单");
        button11.setBounds(380,200,190,60);
        button11.addActionListener(this);
        button11.setActionCommand("返回主菜单");

        button12 = new JButton("继续游戏");
        button12.setBounds(380,280,190,60);
        button12.addActionListener(this);
        button12.setActionCommand("继续游戏");

        //设置标签，freestyleTips的操作提示
        lable = new JLabel("方向键控制移动，按下N键消除当前位置障碍物，按下Y键生成，按回车完成自定义");
        lable.setBounds(300,200,600,300);

        //设置主菜单面板
        showPanel.setLayout(card);//将showPanel设置为卡片组的控制面板

        //在卡片组中添加卡片
        mainMenu = new JPanel(null);
        viceMenu = new JPanel(null);
        gameOverMenu = new JPanel(null);
        freestyleTips = new JPanel(null);
        freestylePanel = new FreestylePanel();
        scorePanel = new ScorePanel();
        showPanel.add("mainMenu",mainMenu);
        showPanel.add("viceMenu",viceMenu);
        showPanel.add("gameOverMenu",gameOverMenu);
        showPanel.add("freestyleTips",freestyleTips);
        showPanel.add("freestylePanel",freestylePanel);
        showPanel.add("game1",gamePanel1);
        showPanel.add("game2",gamePanel2);
        showPanel.add("game3",gamePanel3);
        showPanel.add("game4",gamePanel4);
        showPanel.add("game5",gamePanel5);
        showPanel.add("gameOver1",gameOverPanel1);
        showPanel.add("gameOver2",gameOverPanel2);
        showPanel.add("gameOver3",gameOverPanel3);
        showPanel.add("gameOver4",gameOverPanel4);
        showPanel.add("gameOver5",gameOverPanel5);
        showPanel.add("scorePanel",scorePanel);
        

        //对容器和面板布局进行设置
        Container container = getContentPane();
        container.add(showPanel);
        mainMenu.add(button1);
        mainMenu.add(button2);
        mainMenu.add(button12);
        viceMenu.add(button3);
        viceMenu.add(button4);
        viceMenu.add(button8);
        viceMenu.add(button10);
        gameOverMenu.add(button5);
        gameOverMenu.add(button6);
        gameOverMenu.add(button7);
        freestyleTips.add(button9);
        freestyleTips.add(lable);
        scorePanel.add(button11);

        //获得键盘事件
        addKeyListener(this);
        //设置焦点
        setFocusable(true);
        //设置窗体的可见
        setVisible(true);
    }

    //键盘监听
    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {
        //当游戏中按下Esc键，关卡将焦点归还给menu，从而通过键盘监听弹出副菜单，此时松开Esc则可触发该监听
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_ESCAPE){//弹出副菜单1
            card.show(showPanel,"viceMenu");
        }else if (keyCode == KeyEvent.VK_SPACE){//弹出副菜单2
            if(score<5 && gameNum == 1){
                if(gamePanel1.getIsWin() == 1) {
                    score++;
                }
                gamePanel1.init();//游戏结束后将一切初始化
            }else if(score<5 && gameNum == 2){
                if(gamePanel2.getIsWin() == 1) {
                    score++;
                }
                gamePanel2.init();//游戏结束后将一切初始化
            }else if(score<5 && gameNum == 3){
                if(gamePanel3.getIsWin() == 1) {
                    score++;
                }
                gamePanel3.init();//游戏结束后将一切初始化
            }else if(score<5 && gameNum == 4){
                if(gamePanel4.getIsWin() == 1) {
                    score++;
                }
                gamePanel4.init();//游戏结束后将一切初始化
            }else if(score<5 && gameNum == 5){
                if(gamePanel5.getIsWin() == 1) {
                    score++;
                }
                gamePanel5.init();//游戏结束后将一切初始化
            }
            card.show(showPanel,"gameOverMenu");
        }else if(keyCode == KeyEvent.VK_ENTER){//确认自定义地图
            if(gameNum == 1) {
                gamePanel1.CreatMaze(freestylePanel.getN());
                for (int i = 0; i < freestylePanel.getN(); i++) {
                    gamePanel1.SetMaze(i, freestylePanel.getBoxX(i), freestylePanel.getBoxY(i));
                }
                card.show(showPanel, "game1");
                gamePanel1.setFocusable(true);
                gamePanel1.requestFocus(true);
            }else if(gameNum == 2){
                gamePanel2.CreatMaze(freestylePanel.getN());
                for (int i = 0; i < freestylePanel.getN(); i++) {
                    gamePanel2.SetMaze(i, freestylePanel.getBoxX(i), freestylePanel.getBoxY(i));
                }
                card.show(showPanel, "game2");
                gamePanel2.setFocusable(true);
                gamePanel2.requestFocus(true);
            }else if(gameNum == 3){
                gamePanel3.CreatMaze(freestylePanel.getN());
                for (int i = 0; i < freestylePanel.getN(); i++) {
                    gamePanel3.SetMaze(i, freestylePanel.getBoxX(i), freestylePanel.getBoxY(i));
                }
                card.show(showPanel, "game3");
                gamePanel3.setFocusable(true);
                gamePanel3.requestFocus(true);
            }else if(gameNum == 4){
                gamePanel4.CreatMaze(freestylePanel.getN());
                for (int i = 0; i < freestylePanel.getN(); i++) {
                    gamePanel4.SetMaze(i, freestylePanel.getBoxX(i), freestylePanel.getBoxY(i));
                }
                card.show(showPanel, "game4");
                gamePanel4.setFocusable(true);
                gamePanel4.requestFocus(true);
            }else if(gameNum == 5){
                gamePanel5.CreatMaze(freestylePanel.getN());
                for (int i = 0; i < freestylePanel.getN(); i++) {
                    gamePanel5.SetMaze(i, freestylePanel.getBoxX(i), freestylePanel.getBoxY(i));
                }
                card.show(showPanel, "game5");
                gamePanel5.setFocusable(true);
                gamePanel5.requestFocus(true);
            }
        }
    }

    //事件监听
    @Override
    public void actionPerformed(ActionEvent e) {
        //注意设置焦点，当上一个面板失焦时将焦点交给下一个需要展现的面板

        if (e.getActionCommand().equals("开始游戏")) {
            gameNum = 1;
            card.show(showPanel,"game1");
            button1.setFocusable(false);
            gamePanel1.setFocusable(true);
            gamePanel1.requestFocus(true);
        }else if(e.getActionCommand().equals("查看当前积分")){
            scorePanel.setScore(score);
            card.show(showPanel,"scorePanel");
            button2.setFocusable(false);
            button11.setFocusable(true);
        }else if(e.getActionCommand().equals("下一关")) {
            if(gameNum<5) {
                gameNum++;
            }
            if(gameNum == 2) {
                card.show(showPanel, "game2");
                button2.setFocusable(false);
                gamePanel2.setFocusable(true);
                gamePanel2.requestFocus(true);
            }else if(gameNum == 3){
                card.show(showPanel, "game3");
                button2.setFocusable(false);
                gamePanel3.setFocusable(true);
                gamePanel3.requestFocus(true);
            }else if(gameNum == 4){
                card.show(showPanel, "game4");
                button2.setFocusable(false);
                gamePanel4.setFocusable(true);
                gamePanel4.requestFocus(true);
            }else if(gameNum == 5){
                card.show(showPanel, "game5");
                button2.setFocusable(false);
                gamePanel5.setFocusable(true);
                gamePanel5.requestFocus(true);
            }
        }else if(e.getActionCommand().equals("继续游戏")){
            if(gameNum == 1) {
                card.show(showPanel,"game1");
                button3.setFocusable(false);
                gamePanel1.setFocusable(true);
                gamePanel1.requestFocus(true);
            }else if(gameNum == 2){
                card.show(showPanel,"game2");
                button3.setFocusable(false);
                gamePanel2.setFocusable(true);
                gamePanel2.requestFocus(true);
            }else if(gameNum == 3){
                card.show(showPanel,"game3");
                button3.setFocusable(false);
                gamePanel3.setFocusable(true);
                gamePanel3.requestFocus(true);
            }else if(gameNum == 4){
                card.show(showPanel,"game4");
                button3.setFocusable(false);
                gamePanel4.setFocusable(true);
                gamePanel4.requestFocus(true);
            }else if(gameNum == 5){
                card.show(showPanel,"game5");
                button3.setFocusable(false);
                gamePanel5.setFocusable(true);
                gamePanel5.requestFocus(true);
            }
        }else if(e.getActionCommand().equals("返回主菜单")){
            card.show(showPanel,"mainMenu");
            button4.setFocusable(false);
            button1.setFocusable(true);
        }else if(e.getActionCommand().equals("查看路径")){
            if(gameNum == 1){
                card.show(showPanel,"gameOver1");
                button7.setFocusable(false);
            }else if(gameNum == 2){
                card.show(showPanel,"gameOver2");
                button7.setFocusable(false);
            }else if(gameNum == 3){
                card.show(showPanel,"gameOver3");
                button7.setFocusable(false);
            }else if(gameNum == 4){
                card.show(showPanel,"gameOver4");
                button7.setFocusable(false);
            }else if(gameNum == 5){
                card.show(showPanel,"gameOver5");
                button7.setFocusable(false);
            }
        }else if(e.getActionCommand().equals("自定义该关卡")){
            card.show(showPanel, "freestyleTips");
            button8.setFocusable(false);
            button9.setFocusable(true);
        }else if (e.getActionCommand().equals("好")) {
            if(gameNum == 1) {
                freestylePanel.CreatMaze(M.getX1().length);
                for (int i = 0; i < M.getX1().length; i++) {//传入关卡数据
                    freestylePanel.SetMaze(i, M.getX1(), M.getY1());
                }
                card.show(showPanel, "freestylePanel");
                button9.setFocusable(false);
                freestylePanel.setFocusable(true);
                freestylePanel.requestFocus(true);
            }else if(gameNum == 2){
                freestylePanel.CreatMaze(M.getX2().length);
                for (int i = 0; i < M.getX2().length; i++) {//传入关卡数据
                    freestylePanel.SetMaze(i, M.getX2(), M.getY2());
                }
                card.show(showPanel, "freestylePanel");
                button9.setFocusable(false);
                freestylePanel.setFocusable(true);
                freestylePanel.requestFocus(true);
            }else if(gameNum == 3){
                freestylePanel.CreatMaze(M.getX3().length);
                for (int i = 0; i < M.getX3().length; i++) {//传入关卡数据
                    freestylePanel.SetMaze(i, M.getX3(), M.getY3());
                }
                card.show(showPanel, "freestylePanel");
                button9.setFocusable(false);
                freestylePanel.setFocusable(true);
                freestylePanel.requestFocus(true);
            }else if(gameNum == 4){
                freestylePanel.CreatMaze(M.getX4().length);
                for (int i = 0; i < M.getX4().length; i++) {//传入关卡数据
                    freestylePanel.SetMaze(i, M.getX4(), M.getY4());
                }
                card.show(showPanel, "freestylePanel");
                button9.setFocusable(false);
                freestylePanel.setFocusable(true);
                freestylePanel.requestFocus(true);
            }else if(gameNum == 5){
                freestylePanel.CreatMaze(M.getX5().length);
                for (int i = 0; i < M.getX5().length; i++) {//传入关卡数据
                    freestylePanel.SetMaze(i, M.getX5(), M.getY5());
                }
                card.show(showPanel, "freestylePanel");
                button9.setFocusable(false);
                freestylePanel.setFocusable(true);
                freestylePanel.requestFocus(true);
            }
        }else if(e.getActionCommand().equals("恢复原貌")){
            if(gameNum == 1) {
                gamePanel1.CreatMaze(M.getX1().length);
                for(int i = 0;i<M.getX1().length;i++) {//传入关卡数据
                    gamePanel1.SetMaze(i,M.getX1(),M.getY1());
                }
                card.show(showPanel, "game1");
                button10.setFocusable(false);
                gamePanel1.setFocusable(true);
                gamePanel1.requestFocus(true);
            }else if(gameNum == 2){
                gamePanel2.CreatMaze(M.getX2().length);
                for(int i = 0;i<M.getX1().length;i++) {//传入关卡数据
                    gamePanel2.SetMaze(i,M.getX2(),M.getY2());
                }
                card.show(showPanel, "game2");
                button10.setFocusable(false);
                gamePanel2.setFocusable(true);
                gamePanel2.requestFocus(true);
            }else if(gameNum == 3){
                gamePanel3.CreatMaze(M.getX3().length);
                for(int i = 0;i<M.getX3().length;i++) {//传入关卡数据
                    gamePanel3.SetMaze(i,M.getX3(),M.getY3());
                }
                card.show(showPanel, "game3");
                button10.setFocusable(false);
                gamePanel3.setFocusable(true);
                gamePanel3.requestFocus(true);
            }else if(gameNum == 4){
                gamePanel4.CreatMaze(M.getX4().length);
                for(int i = 0;i<M.getX4().length;i++) {//传入关卡数据
                    gamePanel4.SetMaze(i,M.getX4(),M.getY4());
                }
                card.show(showPanel, "game4");
                button10.setFocusable(false);
                gamePanel4.setFocusable(true);
                gamePanel4.requestFocus(true);
            }else if(gameNum == 5){
                gamePanel5.CreatMaze(M.getX5().length);
                for(int i = 0;i<M.getX5().length;i++) {//传入关卡数据
                    gamePanel5.SetMaze(i,M.getX5(),M.getY5());
                }
                card.show(showPanel, "game5");
                button10.setFocusable(false);
                gamePanel5.setFocusable(true);
                gamePanel5.requestFocus(true);
            }
        }
    }
}
