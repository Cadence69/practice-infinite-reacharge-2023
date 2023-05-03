// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DriveSystem extends SubsystemBase {
  
  private CANSparkMax frontLeft;
  private CANSparkMax frontRight;
  private CANSparkMax backLeft;
  private CANSparkMax backRight;

  private MecanumDrive mecanumDrive;

  /** Creates a new DriveSystem. */
  public DriveSystem() {
     
    frontLeft = new CANSparkMax(0, MotorType.kBrushless);
    frontRight = new CANSparkMax(0, MotorType.kBrushless);
    backLeft = new CANSparkMax(0, MotorType.kBrushless);
    backRight = new CANSparkMax(0, MotorType.kBrushless);

    mecanumDrive = new MecanumDrive(frontLeft, backRight, frontRight, backLeft);

  }

  public CommandBase drivecommand(){

  }

  public void drive () {
    frontLeft.set(.5);
    backLeft.set(.5);
    frontRight.set(.5);
    backRight.set(.5);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
