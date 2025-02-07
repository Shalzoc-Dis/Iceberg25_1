package frc.robot.tuning;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import frc.robot.tuning.Const;

/**
 * This contains lots of default constants that are defined in the program and not in Shuffleboard. 
 * Const objects marked as final are not tunable.
 * The prefix 'D' before the key indicates that it is a default constant.
 */
public class DefaultConstants {

  public static List<Const<?>> entries = new ArrayList<>();

  public DefaultConstants() {
    /** Max allowed robot angular velocity in rad/s */
    entries.add(new Const<Double>("D_ROBOT_ANGULAR_VELOCITY_CAP", 0.2));
    /** Robot wheel diameter in inches */
    entries.add(new Const<Integer>("D_WHEEL_DIAMETER", 4));
    /** Max allowed robot speed in m/s */
    entries.add(new Const<Double>("D_ROBOT_SPEED_CAP", 1.0));
  }
}
