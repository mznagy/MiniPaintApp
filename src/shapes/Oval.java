package shapes;

import java.awt.Graphics;
import java.awt.Point;

public class Oval extends AbstractShape {

    private int width;
    private int height;
    private int xRelative, yRelative;
    private Rectangle[] corners = new Rectangle[4];
    private Point center;

    public Oval(int height, int width, Point position) {
        super(position);
        this.width = width;
        this.height = height;
    }

    public void setRadius(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void draw(Graphics canvas) {
        this.setCorners();
        if (this.getFillColor() != null) {
            canvas.setColor(this.getFillColor());
            canvas.fillOval(this.getPosition().x, this.getPosition().y, this.width, this.height);
        } else {
            canvas.setColor(this.getColor());
            canvas.drawOval(this.getPosition().x, this.getPosition().y, this.width, this.height);
        }
    }

    @Override
    public void setDraggingPoint(Point point) {
        super.setDraggingPoint(point);
        xRelative = point.x - (this.getPosition().x);
        yRelative = point.y - (this.getPosition().y);

    }

    @Override
    public boolean contains(Point point) {
        center = new Point(this.getPosition().x + (int) (0.5 * width), this.getPosition().y + (int) (0.5 * height));
        return Math.abs(point.x - center.x) < 0.5 * this.width && Math.abs(point.y - center.y) < 0.5 * this.height;
    }

    @Override
    public void moveTo(Point point) {
        this.setPosition(new Point(point.x - xRelative, point.y - yRelative));
        this.setCorners();
    }

    @Override
    public void setCorners() {
        corners[0] = new Rectangle(10, 10, new Point(this.getPosition().x - 5, this.getPosition().y - 5));
        corners[1] = new Rectangle(10, 10, new Point(this.getPosition().x + width - 5, this.getPosition().y - 5));
        corners[2] = new Rectangle(10, 10, new Point(this.getPosition().x - 5, this.getPosition().y + height - 5));
        corners[3] = new Rectangle(10, 10, new Point(this.getPosition().x + width - 5, this.getPosition().y + height - 5));
    }

    @Override
    public Rectangle[] getCorners() {
        return corners;
    }

    @Override
    public void moveCorner(Point point) {

        if (this.getCorners()[0].contains(this.getEditPoint())) {
            this.height = this.height + (this.getEditPoint().y - point.y);
            this.width = this.width + (this.getEditPoint().x - point.x);
            this.setPosition(point);
            this.setCorners();
            this.setEditPoint(new Point(this.getCorners()[0].getPosition().x + 5, this.getCorners()[0].getPosition().y + 5));
            if (this.width < 9) {
                this.setEditPoint(new Point(this.getCorners()[1].getPosition().x + 5, this.getCorners()[1].getPosition().y + 5));
            }
            if (this.height < 9) {
                this.setEditPoint(new Point(this.getCorners()[2].getPosition().x + 5, this.getCorners()[2].getPosition().y + 5));
            }
        } else if (this.getCorners()[1].contains(this.getEditPoint())) {
            this.height = Math.abs(this.height + (this.getEditPoint().y - point.y));
            this.width = Math.abs(this.width + (point.x - this.getEditPoint().x));
            this.setPosition(new Point(this.getPosition().x, point.y));
            this.setCorners();
            this.setEditPoint(new Point(this.getCorners()[1].getPosition().x + 5, this.getCorners()[1].getPosition().y + 5));
            if (this.width < 9) {
                this.setEditPoint(new Point(this.getCorners()[0].getPosition().x + 5, this.getCorners()[0].getPosition().y + 5));
            }
            if (this.height < 9) {
                this.setEditPoint(new Point(this.getCorners()[3].getPosition().x + 5, this.getCorners()[3].getPosition().y + 5));
                this.setPosition(new Point(this.getCorners()[0].getPosition().x + 5, this.getCorners()[0].getPosition().y + 5));
            }
        } else if (this.getCorners()[2].contains(this.getEditPoint())) {

            this.height = Math.abs(this.height + (point.y - this.getEditPoint().y));
            this.width = Math.abs(this.width + (this.getEditPoint().x - point.x));
            this.setPosition(new Point(point.x, this.getPosition().y));
            this.setCorners();
            this.setEditPoint(new Point(this.getCorners()[2].getPosition().x + 5, this.getCorners()[2].getPosition().y + 5));
            if (this.width < 9) {
                this.setEditPoint(new Point(this.getCorners()[3].getPosition().x + 5, this.getCorners()[3].getPosition().y + 5));
            }
            if (this.height < 9) {
                this.setEditPoint(new Point(this.getCorners()[0].getPosition().x + 5, this.getCorners()[0].getPosition().y + 5));
            }

        } else if (this.getCorners()[3].contains(this.getEditPoint())) {
            this.height = Math.abs(this.height + (point.y - this.getEditPoint().y));
            this.width = Math.abs(this.width + (point.x - this.getEditPoint().x));
            this.setPosition(this.getPosition());
            this.setCorners();
            this.setEditPoint(new Point(this.getCorners()[3].getPosition().x + 5, this.getCorners()[3].getPosition().y + 5));
            if (this.width < 9) {
                this.setEditPoint(new Point(this.getCorners()[2].getPosition().x + 5, this.getCorners()[2].getPosition().y + 5));
            }
            if (this.height < 9) {
                this.setEditPoint(new Point(this.getCorners()[1].getPosition().x + 5, this.getCorners()[1].getPosition().y + 5));
            }
        }
    }
}
