package org.usfirst.frc.team219.robot.subsystems;

import org.usfirst.frc.team219.robot.RobotMap;
import org.usfirst.frc.team219.robot.commands.ToggleCollector;

import com.ctre.phoenix.motorcontrol.can.TalonSRX; import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The harvester subsystem of Team 219's 2017 robot.
 */
public class Harvester extends Subsystem {

	public TalonSRX collectorMotor;

	public Harvester()
	{
		collectorMotor = new TalonSRX(RobotMap.COLLECTORMOTOR_PORT);
	}
	public void initDefaultCommand() {
	}

	/**
	 * Turns on the collector motor at a speed of 1.
	 * @param collectSpeed The speed that is sent the collector motor
	 */
	public void startRoller(double collectSpeed) 
	{
		collectorMotor.set(ControlMode.PercentOutput,-collectSpeed);		
	}
	
	public void startRollerReverse(double collectSpeed) 
	{
		collectorMotor.set(ControlMode.PercentOutput,collectSpeed);	
	}
	
	/**
	 * Turns off the collector motor by setting the speed to 0.
	 */
	public void stopRoller()
	{
		collectorMotor.set(ControlMode.PercentOutput,0);
	}

}

