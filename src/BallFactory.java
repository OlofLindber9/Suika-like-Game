import java.util.Arrays;

public class BallFactory {


    Model model;
    double  areaHeight;
    double areaWidth;
    int counter = 0;
    NextBall nextBall;
    //Constructor
    BallFactory(Model model, NextBall nextBall){
        this.model = model;
        this.areaHeight = model.areaHeight;
        this.areaWidth = model.areaWidth;
        this.nextBall = nextBall;
    }

    void createVerySmallBall(double x, double y){
        System.out.println("VerySmallBall will be created");

        model.balls.add(new VerySmallBall(x, y, 0, 0, 0.1, 1, false, false, false));
    }

    void createSmallBall(double x, double y){
        System.out.println("SmallBall will be created");

        model.balls.add(new SmallBall(x, y, 0, 0, 0.1, 1, false, false, false));// Detta kan vara bugg!!!!!!!!
    }
    void createNormalBall(double x, double y){
        System.out.println("NormalBall will be created");

        model.balls.add(new NormalBall(x, y, 0, 0, 0.1, 1, false, false, false));
    }
    void createBigBall(double x, double y){
        System.out.println("BigBall will be created");

        model.balls.add(new BigBall(x, y, 0, 0, 0.1, 1, false, false, false));
    }
    void createVeryBigBall(double x, double y){
        System.out.println("VeryBigBall will be created");

        model.balls.add(new VeryBigBall(x, y, 0, 0, 0.1, 1, false, false, false));
    }
    void createHugeBall(double x, double y){
        System.out.println("HugeBall will be created");

        model.balls.add(new HugeBall(x, y, 0, 0, 0.1, 1, false, false, false));
    }
    void createVeryHugeBall(double x, double y){
        System.out.println("VeryHugeBall will be created");

        model.balls.add(new VeryHugeBall(x, y, 0, 0, 0.1, 1, false, false, false));
    }


    void CreateBall(double x, double y, double pixelsPerMeter){
        System.out.println("Ball will be created");

        // Convert pixel coordinates to model's coordinates
        double xModel = x / pixelsPerMeter;
        double yModel = areaHeight - (y / pixelsPerMeter);
        counter++;
            if((counter % 7) == 0){
                model.balls.add(new SmallBall(xModel, yModel, 0, 0, 0.1, 1, false, false, false));
                nextBall.setValue("VerySmallBall");
            }
            if((counter % 7) == 1){
                model.balls.add(new VerySmallBall(xModel, yModel, 0, 0, 0.1, 1,false, false, false));
                nextBall.setValue("NormalBall");
            }
            if((counter % 7) == 2){
                model.balls.add(new NormalBall(xModel, yModel, 0, 0, 0.1, 1,false, false, false));
                nextBall.setValue("NormalBall");
            }
            if((counter % 7) == 3){
                model.balls.add(new NormalBall(xModel, yModel, 0, 0, 0.1, 1,false, false, false));
                nextBall.setValue("NormalBall");
            }
            if((counter % 7) == 4){
                model.balls.add(new NormalBall(xModel, yModel, 0, 0, 0.1, 1,false, false, false));
                nextBall.setValue("VerySmallBall");
            }
            if((counter % 7) == 5){
                model.balls.add(new VerySmallBall(xModel, yModel, 0, 0, 0.1, 1,false, false, false));
                nextBall.setValue("VerySmallBall");
            }
            if((counter % 7) == 6){
                model.balls.add(new VerySmallBall(xModel, yModel, 0, 0, 0.1, 1,false, false, false));
                nextBall.setValue("SmallBall");
            }
    }
}
