package algorithms;

import edu.princeton.cs.algs4.StdOut;

public class Matrix {
	static double dot(double[] x, double[] y){
		return x[0]*y[0]+x[1]*y[1];
	}
	static double[][] mult(double[][] x, double[][] y){
		//maybe have something wrong;
		int xrow = x.length;
		double[][] result = new double[xrow][xrow];
		//行号
		for(int m = 0; m < xrow; m++){
			//列号
			for(int n = 0; n < xrow; n++)
				for(int i = 0; i < x[0].length; i++)
					result[m][n]+=x[m][i]*y[i][n];
		}
		return result;
	}
	static double[] mult(double[] x, double[][] y){
		int yrow = y.length;
		int yclm = y[0].length;
		double[] result = new double[yrow];
		//y列号
		for(int n = 0; n < yclm; n++)
			//y行号
			for(int m = 0; m < yrow; m++)
				result[m]=y[m][n]*x[m];
		return result;
	}
	static double[] mult(double[][] x, double[] y){
		int xrow = x.length;
		int xclm = x[0].length;
		double[] result = new double[xrow];
		//x行号
		for(int m = 0; m < xrow; m++){
			//x列号
			for(int n = 0; n < xclm; n++)
				result[m] += y[n]*x[m][n];
		}
		return result;
	}
	static double[][] transpose(double[][] a){
		int oRow = a.length;
		int oClm = a[0].length;
		double[][] result = new double[oClm][oRow];
		
		for(int cRow = 0; cRow < oClm; cRow++){
			for(int cClm = 0; cClm < oRow; cClm++){
				result[cRow][cClm] = a[cClm][cRow];
			}
		}
		return result;
	}
	public static void main(String[] args){
		double[][] a = new double[][]{{2,1},{4,3}};
		double[][] b = new double[][]{{1,2},{1,0}};
		print(mult(a,b));
	}
	private static void print(double[] a){
		for(int i = 0; i < a.length; i++)
			StdOut.print(a[i]+"\t");
		StdOut.println();
	}
	private static void print(double[][] a){
		for(int i = 0; i < a.length; i++)
			print(a[i]);
	}
//	private static void legalMatrixTest(double[][]... as) throws MatrixIllegalException{
//		for(double[][] a:as){
//			int n = 0;
//			while(a[n].length==a[n+1].length&&n<a.length-1){
//				n++;
//			}
//			if(n==a.length-1)
//				throw new MatrixIllegalException();
//		}
//	}
//	public static class MatrixIllegalException extends Exception{}
}
