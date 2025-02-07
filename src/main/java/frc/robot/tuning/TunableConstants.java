package frc.robot.tuning;

import frc.robot.tuning.Const;
import frc.robot.tuning.DefaultConstants;
import edu.wpi.first.wpilibj.Preferences;

/**
 * This class contains the tunable constants for the robot. Non-tunable constants are found in the {@link DefaultConstants} file.
 * Each constant is made of a key-value pair using the {@link Const#Const()} objects.
 * The constants are tuned using Shuffleboard in testing mode.
 */
public class TunableConstants {
  private TunableConstants() {};

  // To add a new tunable constant, make sure to create a default constant, add a field here along with a getter, add it to the loadFromPreferences, 
  // update, and save methods, and add a NetworkTable entry and getter in the DashboardManager. It is a lot of work, but I'm working on redcing that.

  private static double robotSpeedCap;
  public static double robotSpeedCap() { return robotSpeedCap; }



  public static void loadFromPreferences() {
    // FIXME: Find a way to allow this to be done without writhing this for every single constant. Use an array and a loop or someothing.
    robotSpeedCap = Preferences.getDouble(DefaultConstants.D_ROBOT_SPEED_CAP.key(), DefaultConstants.D_ROBOT_SPEED_CAP.val());
  }

  /** Call periodically to update the values from the dashboard. This allows for live editing */
  public static void updateConstants(double nRobotSpeedCap) {
    robotSpeedCap = nRobotSpeedCap;



  }

  /** Saves the current runtime values to persistent storage */
  public static void saveToPreferences() {
    Preferences.setDouble(DefaultConstants.D_ROBOT_SPEED_CAP.key(), DefaultConstants.D_ROBOT_SPEED_CAP.val());
  }


}
