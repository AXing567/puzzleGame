import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * @author ax
 * @description 键盘事件练习
 * @date 2024/4/9 下午4:53
 */
public class Test4KeyListener extends JFrame implements KeyListener {

    public Test4KeyListener() {
        this.setSize(603, 680);
        this.setTitle("拼图单机版 v1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 关闭默认布局,让图片非居中显示而是根据坐标显示
        this.setLayout(null);


        // 设置按钮监听
        this.addKeyListener(this);


        // 显示窗口
        this.setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 65){
            System.out.println("按下了A");
        }

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 65){
            System.out.println("按下的A松开了");
        }

    }

}
