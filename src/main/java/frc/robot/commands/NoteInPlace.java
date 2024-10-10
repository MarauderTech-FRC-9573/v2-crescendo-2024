package frc.robot.commands;

import javax.swing.plaf.synth.SynthToolTipUI;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.ShooterSubsystem;

public class NoteInPlace extends Command {
    ShooterSubsystem shooterSubsystem;
    DigitalInput beamBreaker;
    CommandXboxController xboxController;
    XboxController controller;

    public NoteInPlace(ShooterSubsystem shooterSubsystem, CommandXboxController xboxController) {
        this.shooterSubsystem = shooterSubsystem;
        this.beamBreaker = shooterSubsystem.beamBreaker;
        this.xboxController = xboxController;
        this.controller = xboxController.getHID();
        
    }

    public void periodic() {

    }
}
