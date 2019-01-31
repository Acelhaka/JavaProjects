
public class LinearEquation 
{
	/** Data fields */
	private double  a,
					b,
					c,
					d,
					e,
					f;
	
	
	
	/** Construct a LinearEquation object */
	LinearEquation()
	{
		
	}
	
	
	
	/** Construct a LinearEquation object */
	LinearEquation(double newA, double newB, double newC, 
				   double newD, double newE, double newF)
	{
		
		a = newA;
		b = newB;
		c = newC;
		d = newD;
		e = newE;
		f = newF;
	}
	
	
	
	/** get method to return the value of a */
	double getA()
	{
		return a;
	}
	
	
	
	/** get method to return the value of b */
	double getB() 
	{
		return b;
	}
	
	
	
	/** get method to return the value of c */
	double getC()
	{
		return c;
	}
	
	
	
	/** get method to return the value of d */
	double getD()
	{
		return d;
	}
	
	
	
	/** get method to return the value of e */
	double getE() 
	{
		return e;
	}
	
	
	
	/** get method to return the value of f */
	double getF() 
	{
		return f;
	}
	
	
	
	/** returns true if equation is Solvable */
	boolean isSolvable() 
	{
		if ((a*d - b*c) != 0)
			return true;
		else
			return false;
	}
	
	
	
	/** get method to return the value of X */
	double getX() 
	{
		return (e*d - b*f) / (a*d - b*c);
	} 
	
	
	
	/** get method to return the value of Y */
	double getY() 
	{
		return (a*f - e*c) / (a*d - b*c);
	}
	
}
