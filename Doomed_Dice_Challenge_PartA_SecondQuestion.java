public class Doomed_Dice_Challenge_PartA_SecondQuestion
{
	public static void main(String[] args) {
	    int[] Dice_A = {1,2,3,4,5,6};
	    int[] Dice_B = {1,2,3,4,5,6};
	    System.out.println("Distribution of All Possible Combinations: " );
	    for(int i=0;i<6;i++)
	    {
	        for(int j=0;j<6;j++)
	        {
	            System.out.print("(" + Dice_A[i] + "," + Dice_B[j] + ") ");
	        }
	        System.out.println();
	    }
	}
}
