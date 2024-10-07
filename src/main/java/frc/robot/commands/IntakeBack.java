package frc.robot.commands;

import static frc.robot.Constants.IntakeConstants.*;

import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class IntakeBack extends Command {
    private IntakeSubsystem intakeSubsystem; 

    public IntakeBack(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
    }

    @Override
    public void initialize() {
        intakeSubsystem.intakeMotor.set(launchSpeed);
    }

    @Override
    public void execute() {}

    @Override 
    public void end(boolean isInterrupted) {
        intakeSubsystem.stop();
    }

}