package frc.robot;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.commands.Intake;
import frc.robot.commands.IntakeBack;
import frc.robot.commands.Eject;
import frc.robot.commands.ForceIntake;
import frc.robot.Constants.DriveConstants;
import frc.robot.commands.LaunchAmp;
import frc.robot.commands.LaunchSpeaker;
import frc.robot.commands.Spoonfeeding;

import static frc.robot.Constants.DriveConstants.precisionSpeed;
import static frc.robot.Constants.DriveConstants.turboSpeed;
import static frc.robot.Constants.DriveConstants.defaultSpeed;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class RobotContainer {
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  //private final VisionSubsystem  visionSubsystem = new VisionSubsystem();
  private final CommandXboxController operatorController = new CommandXboxController(DriveConstants.operatorControllerPort);
  private final CommandXboxController driverController = new CommandXboxController(DriveConstants.driverControllerPort);
  
  //private final PowerDistribution pdh = new PowerDistribution(1, ModuleType.kRev);
  
  private final SendableChooser<Command> m_autoChooser = new SendableChooser<Command>();
  
  
  public RobotContainer() {
    initalizeAutoChooser();
    //pdh.setSwitchableChannel(true);
    configureButtonBindings();
    driveSubsystem.setDefaultCommand(new RunCommand(() -> driveSubsystem.driveArcade(-driverController.getLeftY(), driverController.getRightX()), driveSubsystem));
    intakeSubsystem.setDefaultCommand(new RunCommand(() -> intakeSubsystem.noteinPlace(driverController, operatorController), intakeSubsystem));
    SmartDashboard.putData("Autos: ", m_autoChooser);
    
  }
  
  private void configureButtonBindings() {
    operatorController.rightTrigger().whileTrue(new LaunchSpeaker(shooterSubsystem, intakeSubsystem));
    operatorController.leftTrigger().whileTrue(new IntakeBack(intakeSubsystem).withTimeout(0.5).andThen(new LaunchAmp(shooterSubsystem, intakeSubsystem)));
    operatorController.rightBumper().whileTrue(new IntakeBack(intakeSubsystem).withTimeout(0.5).andThen(new Spoonfeeding(shooterSubsystem, intakeSubsystem)));
    operatorController.x().whileTrue(new Intake(intakeSubsystem));
    operatorController.y().whileTrue(new Eject(intakeSubsystem, shooterSubsystem));   
    operatorController.leftBumper().whileTrue(new ForceIntake(intakeSubsystem));
    // Set up a binding to run the intake command while the operator is pressing and holding the x button
    
    driverController.leftBumper()
    .whileTrue(new InstantCommand(() -> driveSubsystem.setMaxOutput(turboSpeed)))
    .whileFalse(new InstantCommand(() -> driveSubsystem.setMaxOutput(defaultSpeed)));
    
    driverController.rightBumper()
    .whileTrue(new InstantCommand(() -> driveSubsystem.setMaxOutput(precisionSpeed)))
    .whileFalse(new InstantCommand(() -> driveSubsystem.setMaxOutput(defaultSpeed)));
    
  }
  
  public void initalizeAutoChooser() {
    
    m_autoChooser.addOption("TAXI: ", 
    new WaitCommand(0.1)
    .andThen(new RunCommand(() -> driveSubsystem.driveArcade(0.5, 0), driveSubsystem))
    .withTimeout(1)
    .andThen(new RunCommand(() -> driveSubsystem.driveArcade(0, 0), driveSubsystem)));
    
    m_autoChooser.setDefaultOption("SPEAKER, TAXI: ", 
    new WaitCommand(0.1)
    .andThen(new IntakeBack(intakeSubsystem))
    .withTimeout(0.5)
    .andThen(new LaunchSpeaker(shooterSubsystem, intakeSubsystem))
    .withTimeout(2)
    .andThen(new RunCommand(() -> driveSubsystem.driveArcade(-0.8, 0), driveSubsystem))
    .withTimeout(3)
    .andThen(new RunCommand(() -> driveSubsystem.driveArcade(0, 0), driveSubsystem))
    );
    
   /* m_autoChooser.addOption("2 NOTE:", 
    new WaitCommand(0.1)
    .andThen(new IntakeBack(intakeSubsystem))
    .withTimeout(0.5)
    .andThen(new LaunchSpeaker(shooterSubsystem, intakeSubsystem))
    .withTimeout(2)
    .andThen(new RunCommand(() -> driveSubsystem.driveArcade(-0.4, 0), driveSubsystem))
    .withTimeout(3)
    .andThen(new RunCommand(() -> driveSubsystem.driveArcade(0, 0), driveSubsystem))
    .withTimeout(0.1)
    .andThen(new Intake(intakeSubsystem))
    .withTimeout(1)
    .andThen(new RunCommand(() -> driveSubsystem.driveArcade(0.5, 0), driveSubsystem))
    .withTimeout(2)
    .andThen(new RunCommand(() -> driveSubsystem.driveArcade(0, 0), driveSubsystem))
    .withTimeout(0.1)
    .andThen(new LaunchSpeaker(shooterSubsystem, intakeSubsystem))
    .withTimeout(2)
    ); */

    m_autoChooser.addOption("2 NOTE: ", 
    new WaitCommand(0.1)
      .andThen(new IntakeBack(intakeSubsystem))
      .withTimeout(0.5)
      .andThen(new LaunchSpeaker(shooterSubsystem, intakeSubsystem))
      .withTimeout(2)
      .andThen(new RunCommand(() -> driveSubsystem.driveArcade(-0.4, 0), driveSubsystem))
      .withTimeout(1)
      // .andThen(new RunCommand(() -> driveSubsystem.driveArcade(0, 0), driveSubsystem))
      // .andThen(new RunCommand(() -> intakeSubsystem.turnON(), intakeSubsystem))
      // .withTimeout(2)
      // .andThen(new RunCommand(() -> driveSubsystem.driveArcade(0.4, 0), driveSubsystem))
      // .withTimeout(3)
      // .andThen(new RunCommand(() -> driveSubsystem.driveArcade(0, 0), driveSubsystem))
      // .andThen(new LaunchSpeaker(shooterSubsystem, intakeSubsystem))
      // .withTimeout(2)
    );

  } 
    
  public Command getAutonomousCommand() {
    return m_autoChooser.getSelected();
    
  }
}