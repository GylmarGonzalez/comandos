package test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Main2 {
	
	private static DecimalFormatSymbols symbolsEN_US = DecimalFormatSymbols.getInstance(Locale.US);
	private static DecimalFormat formatEN_US = new DecimalFormat("###,###,###,###,###.00", symbolsEN_US);

	  public static void main(String[] args) {
	        Integer block = 420001;  // you want the supply after which block?
	        BigDecimal btcSupplyAtBlock = btcSupplyAtBlock(block);
	        System.out.printf(formatEN_US.format(btcSupplyAtBlock));
	    }

	    public static BigDecimal btcSupplyAtBlock(Integer b) {
	        if (b >= 33 * 210000) {
	            //return 20999999.9769;
	            return new BigDecimal("20999999.9769");
	        } else {
                //double reward = 50e8;
	        	BigDecimal reward = new BigDecimal("50.00");
	            // double supply = 0;
	            BigDecimal supply = BigDecimal.ZERO;
	            Integer y = 210000;  // reward changes all y blocks
	            while (b > y - 1) {
	            	BigDecimal yw = BigDecimal.valueOf(y).multiply(reward);
	            	supply = supply.add(yw);
	                //supply = supply + y * reward;
	                //reward = (int) (reward / 2.0);
	                reward = reward.divide(new BigDecimal("2.0"));
	                b = b - y;
	            }
	            //supply = supply + b * reward;
	            //BigDecimal bw = BigDecimal.valueOf(b).multiply(reward);
	            BigDecimal bw = BigDecimal.valueOf(b).multiply(reward);
	            supply.add(supply.add(bw));
	            
	           // return (supply + reward) / 1e8;
	            return supply.add(reward);
	        }
	    }
}
