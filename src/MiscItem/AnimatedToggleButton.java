package MiscItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class AnimatedToggleButton extends JToggleButton {
    private float alpha = 0.0f; // For fade-in/out effect
    private Timer timer;

    public AnimatedToggleButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setPreferredSize(new Dimension(100, 50));

        // Timer for animation
        timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSelected()) {
                    alpha += 0.1f;
                    if (alpha >= 1.0f) {
                        alpha = 1.0f;
                        timer.stop();
                    }
                } else {
                    alpha -= 0.1f;
                    if (alpha <= 0.0f) {
                        alpha = 0.0f;
                        timer.stop();
                    }
                }
                repaint();
            }
        });

        // Add action listener to start animation on toggle
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alpha = isSelected() ? 0.0f : 1.0f; // Reset alpha for animation
                timer.start();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Create a blurred effect
        BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D gImg = img.createGraphics();
        gImg.setColor(isSelected() ? Color.GREEN : Color.RED);
        gImg.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        gImg.dispose();

        // Apply blur effect
        float[] blurKernel = {
                1f / 16, 2f / 16, 1f / 16,
                2f / 16, 4f / 16, 2f / 16,
                1f / 16, 2f / 16, 1f / 16
        };
        ConvolveOp blurOp = new ConvolveOp(new Kernel(3, 3, blurKernel));
        img = blurOp.filter(img, null);

        // Draw the blurred image
        g2d.drawImage(img, 0, 0, null);

        // Set transparency
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2d.setColor(Color.BLACK);
        g2d.drawString(getText(), getWidth() / 2 - g2d.getFontMetrics().stringWidth(getText()) / 2, getHeight() / 2 + 5);

        g2d.dispose();
        super.paintComponent(g);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Animated Toggle Button");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());
            frame.add(new AnimatedToggleButton("Toggle Me"));
            frame.setSize(300, 200);
            frame.setVisible(true);
        });
    }
}
