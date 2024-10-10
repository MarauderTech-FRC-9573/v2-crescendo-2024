package frc.robot.commands;

import javax.swing.plaf.synth.SynthToolTipUI;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.ShooterSubsystem;

public class NoteInPlace extends Command {
    ShooterSubsystem shooterSubsystem;
    CommandXboxController xboxController;
    XboxController controller;

    public NoteInPlace(ShooterSubsystem shooterSubsystem, CommandXboxController xboxController) {
        this.shooterSubsystem = shooterSubsystem;
        this.xboxController = xboxController;
        this.controller = xboxController.getHID();
        
    }

    public void periodic() {
        if (shooterSubsystem.beamBreaker.get()) {
            System.out.println("Note detected...");
            controller.setRumble(RumbleType.kLeftRumble, 1.0);
            controller.setRumble(RumbleType.kRightRumble, 1.0);
        } else {
            System.out.println("No note detected...");
            controller.setRumble(RumbleType.kLeftRumble, 0);
            controller.setRumble(RumbleType.kRightRumble, 0);
        }

    }
}
