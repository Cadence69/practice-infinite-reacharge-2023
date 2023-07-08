// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSystem;

public class RotateToAngle extends CommandBase {
  /** Creates a new RotateToAngle. */

  //ToDo:  Create a drive system instance variable (don't instantiate)

  private DriveSystem driveSystem;
  private double angle;
  private double gyro;

  private final double error = 2.5;
  private final double turnSpeed = 0.6;
  private boolean isDone = false;

  public RotateToAngle(DriveSystem ds, double ang) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveSystem = ds;
    this.angle = ang;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    gyro = driveSystem.getGyro();

    if (gyro >= (angle - error) && gyro <= (angle + error)) {
      driveSystem.drive(0.0, 0.0, 0.0);
      isDone = true;
    }
    else if (gyro > angle) {
      driveSystem.drive(0.0, 0.0, -turnSpeed);
    }
    else {
      driveSystem.drive(0.0, 0.0, turnSpeed);
    }


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveSystem.drive(0.0, 0.0, 0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (isDone)
    return true;
   else
    return false;
  
}
}