package com.ax.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    // 用来管理数据,加载图片的时候会根据二维数组加载图片
    int[][] arr = new int[4][4];
    // 用于判断游戏是否胜利的数组
    int[][] victory = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    // 定义(x,y)用于记录空白方块的坐标
    int x = 3;
    int y = 3;
    // 根目录路径
    String path = "/home/ax/IdeaProjects/puzzleGame/";
    // 本局已走步数
    int step = 0;

    // 创建菜单栏的子菜单
    JMenuItem replayJMenuItem = new JMenuItem("重新游戏");
    JMenuItem reLoginJMenuItem = new JMenuItem("重新登陆");
    JMenuItem closeJMenuItem = new JMenuItem("关闭游戏");
    JMenuItem acountJMenuItem = new JMenuItem("公众号");

    public GameJFrame() {
        // 初始化窗口
        initJFrame();
        // 初始化菜单栏
        initJManuBar();
        // 初始化图片数据(打乱图片顺序)
        initData();
        // 初始化图片(按照打乱之后的结果加载图片)
        initImage();


        // 显示窗口
        this.setVisible(true);
    }

    private void initData() {
        int[] tempArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        Random rd = new Random();
        for (int i = 0; i < tempArr.length - 1; i++) {
            // 将空白方块放置于最后一个方块,并不参与打乱
            int index = rd.nextInt(tempArr.length - 1);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        for (int i = 0; i < tempArr.length; i++) {
            arr[i / 4][i % 4] = tempArr[i];
        }

        // 初始化空白方块坐标
        x = 3;
        y = 3;
    }

    private void initImage() {
        // 清空界面里所有的图片
        this.getContentPane().removeAll();
        // 判断游戏是否胜利
        if (victory()) {
            System.out.println("win!!");
            // 游戏胜利后不再刷新界面并显示胜利图片
            // 胜利图片添加到winJLabel管理容器中
            JLabel winJLabel = new JLabel(new ImageIcon(path + "image/win.png"));
            // 设置管理容器的参数
            winJLabel.setBounds(203, 283, 197, 73);
            // 将管理容器添加到界面窗口中
            this.getContentPane().add(winJLabel);
        }
        // 添加背景到管理容器中
        JLabel background = new JLabel(new ImageIcon(path + "image/background.png"));
        // 设置背景图片的位置及参数
        background.setBounds(40, 40, 508, 560);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // 定义小图片对象
                ImageIcon icon = new ImageIcon(path + "image/animal/animal3/" + arr[i][j] + ".jpg");

                // 创建对象管理容器
                JLabel jLabel = new JLabel(icon);
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                // 指定小图片的位置
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                // 将小图片管理容器添加到界面中
                this.getContentPane().add(jLabel);
            }
        }
        // 将背景图片添加到界面中 (先添加的图片会在上面,后添加的图片会在更下方)
        this.getContentPane().add(background);


        //添加记步功能
        JLabel stepJLabel = new JLabel("步数:" + step);
        stepJLabel.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepJLabel);


        // 刷新界面
        this.getContentPane().repaint();
    }

    private void initJFrame() {
        // 设置窗口的长宽
        this.setSize(603, 680);
        // 设置窗口的标题
        this.setTitle("拼图单机版 v1.0");
        // 设置窗口置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置界面关闭模式为关闭后程序也随之关闭
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 关闭默认布局,让图片非居中显示而是根据坐标显示
        this.setLayout(null);


        // 给窗口添加按键事件
        this.addKeyListener(this);


    }

    private void initJManuBar() {
        // 创建JMenuBar对象用于菜单栏
        JMenuBar jMenuBar = new JMenuBar();
        // 创建菜单栏的内容
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");


        // 将子菜单绑定事件
        replayJMenuItem.addActionListener(this);
        reLoginJMenuItem.addActionListener(this);
        closeJMenuItem.addActionListener(this);
        acountJMenuItem.addActionListener(this);


        // 将子菜单添加到父菜单中
        functionJMenu.add(replayJMenuItem);
        functionJMenu.add(reLoginJMenuItem);
        functionJMenu.add(closeJMenuItem);

        aboutJMenu.add(acountJMenuItem);

        // 将父菜单添加到菜单栏中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        // 给整个页面设置菜单
        this.setJMenuBar(jMenuBar);


    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

        int code = keyEvent.getKeyCode();
        if (code == 65) {
            System.out.println("show complete image.");
            // 移除所有图片
            this.getContentPane().removeAll();
            // 将完整的图片添加到界面中
            JLabel jLabel = new JLabel(new ImageIcon(path + "image/animal/animal3/all.jpg"));
            // 设置完整图片的位置及大小
            jLabel.setBounds(83, 134, 420, 420);
            // 添加背景到管理容器中
            JLabel background = new JLabel(new ImageIcon(path + "image/background.png"));
            // 设置背景图片的位置及参数
            background.setBounds(40, 40, 508, 560);


            // 将完整图片添加到界面中
            this.getContentPane().add(jLabel);
            // 将背景图片添加到界面中
            this.getContentPane().add(background);

            // 刷新窗口界面
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        // 按键松开后调用此方法体


        // 如果游戏胜利则不执行按键操作
        if (victory()) {
            return;
        }


        // 获取按键码,识别按键
        int code = keyEvent.getKeyCode();
        if (code == 37) {
            System.out.println("left");
            // 如果方块在最右方,则不移动
            if (y == 3) {
                return;
            }
            // 将方块右方的内容向左移动
            arr[x][y] = arr[x][y + 1];
            arr[x][y + 1] = 0;
            y++;

            // 移动了方块,步数增加
            step++;

            // 刷新界面
            initImage();
        } else if (code == 38) {
            // 将方块下方的内容向上移动
            System.out.println("up");
            // 如果方块在最下方,则不移动
            if (x == 3) {
                return;
            }
            // 将方块下方的内容向上移动
            arr[x][y] = arr[x + 1][y];
            arr[x + 1][y] = 0;
            x++;

            // 移动了方块,步数增加
            step++;

            // 刷新界面
            initImage();
        } else if (code == 39) {
            System.out.println("right");
            // 如果方块在最左方,则不移动
            if (y == 0) {
                return;
            }
            // 将方块左方的内容向右移动
            arr[x][y] = arr[x][y - 1];
            arr[x][y - 1] = 0;
            y--;

            // 移动了方块,步数增加
            step++;

            // 刷新界面
            initImage();

        } else if (code == 40) {
            System.out.println("down");
            // 如果方块在最上方,则不移动
            if (x == 0) {
                return;
            }
            // 将方块上方的内容向下移动
            arr[x][y] = arr[x - 1][y];
            arr[x - 1][y] = 0;
            x--;

            // 移动了方块,步数增加
            step++;

            // 刷新界面
            initImage();

        } else if (code == 65) {
            // 如果松开了显示完整图片的按键A则显示回原先的拼图界面
            initImage();
        } else if (code == 87) {
            // 一键胜利 按键W
            System.out.println("One click victory.");
            arr = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            initImage();
        }

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // 按下空格或者鼠标点击时会触发的事件
        Object source = actionEvent.getSource();
        if (source == replayJMenuItem) {
            System.out.println("重新游戏");
            // 计步器归零
            step = 0;
            // 初始化图片数据
            initData();
            // 初始化界面
            initImage();

        } else if (source == reLoginJMenuItem) {
            System.out.println("重新登陆");
        } else if (source == closeJMenuItem) {
            System.out.println("关闭游戏");
            System.exit(0);
        } else if (source == acountJMenuItem) {
            System.out.println("公众号");
            // 定义对话框窗口
            JDialog jDialog = new JDialog();
            // 定义JLabel管理容器
            JLabel jLabel = new JLabel(new ImageIcon(path + "image/about.png"));
            jLabel.setBounds(0, 0, 258, 258);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(344, 344);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);
            jDialog.setVisible(true);

        }
    }

    private boolean victory() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != victory[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
