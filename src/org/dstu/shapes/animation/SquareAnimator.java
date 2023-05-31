package org.dstu.shapes.animation;

import org.dstu.shapes.Shape;
import org.dstu.shapes.Square;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SquareAnimator extends Animator {

    public SquareAnimator(Shape shape, JComponent component) {
       super(shape, component);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(shape.getX() + "   " + shape.getY());
            if (shape.getX() < (component.getWidth() - shape.getSide()) && shape.getY() == 0) shape.moveTo(shape.getX() + 10, shape.getY());
            else if (shape.getX() >= (component.getWidth() - shape.getSide()) && shape.getY() < (component.getHeight() - shape.getSide())) shape.moveTo(shape.getX(), shape.getY() + 10);
            else if ((shape.getX() > 0) && shape.getY() >= (component.getHeight() - shape.getSide())) shape.moveTo(shape.getX() - 10, shape.getY());
            else if (shape.getX() <= 0 && shape.getY() > 0) shape.moveTo(shape.getX(), shape.getY() - 10);
            changeColor();

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

    public void changeColor() {
        if ((shape.getX() >= (component.getSize().width - shape.getSide()) && shape.getY() == 0) ||
                shape.getX() >= (component.getSize().width - shape.getSide()) && shape.getY() >= (component.getSize().height - shape.getSide()) ||
                ((shape.getX() <= 0) && shape.getY() >= (component.getSize().height - shape.getSide())) ||
                shape.getX() <= 0 && shape.getY() <= 0) {
            Random rand = new Random();
            shape.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        }
    }
}
