// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.DriveConstants.*;


public class DriveSystem extends SubsystemBase {
  
  private CANSparkMax frontLeft;
  private CANSparkMax frontRight;
  private CANSparkMax backLeft;
  private CANSparkMax backRight;

  private MecanumDrive mecanumDrive;

  /** Creates a new DriveSystem. */
  public DriveSystem() {
     
    frontLeft = new CANSparkMax(FRONTLEFT, MotorType.kBrushless);
    frontRight = new CANSparkMax(FRONTRIGHT, MotorType.kBrushless);
    backLeft = new CANSparkMax(BACKLEFT, MotorType.kBrushless);
    backRight = new CANSparkMax(BACKRIGHT, MotorType.kBrushless);

    mecanumDrive = new MecanumDrive(frontLeft, backRight, frontRight, backLeft);

  }

  public CommandBase driveWithJoystick(Joystick joy){
    return runEnd(

    () -> {
      double ySpeed = MathUtil.applyDeadband(joy.getY(), 0.15);
      double xSpeed = MathUtil.applyDeadband(joy.getX(), 0.15);
      double rotation = MathUtil.applyDeadband(joy.getZ(), 0.15);

      mecanumDrive.driveCartesian(ySpeed, xSpeed, rotation);
    },

    () -> {
      mecanumDrive.driveCartesian(0, 0, 0);
      }
    );
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
