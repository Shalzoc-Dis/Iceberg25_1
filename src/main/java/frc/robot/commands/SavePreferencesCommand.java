package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.ui.DashboardManager;
import frc.robot.tuning.TunableConstants;

public class SavePreferencesCommand extends Command {
  private final DashboardManager m_dashbaord;

  public SavePreferencesCommand(DashboardManager dashboard) {
    m_dashbaord = dashboard;
  }

  @Override
  public void execute() {
    // Check if the save button was pressed
    if (m_dashbaord.isSaveRequested()) {
      TunableConstants.saveToPreferences();
      m_dashbaord.resetSaveButton();
      System.out.println("Preferences have been saved.");
    }
  }

  @Override
  public boolean isFinished() { 
    return false;
  }

}
