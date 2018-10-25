package Complex;

import java.util.Scanner;
public class Complex {

	private  float Re;
	private  float Im;
	static Scanner scan = new Scanner(System.in);
	
	Complex(){
		Re=0;
		Im=0;			
	}
	
	Complex(float a, float b){
		Re=a;
		Im=b;
	}

	
public	 Complex Read(){
	System.out.println("Enter Re: ");
	Re = scan.nextFloat();
	
	System.out.println("Enter Im: ");
	Im = scan.nextFloat();
	return new Complex(Re,Im);
	
	}
	
	void Print(){
		System.out.println(Re+" + "+ Im +"i");
	}
	
	Complex Add(Complex C){
		float A = Re+C.Re;
		float B = Im+C.Im;
		return new Complex(A, B);
		
	}
	
	Complex Substract(Complex C){
		float A = Re-C.Re;
		float B = Im-C.Im;
		return new Complex(A, B);
	}
	
	Complex Mult(Complex C){
		float A = Re*C.Re;
		float B = Im*C.Im;
		return new Complex(A, B);
	}
	
	public boolean equals(Complex C){
		if(Re==C.Re&&Im==C.Im){
			return true;
			
		}
		else 
			return false;
	}


	
}
