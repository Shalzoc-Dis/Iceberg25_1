package frc.robot.ui;

import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.tuning.TunableConstants;

public class DashboardManager {

  private final ShuffleboardTab tuningTab;
  // The 'e' prefix just means entry here.
  private NetworkTableEntry eRobotSpeedCap;
  private NetworkTableEntry eSaveButton;

  public DashboardManager() {
    tuningTab = Shuffleboard.getTab("Tuning");

    // Create lists and widgets for the tunable constants.

    // Create a save button widget (a toggle button is a common choice)
    // FIXME Type mismatch
    // eSaveButton = tuningTab.add("Save Preferences", false)
    //                             .withWidget(BuiltInWidgets.kToggleButton)
    //                             .getEntry();
  }


  /** After handling the save, reset the button state. */
  public void resetSaveButton() { eSaveButton.setBoolean(false); }

  /** Update the layout based on the current mode (Auto, Teleop, ...)
   * This can modify widgets and create new tabs.
   */
  public void updateMode(Modes mode) {
    String modeName;

    switch (mode) {
      case  TESTING:
        modeName = "Testing";
        break;
      default:
        modeName = "Testing";
        break;
    }
    tuningTab.getLayout(modeName + " Layout", "BuiltInLayouts.kList");
  }


  public double robotSpeedCap() { return eRobotSpeedCap.getDouble(TunableConstants.robotSpeedCap()); }

  public boolean isSaveRequested() {
    // If the save button is pressed
    return false;
  }

  public enum Modes {
    TESTING, AUTONOMOUS, TELEOP, DISABLED
  }

}
