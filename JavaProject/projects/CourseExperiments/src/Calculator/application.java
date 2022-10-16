
/* 缺点：每输入两个数及其两个数之间的运算符后必须按等于按钮计算后才能继续后续计算
  无法连续输入数和运算符后按等于按钮进行计算
 */

package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class application {
    public static void main(String[] args) {
        new Calculator();
    }
}

//计算器类
class Calculator extends JFrame{

    ArrayList<String> value = new ArrayList<String>();
    ArrayList<String> symbol = new ArrayList<String>();
    int count = 0;
    boolean j;

    JTextField textField;//公共的文本框对象，因为下面的方法和类里都要用到

    //构造器
    public Calculator() {
        //设置窗口属性
        setLayout(new BorderLayout());
        setSize(400, 600);
        setLocation(400, 100);
        setTitle("这是峰哥的小垃圾计算器");

        //设置窗口关闭事件可以不加窗口监听类，因为是JFrame直接添上下面这行代码即可
        // setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)

        //设置面板
        Panel p1 = new Panel(new GridLayout(1, 1));
        Panel p2 = new Panel(new GridLayout(5, 4));

        //设置按钮
        //数字键
        Button num0 = new Button("0");
        num0.setFont(new Font("宋体",Font.BOLD,20));
        Button num1 = new Button("1");
        num1.setFont(new Font("宋体",Font.BOLD,20));
        Button num2 = new Button("2");
        num2.setFont(new Font("宋体",Font.BOLD,20));
        Button num3 = new Button("3");
        num3.setFont(new Font("宋体",Font.BOLD,20));
        Button num4 = new Button("4");
        num4.setFont(new Font("宋体",Font.BOLD,20));
        Button num5 = new Button("5");
        num5.setFont(new Font("宋体",Font.BOLD,20));
        Button num6 = new Button("6");
        num6.setFont(new Font("宋体",Font.BOLD,20));
        Button num7 = new Button("7");
        num7.setFont(new Font("宋体",Font.BOLD,20));
        Button num8 = new Button("8");
        num8.setFont(new Font("宋体",Font.BOLD,20));
        Button num9 = new Button("9");
        num9.setFont(new Font("宋体",Font.BOLD,20));
        //功能键
        Button add = new Button("+");//加
        add.setFont(new Font("宋体",Font.BOLD,20));
        Button reduce = new Button("-");//减
        reduce.setFont(new Font("宋体",Font.BOLD,25));
        Button rid = new Button("×");//乘
        rid.setFont(new Font("宋体",Font.BOLD,20));
        Button divide = new Button("÷");//除
        divide.setFont(new Font("宋体",Font.BOLD,20));
        Button mod = new Button("%");//取模
        mod.setFont(new Font("宋体",Font.BOLD,20));
        Button negative = new Button("+/-");//取负（正）
        negative.setFont(new Font("宋体",Font.BOLD,20));
        Button point = new Button(".");//小数点
        point.setFont(new Font("宋体",Font.BOLD,20));
        //操作键
        Button equal = new Button("=");//等于
        equal.setFont(new Font("宋体",Font.BOLD,25));
        Button delete = new Button("delete");//删除
        delete.setFont(new Font("宋体",Font.BOLD,20));
        Button back = new Button("C");//归零
        back.setFont(new Font("宋体",Font.BOLD,20));

        //设置文本框
        textField = new JTextField(1000);
        textField.setText("0");
        textField.setFont(new Font("宋体",Font.BOLD,40));
        textField.setHorizontalAlignment(SwingConstants.RIGHT);

        //组件组装
        p1.add(textField);
        p2.add(mod);
        p2.add(back);
        p2.add(delete);
        p2.add(divide);
        p2.add(num7);
        p2.add(num8);
        p2.add(num9);
        p2.add(rid);
        p2.add(num4);
        p2.add(num5);
        p2.add(num6);
        p2.add(reduce);
        p2.add(num1);
        p2.add(num2);
        p2.add(num3);
        p2.add(add);
        p2.add(negative);
        p2.add(num0);
        p2.add(point);
        p2.add(equal);

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

        setVisible(true);

        //按键监听
        num0.addActionListener(new MyListener());
        num0.setActionCommand("0");
        num1.addActionListener(new MyListener());
        num1.setActionCommand("1");
        num2.addActionListener(new MyListener());
        num2.setActionCommand("2");
        num3.addActionListener(new MyListener());
        num3.setActionCommand("3");
        num4.addActionListener(new MyListener());
        num4.setActionCommand("4");
        num5.addActionListener(new MyListener());
        num5.setActionCommand("5");
        num6.addActionListener(new MyListener());
        num6.setActionCommand("6");
        num7.addActionListener(new MyListener());
        num7.setActionCommand("7");
        num8.addActionListener(new MyListener());
        num8.setActionCommand("8");
        num9.addActionListener(new MyListener());
        num9.setActionCommand("9");
        point.addActionListener(new MyListener());
        point.setActionCommand(".");
        add.addActionListener(new MyListener());
        add.setActionCommand("+");
        reduce.addActionListener(new MyListener());
        reduce.setActionCommand("-");
        rid.addActionListener(new MyListener());
        rid.setActionCommand("×");
        divide.addActionListener(new MyListener());
        divide.setActionCommand("÷");
        mod.addActionListener(new MyListener());
        mod.setActionCommand("%");
        equal.addActionListener(new MyListener());
        equal.setActionCommand("=");
        negative.addActionListener(new MyListener());
        negative.setActionCommand("+/-");
        delete.addActionListener(new MyListener());
        delete.setActionCommand("delete");
        back.addActionListener(new MyListener());
        back.setActionCommand("C");

        //设置窗口监听（关闭事件）
        addWindowListener(new MyWindowListener());

    }

    //窗口监听类
    class MyWindowListener extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    //事件监听类
    class MyListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("0")){
                boolean t = takeZero1(textField.getText());
                if (t == true) {
                    textField.setText("0");
                }
                else if (t == false){
                    textField.setText(textField.getText() + "0");
                }
            }
            else if(e.getActionCommand().equals("1")) {
                boolean t = takeZero1(textField.getText());
                if (t == true) {
                    textField.setText("1");
                }
                else if (t == false){
                    textField.setText(textField.getText() + "1");
                }
            }

            else if(e.getActionCommand().equals("2")){
                boolean t = takeZero1(textField.getText());
                if (t == true) {
                    textField.setText("2");
                }
                else if (t == false){
                    textField.setText(textField.getText() + "2");
                }
            }

            else if(e.getActionCommand().equals("3")){
                boolean t = takeZero1(textField.getText());
                if (t == true) {
                    textField.setText("3");
                }
                else if (t == false){
                    textField.setText(textField.getText() + "3");
                }
            }

            else if(e.getActionCommand().equals("4")){
                boolean t = takeZero1(textField.getText());
                if (t == true) {
                    textField.setText("4");
                }
                else if (t == false){
                    textField.setText(textField.getText() + "4");
                }
            }

            else if(e.getActionCommand().equals("5")){
                boolean t = takeZero1(textField.getText());
                if (t == true) {
                    textField.setText("5");
                }
                else if (t == false){
                    textField.setText(textField.getText() + "5");
                }
            }

            else if(e.getActionCommand().equals("6")){
                boolean t = takeZero1(textField.getText());
                if (t == true) {
                    textField.setText("6");
                }
                else if (t == false){
                    textField.setText(textField.getText() + "6");
                }
            }

            else if(e.getActionCommand().equals("7")){
                boolean t = takeZero1(textField.getText());
                if (t == true) {
                    textField.setText("7");
                }
                else if (t == false){
                    textField.setText(textField.getText() + "7");
                }
            }

            else if(e.getActionCommand().equals("8")){
                boolean t = takeZero1(textField.getText());
                if (t == true) {
                    textField.setText("8");
                }
                else if (t == false){
                    textField.setText(textField.getText() + "8");
                }
            }

            else if(e.getActionCommand().equals("9")){
                boolean t = takeZero1(textField.getText());
                if (t == true) {
                    textField.setText("9");
                }
                else if (t == false){
                    textField.setText(textField.getText() + "9");
                }
            }

            else if(e.getActionCommand().equals(".")){
                textField.setText(textField.getText()+".");
            }
            else if(e.getActionCommand().equals("+")){
                value.add(textField.getText());
                symbol.add("+");
                count++;
                textField.setText("");
            }
            else if(e.getActionCommand().equals("-")){
                value.add(textField.getText());
                symbol.add("-");
                count++;
                textField.setText("");
            }
            else if(e.getActionCommand().equals("×")){
                value.add(textField.getText());
                symbol.add("×");
                count++;
                textField.setText("");
            }
            else if(e.getActionCommand().equals("÷")){
                value.add(textField.getText());
                symbol.add("÷");
                count++;
                textField.setText("");
            }
            else if(e.getActionCommand().equals("%")){
                value.add(textField.getText());
                symbol.add("%");
                count++;
                textField.setText("");
            }
            else if(e.getActionCommand().equals("+/-")){
                textField.setText(Negative(textField.getText()));
            }
            else if(e.getActionCommand().equals("delete")){
                textField.setText(Delete(textField.getText()));
            }
            else if(e.getActionCommand().equals("C")){
                textField.setText("0");
                value.clear();
                symbol.clear();
                count = 0;
            }
            else if(e.getActionCommand().equals("=")){
                j = true;
                value.add(textField.getText());
                boolean t = takeZero2(Operator(symbol.get(count-1)));
                if (t == true){
                    textField.setText("0");
                }
                else if(t == false){
                    textField.setText(Operator(symbol.get(count-1)));
                }
            }
        }
    }
    //计算方法
    public String Operator(String str){
        Double result = 0.0 ;
        Double a = Double.parseDouble(value.get(2*count-2));
        Double b = Double.parseDouble(value.get(2*count-1));
        switch(str) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "×":
                result = a * b;
                break;
            case "÷":
                if (b != 0) {
                    result = a / b;
                    break;
                } else if (b == 0) {
                    String err = "除数不能为零！";
                    return err;
                }
            case "%":
                result = a % b;
            break;
        }
        java.text.NumberFormat NF = java.text.NumberFormat.getInstance();
        //设置数的小数部分所允许的最大位数，避免小数位被舍掉
        NF.setMaximumFractionDigits(15);
        //设置数的小数部分所允许的最小位数，避免小数位有多余的0
        NF.setMinimumFractionDigits(0);
        //去掉科学计数法显示
        NF.setGroupingUsed(false);
        return NF.format(result);
    }
    //删除功能方法
    public String  Delete(String str) {
        char res1[] = str.toCharArray();
        int n = res1.length;
        char[] res2 = new char[n - 1];
        for (int i = 0; i < n - 1; i++) {
            res2[i] = res1[i];
        }
        String res = new String(res2);
        return res;
    }
    //取正（负）功能方法
    public String  Negative(String str) {
        if(null == str || str.equals("")){
            str = "-";
            return str;
        }
        else {
            char res1[] = str.toCharArray();
            int n = res1.length;
            char[] res2 = new char[n + 1];
            res2[0] = '-';
            if (res1[0] == '0' && res1[n - 1] == '0') {
                String res = "-";
                return res;
            } else if (res1[0] == '-') {
                char[] res3 = new char[n - 1];
                for (int i = 0; i < n - 1; i++) {
                    res3[i] = res1[i + 1];
                }
                String res = new String(res3);
                return res;
            } else {
                for (int i = 0; i < n; i++) {
                    res2[i + 1] = res1[i];
                }
                String res = new String(res2);
                return res;
            }
        }
    }
    //输入框输入数字时去零方法
    public Boolean  takeZero1(String str) {
        if (null == str || str.equals("")) {
            return false;
        } else {
            char res1[] = str.toCharArray();
            int n = res1.length;
            if (n > 1) {
                return false;
            } else {
                if (res1[0] == '0') {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
    //输入框按下等号后去零方法
    public Boolean takeZero2 (String str){
        char res1[] = str.toCharArray();
        int n = res1.length;
        if (res1[0] == '0' && res1[n - 1] == '0') {
            return true;
        } else {
            return false;
        }
    }
}