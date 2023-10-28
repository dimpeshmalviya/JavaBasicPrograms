public class dupli_remove_recc {
    //code to remove duplicates using recursion.
    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]){
        //base case
        if(idx == str.length()){
            System.out.println(newStr);
            return;
        }
        //kaam
        char currChar = str.charAt(idx);
        if(map[currChar-'a'] ==true){
            //then it is duplicate char 
            //calling of next index
            removeDuplicates(str, idx+1, newStr, map);
        }else{
            map[currChar-'a']=true;
            removeDuplicates(str, idx+1, newStr.append(currChar), map);
        }
    }
    public static void main(String[] args) {
        String str= "appnnacolleege";
        removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
    }
}
