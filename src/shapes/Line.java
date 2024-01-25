package shapes;

import java.awt.Graphics;
import java.awt.Point;

public class Line extends AbstractShape {

    private Point p2;
    private int p1RelativeX, p2RelativeX, p1RelativeY, p2RelativeY;
    private Rectangle[] corners = new Rectangle[2];

    public Line(Point p2, Point position) {
        super(position);
        this.p2 = p2;
        super.setFillColor(super.getColor());
    }

    public void setPosition2(Point p2) {
        this.p2 = p2;
    }

    public Point getPosition2() {
        return this.p2;
    }

    @Override
    public void draw(Graphics canvas) {
        this.setCorners();
        canvas.setColor(this.getColor());
        canvas.drawLine(this.getPosition().x, this.getPosition().y, this.getPosition2().x, this.getPosition2().y);
    }

    @Override
    public void setDraggingPoint(Point point) {
        super.setDraggingPoint(point);
        p1RelativeX = point.x - super.getPosition().x;
        p1RelativeY = point.y - super.getPosition().y;
        p2RelativeX = point.x - p2.x;
        p2RelativeY = point.y - p2.y;
    }

    @Override
    public boolean contains(Point point) {
        return Math.abs(Point.distance(point.x, point.y, this.getPosition().x, this.getPosition().y) + Point.distance(point.x, point.y, p2.x, p2.y)) - Point.distance(this.getPosition().x, this.getPosition().y, p2.x, p2.y) <= 2;
    }

    @Override
    public void moveTo(Point point) {
        super.setPosition(new Point(point.x - p1RelativeX, point.y - p1RelativeY));
        this.setPosition2(new Point(point.x - p2RelativeX, point.y - p2RelativeY));
        this.setCorners();
    }

    @Override
    public void setCorners() {
        corners[0] = new Rectangle(10, 10, new Point(this.getPosition().x - 5, this.getPosition().y - 5));
        corners[1] = new Rectangle(10, 10, new Point(this.getPosition2().x - 5, this.getPosition2().y - 5));
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
            this.setPosition2(point);
            this.setCorners();
            this.setEditPoint(this.getPosition2());

        }

    }

}
