package frc.robot.tuning;

import frc.robot.tuning.Const;
import frc.robot.tuning.DefaultConstants;
import edu.wpi.first.wpilibj.Preferences;

import java.util.List;
import java.util.ArrayList;

/**
 * This class contains the tunable constants for the robot. Non-tunable constants are found in the {@link DefaultConstants} file.
 * Each constant is made of a key-value pair using the {@link Const#Const()} objects.
 * The constants are tuned using Shuffleboard in testing mode.
 */
public class TunableConstants {
  private TunableConstants() {};

  private static double robotSpeedCap;
  public static double robotSpeedCap() { return robotSpeedCap; }


  private static List<Object> savedPreferences = new ArrayList<>();

  /** Currently only supports Doubles, Booleans, and Strings */
  public static void loadFromPreferences() {
    // FIXME: Find a way to allow this to be done without writhing this for every single constant. Use an array and a loop or someothing.
    robotSpeedCap = Preferences.getDouble(DefaultConstants.D_ROBOT_SPEED_CAP.key(), DefaultConstants.D_ROBOT_SPEED_CAP.val());

    for (int i = 0; i < DefaultConstants.entries.size(); i++) {
      Const<?> item = DefaultConstants.entries.get(i);
      if (item.val().getClass() == Double.class) {
        savedPreferences.add(i, Preferences.getDouble(item.key(), (Double) item.val()));
      }
      else if (item.val().getClass() == Boolean.class) {
        savedPreferences.add(i, Preferences.getBoolean(item.key(), (Boolean) item.val()));
      }
      else if(item.val().getClass() == String.class) {
        savedPreferences.add(i, Preferences.getString(item.key(), (String) item.val()));
      }
      else {
        // TODO Throw an error or handle it somehow
      }
    }
  }

  /** Saves the current runtime values to persistent storage */
  public static void saveToPreferences() {
    Preferences.setDouble(DefaultConstants.D_ROBOT_SPEED_CAP.key(), DefaultConstants.D_ROBOT_SPEED_CAP.val());
  }


}