import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author ax
 * @description 点击事件练习
 * @date 2024/4/9 下午4:53
 */
public class Test2ActionListener {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(603, 680);
        jFrame.setTitle("拼图单机版 v1.0");
        jFrame.setAlwaysOnTop(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 关闭默认布局,让图片非居中显示而是根据坐标显示
        jFrame.setLayout(null);
        // 定义一个JButton
        JButton jbt = new JButton("button");
        // 设置其位置及大小
        jbt.setBounds(0, 0, 100, 100);
        // 设置绑定事件
        jbt.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("You clicked the button.");
            }
        });

        // 将按钮添加到jFrame
        jFrame.getContentPane().add(jbt);


        jFrame.setVisible(true);

    }
}
