package edu.ucsb.cs56.drawings.yuxiang.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Line2D;

/**
   A robot with antennas
      
   @author Yuxiang Wang 
   @version for CS56, M16, UCSB
   
*/
public class RobotWithAntenna extends Robot implements Shape
{
    /**
     * Constructor for objects of class RobotWithAntenna
     */
    public RobotWithAntenna(double x, double y, double width, double height)
    {
	// construct the basic robot shell
	super(x,y,width,height);
	
	double headX = x + width/4.0;
	double headWidth = 0.5 * width;
        double headHeight = 0.25 * height;

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	Line2D.Double leftAntenna = 
            new Line2D.Double (headX + 0.1 * headWidth, y,
                               headX - 0.1 * headWidth, y - 0.8 * headHeight);
	
        Line2D.Double rightAntena =
            new Line2D.Double (headX + 0.9 * headWidth, y,
                               headX + 1.1 * headWidth, y - 0.8 * headHeight);
	
	// add the antennas to the robot
	
        GeneralPath wholeRobot = this.get();
        wholeRobot.append(leftAntenna, false);
        wholeRobot.append(rightAntena, false);
    }    
}
