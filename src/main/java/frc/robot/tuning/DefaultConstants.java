package frc.robot.tuning;

import frc.robot.tuning.Const;




/**
 * This contains lots of default constants that are defined in the program and not in Shuffleboard. 
 * Const objects marked as final are not tunable.
 * The prefix 'D' before the key indicates that it is a default constant.
 */
public class DefaultConstants {

  /** Robot wheel diameter in inches */
  public static final Const<Integer> D_WHEEL_DIAMETER =  new Const<>("D_WHEEL_DIAMETER", 4);
  /** Max allowed robot speed in m/s */
  public static final Const<Double> D_ROBOT_SPEED_CAP = new Const<>("D_ROBOT_SPEED_CAP", 1.0);

}
