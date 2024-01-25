package shapes;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class Rectangle extends AbstractShape {

    private int width, length;
    private int xRelative, yRelative;
    private Rectangle[] corners = new Rectangle[4];

    public Rectangle(int width, int length, Point position) {
        super(position);
        this.width = width;
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void draw(Graphics canvas) {
        this.setCorners();

        if (this.getFillColor() != null) {
            canvas.setColor(this.getFillColor());
            canvas.fillRect(this.getPosition().x, this.getPosition().y, width, length);

        } else {
            canvas.setColor(this.getColor());
            canvas.drawRect(this.getPosition().x, this.getPosition().y, width, length);
        }
    }

    @Override
    public void setDraggingPoint(Point point) {
        super.setDraggingPoint(point);
        xRelative = point.x - super.getPosition().x;
        yRelative = point.y - super.getPosition().y;

    }

    @Override
    public boolean contains(Point point) {
        return (point.x <= this.getPosition().x + width) && (point.y <= this.getPosition().y + length) && (point.x >= this.getPosition().x) && (point.y >= this.getPosition().y);

    }

    @Override
    public void moveTo(Point point) {
        super.setPosition(new Point(point.x - xRelative, point.y - yRelative));
        this.setCorners();

    }

    @Override
    public void setCorners() {
        corners[0] = new Rectangle(10, 10, new Point(super.getPosition().x - 5, super.getPosition().y - 5));
        corners[1] = new Rectangle(10, 10, new Point(super.getPosition().x + width - 5, super.getPosition().y - 5));
        corners[2] = new Rectangle(10, 10, new Point(super.getPosition().x - 5, super.getPosition().y + length - 5));
        corners[3] = new Rectangle(10, 10, new Point(super.getPosition().x + width - 5, super.getPosition().y + length - 5));
    }

    @Override
    public Rectangle[] getCorners() {
        return corners;
    }

    @Override
    public void moveCorner(Point point) {

        if (this.getCorners()[0].contains(this.getEditPoint())) {
            this.length = this.length + (this.getEditPoint().y - point.y);
            this.width = this.width + (this.getEditPoint().x - point.x);
            this.setPosition(point);
            this.setCorners();
            this.setEditPoint(new Point(this.getCorners()[0].getPosition().x + 5, this.getCorners()[0].getPosition().y + 5));
            if (this.width < 9) {
                this.setEditPoint(new Point(this.getCorners()[1].getPosition().x + 5, this.getCorners()[1].getPosition().y + 5));
            }
            if (this.length < 9) {
                this.setEditPoint(new Point(this.getCorners()[2].getPosition().x + 5, this.getCorners()[2].getPosition().y + 5));
            }
        } else if (this.getCorners()[1].contains(this.getEditPoint())) {
            this.length = Math.abs(this.length + (this.getEditPoint().y - point.y));
            this.width = Math.abs(this.width + (point.x - this.getEditPoint().x));
            this.setPosition(new Point(this.getPosition().x, point.y));
            this.setCorners();
            this.setEditPoint(new Point(this.getCorners()[1].getPosition().x + 5, this.getCorners()[1].getPosition().y + 5));
            if (this.width < 9) {
                this.setEditPoint(new Point(this.getCorners()[0].getPosition().x + 5, this.getCorners()[0].getPosition().y + 5));
            }
            if (this.length < 9) {
                this.setEditPoint(new Point(this.getCorners()[3].getPosition().x + 5, this.getCorners()[3].getPosition().y + 5));
                this.setPosition(new Point(this.getCorners()[0].getPosition().x + 5, this.getCorners()[0].getPosition().y + 5));
            }
        } else if (this.getCorners()[2].contains(this.getEditPoint())) {

            this.length = Math.abs(this.length + (point.y - this.getEditPoint().y));
            this.width = Math.abs(this.width + (this.getEditPoint().x - point.x));
            this.setPosition(new Point(point.x, this.getPosition().y));
            this.setCorners();
            this.setEditPoint(new Point(this.getCorners()[2].getPosition().x + 5, this.getCorners()[2].getPosition().y + 5));
            if (this.width < 9) {
                this.setEditPoint(new Point(this.getCorners()[3].getPosition().x + 5, this.getCorners()[3].getPosition().y + 5));
            }
            if (this.length < 9) {
                this.setEditPoint(new Point(this.getCorners()[0].getPosition().x + 5, this.getCorners()[0].getPosition().y + 5));
            }

        } else if (this.getCorners()[3].contains(this.getEditPoint())) {
            this.length = Math.abs(this.length + (point.y - this.getEditPoint().y));
            this.width = Math.abs(this.width + (point.x - this.getEditPoint().x));
            this.setPosition(this.getPosition());
            this.setCorners();
            this.setEditPoint(new Point(this.getCorners()[3].getPosition().x + 5, this.getCorners()[3].getPosition().y + 5));
            if (this.width < 9) {
                this.setEditPoint(new Point(this.getCorners()[2].getPosition().x + 5, this.getCorners()[2].getPosition().y + 5));
            }
            if (this.length < 9) {
                this.setEditPoint(new Point(this.getCorners()[1].getPosition().x + 5, this.getCorners()[1].getPosition().y + 5));
            }
        }
    }
}
