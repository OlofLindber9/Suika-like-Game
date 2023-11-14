import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public final class Animator extends JPanel implements ActionListener {

    private static int cursorX;
    private static int cursorY;
    private final NextBall nextBall;

    public Animator(int pixelWidth, int pixelHeight, int fps) {
        super(true);
        this.timer = new Timer(1000 / fps, this);
        this.deltaT = 1.0 / fps;
        this.model = new Model(pixelWidth / pixelsPerMeter, pixelHeight / pixelsPerMeter, this);
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(pixelWidth, pixelHeight));
        this.nextBall = new NextBall();
        this.ballFactory = new BallFactory(model, nextBall);
    }

    private static final double pixelsPerMeter = 200;
    private Model model;

    BallFactory ballFactory;
    private Timer timer;
    private double deltaT;

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        //här är en stor rektangel. Detta kanske inte funkar med Onclick.
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());

        // draw balls
        for (Ball b : model.balls) {
            double x = b.position_current.getX() - b.radius;
            double y = b.position_current.getY() + b.radius;
            // paint balls (y-coordinates are inverted)
            Ellipse2D.Double e = new Ellipse2D.Double(
                    x * pixelsPerMeter,
                    this.getHeight() - (y * pixelsPerMeter),
                    b.radius * 2 * pixelsPerMeter,
                    b.radius * 2 * pixelsPerMeter);

            if (b instanceof VerySmallBall){
                g2.setColor(Color.BLUE);
            }
            if (b instanceof SmallBall){
                g2.setColor(Color.RED);
            }
            if (b instanceof NormalBall){
                g2.setColor(Color.BLACK);
            }
            if (b instanceof BigBall){
                g2.setColor(Color.YELLOW);
            }
            if (b instanceof VeryBigBall){
                g2.setColor(Color.GREEN);
            }
            if (b instanceof HugeBall){
                g2.setColor(Color.pink);
            }
            if (b instanceof VeryHugeBall){
                g2.setColor(Color.CYAN);
            }
            g2.fill(e);
        }
        drawPreviewBall(g2);
        g2.setColor(Color.BLACK);
        Path2D jar = new Path2D.Double();
        jar.moveTo(600,10);
        jar.lineTo(600,870);
        jar.lineTo(1320,870);
        jar.lineTo(1320,10);

        g2.draw(jar);
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawPreviewBall(Graphics2D g2) {
        if(Objects.equals(ballFactory.nextBall.getValue(), "VerySmallBall")){
            double x = cursorX;
            double y = 10;
            // paint balls (y-coordinates are inverted)
            Ellipse2D.Double e = new Ellipse2D.Double(
                    x,
                    this.getHeight() - (y),
                    0.1 * 2 * pixelsPerMeter,
                    0.1 * 2 * pixelsPerMeter);
            g2.setColor(Color.BLUE);
            g2.fill(e);
        }
        if(Objects.equals(ballFactory.nextBall.getValue(), "SmallBall")){
            double x = cursorX;
            double y = 10;
            // paint balls (y-coordinates are inverted)
            Ellipse2D.Double e = new Ellipse2D.Double(
                    x,
                    this.getHeight() - (y),
                    0.15 * 2 * pixelsPerMeter,
                    0.15 * 2 * pixelsPerMeter);
            g2.setColor(Color.RED);
            g2.fill(e);

        }
        if(Objects.equals(ballFactory.nextBall.getValue(), "NormalBall")){
            double x = cursorX;
            double y = 10;
            // paint balls (y-coordinates are inverted)
            Ellipse2D.Double e = new Ellipse2D.Double(
                    x,
                    this.getHeight() - (y),
                    0.225 * 2 * pixelsPerMeter,
                    0.225 * 2 * pixelsPerMeter);
            g2.setColor(Color.BLACK);
            g2.fill(e);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.step(deltaT);
        this.repaint();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Animator anim = new Animator(1920, 1080, 120);
                anim.addMouseListener(new CustomMouseAdapter(anim, pixelsPerMeter));
                anim.addMouseMotionListener(new MouseMotionAdapter(){
                    @Override
                    public void mouseMoved(MouseEvent e){
                        cursorX = e.getX();
                        cursorY = e.getY();
                    }
                });
                JFrame frame = new JFrame("Suika game");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(anim);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                anim.start();
            }
        });
    }
}

