package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import static frc.robot.Constants.ShooterConstants.*;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class ShooterSubsystem extends SubsystemBase {
  public final CANSparkMax bottomShooterMotor;
  public final CANSparkMax topShooterMotor;
  public final DigitalInput beamBreaker = new DigitalInput(0); // arbitrary channel value chnage to actual value
  
  public ShooterSubsystem() { 
    bottomShooterMotor = new CANSparkMax(7, MotorType.kBrushless);
    topShooterMotor = new CANSparkMax(8, MotorType.kBrushless);
    bottomShooterMotor.setSmartCurrentLimit(kShooterCurrentLimit);
    topShooterMotor.setSmartCurrentLimit(kShooterCurrentLimit);
  }
  
  public void stop() {
    bottomShooterMotor.set(0);
    topShooterMotor.set(0);
  }
  
  public void noteinPlace(CommandXboxController xboxController1, CommandXboxController xboxController2) {
    System.out.println("hi!");
    GenericHID controller1 = xboxController1.getHID();
    GenericHID controller2 = xboxController2.getHID();
    if (!beamBreaker.get()) {
      System.out.println("Note detected...");
      controller1.setRumble(RumbleType.kLeftRumble, 1.0);
      controller2.setRumble(RumbleType.kRightRumble, 1.0);
    } else {
      System.out.println("No note detected...");
      controller1.setRumble(RumbleType.kLeftRumble, 0);
      controller2.setRumble(RumbleType.kRightRumble, 0);
    }
    
  }
}