



public class Generator {
    
    
    public static int totallscore = 0 ;
    
    public static void setscore (int x )
    {
        totallscore += x ; 
    }
    
    public static int getscore ()
    {
        return totallscore;
    }
    
    
    
    
    public static int search (String[] arr , String word)
    {
        
        for (int i = 0 ; i < arr.length ; ++i)
            if (word.equalsIgnoreCase(arr[i]))
               return 1 ;  
        
        return 0 ;  
        
    }
    
      // adds chars to the original word untill length = 8
 	// also changes the order of the chars in the originalWord
 	// before adding the chars 
     public static String randomizer (String originalWord ) {
         // string(characters) that we will generate the random characters from it
         // the first value is any 5 random characters
         // the seconed value x is the word that we generate from the database
        String alphabet = "qwertyuioplkjhgfdsazxcvbnm" , x;
        // string c empty to put the characters in
        String c = "";
        // N to get the length of the string alphabet
        int N = alphabet.length();
            // create object from random 
        java.util.Random r = new java.util.Random();
            // the call of method per with attribute the word
        x = per(originalWord);
        // condition to generate 8 random characters only
        while(x.length() != 8)
        {
            // the empty c string which we but in it the random characters
            // charAt :This method returns the character located at the String's specified index.
            // The string indexes start from zero
           
            c += alphabet.charAt(r.nextInt(N));
            // condation if x doesn't contain c put the c(the 5 random chars) and x(orginal word) togther
          if (!x.contains(c))
              x += c;                  
              c ="";
 
        }
        
        return x;
 
    } //end of randomizer method
   
     // takes a word and reverse it 
 	// for example 
 	// cat = tac 
 	// car = rac 
    public static  String per (String word ) {
        String x = "" ;
        // for loop to reverse the word 
        for (int i = word.length()-1 ; i >= 0 ; --i)
            x += word.charAt(i);
   
        return x;
    } //end of per method
    
     public static String reverse(String input){
   
    char[] in = input.toCharArray();
    int begin=0;
    int end=in.length-1;
    char temp;
    while(end>begin){
        temp = in[begin];
        in[begin]=in[end];
        in[end] = temp;
        end--;
        begin++;
    }
    return new String(in);
}
}
