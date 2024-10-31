// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

  private VictorSPX driveLeft1 = new VictorSPX(1);
  private VictorSPX driveLeft2 = new VictorSPX(2);
  private VictorSPX driveRight1 = new VictorSPX(3);
  private VictorSPX driveRight2 = new VictorSPX(4);

  public void driveControl(double leftSpeed, double rightSpeed){
    driveLeft1.set(ControlMode.PercentOutput, leftSpeed);
    driveLeft2.set(ControlMode.PercentOutput, leftSpeed);
    driveRight1.set(ControlMode.PercentOutput, rightSpeed);
    driveRight2.set(ControlMode.PercentOutput, rightSpeed);

  }

  public Joystick newJoysStick = new Joystick(0);

  @Override
  public void robotInit() {
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    double x_ampl = newJoysStick.getRawAxis(1);
    double y_ampl = newJoysStick.getRawAxis(0);

    if (y_ampl > 0){
      driveControl(0.5,-0.5);
    }
    else if (y_ampl < 0){
      driveControl(-0.5, 0.5);
    }

    if (x_ampl > 1){
      driveControl(-0.5, -0.5);
    }
    else if (x_ampl < 0){
      driveControl(0.5, 0.5);
    }
    //y-axis is fwd & back, 1 is fwd, -1 is bwd
    //x-axis is sides
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
