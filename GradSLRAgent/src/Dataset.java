public class Dataset {

    private double [] x = {23,26,30,34,43,48,52,57,58};
    private double [] y = {651,762,856,1063,1190,1298,1421,1440,1518};

    public double[] getX() {
        return x;
    }
    public double[] getY() {
        return y;
    }
    public void tables(){
        System.out.printf("\tyears \t adv \t sales \n");
        for (int i=0;i<x.length;i++){
            System.out.printf("\t %d \t %f \t %f\n",i+1,x[i],y[i]);
        }
    }
}