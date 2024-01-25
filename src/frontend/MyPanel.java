package frontend;

import java.awt.Color;
import shapes.DrawingEngine;
import shapes.Shape;
import java.awt.Graphics;
import java.awt.Point;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import shapes.AbstractShape;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import shapes.Oval;
import shapes.Line;
import shapes.Rectangle;
import shapes.Triangle;

public class MyPanel extends javax.swing.JPanel implements DrawingEngine {

    private static ArrayList<Shape> shapes;
    private int lineCounter = 0;
    private int circleCounter = 0;
    private int rectangleCounter = 0;
    private int squareCounter = 0;
    private int triangleCounter = 0;
    private ArrayList<Shape> corners = new ArrayList<Shape>();

    public MyPanel() {
        shapes = new ArrayList<>();
    }

    @Override
    public void paintComponent(Graphics canvas) {
        super.paintComponent(canvas);
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).draw(canvas);
        }
        for (int i = 0; i < corners.size(); i++) {
            corners.get(i).setFillColor(Color.BLACK);
            corners.get(i).draw(canvas);
        }
    }

    @Override
    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    @Override
    public void removeShape(Shape shape) {
        this.shapes.remove(shape);
        this.showCorners(false, null);
    }

    @Override
    public AbstractShape[] getShapes() {
        AbstractShape[] ShapesArray = new AbstractShape[shapes.size()];
        for (int i = 0; i < shapes.size(); i++) {
            ShapesArray[i] = (AbstractShape) shapes.get(i);
        }
        return ShapesArray;
    }

    @Override
    public void refresh(Graphics canvas) {
        repaint();
    }

    public void showCorners(boolean bool, AbstractShape shape) {
        if (bool) {
            for (int i = 0; i < shape.getCorners().length; i++) {
                corners.add(shape.getCorners()[i]);
            }
        } else {
            corners.removeAll(corners);
        }
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 876, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public int getLineCounter() {
        return lineCounter;
    }

    public void setLineCounter(int lineCounter) {
        this.lineCounter = lineCounter;
    }

    public int getCircleCounter() {
        return circleCounter;
    }

    public void setCircleCounter(int circleCounter) {
        this.circleCounter = circleCounter;
    }

    public int getRectangleCounter() {
        return rectangleCounter;
    }

    public void setRectangleCounter(int rectangleCounter) {
        this.rectangleCounter = rectangleCounter;
    }

    public int getSquareCounter() {
        return squareCounter;
    }

    public void setSquareCounter(int squareCounter) {
        this.squareCounter = squareCounter;
    }

    public int getTriangleCounter() {
        return triangleCounter;
    }

    public void setTriangleCounter(int triangleCounter) {
        this.triangleCounter = triangleCounter;
    }

    public void saveToFile(String filename) {
        JSONArray arr = new JSONArray();
        for (int i = 0; i < shapes.size(); i++) {
            Shape shape = shapes.get(i);
            JSONObject temp = new JSONObject();
            temp.put("PositionX", (int) shape.getPosition().x);
            temp.put("PositionY", (int) shape.getPosition().y);
            if (shape.getFillColor() != null) {
                temp.put("FillColor", (int) shape.getFillColor().getRGB());
            } else {
                temp.put("Color", (int) shape.getColor().getRGB());
            }
            temp.put("Id", shape.getId());
            if (shape instanceof Line) {
                temp.put("Point2X", ((Line) shape).getPosition2().x);
                temp.put("Point2Y", ((Line) shape).getPosition2().y);
                temp.put("Type", "Line");
            } else if (shape instanceof Rectangle) {
                temp.put("Length", ((Rectangle) shape).getLength());
                temp.put("Width", ((Rectangle) shape).getWidth());
                temp.put("Type", "Rectangle");
            } else if (shape instanceof Oval) {
                temp.put("Height", ((Oval) shape).getHeight());
                temp.put("Width", ((Oval) shape).getWidth());
                temp.put("Type", "Circle");
            } else if (shape instanceof Triangle) {
                temp.put("Point2X", ((Triangle) shape).getP2().x);
                temp.put("Point2Y", ((Triangle) shape).getP2().y);
                temp.put("Point3X", ((Triangle) shape).getP3().x);
                temp.put("Point3Y", ((Triangle) shape).getP3().y);
                temp.put("Type", "Triangle");
            }
            arr.add(temp);
        }
        try {
            FileWriter file = new FileWriter(filename);
            file.write(arr.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        this.shapes.clear();
        this.circleCounter = 0;
        this.lineCounter = 0;
        this.rectangleCounter = 0;
        this.squareCounter = 0;
        this.triangleCounter = 0;
        VectorDrawing.clearBox();
        this.refresh(null);
        JSONParser parser = new JSONParser();
        try {
            Object read = parser.parse(new FileReader(filename));
            JSONArray arr = (JSONArray) read;
            for (int i = 0; i < arr.size(); i++) {
                JSONObject temp = (JSONObject) arr.get(i);
                String type = (String) temp.get("Type");
                long positionX = (long) temp.get("PositionX");
                long positionY = (long) temp.get("PositionY");
                Point point = new Point((int) positionX, (int) positionY);
                String id = (String) temp.get("Id");
                if (type.equalsIgnoreCase("Rectangle")) {
                    long width = (long) temp.get("Width");
                    long length = (long) temp.get("Length");
                    Rectangle rec = new Rectangle((int) width, (int) length, point);
                    if (temp.get("FillColor") != null) {
                        long fillColor = (long) temp.get("FillColor");
                        rec.setFillColor(new Color((int) fillColor));

                    } else {
                        long color = (long) temp.get("Color");
                        rec.setColor(new Color((int) color));
                    }
                    rec.setId(id);
                    this.addShape(rec);
                    this.rectangleCounter++;
                    VectorDrawing.addInBox("Rectangle " + "R_" + this.getRectangleCounter());
                    this.refresh(null);
                } else if (type.equalsIgnoreCase("Line")) {
                    long lineP2X = (long) temp.get("Point2X");
                    long lineP2Y = (long) temp.get("Point2Y");
                    Point lineP2 = new Point((int) lineP2X, (int) lineP2Y);
                    Line line = new Line(lineP2, point);
                    long color = (long) temp.get("Color");
                    line.setColor(new Color((int) color));
                    line.setId(id);
                    this.lineCounter++;
                    VectorDrawing.addInBox("Line " + "L_" + this.getLineCounter());
                    this.addShape(line);
                    this.refresh(null);
                } else if (type.equalsIgnoreCase("Circle")) {
                    long width = (long) temp.get("Width");
                    long height = (long) temp.get("Height");
                    Oval circle = new Oval((int) height, (int) width, point);
                    if (temp.get("FillColor") != null) {
                        long fillColor = (long) temp.get("FillColor");
                        circle.setFillColor(new Color((int) fillColor));

                    } else {
                        long color = (long) temp.get("Color");
                        circle.setColor(new Color((int) color));
                    }
                    circle.setId(id);
                    this.circleCounter++;
                    VectorDrawing.addInBox("Circle " + "C_" + this.getCircleCounter());
                    this.addShape(circle);
                    this.refresh(null);
                } else if (type.equalsIgnoreCase("Triangle")) {
                    long trigP2X = (long) temp.get("Point2X");
                    long trigP2Y = (long) temp.get("Point2Y");
                    long trigP3X = (long) temp.get("Point3X");
                    long trigP3Y = (long) temp.get("Point3Y");
                    Point trigP2 = new Point((int) trigP2X, (int) trigP2Y);
                    Point trigP3 = new Point((int) trigP3X, (int) trigP3Y);
                    Triangle trig = new Triangle(point, trigP2, trigP3);
                    if (temp.get("FillColor") != null) {
                        long fillColor = (long) temp.get("FillColor");
                        trig.setFillColor(new Color((int) fillColor));
                    } else {
                        long color = (long) temp.get("Color");
                        trig.setColor(new Color((int) color));
                    }
                    trig.setId(id);
                    this.lineCounter++;
                    VectorDrawing.addInBox("Triangle " + "T_" + this.getLineCounter());
                    this.addShape(trig);
                    this.refresh(null);
                }
            }
            this.refresh(null);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
