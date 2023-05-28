package org.dstu.shapes.animation;

import org.dstu.shapes.Shape;
import org.dstu.shapes.Square;

import javax.swing.*;

public class SquareAnimator extends Animator {

    public SquareAnimator(Shape shape, JComponent component) {
       super(shape, component);
    }

    @Override
    public void run() {
        while (true) {
            if (shape.getX() < (800 - shape.getSide()) && shape.getY() == 0) shape.moveTo(shape.getX() + 10, shape.getY());
            else if (shape.getX() == (800 - shape.getSide()) && shape.getY() < (600 - shape.getSide())) shape.moveTo(shape.getX(), shape.getY() + 10);
            else if ((shape.getX() > 0) && shape.getY() == (600 - shape.getSide())) shape.moveTo(shape.getX() - 10, shape.getY());
            else if (shape.getX() == 0 && shape.getY() > 0) shape.moveTo(shape.getX(), shape.getY() - 10);

            if (component != null) {
                component.repaint();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
