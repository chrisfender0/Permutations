package permutations;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author chrisjuste
 */
public class Permutations {
    
    public void euclideanAlgorithm(int a, int b){
        int x = a;
        int y = b;
        int r;
        while(y!=0){
            r = x%y;
            x = y;
            y = r;
            System.out.println("x = " + x + " | y = " + y);
        }
        int lcm = a*b/x;
        System.out.println("GCD="+x);
        System.out.println("LCM=" + lcm);
    }
    
    //Factorial of integers only 
    public BigInteger factorial(int x){
        BigInteger facto = new BigInteger("1");
        for(int i=2;i<=x;i++){
            facto = facto.multiply(BigInteger.valueOf(i));
        }
        return facto;
    }
    
    //Factorial with decimals 
    public BigDecimal factorialD(int x){
        BigDecimal facto = new BigDecimal("1");
        for(int i=2;i<=x;i++){
            facto = facto.multiply(BigDecimal.valueOf(i));
        }
        return facto;
    }
    
     
    public BigInteger r_combo(int n, int r){
        BigInteger a,b,c;
        a = factorial(n);
        b = factorial(r);
        c = factorial(n-r);
        b = b.multiply(c);
        a = a.divide(b);
        return a;
    }
    
    //r-combo type for decimals 
    public BigDecimal r_comboD(int n, int r){
        BigDecimal a,b,c;
        a = factorialD(n);
        b = factorialD(r);
        c = factorialD(n-r);
        b = b.multiply(c);
        a = a.divide(b);
        return a;
    }
    
    //r_combo repeating for integers only 
    public BigInteger RCombo_YES_REPEAT(int n, int r){
        BigInteger a,b,c;
        a = factorial(n+r-1);
        b = factorial(r);
        c = factorial(n-1);
        b = b.multiply(c);
        a = a.divide(b);
        return a;
    }
    
    //r_combo repeating for decimals 
    public BigInteger RCombo_NO_REPEAT(int n, int r){
        BigInteger a,b,c;
        a = factorial(n);
        b = factorial(r);
        c = factorial(n-r);
        b = b.multiply(c);
        a = a.divide(b);
        return a;
    }
    
    //R permutation for integers 
    public BigInteger RPerm_YES_REPEAT(int n, int r){
        BigInteger a;
        a = BigInteger.valueOf(n);
        return a.pow(r);
    }
    
    //R permutation for decimals 
    public BigInteger RPerm_NO_REPEAT(int n, int r){
        BigInteger a,b;
        a = factorial(n);
        b = factorial(n-r);
        a = a.divide(b);
        return a;
    }
    public BigInteger repeat_combo1 (int n, int r){
        int n_temp = n+r-1;
        int r_temp = r;
        BigInteger temp = r_combo(n_temp,r_temp);
        return temp;
    }
    public BigInteger repeat_combo2 (int n, int r){
        int n_temp = n+r-1;
        int r_temp = n-1;
        BigInteger temp = r_combo(n_temp,r_temp);
        return temp;
    }
    public BigDecimal stirling(int n, int r){
        BigDecimal result;
        result = BigDecimal.valueOf(0);
        BigDecimal a,b,c,d;
        d = factorialD(r);
        for(int i=0;i<r;i++){
            
            a = BigDecimal.valueOf(-1);
            a = a.pow(i);
            b = r_comboD(r,i);
            c = BigDecimal.valueOf(r-i);
            c = c.pow(n);
            a = a.multiply(b);
            a = a.multiply(c);
            result = result.add(a);
        }
        return result.divide(d);
    }
    public BigDecimal binomial_distribution(int k, int n, double p){
        BigDecimal a,b,q;
        a = r_comboD(n, k);
        b = BigDecimal.valueOf(p);
        b = b.pow(k);
        q = BigDecimal.valueOf(1-p);
        q = q.pow(n-k);
        a = a.multiply(b);
        a = a.multiply(q);
        return a;
    }
}

