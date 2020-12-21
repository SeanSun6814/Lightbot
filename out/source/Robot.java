public class Robot extends RobotBase {

    public Drive drive = new Drive();
    public GroundSensor groundSensor = new GroundSensor();

    public void init() {
    }

    public void loop() {
        drive.moveForward();
        if (groundSensor.getFrontGroundType().equals("Nothing"))
            drive.rotateLeft();
    }
}
