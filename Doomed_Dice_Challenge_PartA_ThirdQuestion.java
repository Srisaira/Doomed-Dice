import java.util.*;
public class Doomed_Dice_Challenge_PartA_ThirdQuestion
{
	public static void main(String[] args) {
	    int[] Dice_A = {1,2,3,4,5,6};
	    int[] Dice_B = {1,2,3,4,5,6};
	    //Creating a Hashmap for storing all possible sums occurring among the combinations of two dice and their count
	    HashMap<Integer,Integer> map = new HashMap<>();
	    for(int i=0;i<6;i++)
	    {
	        for(int j=0;j<6;j++)
	        {
	            int temp = Dice_A[i] + Dice_B[j];
	            if(map.containsKey(temp))
	            {
	                map.put(temp,map.get(temp)+1);
	            }
	            else{
	                map.put(temp,1);
	            }
	        }
	    }
	    //Printing all the Key, Value pair in the hashmap
	    System.out.println("Probability of all Possible Sums occurring among the number of combinations from (2):  ");
	    for(Map.Entry<Integer,Integer> i : map.entrySet())
	    {
	        float res = (float) i.getValue() / 36;
	        System.out.println("P(Sum of " + i.getKey() + ") = " + i.getValue() + " / 36 = " + res);
	    }
	}
}
