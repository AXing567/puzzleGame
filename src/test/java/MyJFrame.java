import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJFrame extends JFrame implements ActionListener {
    JButton jbt1 = new JButton("button1");
    JButton jbt2 = new JButton("button2");

    public MyJFrame() {

        this.setSize(603, 680);
        this.setTitle("拼图单机版 v1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 关闭默认布局,让图片非居中显示而是根据坐标显示
        this.setLayout(null);

        jbt1.setBounds(0, 0, 100, 50);
        jbt2.setBounds(100, 0, 100, 50);

        jbt1.addActionListener(this);
        jbt2.addActionListener(this);

        this.getContentPane().add(jbt1);
        this.getContentPane().add(jbt2);

        // 显示窗口
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if (source == jbt1) {  
            System.out.println("点击了按钮1");
        } else if (source == jbt2) {
            System.out.println("点击了按钮2");
        }
    }
}
