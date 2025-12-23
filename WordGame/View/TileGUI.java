package WordGame.View;

import WordGame.GameElements.Tile;

import javax.swing.*;
import java.awt.*;

public class TileGUI extends JButton {
    private final Color selectedColor = new Color(26, 98, 149);
    private static final Font font = new Font("Courier", Font.PLAIN, 12);
    private static final Font selectedFont = new Font("Courier", Font.BOLD, 12);

    public TileGUI(Tile tile) {
        String text = getTileGUI_HTML(tile);
        setStyle(text);
    }

    public JButton getComponent(){
        return this;
    }

    public void makeDeselected(){
        setForeground(Color.BLACK);
        setFont(font);
    }

    public void makeSelected(){
        setForeground(selectedColor);
        setFont(selectedFont);
    }

    public void makeUsed() {
        setForeground(Color.LIGHT_GRAY);
    }

    private void setStyle(String text){
        setText(text);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(font);

        setMargin(new Insets(0, 0, 0, 0));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(new Dimension(75, 75));
    }

    private String getTileGUI_HTML(Tile tile) {
        return "<html><center><font size='7'>"
                + tile.letter()
                + "</font><sub><font size='6'>"
                + tile.score()
                + "</font></sub></center></html>";
    }
}

