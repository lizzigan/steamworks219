package org.usfirst.frc.team219.robot.subsystems;

import org.usfirst.frc.team219.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX; import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Augur extends Subsystem 
{

	
	private TalonSRX conveyorTalon;
	
	public Augur()
	{
		conveyorTalon = new TalonSRX(RobotMap.AUGURMOTOR_PORT);
		
	}

	/**
	 * Sets the augur to move the balls in the direction of the shooter
	 */
	public void forward()
	{
		conveyorTalon.set(ControlMode.PercentOutput,.80);
	}
	
	
	/**
	 * Sets the augur to move in reverse direction. Meant to deal with blockages. 
	 */
	public void reverse()
	{
		conveyorTalon.set(ControlMode.PercentOutput,-.80);
	}
	
	/**
	 * Stops the augur by setting the motor speed to 0.
	 */
	public void stop()
	{
		conveyorTalon.set(ControlMode.PercentOutput,0);
	}
	public void initDefaultCommand() 
	{
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
}

