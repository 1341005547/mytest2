package utils;

public class UtilData {
	/**
	 * 数字字符串转化int类型数字
	 * @param s
	 * @return
	 */
	public static int string2Int(String s){
		int num = 0;
		int num1 = 0;
		int num2 = 1;
		char[] array = s.toCharArray();
		for(int i=0;i<array.length;i++){
			num2 = (array[i]-48);
			for(int j=0;j<array.length-i-1;j++){
				num2 = num2 * 10;
			}
			num = num + num2;
		}
		return num;
	}
	
	
}
