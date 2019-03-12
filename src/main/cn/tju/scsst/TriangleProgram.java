package main.cn.tju.scsst;


/**
 * 
 * @author Howie Lu
 * There is one 50 yuan, one 20 yuan, two 5 yuan bills and three 1 yuan 
 * coins in your pocket. Write a program to find out whether you can 
 * take out a given number (x) yuan.
 */
public class TriangleProgram {
	int[] triangle = {50, 20, 5, 5, 1, 1, 1};
	Boolean[] accessible = new Boolean[sumOfTriangle(triangle) + 1];
	
	//Init the accessible array 
	void initAccessable() {
		for(int i = 0; i < accessible.length; i++) {
			accessible[i] = false;
		}
		accessible[0] = true;
	}
	
	// Calculate the sum of the triangle array
	int sumOfTriangle(int[] triangle) {
		int sum = 0;
		for(int i = 0; i < triangle.length; i++) {
			sum += triangle[i];
		}
		return sum;
	}
	
	//Judge if the given money is valid
	Boolean isValid(int money) {
		if(money > sumOfTriangle(triangle) || money < 0) {
			return false;
		}else {
			return true;
		}
	}
	
	//Judge can we take out the given money using our triangle
	public Boolean canWeTakeOut(int money) {
		Boolean bool = false;
		initAccessable();
		//Using dynamic programming
		if(isValid(money)) {
			for(int i = 0; i < triangle.length; i++) {
				for (int j = accessible.length - 1; j >= 0; j--) {
					if(j - triangle[i] >= 0 && accessible[j - triangle[i]] == true) {
						accessible[j] = true;
					}
				}
			}
		}else {
			return false;
		}
		if(accessible[money] == true) {
			bool = true;
		}
		return bool;
	}
}
