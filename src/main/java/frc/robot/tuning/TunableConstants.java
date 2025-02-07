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
  private static TunableConstants m_instance;

  /** This merely contains the values, it does not contain the keys. */
  public static List<Object> workingValues = new ArrayList<>();

  /** Initialize the tunable constants and load them from persistent storage */
  public static synchronized void init() {
    DefaultConstants.init();
    if (m_instance == null) {
      m_instance = new TunableConstants();

      for (Const<?> item : DefaultConstants.entries) {
        workingValues.add(item.val());
      }
    }
    loadFromPreferences();
  }


  /** Load the preferences from storage into memory for use */
  public static void loadFromPreferences() {
    // FIXME: Find a way to allow this to be done without writhing this for every single constant. Use an array and a loop or something.
    // robotSpeedCap = Preferences.getDouble(DefaultConstants.D_ROBOT_SPEED_CAP.key(), DefaultConstants.D_ROBOT_SPEED_CAP.val());

    for (int i = 0; i < DefaultConstants.entries.size(); i++) {
      Const<?> item = DefaultConstants.entries.get(i);
      Object value = item.val();

      if (value instanceof Double) {
        workingValues.add(i, Preferences.getDouble(item.key(), (Double) value));
      } 
      else if (value instanceof Boolean) {
        workingValues.add(i, Preferences.getBoolean(item.key(), (Boolean) value));
      } 
      else if (value instanceof String) {
        workingValues.add(i, Preferences.getString(item.key(), (String) value));
      } 
      else if (value instanceof Integer) {
        workingValues.add(i, Preferences.getInt(item.key(), (Integer) value));
      } 
      else if (value instanceof Float) {
        workingValues.add(i, Preferences.getFloat(item.key(), (Float) value));
      } 
      else {
        // TODO: Throw an error or handle it somehow
        // This could never be needed
      }
    }
  }

  /** Saves the current runtime values to persistent storage */
  public static void saveToPreferences() {
    // Preferences.setDouble(DefaultConstants.D_ROBOT_SPEED_CAP.key(), DefaultConstants.D_ROBOT_SPEED_CAP.val());
    for (int i = 0; i < workingValues.size(); i++) {
      Const<?> item = DefaultConstants.entries.get(i);
      Object value = item.val();
      
      if (value instanceof Double) {
        Preferences.setDouble(item.key(), (Double) value);
      } 
      else if (value instanceof Boolean) {
        Preferences.setBoolean(item.key(), (Boolean) value);
      } 
      else if (value instanceof String) {
        Preferences.setString(item.key(), (String) value);
      } 
      else if (value instanceof Integer) {
        Preferences.setInt(item.key(), (Integer) value);
      } 
      else if (value instanceof Float) {
        Preferences.setFloat(item.key(), (Float) value);
      } 
      else {
        // TODO: Throw an error or handle it somehow
        // This could never be needed
      }
    }
  }

  /** If given a key, this finds the current value of the entry */
  /*
  public static Object find(String key) {
    for (int i = 0; i < DefaultConstants.entries.size(); i++) {
      Const<?> item = DefaultConstants.entries.get(i);
      if (item.key() == key) {
        return workingValues.get(i);
      }
    }
    return null;
  }
 */
}