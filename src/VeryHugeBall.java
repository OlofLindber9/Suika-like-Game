public class VeryHugeBall extends Ball{
    VeryHugeBall(double x, double y, double ax, double ay, double r, double m, boolean outOfConstraint, boolean outOfGame, boolean intersectWithOtherBall) {
        super(x, y, ax, ay, r, m, outOfConstraint, outOfGame, intersectWithOtherBall);
        this.radius = 1.1390625;
        this.mass = 7;
    }
}
