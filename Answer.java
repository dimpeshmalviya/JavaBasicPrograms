class Solution {
   public static int answer(int []arr, int target, boolean find)

{

int mid=0, temp=-1;

    int start=0,end=arr.length-1;

    while(start<=end)

    {

         mid=(start+end)/2;

        if(arr[mid]<target)

        start =mid+1;

        else if(arr[mid]>target)

        end=mid-1;

        else

        {

        temp=mid;

        if(find)

            end=mid-1;

            else

start=mid+1;

            

        }

    }

    return temp;

   }

   



 public int []searchRange(int arr[], int target)

{

int temp[]={-1,-1};

temp[0]=answer(arr,target, true);
if(temp[0]!=-1)
temp[1]=answer(arr,target,false);

 return temp;

}
        
    
}
