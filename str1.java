


public class str1 {
    public static void main(String[] args) {
        String sb= "priyanshu";
        StringBuilder result = new StringBuilder();
       for(char ch : sb.toCharArray()){
        if(Character.isLowerCase(ch)){
            result.append(Character.toUpperCase(ch));
        }else if(Character.isUpperCase(ch)){
            result.append(Character.toLowerCase(ch));
        }else{
            result.append(ch);
        }
       }
        System.out.println(result);
    }
}
