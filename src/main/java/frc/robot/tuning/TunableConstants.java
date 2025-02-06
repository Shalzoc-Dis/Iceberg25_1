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

  private static double maxRobotSpeed;
  public static double maxRobotSpeed() { return maxRobotSpeed; }



  public static void loadFromPreferences() {
    // FIXME: Find a way to allow this to be done without writhing this for every single constant. Use an array and a loop or someothing.
    maxRobotSpeed = Preferences.getDouble(DefaultConstants.D_MAX_SPEED.key(), DefaultConstants.D_MAX_SPEED.val());
  }

  /** Call periodically to update the values from the dashboard. This allows for live editing */
  public static void updateConstants() {



  }

  /** Saves the current runtime values to persistent storage */
  public static void saveToPreferences() {

  }


}
