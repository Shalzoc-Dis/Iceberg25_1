package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.ui.DashboardManager;
import frc.robot.tuning.TunableConstants;

public class UpdatePreferencesCommand extends Command {
  private final DashboardManager m_dashboard;

  public UpdatePreferencesCommand(DashboardManager dashboard) {
    m_dashboard = dashboard;
  }

  @Override
  public void execute() {
    TunableConstants.updateConstants(m_dashboard.robotSpeedCap());
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
