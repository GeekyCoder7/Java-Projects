package Complex;

public class testComplex {
	public static void main(String[] args) {
	
	Complex a = new Complex();
	Complex b = new Complex();
	Complex c = new Complex();
	Complex d = new Complex();
	a = a.Read();
	b = b.Read();
	c = new Complex(0,0);
	d = new Complex(2,4);
	
	c = a.Add(b);
	c.Print();
	
	Complex m1 = new Complex(0,0);
	m1 = c.Mult(d);
	
	a = b.Add(m1);
	a.Print();
	
	Complex m2 = new Complex(0,0);
	m2 = c.Substract(d);
	b = a.Add(m2);
	b.Print();
	
	Complex m3 = new Complex(0,0);
	m3=a.Mult(b);
	
	Complex m4 = new Complex(0,0);
	
	m4= c.Mult(d);
	
	d=m3.Mult(m4);
	d.Print();
	
	
}

}