import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;


public class SimpleEditorFrame extends JFrame {

    JMenuBar menuBar;
    JMenu myMenu, chooseFigure;
    JMenuItem save, load, cleanAll, triangle, square, circle, rectangle, informations, instruction;
    MyPanel drawingField;

    JFrame frame = new JFrame();

    public SimpleEditorFrame() {
        frame.setTitle("Najprostszy Edytor Graficzny");
        frame.setSize(720, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout border = new BorderLayout();
        frame.setLayout(border);

        menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        myMenu = new JMenu("Menu");
        chooseFigure = new JMenu("Wybierz figurę");
        instruction = new JMenuItem("Instrukcja");
        informations = new JMenuItem("Info");
        save = new JMenuItem("Zapisz");
        load = new JMenuItem("Wczytaj");
        cleanAll = new JMenuItem("Wyczyść wszystko");
        triangle = new JMenuItem("Trójkąt");
        square = new JMenuItem("Kwadrat");
        circle = new JMenuItem("Okrag");
        rectangle = new JMenuItem("Prostokąt");

        chooseFigure.add(circle);
        chooseFigure.add(triangle);
        chooseFigure.add(rectangle);
        chooseFigure.add(square);
        myMenu.add(chooseFigure);
        myMenu.add(save);
        myMenu.add(load);
        myMenu.add(cleanAll);
        menuBar.add(myMenu);
        menuBar.add(instruction);
        menuBar.add(informations);

        frame.setJMenuBar(menuBar);
        drawingField = new MyPanel();
        MyPopupMenu myPopupMenu = new MyPopupMenu();
        drawingField.add(myPopupMenu);
        frame.add(drawingField, BorderLayout.CENTER);

        instruction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Wybierz figurę, którą chcesz\n" +
                        " narysować z menu\n\n" + "Naciśnij na panel i przeciągnij myszkę" +
                        " w celu narysowania figury\n\n" + "Naciśnij prawym przyciskiem myszy\n" +
                        "na figurę by zmienić jej rozmiar i kolor\n\n" + "Żeby wyczyścić panel wybierz\n" +
                        "odpowiednią opcję z menu", "Instrukcja", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        informations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Program umożliwia rysowanie" +
                        "\n i modyfikowanie prostych figur geometrycznych\n\n" +
                        "Autor: Rafał Mateusiak", "O programie", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        cleanAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingField.isPanelactive = true;
                drawingField.removeAll();
                drawingField.repaint();
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // save
            }
        });
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //load
            }
        });
        triangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingField.setCurrentFigure("TROJKAT");
                drawingField.isPanelactive = true;
            }
        });
        circle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingField.setCurrentFigure("KOLO");
                drawingField.isPanelactive = true;
            }
        });
        square.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingField.setCurrentFigure("KWADRAT");
            }
        });
        rectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingField.setCurrentFigure("PROSTOKAT");
                drawingField.isPanelactive = true;
            }
        });
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e) {
            System.out.println("Error setting native LAF: " + e);
        }
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    class MyPopupMenu extends JPopupMenu {

        JPopupMenu mypopupmenu;
        JMenuItem edit, black, red, green, blue, yellow, orange, random;
        JMenu chooseColor;

        MyPopupMenu() {
            mypopupmenu = new JPopupMenu();
            edit = new JMenuItem("Edytuj");
            chooseColor = new JMenu("Wybierz kolor");
            black = new JMenuItem("Czarny");
            red = new JMenuItem("Czerwony");
            green = new JMenuItem("Zielony");
            blue = new JMenuItem("Niebieski");
            yellow = new JMenuItem("Żółty");
            orange = new JMenuItem("Pomarańczowy");
            random = new JMenuItem("Losowy");

            chooseColor.add(black);
            chooseColor.add(red);
            chooseColor.add(green);
            chooseColor.add(blue);
            chooseColor.add(yellow);
            chooseColor.add(orange);
            chooseColor.add(random);
            mypopupmenu.add(edit);
            mypopupmenu.add(chooseColor);

            edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // setEditable(true);
                }
            });
            black.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    drawingField.setCurrentColor(Color.BLACK);
                }
            });
            red.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    drawingField.setCurrentColor(Color.RED);

                }
            });
            green.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    drawingField.setCurrentColor(Color.GREEN);
                }
            });
            blue.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    drawingField.setCurrentColor(Color.BLUE);
                }
            });
            yellow.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    drawingField.setCurrentColor(Color.YELLOW);
                }
            });
            orange.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    drawingField.setCurrentColor(Color.ORANGE);
                }
            });
            random.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Random r = new Random();
                    Color randomColor = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
                    drawingField.setCurrentColor(randomColor);
                }
            });
            // obsługa pojawienia się PopupMenu
            drawingField.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        mypopupmenu.show(frame, e.getX(), e.getY());
                    }
                }
            });
        }
    }

    public static  void main(String[] arguments) {
        new SimpleEditorFrame();
    }
}
class MyPanel extends JPanel {
    
    Boolean isPanelactive = false;
    Boolean isDrawing = false;
    Color currentColor = Color.BLACK;
    String currentFigure = "";
    private int X1 = 0, X2 = 0, Y1 = 0, Y2 = 0;
    List<Object> paintedFigures = new ArrayList<Object>();

    public  MyPanel() {

        addMouseListener(new MyMouseListener());
    }

    public void setStartPoints(int x1, int y1) {
        this.X1 = x1;
        this.Y1 = y1;
    }

    public int getX1() {
        return X1;
    }
    public int getY1() {
        return Y1;
    }

    public void setEndPoints(int x2, int y2) {
        this.X2 = x2;
        this.Y2 = y2;
    }

    public int getX2() {
        return X2;
    }
    public int getY2() {
        return Y2;
    }

    public void setCurrentColor(Color current) {
        this.currentColor = current;
    }
    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentFigure(String figure) {
        this.currentFigure = figure;
    }
    public String getCurrentFigure() {
        return currentFigure;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        if (isDrawing && isPanelactive) {
            drawAll(g2d);
        }

        g2d.dispose();
        // if (myEditor.getEditMode() == false) {
        //      drawCurrent(g);
        // }
    }
    public void drawAll(Graphics2D g2d) {

        for (int i = 0; i < paintedFigures.size(); i++) {
            Figure figureCase = (Figure) paintedFigures.get(i);
            if (figureCase.getName() != null) {
                switch (figureCase.getName()) {
                    case "KWADRAT":
                        // setToDrawSquare(g2d);
                        break;
                    case "KOLO":
                        Circle o = (Circle) paintedFigures.get(i);
                        setToDrawCircle(g2d, o.getMeX1(), o.getMeY1(), o.getMeX2(), o.getMeY2(), false);
                        break;
                    case "TROJKAT":
                        // setToDrawTriangle(g2d);
                        break;
                    case "PROSTOKAT":
                        Rectangle r = (Rectangle) paintedFigures.get(i);
                        setToDrawRectangle(g2d, r.getMeX1(), r.getMeY1(), r.getMeX2(), r.getMeY2(), false);
                        break;
                }
            }
        }
    }
    public void addFigure(int startX, int startY, int width, int height) {
        switch (getCurrentFigure()) {
            case "PROSTOKAT":
                Rectangle rect2d = new Rectangle(startX, startY, width, height, "PROSTOKAT");
                paintedFigures.add(rect2d);
                isDrawing = false;
                setStartPoints(0,0);
                setEndPoints(0,0);
                break;
            case "KOLO":
                Circle circ2d = new Circle(startX, startY, width, height, "KOLO");
                paintedFigures.add(circ2d);
                isDrawing = false;
                setStartPoints(0,0);
                setEndPoints(0,0);
                break;
        }
    }
    public void setToDrawRectangle(Graphics2D g2d, int s1, int t1, int s2, int t2, Boolean isNew) {
        int width = Math.abs(s2 - s1);
        int height = Math.abs(t2 - t1);
        g2d.setColor(getCurrentColor());
        g2d.fillRect(s1, t1, width, height);
        if (isNew) {
            addFigure(s1, t1, width, height);
        }
        else {
            isDrawing = false;
            setStartPoints(0,0);
            setEndPoints(0,0);
        }
    }

    public void setToDrawCircle (Graphics2D g2d, int s1, int t1, int s2, int t2, Boolean isNew) {
        int width = (int) Math.sqrt((Math.pow(Math.abs(s2 - s1), 2) + Math.pow(Math.abs(t2 - t1), 2)));
        int height = width;
        System.out.println(s1 + " " + t1 + " " + s2 + " " + t2);
        g2d.setColor(getCurrentColor());
        g2d.fillOval(s1, t1, width, height);
        if (isNew) {
            addFigure(s1, t1, width, height);
        }
        else {
            isDrawing = false;
            setStartPoints(0,0);
            setEndPoints(0,0);
        }
    }
    public boolean isEndOfDrawing() {
        return isDrawing;
    }
    class Figure {
        private String _name;
        Figure (String name) { this._name = name; }
        public String getName() { return _name; }
    }
    class Rectangle extends Figure {
        private int xx1, yy1, xx2, yy2;

        Rectangle (int x1, int y1, int x2, int y2, String name) {
            super(name);
            this.xx1 = x1;
            this.yy1 = y1;
            this.xx2 = x2;
            this.yy2 = y2;
        }
        public int getMeX1(){ return xx1; }
        public int getMeY1(){ return yy1; }
        public int getMeX2(){ return xx2; }
        public int getMeY2(){ return yy2; }
    }

    class Circle extends Figure{
        private int xx1, yy1, xx2, yy2;

        Circle (int x1, int y1, int x2, int y2, String name) {
            super(name);
            this.xx1 = x1;
            this.yy1 = y1;
            this.xx2 = x2;
            this.yy2 = y2;
        }
        public int getMeX1(){ return xx1; }
        public int getMeY1(){ return yy1; }
        public int getMeX2(){ return xx2; }
        public int getMeY2(){ return yy2; }
    }

    class MyMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // h
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (isPanelactive) {
                isDrawing = true;
                setStartPoints(e.getX(), e.getY());
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (isPanelactive) {
                setEndPoints(e.getX(), e.getY());
                Graphics g = getGraphics();
                Graphics2D g2d = (Graphics2D) g.create();
                switch (getCurrentFigure()) {
                    case "KOLO":
                        setToDrawCircle(g2d, getX1(), getY1(), getX2(), getY2(), true);
                        g2d.dispose();
                    case "PROSTOKAT":
                        setToDrawRectangle(g2d, getX1(), getY1(), getX2(), getY2(), true);
                        g2d.dispose();
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
