package items.Deques;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayDeque;
import java.util.Deque;

import engine.abstractclasses.GraphicsItem;
import engine.util.GraphicsPanel;
import engine.variables.Vector2;
import items.ZoomScale;

public class DequesItem extends GraphicsItem{

    protected Deque<String> deque = new ArrayDeque<String>();
    public ZoomScale zoomScale = new ZoomScale();
    private Vector2 position = new Vector2();
    private Vector2 size = new Vector2(100, 100);
    private static final int SPACEMENT = 10;

    DequesItem(){
        position.y = (GraphicsPanel.getPanelHeight() / 2) - (size.y / 2);
    }

    @Override
    public void update(double deltaTime) {
    }

    @Override
    public void draw(Graphics2D g2) {
        for (int i = 0; i < deque.toArray().length; i++) {
            position.x = (size.x * i) + SPACEMENT * (i + 1);
            g2.setColor(Color.BLACK);
            g2.drawString("index: " + Integer.toString(i), (int) position.x, (int) (position.y - 2));
            g2.drawString("valor: " + deque.toArray()[i], (int) position.x, (int) (position.y + size.y + SPACEMENT));
            g2.setColor(Color.DARK_GRAY);
            g2.fillRoundRect((int) position.x, (int) position.y, (int) size.x, (int) size.y, 
                (int) (size.x * 0.1), (int) (size.y * 0.1));
        }
    }

}