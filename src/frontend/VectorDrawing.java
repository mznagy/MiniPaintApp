package frontend;

import shapes.Shape;
import java.awt.Point;
import javax.swing.filechooser.FileNameExtensionFilter;
import shapes.AbstractShape;
import shapes.Oval;
import shapes.Line;
import shapes.Rectangle;
import shapes.Triangle;

public class VectorDrawing extends javax.swing.JFrame implements Node {

    private MyPanel panel;
    private AbstractShape selectedShape;

    public VectorDrawing() {
        this.setTitle("Vector Drawing Application");
        initComponents();
        panel = (MyPanel) board;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        board = new MyPanel();
        LineBtn = new javax.swing.JButton();
        CircleBtn = new javax.swing.JButton();
        RectangleBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ColorizeBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        ShapesBox = new javax.swing.JComboBox<>();
        Trianglebtn = new javax.swing.JButton();
        Copybtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        savebtn = new javax.swing.JMenuItem();
        loadbtn = new javax.swing.JMenuItem();

        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setDialogType(javax.swing.JFileChooser.CUSTOM_DIALOG);
        fileChooser.setCurrentDirectory(new java.io.File("/C:/Users/omari/OneDrive/Desktop/Paint2"));
        fileChooser.setDialogTitle("");
        fileChooser.setAlignmentX(400.0F);
        fileChooser.setAlignmentY(200.0F);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setLocation(new java.awt.Point(550, 300));

        board.setBackground(new java.awt.Color(255, 255, 255));
        board.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        board.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                boardMouseDragged(evt);
            }
        });
        board.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boardMousePressed(evt);
            }
        });

        javax.swing.GroupLayout boardLayout = new javax.swing.GroupLayout(board);
        board.setLayout(boardLayout);
        boardLayout.setHorizontalGroup(
            boardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        boardLayout.setVerticalGroup(
            boardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );

        LineBtn.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.focusedBackground"));
        LineBtn.setText("Line");
        LineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LineBtnActionPerformed(evt);
            }
        });

        CircleBtn.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.focusedBackground"));
        CircleBtn.setText("Oval");
        CircleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CircleBtnActionPerformed(evt);
            }
        });

        RectangleBtn.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.focusedBackground"));
        RectangleBtn.setText("Rectangle");
        RectangleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RectangleBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Shape");

        ColorizeBtn.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.focusedBackground"));
        ColorizeBtn.setText("Colorize");
        ColorizeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorizeBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.focusedBackground"));
        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        Trianglebtn.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.focusedBackground"));
        Trianglebtn.setText("Triangle");
        Trianglebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrianglebtnActionPerformed(evt);
            }
        });

        Copybtn.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.focusedBackground"));
        Copybtn.setText("Copy");
        Copybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopybtnActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        savebtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        savebtn.setText("Save as");
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });
        jMenu1.add(savebtn);

        loadbtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        loadbtn.setText("Load");
        loadbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadbtnActionPerformed(evt);
            }
        });
        jMenu1.add(loadbtn);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ShapesBox, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ColorizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Copybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(board, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LineBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                        .addComponent(RectangleBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                        .addComponent(CircleBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                        .addComponent(Trianglebtn)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LineBtn)
                        .addComponent(RectangleBtn))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Trianglebtn)
                        .addComponent(CircleBtn)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(board, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ShapesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(ColorizeBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Copybtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteBtn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void LineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LineBtnActionPerformed

        AddLine line = new AddLine(panel);
        line.setVisible(true);
        line.setParentNode(this);
        this.setVisible(false);

    }//GEN-LAST:event_LineBtnActionPerformed

    private void RectangleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RectangleBtnActionPerformed
        AddRectangle rectangle = new AddRectangle(panel);
        rectangle.setVisible(true);
        rectangle.setParentNode(this);
        this.setVisible(false);

    }//GEN-LAST:event_RectangleBtnActionPerformed

    private void CircleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CircleBtnActionPerformed
        AddCircle circle = new AddCircle(panel);
        circle.setVisible(true);
        circle.setParentNode(this);
        this.setVisible(false);

}//GEN-LAST:event_CircleBtnActionPerformed

    private void ColorizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColorizeBtnActionPerformed
int index = ShapesBox.getSelectedIndex();
          if(index<0){return;}
        ColorizeWindow colorize = new ColorizeWindow(panel, panel.getShapes()[ShapesBox.getSelectedIndex()]);
        colorize.setVisible(true);
        colorize.setParentNode(this);
        this.setVisible(false);
    }//GEN-LAST:event_ColorizeBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        int index = ShapesBox.getSelectedIndex();
        if (index < 0) {
            return;
        }
        Shape[] myshapes = panel.getShapes();
        ShapesBox.removeItemAt(index);
        panel.removeShape(myshapes[index]);
        panel.refresh(null);
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void TrianglebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrianglebtnActionPerformed
        AddTriangle triangle = new AddTriangle(panel);
        triangle.setVisible(true);
        triangle.setParentNode(this);
        this.setVisible(false);

    }//GEN-LAST:event_TrianglebtnActionPerformed

    private void boardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boardMousePressed
        Point click = evt.getPoint();
        if (selectedShape != null) {
            selectedShape.setEditPoint(null);
            selectedShape = null;
        }
        panel.showCorners(false, selectedShape);
        for (int i = 0; i < panel.getShapes().length; i++) {
            for (int j = 0; j < panel.getShapes()[i].getCorners().length; j++) {
                if (panel.getShapes()[i].getCorners()[j].contains(click)) {
                    panel.showCorners(false, selectedShape);
                    selectedShape = panel.getShapes()[i];
                    panel.showCorners(true, selectedShape);
                    selectedShape.setEditPoint(new Point(selectedShape.getCorners()[j].getPosition().x + 5, selectedShape.getCorners()[j].getPosition().y + 5));
                    ShapesBox.setSelectedIndex(i);
                }
            }
            if (panel.getShapes()[i].contains(click)) {
                panel.showCorners(false, selectedShape);
                ShapesBox.setSelectedIndex(i);
                selectedShape = panel.getShapes()[i];
                panel.showCorners(true, selectedShape);
                selectedShape.setDraggingPoint(click);
            }
        }


    }//GEN-LAST:event_boardMousePressed

    private void boardMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boardMouseDragged
        Point click = evt.getPoint();
        if (selectedShape != null && selectedShape.getEditPoint() == null) {
            selectedShape.moveTo(click);
            panel.showCorners(false, selectedShape);
            panel.showCorners(true, selectedShape);
            panel.refresh(null);
        } else if (selectedShape != null && selectedShape.getEditPoint() != null) {
            selectedShape.moveCorner(click);
            panel.showCorners(false, selectedShape);
            panel.showCorners(true, selectedShape);
            panel.refresh(null);
        }
    }//GEN-LAST:event_boardMouseDragged

    private void CopybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopybtnActionPerformed

          int index = ShapesBox.getSelectedIndex();
          if(index<0){return;}
        Shape shape = (Shape) panel.getShapes()[ShapesBox.getSelectedIndex()];
        if (shape instanceof Line) {
            Line line = new Line(((Line) shape).getPosition2(), ((Line) shape).getPosition());
            line.setColor(shape.getColor());
            line.setFillColor(shape.getFillColor());
            line.setId("L_" + panel.getLineCounter());
            panel.setLineCounter(panel.getLineCounter() + 1);
            this.addInBox("Line " + "L_" + panel.getLineCounter());
            panel.addShape(line);

        } else if (shape instanceof Rectangle) {
            Rectangle rec = new Rectangle(((Rectangle) shape).getWidth(), ((Rectangle) shape).getLength(), shape.getPosition());
            rec.setColor(shape.getColor());
            rec.setFillColor(shape.getFillColor());
            rec.setId("R_" + panel.getRectangleCounter());
            panel.setRectangleCounter(panel.getRectangleCounter() + 1);
            this.addInBox("Rectangle " + "R_" + panel.getRectangleCounter());
            panel.addShape(rec);
        } else if (shape instanceof Oval) {
            Oval circle = new Oval(((Oval) shape).getHeight(), ((Oval) shape).getWidth(), shape.getPosition());
            circle.setColor(shape.getColor());
            circle.setFillColor(shape.getFillColor());
            circle.setId("C_" + panel.getCircleCounter());
            panel.setCircleCounter(panel.getCircleCounter() + 1);
            this.addInBox("Circle " + "C_" + panel.getCircleCounter());
            panel.addShape(circle);
        } else if (shape instanceof Triangle) {
            Triangle trig = new Triangle(((Triangle) shape).getPosition(), ((Triangle) shape).getP2(), ((Triangle) shape).getP3());
            trig.setColor(shape.getColor());
            trig.setFillColor(shape.getFillColor());
            trig.setId("T_" + panel.getTriangleCounter());
            panel.setTriangleCounter(panel.getTriangleCounter() + 1);
            this.addInBox("Traingle " + "T_" + panel.getTriangleCounter());
            panel.addShape(trig);
        }
        panel.refresh(null);
    }//GEN-LAST:event_CopybtnActionPerformed

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        fileChooser.setDialogTitle("Save As");
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".json", "json"));
        int i = fileChooser.showSaveDialog(panel);
        if (i == fileChooser.APPROVE_OPTION){
            String filename = fileChooser.getSelectedFile().getPath();
            if(filename.contains(".json"))
            {
                panel.saveToFile(filename);
            }else
            {
                filename = filename + ".json" ;
                panel.saveToFile(filename);
            }
            
            
        }
    }//GEN-LAST:event_savebtnActionPerformed

    private void loadbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadbtnActionPerformed
        fileChooser.setDialogTitle("Load");
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".json", "json"));
        int i = fileChooser.showOpenDialog(panel);
        if (i == fileChooser.APPROVE_OPTION){
            panel.loadFromFile(fileChooser.getSelectedFile().getPath());
        }
        
    }//GEN-LAST:event_loadbtnActionPerformed

    public static void addInBox(String s) {
        ShapesBox.addItem(s);
    }

    public static void clearBox() {
        ShapesBox.removeAllItems();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VectorDrawing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VectorDrawing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VectorDrawing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VectorDrawing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VectorDrawing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CircleBtn;
    private javax.swing.JButton ColorizeBtn;
    private javax.swing.JButton Copybtn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton LineBtn;
    private javax.swing.JButton RectangleBtn;
    private static javax.swing.JComboBox<String> ShapesBox;
    private javax.swing.JButton Trianglebtn;
    private javax.swing.JPanel board;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem loadbtn;
    private javax.swing.JMenuItem savebtn;
    // End of variables declaration//GEN-END:variables

    @Override
    public Node getParentNode() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParentNode(Node node) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
