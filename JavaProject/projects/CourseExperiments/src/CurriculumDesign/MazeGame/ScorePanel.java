package CurriculumDesign.MazeGame;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {

    private int score;

    public void setScore(int score) {
        this.score = score;
    }
    //绘制面板，所以东西用这支笔画
    @Override
    protected void paintComponent(Graphics g) {//每画一次为一帧画面

        if(score == 0){
            Data.s0.paintIcon(this, g, 0, 0);
        }else if(score == 1){
            Data.s1.paintIcon(this, g, 0, 0);
        }else if(score == 2){
            Data.s2.paintIcon(this, g, 0, 0);
        }else if(score == 3){
            Data.s3.paintIcon(this, g, 0, 0);
        }else if(score == 4){
            Data.s4.paintIcon(this, g, 0, 0);
        }else if(score == 5){
            Data.s5.paintIcon(this, g, 0, 0);
        }
    }

}
