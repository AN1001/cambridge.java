package WordGame.View;

import javax.swing.*;
import java.awt.*;

public class ScoreGUI extends JLabel {
    public ScoreGUI() {
        setText("0");
        setFont(new Font("Courier", Font.BOLD, 24));
        setHorizontalAlignment(SwingConstants.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(new Dimension(75, 75));
        setOpaque(true);
    }

    public void updateScore(int newScore) {
        setText(Integer.toString(newScore));
    }
}
