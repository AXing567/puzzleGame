import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * @author ax
 * @description
 * @date 2024/4/9 下午5:03
 */
public class Test5MouseListener extends JFrame implements MouseListener {
    public Test5MouseListener() {
        this.setSize(603, 680);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 关闭默认布局,让图片非居中显示而是根据坐标显示
        this.setLayout(null);


        // 定义一个JButton
        JButton jbt = new JButton("button");
        // 设置其位置及大小
        jbt.setBounds(0, 0, 100, 100);
        // 给按钮添加事件
        jbt.addMouseListener(this);


        // 添加到窗口中
        this.getContentPane().add(jbt);


        // 显示窗口
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        System.out.println("按下");

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        System.out.println("松开");

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        System.out.println("划入");

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        System.out.println("划出");

    }
}
