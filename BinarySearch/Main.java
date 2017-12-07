public class Main{
	public static void main(String[] args) {
		//Rotation rt = new Rotation();
		//System.out.println(rt.getMinimum(new int[]{1, 2, 3, 4}, 0, 3));
		//System.out.println(rt.getMaximum(new int[]{1,3,50,10,9,7,6}, 0, 6));

		/*CountOccurences co = new CountOccurences();
		System.out.println(co.getCount(new int[]{1,1,2,2,2,2,3}, 3));*/


		/*CeilingAndFloor cf =  new CeilingAndFloor();
		System.out.println(cf.getCeiling(new int[]{1, 2, 8, 10, 10, 12, 19}, 0, 6, 5));
		System.out.println(cf.getFloor(new int[]{1, 2, 8, 10, 10, 12, 19}, 0, 6, 5));*/


		Median med = new Median();
		System.out.println(med.getMedianOfTwo(new int[]{1,12,15,26,38}, new int[]{2,13,17,30,45}, 0, 4, 0, 4));
	}
}