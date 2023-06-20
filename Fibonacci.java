import java.math.BigInteger;
/* CS211 Fibonacci Class, for Chapter 12 Assignment
 * Bellevue College, W.P. Iverson, instructor
 * January 2022
 */
public class Fibonacci {
	
	// fields, ONE is in any version of Java already
	// but BigInteger.TWO requires Java 9 or higher, so I make one here
	private static final BigInteger TWO = new BigInteger("2");
	private static final BigInteger ONE = new BigInteger("1");
	private int n; // the boring old 32-bit limited int
	
	// only one constructor needed
	public Fibonacci(int number) {
		n = number;
	}
	
	// make this private as right now I cannot think of why we need to allow
	@SuppressWarnings("unused")
	private Fibonacci() {
		this(1);
	}
	
		
	
	
	public int fibonacci() {
		return fibonacci(n);
	}
	
	
    private int fibonacci(int n) {
        if (n<=2) {
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    // Exactly the same concept as above, but using BigInteger
    // This allows us to go up to any size integer
	public BigInteger bigFib() {
		return bigFib(new BigInteger(Integer.toString(n)));
	}
	
	// recursive helper
    private BigInteger bigFib(BigInteger n) {
        if (n.compareTo(TWO)<=0) {
            return ONE;
        } else {
            return bigFib(n.subtract(ONE)).add(bigFib(n.subtract(TWO)));
        }
    }
	public BigInteger bigFastFib() {
		return bigFastFib(n, 1, new BigInteger("1"), new BigInteger("1"));
	}
	
	private BigInteger bigFastFib(int finalN, int currN, BigInteger curr, BigInteger prev) {
		if(finalN <= 2) {
			return new BigInteger("1");
		}
		if(currN == finalN) {
			return curr.add(prev);
		}
		
		BigInteger temp = new BigInteger(curr.toString());
		curr = curr.add(prev);
		prev = new BigInteger(temp.toString());

		if(currN <= 2) {
			currN = 2;
			curr = new BigInteger("1");
			prev = new BigInteger("1");
		}
		return bigFastFib(finalN, currN+1, curr, prev);
	}	
    
    
    
	

	


}
