package com.ruegnerlukas.simpleutils.color;

import java.awt.Color;

import com.ruegnerlukas.simplemath.vectors.IVector;
import com.ruegnerlukas.simplemath.vectors.IVector.VectorType;
import com.ruegnerlukas.simplemath.vectors.vec3.Vector3f;
import com.ruegnerlukas.simplemath.vectors.vec4.Vector4f;

public class Colorf implements IColor {

	
	public float r;
	public float g;
	public float b;
	public float a;
	
	
	
	
	
	
	/**
	 * @param r	the red component (0-1)
	 * @param g	the green component (0-1)
	 * @param b	the blue component (0-1)
	 * @param a	the alpha component (0-1)
	 * */
	public Colorf(float r, float g, float b, float a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	
	/**
	 * @param r	the red component (0-255)
	 * @param g	the green component (0-255)
	 * @param b	the blue component (0-255)
	 * @param a	the alpha component (0-255)
	 * */
	public Colorf(int r, int g, int b, int a) {
		this.r = (float)r / 255f;
		this.g = (float)g / 255f;
		this.b = (float)b / 255f;
		this.a = (float)a / 255f;
	}
	
	
	/**
	 * @param vec 	the color values stored in the vector
	 * */
	public Colorf(IVector vec) {
		if(vec.getDimensions() == 3) {
			if(vec.getVectorType() == VectorType.FLOAT || vec.getVectorType() == VectorType.DOUBLE) {
				this.r = vec.getFloat(0);
				this.g = vec.getFloat(1);
				this.b = vec.getFloat(2);
				this.a = 1f;
			} else {
				this.r = vec.getFloat(0) / 255f;
				this.g = vec.getFloat(1) / 255f;
				this.b = vec.getFloat(2) / 255f;
				this.a = 1f;
			}
		} else if(vec.getDimensions() == 4) {
			if(vec.getVectorType() == VectorType.FLOAT || vec.getVectorType() == VectorType.DOUBLE) {
				this.r = vec.getFloat(0);
				this.g = vec.getFloat(1);
				this.b = vec.getFloat(2);
				this.a = vec.getFloat(3);
			} else {
				this.r = vec.getFloat(0) / 255f;
				this.g = vec.getFloat(1) / 255f;
				this.b = vec.getFloat(2) / 255f;
				this.a = vec.getFloat(3) / 255f;
			}
		} else {
			throw new IllegalArgumentException("Vector must have 3 or 4 dimensions.");
		}
	}
	
	
	
	
	
	
	public float getFloatR() {
		return this.r;
	}
	
	
	
	
	public float getFloatG() {
		return this.g;
	}
	
	
	
	
	public float getFloatB() {
		return this.b;
	}
	
	
	
	
	public float getFloatA() {
		return this.a;
	}

	
	
	
	public int getIntR() {
		return (int)(this.r*255f);
	}
	
	
	
	
	public int getIntG() {
		return (int)(this.g*255f);
	}
	
	
	
	
	public int getIntB() {
		return (int)(this.b*255f);
	}
	
	
	
	
	public int getIntA() {
		return (int)(this.a*255f);
	}
	
	
	
	
	public Colorf set(IColor other) {
		return set(other.getFloatR(), other.getFloatG(), other.getFloatB(), other.getFloatA());
	}
	
	
	
	
	public Colorf set(IVector vec) {
		if(vec.getDimensions() == 3) {
			if(vec.getVectorType() == VectorType.FLOAT || vec.getVectorType() == VectorType.DOUBLE) {
				this.set(vec.getFloat(0), vec.getFloat(1), vec.getFloat(2), 1f);
			} else {
				this.set(vec.getFloat(0)/255f, vec.getFloat(1)/255f, vec.getFloat(2)/255f, 1f);
			}
		} else if(vec.getDimensions() == 4) {
			if(vec.getVectorType() == VectorType.FLOAT || vec.getVectorType() == VectorType.DOUBLE) {
				this.set(vec.getFloat(0), vec.getFloat(1), vec.getFloat(2), vec.getFloat(3));
			} else {
				this.set(vec.getFloat(0)/255f, vec.getFloat(1)/255f, vec.getFloat(2)/255f, vec.getFloat(3)/255f);
			}
		} else {
			throw new IllegalArgumentException("Vector must have 3 or 4 dimensions.");
		}
		return this;
	}
	
	
	
	
	public Colorf set(float r, float g, float b, float a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
		return this;
	}
	
	
	
	
	public Colorf set(int r, int g, int b, int a) {
		this.r = (float)r / 255f;
		this.g = (float)g / 255f;
		this.b = (float)b / 255f;
		this.a = (float)a / 255f;
		return this;
	}
	
	
	
	
	public Colorf add(IColor other) {
		return add(other.getFloatR(), other.getFloatG(), other.getFloatB(), other.getFloatA());
	}
	
	
	
	
	public Colorf add(IVector vec) {
		if(vec.getDimensions() == 3) {
			if(vec.getVectorType() == VectorType.FLOAT || vec.getVectorType() == VectorType.DOUBLE) {
				this.add(vec.getFloat(0), vec.getFloat(1), vec.getFloat(2), 1f);
			} else {
				this.add(vec.getFloat(0)/255f, vec.getFloat(1)/255f, vec.getFloat(2)/255f, 1f);
			}
		} else if(vec.getDimensions() == 4) {
			if(vec.getVectorType() == VectorType.FLOAT || vec.getVectorType() == VectorType.DOUBLE) {
				this.add(vec.getFloat(0), vec.getFloat(1), vec.getFloat(2), vec.getFloat(3));
			} else {
				this.add(vec.getFloat(0)/255f, vec.getFloat(1)/255f, vec.getFloat(2)/255f, vec.getFloat(3)/255f);
			}
		} else {
			throw new IllegalArgumentException("Vector must have 3 or 4 dimensions.");
		}
		return this;
	}
	
	
	
	
	public Colorf add(float r, float g, float b , float a) {
		this.r += r;
		this.g += g;
		this.b += b;
		this.a += a;
		return this;
	}
	
	
	
	
	public Colorf add(int r, int g, int b , int a) {
		this.r += (float)r / 255f;
		this.g += (float)g / 255f;
		this.b += (float)b / 255f;
		this.a += (float)a / 255f;
		return this;
	}
	
	
	
	
	public Colorf sub(IColor other) {
		return sub(other.getFloatR(), other.getFloatG(), other.getFloatB(), other.getFloatA());
	}

	
	
	
	public Colorf sub(IVector vec) {
		if(vec.getDimensions() == 3) {
			if(vec.getVectorType() == VectorType.FLOAT || vec.getVectorType() == VectorType.DOUBLE) {
				this.sub(vec.getFloat(0), vec.getFloat(1), vec.getFloat(2), 1f);
			} else {
				this.sub(vec.getFloat(0)/255f, vec.getFloat(1)/255f, vec.getFloat(2)/255f, 1f);
			}
		} else if(vec.getDimensions() == 4) {
			if(vec.getVectorType() == VectorType.FLOAT || vec.getVectorType() == VectorType.DOUBLE) {
				this.sub(vec.getFloat(0), vec.getFloat(1), vec.getFloat(2), vec.getFloat(3));
			} else {
				this.sub(vec.getFloat(0)/255f, vec.getFloat(1)/255f, vec.getFloat(2)/255f, vec.getFloat(3)/255f);
			}
		} else {
			throw new IllegalArgumentException("Vector must have 3 or 4 dimensions.");
		}
		return this;
	}
	
	
	
	
	public Colorf sub(float r, float g, float b , float a) {
		this.r -= r;
		this.g -= g;
		this.b -= b;
		this.a -= a;
		return this;
	}
	
	
	
	
	public Colorf sub(int r, int g, int b , int a) {
		this.r -= (float)r / 255f;
		this.g -= (float)g / 255f;
		this.b -= (float)b / 255f;
		this.a -= (float)a / 255f;
		return this;
	}
	
	
	
	
	public Colorf mul(IColor other) {
		return mul(other.getFloatR(), other.getFloatG(), other.getFloatB(), other.getFloatA());
	}

	
	
	
	public Colorf mul(IVector vec) {
		if(vec.getDimensions() == 3) {
			if(vec.getVectorType() == VectorType.FLOAT || vec.getVectorType() == VectorType.DOUBLE) {
				this.mul(vec.getFloat(0), vec.getFloat(1), vec.getFloat(2), 1f);
			} else {
				this.mul(vec.getFloat(0)/255f, vec.getFloat(1)/255f, vec.getFloat(2)/255f, 1f);
			}
		} else if(vec.getDimensions() == 4) {
			if(vec.getVectorType() == VectorType.FLOAT || vec.getVectorType() == VectorType.DOUBLE) {
				this.mul(vec.getFloat(0), vec.getFloat(1), vec.getFloat(2), vec.getFloat(3));
			} else {
				this.mul(vec.getFloat(0)/255f, vec.getFloat(1)/255f, vec.getFloat(2)/255f, vec.getFloat(3)/255f);
			}
		} else {
			throw new IllegalArgumentException("Vector must have 3 or 4 dimensions.");
		}
		return this;
	}
	
	
	
	
	public Colorf mul(float r, float g, float b , float a) {
		this.r *= r;
		this.g *= g;
		this.b *= b;
		this.a *= a;
		return this;
	}
	
	
	
	
	public Colorf mul(int r, int g, int b , int a) {
		this.r *= (float)r / 255f;
		this.g *= (float)g / 255f;
		this.b *= (float)b / 255f;
		this.a *= (float)a / 255f;
		return this;
	}
	
	
	
	
	public Colorf div(IColor other) {
		return div(other.getFloatR(), other.getFloatG(), other.getFloatB(), other.getFloatA());
	}

	
	
	
	public Colorf div(IVector vec) {
		if(vec.getDimensions() == 3) {
			if(vec.getVectorType() == VectorType.FLOAT || vec.getVectorType() == VectorType.DOUBLE) {
				this.div(vec.getFloat(0), vec.getFloat(1), vec.getFloat(2), 1f);
			} else {
				this.div(vec.getFloat(0)/255f, vec.getFloat(1)/255f, vec.getFloat(2)/255f, 1f);
			}
		} else if(vec.getDimensions() == 4) {
			if(vec.getVectorType() == VectorType.FLOAT || vec.getVectorType() == VectorType.DOUBLE) {
				this.div(vec.getFloat(0), vec.getFloat(1), vec.getFloat(2), vec.getFloat(3));
			} else {
				this.div(vec.getFloat(0)/255f, vec.getFloat(1)/255f, vec.getFloat(2)/255f, vec.getFloat(3)/255f);
			}
		} else {
			throw new IllegalArgumentException("Vector must have 3 or 4 dimensions.");
		}
		return this;
	}
	
	
	
	public Colorf div(float r, float g, float b , float a) {
		this.r /= r;
		this.g /= g;
		this.b /= b;
		this.a /= a;
		return this;
	}
	
	
	
	
	public Colorf div(int r, int g, int b , int a) {
		this.r /= (float)r / 255;
		this.g /= (float)g / 255;;
		this.b /= (float)b / 255;;
		this.a /= (float)a / 255;;
		return this;
	}

	

	
	public Colorf clamp() {
		this.r = Math.max(Math.min(r, 0f), 1f);
		this.g = Math.max(Math.min(g, 0f), 1f);
		this.b = Math.max(Math.min(b, 0f), 1f);
		this.a = Math.max(Math.min(a, 0f), 1f);
		return this;
	}
	
	
	
	
	public Colorf lerp(IColor other, float t) {
		return lerp(other.getFloatR(), other.getFloatG(), other.getFloatB(), other.getFloatA(), t);
	}
	
	
	
	
	public Colorf lerp(float r, float g, float b, float a, float t) {
		this.r += t * (r - this.r);
		this.g += t * (g - this.g);
		this.b += t * (b - this.b);
		this.a += t * (a - this.a);
		return this;
	}

	
	
	
	public Colorf lerp(int r, int g, int b, int a, float t) {
		this.r += t * (((float)r/255f) - this.r);
		this.g += t * (((float)g/255f) - this.g);
		this.b += t * (((float)b/255f) - this.b);
		this.a += t * (((float)a/255f) - this.a);
		return this;
	}
	
	
	
	
	public Colorf multiplyAlpha() {
		this.r *= this.a;
		this.g *= this.a;
		this.b *= this.a;
		return this;
	}
	
	
	
	
	public int toIntBits() {
		int color = ((int)(255 * a) << 24) | ((int)(255 * b) << 16) | ((int)(255 * g) << 8) | ((int)(255 * r));
		return color;
	}

	
	
	
	/**
	 * converts this color to a vector3 and drops the alpha component in the process.
	 * @return a vector3
	 * */
	public Vector3f toVector3() {
		return new Vector3f(this.r, this.g, this.b);
	}
	
	
	
	
	/**
	 * converts this color to a vector4.
	 * @return a vector4
	 * */
	public Vector4f toVector4() {
		return new Vector4f(this.r, this.g, this.b, this.a);
	}
	
	
	
	
	public Color toAWTColor() {
		return new Color(getIntR(), getIntG(), getIntB(), getIntA());
	}
	
	
	
	
	public Colorf copy() {
		return new Colorf(this.r, this.g, this.b, this.a);
	}
	
	
	
	
	@Override
	public String toString() {
		return "Colorf." + this.hashCode() + "(" + r + ", " + g + ", " + b + ", " + a + ")";
	}


}