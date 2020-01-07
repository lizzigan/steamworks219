package org.usfirst.frc.team219.robot.subsystems;

import org.usfirst.frc.team219.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX; import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Agitator extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public TalonSRX mixer;
	
	public Agitator()
	{
		mixer = new TalonSRX(RobotMap.Mixer);
		mixer.getSensorCollection().setQuadraturePosition(0, 10);
		
	}
	
	public void mixerGo()
	{
		mixer.set(ControlMode.PercentOutput,.6);
	}
	
	public void chooseDirection()
	{
		if(mixer.getSensorCollection().getQuadraturePosition()/4096.0 > .01)
		{
			
			mixerReverse();
		}
		else if(mixer.getSensorCollection().getQuadraturePosition()/4096.0 < -.01)
		{
		
			mixerGo();
		}
	}
	
	public void mixerStop()
	{
		mixer.set(ControlMode.PercentOutput,0);
	}
	
	public void mixerReverse()
	{
		mixer.set(ControlMode.PercentOutput,-.6);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
}

