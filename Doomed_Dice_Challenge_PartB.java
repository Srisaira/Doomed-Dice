import java.util.*;
public class Doomed_Dice_Challenge_PartB
{
    public static void undoom_dice(int[] Dice_A, int[] Dice_B)
    {   
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
        //Creating two new integer arrays A and B each of size 6
        int[] New_Die_A = new int[6];
        int[] New_Die_B = new int[6];
        //Since sum of 2 = 1 + 1 is the only possible combination
        New_Die_A[0] = 1;
        New_Die_B[0] = 1;
        //Since sum of 12 = 4 + 8 or 3 + 9 or 2 + 10 or 1 + 11, but only 4 and 8 pair is appropriate as per the conditions
        New_Die_A[1] = 4;
        New_Die_B[1] = 12 - New_Die_A[1];
        //Updating the hashmap by decrementing value by 1 corresponding to the key which is the sum of each element from both arrays
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<6;j++)
            {
                int t=New_Die_A[i]+New_Die_B[j];
                if(New_Die_A[i]!=0 && New_Die_B[j]!=0 )
                {
                    map.put(t,map.get(t)-1);
                }
            }
        }
        //Creating while loop which runs until all the elements are filled in both the arrays
        boolean flag=true;
        while(flag==true)
        {
            //Initializing minimum value, key of the minimum value, second_minimum value and key of the second value in the map
            int min = Integer.MAX_VALUE, sec_min = Integer.MAX_VALUE, minKey = 0, sec_minKey = 0;
            //Obtaining minimum value and the key corresponding to it in the map
            for(Map.Entry<Integer,Integer> i: map.entrySet())
            {
                if(i.getValue()<min && i.getValue()!=0)
                {
                    min = i.getValue();
                    minKey=i.getKey();
                }
            }
            //Obtaining the second minimum value and the key corresponding to it in the map
            for(Map.Entry<Integer,Integer> i: map.entrySet())
            {
                if(i.getValue()<sec_min && i.getValue()!=0 && (sec_min>=min && minKey!=i.getKey()))
                {
                    sec_min=i.getValue();
                    sec_minKey=i.getKey();
                }
            }
            //Creating a while loop to find the index of zero value in the array A 
            boolean temp=true;
            int x=0;
            while(temp==true && x<6)
            {
                if(New_Die_A[x]==0)
                {
                    temp=false;
                }
                x++;
            }
            //If array A has zero value i.e., empty space for storing the new number, otherwise go to else part
            if(temp==false)
            {
                New_Die_A[x-1]=minKey - 1;
                New_Die_A[x]=sec_minKey - 8;
                //Updating the hashmap by decrementing value by 1 corresponding to the key which is the sum of each element from both arrays
                for(int i=x-1;i<6;i++)
                {
                    for(int j=0;j<6;j++)
                    {
                        int t=New_Die_A[i]+New_Die_B[j];
                        if(New_Die_A[i]!=0 && New_Die_B[j]!=0 )
                        {
                            map.put(t,map.get(t)-1);
                        }
                    }
                }
            }
            //Here, Again creating a while loop to find the index of zero value in the array B 
            else
            {
                boolean temp1=true;
                int y=0;
                while(temp1==true && y<6)
                {
                    if(New_Die_B[y]==0)
                    {
                        temp1=false;
                    }
                    y++;
                }
                //If array B has zero value i.e., empty space for storing the new number
                if(temp1==false)
                {
                    New_Die_B[y-1]=minKey - 1;
                    New_Die_B[y]=sec_minKey - 4;
                    //Here, again updating the hashmap by decrementing value by 1 corresponding to the key which is the sum of each element from both arrays
                    for(int j=y-1;j<6;j++)
                    {
                        for(int i=0;i<6;i++)
                        {
                            int t=New_Die_A[i]+New_Die_B[j];
                            if(New_Die_A[i]!=0 && New_Die_B[j]!=0 )
                            {
                                map.put(t,map.get(t)-1);
                            }
                        }
                    }
                }
            }
            //This for loop is created for checking whether the hashmap has any value which is greater than 0. 
            //If true, the outer while loop continues, else exits the while loop.
            boolean temp2=false;
            for(Map.Entry<Integer,Integer> a : map.entrySet())
            {
                if(a.getValue()>0)
                {
                    temp2=true;
                    break;
                }
            }
            if(temp2==true)
            {
                flag=true;
            }
            else{
                flag=false;
            }
        }
        //Printing the elements of array A
        System.out.print("New_Die_A = " + Arrays.toString(New_Die_A));
        System.out.println();
        //Printing the elements of array B
        System.out.print("New_Die_B = " + Arrays.toString(New_Die_B));

    }
	public static void main(String[] args) {
	    //Creating two normal dice Dice_A and Dice_B
	    int[] Dice_A = {1,2,3,4,5,6};
	    int[] Dice_B = {1,2,3,4,5,6};
	    //Giving the two arrays Dice_A and Dice_B as a parameter in the function - undoom_dice()
	    undoom_dice(Dice_A,Dice_B);
	}
}
