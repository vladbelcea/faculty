class Complex
{
    private double real,imaginar;
    private static int nrAfisari;
    
    public Complex(double r, double i)
    {
        real=r;
        imaginar=i;
    }
    
    public double modul()
    {
        return Math.sqrt(real*real+imaginar*imaginar);
    }
    
    public void afisare()
    {
        nrAfisari++;
        System.out.println(real+"+i*"+imaginar);
    }
    
    public Complex suma(Complex complex)
    {
        Complex s;
        s=new Complex(real+complex.real, imaginar+complex.imaginar);
        return s;
    }
    
    public static void nrAfis()
    {
        System.out.println(nrAfisari);
    }
    
}
    public class ClientComplex
    {
        public static void main(String args[])
        {
            Complex complex1;
            complex1= new Complex(4,7);
            Complex complex2;
            complex2= new Complex(5,3);
            System.out.println(complex1.modul());
            complex1.suma(complex2).afisare();
            complex1.afisare();
            Complex.nrAfis();
        }
    }
    





