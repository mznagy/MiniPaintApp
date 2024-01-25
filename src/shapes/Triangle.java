/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;


public class Triangle extends AbstractShape {

    private Rectangle[] corners = new Rectangle[3];
    private Point p2;
    private Point p3;
    private int[] xPoints = new int[3];
    private int[] yPoints = new int[3];
    private Polygon triangle;
    private int p1RelativeX, p2RelativeX, p3RelativeX, p1RelativeY, p2RelativeY, p3RelativeY;

    public Triangle(Point position, Point point2, Point point3) {
        super(position);
        this.p2 = point2;
        this.p3 = point3;
        xPoints[0] = position.x;
        xPoints[1] = point2.x;
        xPoints[2] = point3.x;
        yPoints[0] = position.y;
        yPoints[1] = point2.y;
        yPoints[2] = point3.y;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    @Override
    public void draw(Graphics canvas) {
        this.setCorners();
        this.triangle = new Polygon(xPoints, yPoints, 3);
        if (this.getFillColor() != null) {
            canvas.setColor(this.getFillColor());
            canvas.fillPolygon(triangle);

        } else {
            canvas.setColor(this.getColor());
            canvas.drawPolygon(triangle);
        }
    }

    @Override
    public void setPosition(Point point) {
        super.setPosition(point);
        xPoints[0]=point.x;
        yPoints[0]=point.y;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
        xPoints[1] = p2.x;
        yPoints[1] = p2.y;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
        xPoints[2] = p3.x;
        yPoints[2] = p3.y;
    }

    @Override
    public void setDraggingPoint(Point point) {
        super.setDraggingPoint(point);
        p1RelativeX = point.x - super.getPosition().x;
        p1RelativeY = point.y - super.getPosition().y;
        p2RelativeX = point.x - p2.x;
        p2RelativeY = point.y - p2.y;
        p3RelativeX = point.x - p3.x;
        p3RelativeY = point.y - p3.y;
    }

    @Override
    public boolean contains(Point point) {
        return triangle.contains(point);
    }

    @Override
    public void moveTo(Point point) {
        this.setPosition(new Point(point.x - p1RelativeX, point.y - p1RelativeY));
        this.setP2(new Point(point.x - p2RelativeX, point.y - p2RelativeY));
        this.setP3(new Point(point.x - p3RelativeX, point.y - p3RelativeY));
        this.setCorners();
    }

    @Override
    public void setCorners() {
        corners[0] = new Rectangle(10, 10, new Point(this.getPosition().x - 5, this.getPosition().y - 5));
        corners[1] = new Rectangle(10, 10, new Point(p2.x - 5, p2.y - 5));
        corners[2] = new Rectangle(10, 10, new Point(p3.x - 5, p3.y - 5));
    }
    
    @Override
    public Rectangle[] getCorners() {
        return corners;
    }


    @Override
    public void moveCorner(Point point) {
        if (corners[0].contains(this.getEditPoint())) {
            this.setPosition(point);
            this.setCorners();
            this.setEditPoint(this.getPosition());

        } else if (corners[1].contains(this.getEditPoint())) {
            this.setP2(point);
            this.setCorners();
            this.setEditPoint(p2);
        }else if (corners[2].contains(this.getEditPoint())) {
            this.setP3(point);
            this.setCorners();
            this.setEditPoint(p3);
        }
        
        
    }

    
}
