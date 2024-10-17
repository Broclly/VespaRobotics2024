// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;




public class Robot extends TimedRobot {
  
  private VictorSPX driveLeft1 = new VictorSPX(1);
  private VictorSPX driveRight1 = new VictorSPX(3);
  private VictorSPX driveLeft2 = new VictorSPX(2);
  private VictorSPX driveRight2 = new VictorSPX(4);
  private Joystick joystick = new Joystick(0);


  // Speed variables
  double stopSpeed = 0.0;
  double spinSpeed = 0.5; // Adjust this value for spin speed
  double fastSpeed = 1.0; // Max forward speed


  @Override
  public void robotInit() {
   
  }
  
  @Override
  public void robotPeriodic() {

  }

  @Override
  public void autonomousInit() {
    stop();
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    UsbCamera camera = CameraServer.startAutomaticCapture();
  }

  @Override
  public void teleopPeriodic() {

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

  public void stop() {
   
  }
}