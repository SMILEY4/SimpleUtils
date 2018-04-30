package com.ruegnerlukas.simpleutils.color;

import java.awt.Color;

import com.ruegnerlukas.simplemath.vectors.IVector;
import com.ruegnerlukas.simplemath.vectors.IVector.VectorType;
import com.ruegnerlukas.simplemath.vectors.vec3.Vector3i;
import com.ruegnerlukas.simplemath.vectors.vec4.Vector4i;

public class Colori implements IColor {

	
	public int r;
	public int g;
	public int b;
	public int a;
	
	
	
	
	
	
	/**
	 * @param r	the red component (0-1)
	 * @param g	the green component (0-1)
	 * @param b	the blue component (0-1)
	 * @param a	the alpha component (0-1)
	 * */
	public Colori(float r, float g, float b, float a) {
		this.r = (int)(r*255f);
		this.g = (int)(g*255f);
		this.b = (int)(b*255f);
		this.a = (int)(a*255f);
	}
	
	
	/**
	 * @param r	the red component (0-255)
	 * @param g	the green component (0-255)
	 * @param b	the blue component (0-255)
	 * @param a	the alpha component (0-255)
	 * */
	public Colori(int r, int g, int b, int a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	
	/**
	 * @param vec 	the color values stored in the vector
	 * */
	public Colori(IVector vec) {
		if(vec.getDimensions() == 3) {
			if(vec.getVectorType() == VectorType.FLOAT || vec.getVectorType() == VectorType.DOUBLE) {
				this.r = (int)(vec.getFloat(0)*255f);
				this.g = (int)(vec.getFloat(1)*255f);
				this.b = (int)(vec.getFloat(2)*255f);
				this.a = 255;
			} else {
				this.r = vec.getInt(0);
				this.g = vec.getInt(1);
				this.b = vec.getInt(2);
				this.a = 255;
			}
		} else if(vec.getDimensions() == 4) {
			if(vec.getVectorType() == VectorType.FLOAT || vec.getVectorType() == VectorType.DOUBLE) {
				this.r = (int)(vec.getFloat(0)*255f);
				this.g = (int)(vec.getFloat(1)*255f);
				this.b = (int)(vec.getFloat(2)*255f);
				this.a = (int)(vec.getFloat(3)*255f);
			} else {
				this.r = vec.getInt(0);
				this.g = vec.getInt(1);
				this.b = vec.getInt(2);
				this.a = vec.getInt(3);
			}
		} else {
			throw new IllegalArgumentException("Vector must have 3 or 4 dimensions.");
		}
	}
	
	
	
	
	
	
	public float getFloatR() {
		return this.r/255f;
	}
	
	
	
	
	public float getFloatG() {
		return this.g/255f;
	}
	
	
	
	
	public float getFloatB() {
		return this.b/255f;
	}
	
	
	
	
	public float getFloatA() {
		return this.a/255f;
	}

	
	
	
	public int getIntR() {
		return this.r;
	}
	
	
	
	
	public int getIntG() {
		return this.g;
	}
	
	
	
	
	public int getIntB() {
		return this.b;
	}
	
	
	
	
	public int getIntA() {
		return this.a;
	}
	
	
	
	
	public Colori set(IColor other) {
		return set(other.getIntR(), other.getIntG(), other.getIntB(), other.getIntA());
	}
	
	
	
	
	public Colori set(IVector vec) {
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
	
	
	
	
	public Colori set(float r, float g, float b, float a) {
		this.r = (int)(r*255f);
		this.g = (int)(g*255f);
		this.b = (int)(b*255f);
		this.a = (int)(a*255f);
		return this;
	}
	
	
	
	
	public Colori set(int r, int g, int b, int a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
		return this;
	}
	
	
	
	
	public Colori add(IColor other) {
		return add(other.getIntR(), other.getIntG(), other.getIntB(), other.getIntA());
	}
	
	
	
	
	public Colori add(IVector vec) {
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
	
	
	
	
	public Colori add(float r, float g, float b , float a) {
		this.r += (int)(r*255f);
		this.g += (int)(g*255f);
		this.b += (int)(b*255f);
		this.a += (int)(a*255f);
		return this;
	}
	
	
	
	
	public Colori add(int r, int g, int b , int a) {
		this.r += r;
		this.g += g;
		this.b += b;
		this.a += a;
		return this;
	}
	
	
	
	
	public Colori sub(IColor other) {
		return sub(other.getIntR(), other.getIntG(), other.getIntB(), other.getIntA());
	}

	
	
	
	public Colori sub(IVector vec) {
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
	
	
	
	
	public Colori sub(float r, float g, float b , float a) {
		this.r -= (int)(r*255f);
		this.g -= (int)(g*255f);
		this.b -= (int)(b*255f);
		this.a -= (int)(a*255f);
		return this;
	}
	
	
	
	
	public Colori sub(int r, int g, int b , int a) {
		this.r -= r;
		this.g -= g;
		this.b -= b;
		this.a -= a;
		return this;
	}
	
	
	
	
	public Colori mul(IColor other) {
		return mul(other.getIntR(), other.getIntG(), other.getIntB(), other.getIntA());
	}

	
	
	
	public Colori mul(IVector vec) {
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
	
	
	
	
	public Colori mul(float r, float g, float b , float a) {
		this.r *= (int)(r*255f);
		this.g *= (int)(g*255f);
		this.b *= (int)(b*255f);
		this.a *= (int)(a*255f);
		return this;
	}
	
	
	
	
	public Colori mul(int r, int g, int b , int a) {
		this.r *= r;
		this.g *= g;
		this.b *= b;
		this.a *= a;
		return this;
	}
	
	
	
	
	public Colori div(IColor other) {
		return div(other.getIntR(), other.getIntG(), other.getIntB(), other.getIntA());
	}

	
	
	
	public Colori div(IVector vec) {
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
	
	
	
	public Colori div(float r, float g, float b , float a) {
		this.r /= (int)(r*255f);
		this.g /= (int)(g*255f);
		this.b /= (int)(b*255f);
		this.a /= (int)(a*255f);
		return this;
	}
	
	
	
	
	public Colori div(int r, int g, int b , int a) {
		this.r /= r;
		this.g /= g;
		this.b /= b;
		this.a /= a;
		return this;
	}

	

	
	public Colori clamp() {
		this.r = Math.max(Math.min(r, 0), 255);
		this.g = Math.max(Math.min(g, 0), 255);
		this.b = Math.max(Math.min(b, 0), 255);
		this.a = Math.max(Math.min(a, 0), 255);
		return this;
	}
	
	
	
	
	public Colori lerp(IColor other, float t) {
		return lerp(other.getIntR(), other.getIntG(), other.getIntB(), other.getIntA(), t);
	}
	
	
	
	
	public Colori lerp(float r, float g, float b, float a, float t) {
		this.r += t * ( ((int)(r*255f)) - this.r);
		this.g += t * ( ((int)(g*255f)) - this.g);
		this.b += t * ( ((int)(b*255f)) - this.b);
		this.a += t * ( ((int)(a*255f)) - this.a);
		return this;
	}

	
	
	
	public Colori lerp(int r, int g, int b, int a, float t) {
		this.r += t * (r - this.r);
		this.g += t * (g - this.g);
		this.b += t * (b - this.b);
		this.a += t * (a - this.a);
		return this;
	}
	
	
	
	
	public Colori multiplyAlpha() {
		this.r *= ((float)a / 255f);
		this.g *= ((float)a / 255f);
		this.b *= ((float)a / 255f);
		return this;
	}
	
	
	
	
	public int toIntBits() {
		int color = (a << 24) | (b << 16) | (g << 8) | (r);
		return color;
	}

	
	
	
	public Vector3i toVector3() {
		return new Vector3i(this.r, this.g, this.b);
	}
	
	
	
	
	public Vector4i toVector4() {
		return new Vector4i(this.r, this.g, this.b, this.a);
	}
	


	
	public Color toAWTColor() {
		return new Color(r, g, b, a);
	}
	
	
	
	
	public Colori copy() {
		return new Colori(this.r, this.g, this.b, this.a);
	}
	
	
	
	
	@Override
	public String toString() {
		return "Colori." + this.hashCode() + "(" + r + ", " + g + ", " + b + ", " + a + ")";
	}


}