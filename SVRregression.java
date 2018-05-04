package org.cloudbus.cloudsim.util;
import smile.regression.SVR;
import smile.math.kernel.LinearKernel;

/**
 * the SVR regression class 
 *
 * @author H. Monshizadeh Naeen
 */
public class SVRregression {
    public static double predict(double[] utilizationHistory, double xtimeTopredict)
    {
        double[][] trainx=new double[utilizationHistory.length][1];
        for(int i=0;i<utilizationHistory.length;i++)
        {
            trainx[i][0]=i;
        }
        SVR<double[]> svr = new SVR<>(trainx, utilizationHistory, new LinearKernel(),0.1,1.0);
        double[][] timetoPredict=new double[1][1];
         timetoPredict[0][0]=xtimeTopredict;
        return svr.predict(timetoPredict[0]);
    }
    
}
