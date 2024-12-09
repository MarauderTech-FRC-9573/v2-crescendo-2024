package frc.robot.commands;

import static frc.robot.Constants.IntakeConstants.*;
import static frc.robot.Constants.ShooterConstants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class Launch extends Command {
    private ShooterSubsystem shooterSubsystem;
    private IntakeSubsystem intakeSubsystem;
    private CANSparkMax topMotor, bottomMotor, intakeMotor;
    private double topSpeed, bottomSpeed, intakeSpeed;

    private RelativeEncoder topEncoder, bottomEncoder;
    
    public Launch(ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem, double topSpeed, double bottomSpeed, double intakeSpeed) {
        this.shooterSubsystem = shooterSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        this.bottomMotor = shooterSubsystem.bottomShooterMotor;
        this.topMotor = shooterSubsystem.topShooterMotor;
        this.intakeMotor = intakeSubsystem.intakeMotor;

        this.topSpeed = topSpeed;
        this.bottomSpeed = bottomSpeed;
        this.intakeSpeed = intakeSpeed;

        this.topEncoder = topMotor.getEncoder();
        this.bottomEncoder = bottomMotor.getEncoder();

    }
    
    @Override 
    public void initialize() {
        topMotor.set(topSpeed);
        bottomMotor.set(bottomSpeed);

    }
    
    @Override
    public void execute() {
        if (topEncoder.getVelocity() > topSpeed*1000 && bottomEncoder.getVelocity() > bottomSpeed*1000) {
            intakeMotor.set(intakeSpeed);
        }
    }
    
    public void shoot() {
        
    }
    
    @Override
    public void end(boolean isInterrupted) {
        shooterSubsystem.stop();
        intakeSubsystem.stop();
    }
}