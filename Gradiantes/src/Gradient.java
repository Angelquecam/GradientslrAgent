public class Gradient {
    private double [] x;
    private double [] y;
    private double B0 = 0;
    private double B1 = 0;
    private double alpha = 0.0005;
    private double precision = 0.001;

    public Gradient(double [] x , double [] y ){
        this.x = x;
        this.y = y;
        calculo();
    }
    public double getB0() {
        return B0;
    }
    public double getB1() {
        return B1;
    }
    public double calcularError(){
        double  E = 0;
        for(int i = 0; i < x.length ; i++ ){
            E = E + (y[i] - (B0 + (B1 * x[i])));
        }
        return (E*E) * 1.0/9;
    }
    public double calcularDB0(){
        double  DB0 = 0;
        for(int i = 0; i < x.length ; i++ ){
            DB0 += (y[i] - (B0 + B1 * x[i]));
        }
        return (-2.0/9) * DB0;
    }
    public double calcularDB1(){
        double  DB1 = 0;
        for(int i = 0; i < x.length ; i++ ){
            DB1 += x[i] * (y[i] - (B0 + B1 * x[i]));
        }

        return (-2.0/9) * DB1;
    }
    public void calculo(){
        int count = 0;
        while(calcularError() > precision){
            B0 -= (calcularDB0() * alpha);
            B1 -= (calcularDB1() * alpha);
            System.out.println(calcularError());
            count++;
        }
        System.out.printf("\nnumero de iteraciones: %d \nPresision: %f\nError: %f\n",count,precision, calcularError());
    }
}