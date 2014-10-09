/**
 * @(#)NuPrice.java
 *
 *
 * Kevin Wolf
 * @version 1.00 2014/10/9
 */
import java.text.DecimalFormat;
public class NuPrice {
    
    /**
     * @param args the command line arguments
     * Would ordinarily not put main function, just for testing.
     */
    public static void main(String[] args) {
        nuPriceTest(1, nuPrice(1299.99, 3, "food"), 1591.58);
        nuPriceTest(2, nuPrice(5432.00, 1, "drugs"), 6199.81);
        nuPriceTest(3, nuPrice(12456.95, 4, "books"), 13707.63);
        nuPriceTest(4, nuPrice(13446.97, 2, "electronics"), 14740.57);
        nuPriceTest(5, nuPrice(1299.99, 0, "food"), 1542.44);
        nuPriceTest(6, nuPrice(5432.00, 0, "drugs"), 6131.37);
        nuPriceTest(7, nuPrice(12456.95, 0, "books"), 13079.8);
        nuPriceTest(8, nuPrice(13446.97, 0, "electronics"), 14401.7);
        nuPriceTest(9, nuPrice(0, 0, "food"), 0);
        nuPriceTest(10, nuPrice(0, 0, "drugs"), 0);
        nuPriceTest(11, nuPrice(0, 0, "books"), 0);
        nuPriceTest(12, nuPrice(0, 0, "electronics"), 0);
        nuPriceTest(13, nuPrice(899999, 100, "drugs"), 2149872.61);
        
    }
    
    public static double nuPrice(double original_price, int num_people, String type){
		try{
			double additional_markup = 0;
			double flat_markup = 0.05;
			original_price = original_price + flat_markup*original_price;
			additional_markup += num_people*0.012;
			if (type == "drugs"){
				additional_markup += .075;
			}
			else if (type == "food"){
				additional_markup += .13;
			}
			else if (type == "electronics"){
				additional_markup += .02;
			}
			original_price = original_price + original_price*additional_markup;
			DecimalFormat df = new DecimalFormat("#.##");
			return Double.valueOf(df.format(original_price));
		}
		catch(Exception e){
			return -1;
		}
		
    }
    
    public static void nuPriceTest(int test_number, double result, double expected){
    	if (result == expected){
    		System.out.println("Test "+test_number+" Passed");
    	}
    	else{
    		System.out.println("Test "+test_number+" Failed. Expected Value: "+expected+" Actual Value: "+result);
    	}
    }
}
