package com.ruegnerlukas.simpleutils.color;

import java.awt.Color;

import com.ruegnerlukas.simplemath.vectors.IVector;
import com.ruegnerlukas.simplemath.vectors.vec3.IVector3;
import com.ruegnerlukas.simplemath.vectors.vec4.IVector4;

public interface IColor {

	
	/**
	 * @return the red-component as a float (0-1)
	 * */
	public float getFloatR();
	
	
	/**
	 * @return the green-component as a float (0-1)
	 * */
	public float getFloatG();
	
	
	/**
	 * @return the blue-component as a float (0-1)
	 * */
	public float getFloatB();
	
	
	/**
	 * @return the alpha-component as a float (0-1)
	 * */
	public float getFloatA();

	
	/**
	 * @return the red-component as a int (0-255)
	 * */
	public int getIntR();
	
	
	/**
	 * @return the green-component as a int (0-255)
	 * */
	public int getIntG();
	
	
	/**
	 * @return the blue-component as a int (0-255)
	 * */
	public int getIntB();
	
	
	/**
	 * @return the alpha-component as a int (0-255)
	 * */
	public int getIntA();
	
	
	
	
	/**
	 * sets the values of this color to the same values as the other color
	 * @param other 	the other color
	 * @return this color for chaining
	 * */
	public IColor set(IColor other);
	
	
	
	
	/**
	 * sets the values of this color to the same values as the other color as a vector
	 * @param other 	the other color as a vector
	 * @return this color for chaining
	 * */
	public IColor set(IVector other);
	
	
	
	
	
	/**
	 * sets the values of this color
	 * @param r	the red component (0-1)
	 * @param g	the green component (0-1)
	 * @param b	the blue component (0-1)
	 * @param a	the alpha component (0-1)
	 * @return this color for chaining
	 * */
	public IColor set(float r, float g, float b, float a);
	
	
	
	
	/**
	 * sets the values of this color
	 * @param r	the red component  (0-255)
	 * @param g	the green component  (0-255)
	 * @param b	the blue component  (0-255)
	 * @param a	the alpha component  (0-255)
	 * @return this color for chaining  (0-255)
	 * */
	public IColor set(int r, int g, int b, int a);
	
	
	
	
	/**
	 * adds the values of another color to this color
	 * @param other the other color
	 * @return this color for chaining
	 * */
	public IColor add(IColor other);
	
	
	
	
	/**
	 * adds the values of another color to this color as a vector
	 * @param other the other color as a vector
	 * @return this color for chaining
	 * */
	public IColor add(IVector other);
	
	
	
	
	/**
	 * adds the given values to this color
	 * @param r	the red component (0-1)
	 * @param g	the green component (0-1)
	 * @param b	the blue component (0-1)
	 * @param a	the alpha component (0-1)
	 * @return this color for chaining
	 * */
	public IColor add(float r, float g, float b , float a);
	
	
	
	
	/**
	 * adds the given values to this color
	 * @param r	the red component (0-255)
	 * @param g	the green component (0-255)
	 * @param b	the blue component (0-255)
	 * @param a	the alpha component (0-255)
	 * @return this color for chaining
	 * */
	public IColor add(int r, int g, int b , int a);
	
	
	
	
	/**
	 * subtracts the values of another color from this color
	 * @param other the other color
	 * @return this color for chaining
	 * */
	public IColor sub(IColor other);
	
	
	
	
	/**
	 * subtracts the values of another color from this color as a vector
	 * @param other the other color as a vector
	 * @return this color for chaining
	 * */
	public IColor sub(IVector other);
	
	
	
	
	/**
	 * subtracts the given values from this color
	 * @param r	the red component (0-1)
	 * @param g	the green component (0-1)
	 * @param b	the blue component (0-1)
	 * @param a	the alpha component (0-1)
	 * @return this color for chaining
	 * */
	public IColor sub(float r, float g, float b , float a);
	
	
	
	
	/**
	 * subtracts the given values from this color
	 * @param r	the red component (0-255)
	 * @param g	the green component (0-255)
	 * @param b	the blue component (0-255)
	 * @param a	the alpha component (0-255)
	 * @return this color for chaining
	 * */
	public IColor sub(int r, int g, int b , int a);
	
	
	
	
	/**
	 * multiplies the values of this color by the values of another color
	 * @param other the other color
	 * @return this color for chaining
	 * */
	public IColor mul(IColor other);
	
	
	
	
	/**
	 * multiplies the values of this color by the values of another color
	 * @param other the other color as a vector
	 * @return this color for chaining
	 * */
	public IColor mul(IVector other);
	
	
	
	
	/**
	 * multiplies the values of this color by the given values
	 * @param r	the red component (0-1)
	 * @param g	the green component (0-1)
	 * @param b	the blue component (0-1)
	 * @param a	the alpha component (0-1)
	 * @return this color for chaining
	 * */
	public IColor mul(float r, float g, float b , float a);
	
	
	
	
	/**
	 * multiplies the values of this color by the given values
	 * @param r	the red component (0-255)
	 * @param g	the green component (0-255)
	 * @param b	the blue component (0-255)
	 * @param a	the alpha component (0-255)
	 * @return this color for chaining
	 * */
	public IColor mul(int r, int g, int b , int a);
	
	
	
	
	/**
	 * divides the values of this color by the values of another color
	 * @param other the other color
	 * @return this color for chaining
	 * */
	public IColor div(IColor other);
	
	
	
	
	/**
	 * divides the values of this color by the values of another color
	 * @param other the other color as a vector
	 * @return this color for chaining
	 * */
	public IColor div(IVector other);
	
	
	
	
	/**
	 * divides the values of this color by the given values
	 * @param r	the red component (0-1)
	 * @param g	the green component (0-1)
	 * @param b	the blue component (0-1)
	 * @param a	the alpha component (0-1)
	 * @return this color for chaining
	 * */
	public IColor div(float r, float g, float b , float a);
	
	
	
	
	/**
	 * divides the values of this color by the given values
	 * @param r	the red component (0-255)
	 * @param g	the green component (0-255)
	 * @param b	the blue component (0-255)
	 * @param a	the alpha component (0-255)
	 * @return this color for chaining
	 * */
	public IColor div(int r, int g, int b , int a);

	

	
	/**
	 * clamps the values of this color to the range 0 to 1
	 * @return this color for chaining
	 * */
	public IColor clamp();
	
	
	
	
	/**
	 * interpolates (linear) between this color and another color
	 * @param other the other color
	 * @return this color for chaining
	 * */
	public IColor lerp(IColor other, float t);
	
	
	
	
	/**
	 * interpolates (linear) between this color and the given values
	 * @param r	the red component
	 * @param g	the green component
	 * @param b	the blue component
	 * @param a	the alpha component
	 * @return this color for chaining
	 * */
	public IColor lerp(float r, float g, float b, float a, float t);

	
	
	
	/**
	 * interpolates (linear) between this color and the given values
	 * @param r	the red component
	 * @param g	the green component
	 * @param b	the blue component
	 * @param a	the alpha component
	 * @return this color for chaining
	 * */
	public IColor lerp(int r, int g, int b, int a, float t);
	
	
	
	
	/**
	 * multiplies the rgb values by the alpha value
	 * @return this color for chaining
	 * */
	public IColor multiplyAlpha();
	
	
	
	
	/**
	 * converts this color to a single integer value
	 * @return the int value
	 * */
	public int toIntBits();
	
	
	
	
	/**
	 * converts this color to a vector3 and drops the alpha component in the process.
	 * @return a vector3
	 * */
	public IVector3 toVector3();
	
	
	
	
	/**
	 * converts this color to a vector4.
	 * @return a vector4
	 * */
	public IVector4 toVector4();
	
	
	
	
	/**
	 * converts this color to a {@link java.awt.Color}
	 * @return a {@link java.awt.Color}
	 * */
	public Color toAWTColor();
	
	
	
	
	/**
	 * @return a copy of this color
	 * */
	public IColor copy();
	
}
