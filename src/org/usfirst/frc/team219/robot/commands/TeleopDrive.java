
package org.usfirst.frc.team219.robot.commands;

import org.usfirst.frc.team219.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This command allows the operator to control the robot rather than an autonomous command.
 */
public class TeleopDrive extends Command 
{
	double leftSpeed, rightSpeed;
	boolean inverted;
	double throttle;
	double turn;
	public TeleopDrive()
	{
		requires(Robot.drivetrain);
	}
	

	// Called just before this Command runs the first time
	protected void initialize() {
		inverted = false;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		
		if(Robot.oi.mainDriver.getPOV() == 0 ||  Robot.oi.mainDriver.getPOV() == 45|| Robot.oi.mainDriver.getPOV() == 315)
		{
			inverted = true;
			Robot.drivetrain.setInvertedStatis(true);
		}
		if(Robot.oi.mainDriver.getPOV() == 180 ||  Robot.oi.mainDriver.getPOV() == 225|| Robot.oi.mainDriver.getPOV() == 135)
		{
			inverted = false;
			Robot.drivetrain.setInvertedStatis(false);
		}
//		throttle=Robot.oi.getLeftSpeed();  
//		turn=Robot.oi.getRightSpeed();
//		leftSpeed=throttle-turn;
//		rightSpeed=throttle+turn;    
		leftSpeed = Robot.oi.getLeftSpeed();
		rightSpeed = Robot.oi.getRightSpeed();
		if(leftSpeed==1.0)
		{
			leftSpeed=.7;
		}
		if(rightSpeed==1.0)
		{
			rightSpeed=.7;
		}
		if(inverted)
		{
			Robot.drivetrain.tankDrive(leftSpeed,rightSpeed);
		}
		else
		{
			Robot.drivetrain.tankDrive(rightSpeed, leftSpeed);
		}
//		if(inverted)
//		{
//			Robot.drivetrain.tankDrive(rightSpeed,rightSpeed);
//		}
//		else
//		{
//			Robot.drivetrain.tankDrive(rightSpeed - leftSpeed, rightSpeed + leftSpeed);
//		}
	
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end() 
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
