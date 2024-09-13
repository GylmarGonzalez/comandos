package test;

import java.text.DecimalFormat;
import java.util.Locale;

public class Main {

	  public static void main(String[] args) {
	        int block = 2500000;  // you want the supply after which block?
	        
	        Locale.setDefault(Locale.US);
	        DecimalFormat num = new DecimalFormat("###,###,###,###,###.00");
	        double btcSupplyAtBlock = btcSupplyAtBlock(block);
	        
	        
	       // System.out.println(btcSupplyAtBlock(block));
	        System.out.println(num.format(btcSupplyAtBlock));
	    }

	    public static double btcSupplyAtBlock(int b) {
	        if (b >= 33 * 210000) {
	            return 20999999.9769;
	        } else {
	            double reward = 50e8;
	            double supply = 0;
	            int y = 210000;  // reward changes all y blocks
	            while (b > y - 1) {
	                supply = supply + y * reward;
	                reward = (int) (reward / 2.0);
	                b = b - y;
	            }
	            supply = supply + b * reward;
	            return (supply + reward) / 1e8;
	        }
	    }
}
