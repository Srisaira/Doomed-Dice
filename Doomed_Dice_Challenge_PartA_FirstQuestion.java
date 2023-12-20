public class Doomed_Dice_Challenge_PartA_FirstQuestion
{
	public static void main(String[] args) {
	    int[] Dice_A = {1,2,3,4,5,6};
	    int[] Dice_B = {1,2,3,4,5,6};
	    int Total_combination=0;
	    for(int i=0;i<Dice_A.length;i++)
	    {
	        for(int j=0;j<Dice_B.length;j++)
	        {
	            Total_combination++;
	        }
	    }
	    System.out.println("Total Combinations = " + Total_combination);
	}
}
