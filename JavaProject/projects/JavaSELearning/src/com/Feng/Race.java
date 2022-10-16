package com.Feng;

public class Race implements Runnable {

    private int steps = 0;
    private String winner;

    @Override
    public void run() {

        for (steps = 0; steps <= 100; steps++) {

            if(Thread.currentThread().getName() == "兔子" && steps%10 == 0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            boolean flag = gameOver(steps);
            if(flag){
                break;
            }

            System.out.println(Thread.currentThread().getName() + "跑了第" + steps + "步");
        }

    }

    public boolean gameOver(int steps){
        if(winner != null){
            return true;
        }

        if (steps >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println(winner + "获得比赛胜利！");
            return true;
        }
        return false;
    }

}