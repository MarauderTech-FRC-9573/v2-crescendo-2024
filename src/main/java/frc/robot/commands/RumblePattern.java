package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class RumblePattern extends Command implements Runnable {
    static GenericHID controller1;
    static GenericHID controller2; 

    public RumblePattern(GenericHID controller1, GenericHID controller2)  {
        this.controller1 = controller1;
        this.controller2 = controller2;
    }

    @Override
    public void execute() {
        controller1.setRumble(RumbleType.kBothRumble, 0.5);
        controller2.setRumble(RumbleType.kBothRumble, 0.5);
        new WaitCommand(0.5);
        controller1.setRumble(RumbleType.kBothRumble, 0);
        controller2.setRumble(RumbleType.kBothRumble, 0);      
        new WaitCommand(0.5);
    }

    @Override
    public void run() {
        execute();
    }
    
}
