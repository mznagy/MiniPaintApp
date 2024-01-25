package shapes;

import java.awt.Color;
import java.awt.Point;

public abstract class AbstractShape implements Shape, Moveable,Editable {

    private Point position;
    private Color color = null;
    private Color fillColor = null;
    private String id;
    private Point draggingPoint;
    private Point editPoint;

    public AbstractShape(Point position) {
        this.position = position;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return this.position;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    @Override
    public Color getFillColor() {
        return this.fillColor;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setDraggingPoint(Point point) {
        this.draggingPoint=point;
    }

    @Override
    public Point getDraggingPoint() {
        return draggingPoint;
    }

    @Override
    public void setEditPoint(Point point){
        this.editPoint=point;
    }
    
    @Override
    public Point getEditPoint(){
        return editPoint;
    }
}
