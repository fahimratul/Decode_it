package application.form.other.MorseCode;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;

public class Morsecode_to_text extends javax.swing.JPanel {

    private MigLayout layout;
    private Text2Morse text2Morse;
    private Morse2text morse2text;
    private Animator animator;
    private boolean flag; 
    
    public void setAnimate(int animate) {
        layout.setComponentConstraints(text2Morse, "pos (30%)-240px-" + animate + " 0.5al n n");
        layout.setComponentConstraints(morse2text, "pos (40%)-30px+" + animate + " 0.5al n n");
        if (animate == 30) {
            if (flag) {
                setComponentZOrder(morse2text, 0);
               
            } else {
                setComponentZOrder(text2Morse, 0);
                morse2text.setBackground(new java.awt.Color(167, 211, 224, 25));
                
            }
        }
        revalidate();
    }

    public Morsecode_to_text() {
        initComponents();
        init();
        initAnimator();
    }

    private void initAnimator() {
        animator = new Animator(1000, new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (flag) {
                     text2Morse.setBackground(new java.awt.Color(167, 211, 224, 25)); // Set background color with some transparency
                     morse2text.setBackground(new java.awt.Color(0, 102, 102, 255)); // Set background color with some transparency
                    
                }
                else {                   
                    morse2text.setBackground(new java.awt.Color(0, 102, 102, 25)); // Set background color with some transparency
                    text2Morse.setBackground(new java.awt.Color(167, 211, 224, 255)); // Set background color with some transparency
                }
            }
        });
        animator.addTarget(new PropertySetter(this, "animate", 0, 30, 0));
        animator.setResolution(0);
    }

    private void init() {
       
        layout = new MigLayout("fill", "fill", "fill");
        setLayout(layout);
        text2Morse = new Text2Morse();
        morse2text = new Morse2text();
        add(text2Morse, "pos (30%)-240px 0.5al n n");
        add(morse2text, "pos (40%)-30px 0.5al n n");
        text2Morse.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    if(flag==true){
                        flag=false;
                        animator.start();
                    }
                }
            }
        });
        morse2text.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    if(flag==false){
                        flag=true;
                        animator.start();
                    }
                }
            }
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
