public class Robot extends RobotBase {

    public Drive drive = new Drive();
    public GroundSensor groundSensor = new GroundSensor();
    public LightSwitcher lightSwitcher = new LightSwitcher();

    public void init() {
        System.out.println("INIT IS CALLED!");
    }

    public void loop() {
        // System.out.println("LOOP IS CALLED!");
        drive.moveForward();
        if (groundSensor.getFront().equals("Nothing") && groundSensor.getRight().equals("Space")) {
            drive.rotateRight();
        }

        if (groundSensor.getLeft().equals("Space")) {
            drive.rotateLeft();
        }

        if (groundSensor.getLeft().equals("Light")) {
            drive.rotateLeft();
            lightSwitcher.switchLight();
        }
    }
}
