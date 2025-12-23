package WordGame.View.Buttons;

import WordGame.Game;

import javax.swing.*;
import java.awt.*;

public abstract class ControlButtonGUI extends JButton{
    protected final Game game;
    public ControlButtonGUI(String name, Game game){
        this.game = game;
        setText(getControlButtonHTML(name));

        setFont(new Font("Courier", Font.BOLD, 12));
        setHorizontalAlignment(SwingConstants.CENTER);
        setMargin(new Insets(0, 0, 0, 0));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(new Dimension(300, 75));

        addActionListener(_ -> onClick());
    }

    public abstract void onClick();

    private String getControlButtonHTML(String text){
        return "<html><center><font size='7'>"
                + text
                + "</font></center></html>";
    }
}
