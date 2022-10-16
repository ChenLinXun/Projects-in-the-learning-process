package com.Feng;

import java.util.Arrays;
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("HelloWorld!");


        Scanner number = new Scanner(System.in);

        System.out.println("请输入需要输入数字的个数：");

        int n = number.nextInt();
        int[] a = new int[n];

        System.out.println("请输入" + n + "个数字:");
        for (int i = 0; i < a.length; i++){
            a[i] = number.nextInt();
        }
        //调用取最大值方法，输出最大值
        int max = foundMax(a);
        System.out.println(max);

        //调用数组逆转方法，输出逆转后的数组
        int[] result = reverse(a);
        for (int i : result) {
            System.out.print(i + " ");
        }

        //Arrays类方法将数组升序排序
        Arrays.sort(result);
        //Arrays类方法将数组元素以字符串形式依次输出
        System.out.println(Arrays.toString(result));
    }

        //找数组中最大元素
        public static int foundMax ( int[] b){
            int max = 0;
            for (int i = 0; i < b.length; i++) {
                if (b[i] > max)
                    max = b[i];
            }
            return (max);
        }

        //翻转数组元素
        public static int[] reverse ( int[] b){
            int[] c = new int[b.length];
            for (int i = 0, j = b.length - 1; i < b.length; i++, j--) {
                c[i] = b[j];
            }
            return (c);
        }

    }


