# SME
java class with several methods for evaluating the similarity of two strings.  
The goal of this class is to provide a tool to bypass human error in applications where users must type commands from a set list for desired effect.  
Ideally the 'eval' method would be used in conjunction with a set list of possible user commands, the user input is then compared against all possible inputs in said list, 
generating a 'intention score' for each command. The application can then decide to execute the input with the highest 'intention score', or to prompt the user to try again 
if a threshhold score is not reached on any commands, i.e the user's input looks nothing like any commands on the list.  
This project was inspired by autocorrect features used by smarthphone keyboards and the google websearch engine.

Each "match" method in the class returns a float between 0 and 1.  Ideally each method should return 1 for a complete match, and 0 for totally distinct strings  
The four methods at this time are:

'lenmatch'  
     compares the length of the two strings, different algorithms are used for whether the second string is longer or shorter than the first
    
    
'charmatch'  
     Compares the characters found within each string
    

'patmatch'  
     Looks for patterns of characters found in the two strings
    
'tradmatch'  
      Invokes the String.compareTo() method native to java but converts the result so '0' maps to '1'.  
      and as the absolute value of all other results increase, the result approaches '0'
      
      
     
There is an also additional method included:   

'eval'  
    Takes the two strings to compare and an array of booleans (correpsonding to which methods the user would like to use).
    First, the method uses opens an 'if' block and uses the Sting.isEqual() method to check if the two strings are the same, 
    if this is the case the method immediately returns '1'.  
    Then, in the following 'else' block, all designated methods are run on the passed strings and the scores returned by the methods are averaged and returned as a 'final score'.
