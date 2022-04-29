public class OpGradiente {
    double [] x;
    double [] y;
    double precision =0.001;
    double aprendizaje=0.0005;
    double val;

    public OpGradiente(double [] x , double [] y ,double val ){
        this.x = x;
        this.y = y;
        this.val=val;
        gradiant();
    }

    public void gradiant () {
        int count= 0;
        double b_0=0,b_1=0,b_0grad,b_1grad,err;
        float prues=(float)-2/9,div=(float)1/9;
        do{
            b_0grad=0;
            b_1grad=0;
            err=0;
            for (int k=0;k<x.length;k++){
                b_0grad+=(y[k]-(b_0+b_1*x[k]));
                b_1grad+=((y[k]-(b_0+b_1*x[k]))*x[k]);
                err+=(y[k]-(b_0+b_1*x[k]));
            }
            b_0grad=b_0grad*prues;
            b_1grad=b_1grad*prues;

            err=(err*err) * div;
            b_0-=(aprendizaje * b_0grad);
            b_1-=(aprendizaje * b_1grad);
            count++;
        }while(err> precision);

        System.out.printf("\nnumero de iteraciones: %d\nAprendisaje usado %.5f\nprecision %.5f\n",count,aprendizaje, precision);
        System.out.printf("los valores obtenidos son yhat= %.4f + ( %.4f * %.2f)\n",b_0,b_1,val);
        System.out.printf("yhat = %f\n",b_0+(b_1*val));
    }
}
