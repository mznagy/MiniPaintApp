package shapes;

import frontend.MyPanel;
import java.awt.Graphics;
import java.awt.Point;


public interface Editable {
    
    public void setCorners();
    
    public Rectangle[] getCorners();
    
    
    public void setEditPoint(Point point);
    
    public Point getEditPoint();
    
    public void moveCorner(Point point);
    
    
    
}
