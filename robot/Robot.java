// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
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

  private VictorSPX right1, right2, left1, left2;
  private Joystick stick;
  private UsbCamera camera;

  @Override
  public void robotInit() 
  {
    right1 = new VictorSPX(3);
    right2 = new VictorSPX(4);
    left1 = new VictorSPX(1);
    left2 = new VictorSPX(2);

    stick = new Joystick(0);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() 
  {
    camera = CameraServer.startAutomaticCapture();
  }

  @Override
  public void teleopPeriodic() 
  {
    double x_val = stick.getRawAxis(1);
    double y_val = stick.getRawAxis(0);

    double speed_right = (x_val+y_val);
    double speed_left = (x_val+y_val);

    if(speed_left>1||speed_left<-1)
      speed_left = (int)speed_left;

    if(speed_right>1||speed_right<-1)
      speed_right = (int)speed_right;

    right1.set(ControlMode.PercentOutput, -speed_right);
    right2.set(ControlMode.PercentOutput, -speed_right);
    left1.set(ControlMode.PercentOutput, speed_left);
    left2.set(ControlMode.PercentOutput, speed_left);
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
