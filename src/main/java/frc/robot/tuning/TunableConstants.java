package frc.robot.tuning;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

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
  private static List<Const<?>> m_defaults;

  /** This merely contains the values, it does not contain the keys. */
  public static List<Const<?>> tunables = new ArrayList<>();

  /** Initialize the tunable constants and load them from persistent storage */
  public static synchronized void init() {
    if (m_instance == null) {
      m_instance = new TunableConstants();
      m_defaults = DefaultConstants.getEntries();
      loadFromPreferences();
    }
  }

  /** This is a network table to house the constants that can be used for tuning */
  // private static final NetworkTable tuningTable = NetworkTableInstance.getDefault().getTable("Tuning");


  /** Load the preferences from storage into memory for use */
  public static void loadFromPreferences() {

    for (Const<?> item : m_defaults) {

      Object value = item.val();
      String key = item.key();

      if (value instanceof Double) {
        tunables.add(new Const<Double>(key, Preferences.getDouble(key, (Double) value)));
      } 
      else if (value instanceof Boolean) {
        tunables.add(new Const<Boolean>(key, Preferences.getBoolean(key, (Boolean) value)));
      } 
      else if (value instanceof String) {
        tunables.add(new Const<String>(key, Preferences.getString(key, (String) value)));
      } 
      else if (value instanceof Integer) {
        tunables.add(new Const<Integer>(key, Preferences.getInt(key, (Integer) value)));
      } 
      else if (value instanceof Float) {
        tunables.add(new Const<Float>(key, Preferences.getFloat(key, (Float) value)));
      } 
      else {
        // TODO: Throw an error or handle it somehow
        // This could never be needed
      }
    }
  }

  /** Saves the current runtime values to persistent storage */
  public static void saveToPreferences() {
    for (Const<?> item : tunables) {
      Object value = item.val();
      String key = item.key();

      if (value instanceof Double) {
        Preferences.setDouble(key, (Double) value);
      } 
      else if (value instanceof Boolean) {
        Preferences.setBoolean(key, (Boolean) value);
      } 
      else if (value instanceof String) {
        Preferences.setString(key, (String) value);
      } 
      else if (value instanceof Integer) {
        Preferences.setInt(key, (Integer) value);
      } 
      else if (value instanceof Float) {
        Preferences.setFloat(key, (Float) value);
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
        return tunables.get(i);
      }
    }
    return null;
  }
 */
}