import hsa.Console;
import java.awt.*;

abstract class SuitClass extends ShapeClass

{
    boolean isFilled = true;

    protected void setFilled (boolean n)
    {
	isFilled = n;
    }


    protected boolean isPointInside (int x, int y)

    {

	if (x < cx + width && x > cx && y > cy && y < cy + height)
	{

	    return true;

	}

	return false;
    }


    protected void setWidth (int iNewWidth)
    {
	width = iNewWidth;
	height = iNewWidth * 4 / 3;
    }


    protected void setHeight (int iNewHeight)
    {
	height = iNewHeight;
	width = iNewHeight / 4 * 3;
    }
}
