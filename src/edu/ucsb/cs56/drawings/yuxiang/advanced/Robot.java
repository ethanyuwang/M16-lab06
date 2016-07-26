package edu.ucsb.cs56.drawings.yuxiang.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a robot that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Yuxiang Wang 
   @version for CS56, W16, UCSB
   
*/
public class Robot extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of house
       @param y y coord of lower left corner of house
       @param width width of the house
       @param height of house (including first story and second story)
    */
    public Robot(double x, double y, double width, double height)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
	double headX = x + width/4.0;
	double headWidth = 0.5 * width;
        
        double bodyHeight = .75 * height;
        double headHeight = height - bodyHeight;
        
        double bodyUpperLeftY = y + headHeight;
        
        // Make the body and head
        
        Rectangle2D.Double body = 
            new Rectangle2D.Double(x, bodyUpperLeftY ,
				   width, bodyHeight);

        Rectangle2D.Double head = 
            new Rectangle2D.Double(headX, y,
				   headWidth, headHeight);
	
        // make the roof.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
        Line2D.Double leftArm = 
            new Line2D.Double (x,               y + 1.1 * headHeight,
                               x - 0.4 * width, y + 1.2 * headHeight);
	
        Line2D.Double rightArm =
            new Line2D.Double (x +       width, y + 1.1 * headHeight,
                               x + 1.4 * width, y + 1.2 * headHeight);

	Line2D.Double leftLeg = 
            new Line2D.Double (x + 0.15 * width, y + height,
                               x - 0.15 * width, y + height + 0.5 * bodyHeight);
	
        Line2D.Double rightLeg =
            new Line2D.Double (x + 0.85 * width, y + height,
                               x + 1.15 * width, y + height + 0.5 * bodyHeight);

	
        // put the whole house together
	
        GeneralPath wholeRobot = this.get();
        wholeRobot.append(body, false);
	wholeRobot.append(head, false);
        wholeRobot.append(leftArm, false);
        wholeRobot.append(rightArm, false);
        wholeRobot.append(leftLeg, false);
        wholeRobot.append(rightLeg, false);    
    }
}
