// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import frc.robot.ui.DashboardManager;
import frc.robot.commands.SavePreferencesCommand;
import frc.robot.tuning.TunableConstants;

public class RobotContainer {

  // Create the dashboard manager UI
  private final DashboardManager m_DashboardManager = new DashboardManager();
  public RobotContainer() {

    // Load robot constants
    TunableConstants.loadFromPreferences();


    configureBindings();

    // Schedule commands
    CommandScheduler.getInstance().schedule(new SavePreferencesCommand(m_DashboardManager));
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

  public void updateShuffleboardMode(DashboardManager.Modes mode) {
    m_DashboardManager.updateMode(mode);
  }
}

