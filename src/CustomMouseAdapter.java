import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class CustomMouseAdapter extends MouseAdapter {
    private Animator animator;
    private double pixelPerMeter;

    public CustomMouseAdapter(Animator animator, double pixelPerMeter) {
        this.animator = animator;
        this.pixelPerMeter = pixelPerMeter;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse Pressed at: " + e.getX() + ", " + "10");
        animator.ballFactory.CreateBall(e.getX(), 10, pixelPerMeter);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse Released at: " + e.getX() + ", " + e.getY());
    }
}
