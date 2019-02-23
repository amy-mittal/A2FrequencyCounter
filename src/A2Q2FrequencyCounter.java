/********************************************************************
 * Programmer:	A. Mittal
 * Class:  CS30S
 *
 * Assignment: A2 Frequency Counter
 * Program Name:  A2Q2FrequencyCounter
 *
 * Description: count occurrences of numbers in a large array
 ***********************************************************************/
 
 // import java libraries here as needed
 
 import javax.swing.*;
 //import java.text.DecimalFormat;
 import java.io.*;

public class A2Q2FrequencyCounter {  // begin class
    
    public static void main(String[] args)throws IOException {  // begin main
    
    // ********* declaration of constants **********
    
        final int MAXSIZE = 1000;
        final int UPPERBOUND = 50;
    
    // ********** declaration of variables **********

        String strin;		// string data input from keyboard
        String strout;		// processed info string to be output
        String bannerOut;		// string to print banner to message dialogs

        String prompt;		// prompt for use in input dialogs

        String delim = "[ :]+";	// delimiter string for splitting input string
        String[] tokens;                        // string array for gathering input
        
        String nl = System.lineSeparator();
        // new line character for file writing
        
        int[] list = new int[MAXSIZE];      // pointer to array base address
        int listLength = 0;                 // actual length of array
        int[] frequencyArray;               // the frequency array
        int max = 20;                       // the biggest int in the range of frequencies
        int min = 10;                       // the lowest int in the range of frequencies
    	
    // ***** create objects *******
    
        //ConsoleReader console = new ConsoleReader(System.in);
        //DecimalFormat df1 = new DecimalFormat("##.###");
        
//        BufferedReader fin = new BufferedReader(new FileReader("outFile.txt"));
        PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("frequencyData.txt")));
    	
    // ********** Print output Banner **********

        printBanner();      // call printBanner method
        fileBanner(fout);       // call fileBanner method
        bannerOut = windowBanner(); // call windowBanner method
	    	
    // ************************ get input **********************
    
        listLength = loadList(list);
        
//        System.out.println(listLength);
        
    // ************************ processing ***************************
        
        frequencyArray = frequencyArray(list, listLength, UPPERBOUND);
        
        printArray(frequencyArray);
        
        printRange(frequencyArray, max, min);

    // ************************ print output ****************************
    
    
    // ******** closing message *********
        
        System.out.println("end of processing.");
        fout.println("end of proecessing");
        
    // ***** close streams *****
        
        //fin.close();                // close input buffer stream
        fout.close();               // close output stream
        
    }  // end main
    
//****************** static methods ***************
    /***********************************************************
     * Purpose:     print the range of frequencies
     * Interface:   int[] frequencyArray --> stores the frequency information
     *              int max --> the biggest int in the range of frequencies
     *              int min --> the lowest int in the range of frequencies
     * Returns:     no return
     ************************************************************/
    public static void printRange (int[]frequencyArray, int max, int min){
        System.out.println("\nFrequencies of numbers ranging from " + min + " to " + max);
        for (int i = min - 1; i < max; i++){
            System.out.println(i + 1 + " - " + frequencyArray[i]);
        } // end for
    } // end printRange
    
    /***********************************************************
     * Purpose:     print the frequencies of each int in the array
     * Interface:   int[] frequencyArray --> stores the frequency information
     * Returns:     no return
     ************************************************************/
    public static void printArray (int[] frequencyArray){
        System.out.println("Frequency Counter: ");
        for(int i = 0; i < frequencyArray.length; i++){
            System.out.println(i + 1 + " : " + frequencyArray[i]);
        } // end for
    } // end printArray
    
    /***********************************************************
     * Purpose:     store the frequency information in an array
     * Interface:   int[] list --> pointer to the base address of the array
     *              int len --> actual length of the array
     *              int UPPERBOUND --> value of the largest int in the array
     * Returns:     int[] frequencyArray --> the frequency info is stored in this array
     ************************************************************/
    public static int[] frequencyArray (int[]list, int len, int UPPERBOUND) {
        int[] frequencyArray = new int[UPPERBOUND];
        
        for(int i = 0; i < len; i++) {
            int number = list[i];
            frequencyArray[number - 1]++;

        } // end for
                
        return frequencyArray;
        
    } // end frequencyArray
    
    /***********************************************************
     * Purpose:     load an array from a text file
     * Interface:   int[] list --> pointer to the base address of the array
     *              String delim --> delimiter for split function
     * Returns:     int len --> actual length of array
     ************************************************************/
    public static int loadList(int[] list) throws IOException{
        int len = 0;
        int currentIndex = 0;   // cumulative index of array items
        
        String strin = "";
        String[] tokens;
        
        BufferedReader fin = null;
        
        try{
            fin = new BufferedReader(new FileReader("outFile.txt"));
        } // end try
        catch(FileNotFoundException e){
          System.err.println("file not found");
        } // end catch
        
        // end of file loop
        
        strin = fin.readLine();
        
//        System.out.println(strin);
        
        while (strin != null){
//            System.out.println(strin);
            // split and parse each row item
            
            tokens = strin.split("[ ]");
            
//            System.out.println(tokens.length);
            
            for(int i = 0; i < tokens.length; i++){
//                System.out.format("%5s \n", tokens[i]);
                // parse each item and load into array index
                list[currentIndex++] = Integer.parseInt(tokens[i]);
                
            } // end for int i = 0
            
            // post loop processing
            
            
            strin = fin.readLine();
        } // end while fin
        
        // post loop processing
        
        len = currentIndex;
        
        fin.close();
        return len;
    } // end loadList

 /***********************************************************
    *   Purpose: Create a banner string that can be used to 
    *           print the banner to a message dialog or the console
    *           window
    *   Interface:  no parameters
    *   Returns:    no return
    * **************************************************************/
    public static String windowBanner(){
        String bannerOut = "";
        
    	bannerOut = "*******************************************\n";
    	bannerOut += "Name:		your name here\n";
    	bannerOut += "Class:		CS30S\n";
    	bannerOut += "Assignment:	A2 Frequency Counter\n";
    	bannerOut += "*******************************************\n\n"; 
        
        return bannerOut;
    } // end bannerOut

    /***********************************************************
    *   Purpose: print a banner to the console window
    *   Interface:  no parameters
    *   Returns:    no return
    * **************************************************************/    
    public static void printBanner(){
    	System.out.println("*******************************************");
    	System.out.println("Name:		A. Mittal");
    	System.out.println("Class:		CS30S");
    	System.out.println("Assignment:	A2 Frequency Counter");
    	System.out.println("*******************************************");        
    } // end print banner
    
 
    /***********************************************************
    *   Purpose: prints a banner to the output file
    *   Interface:  print writer fout
    *   Returns:    no return
    * **************************************************************/
    public static void fileBanner(PrintWriter fout){
     	fout.println("*******************************************");
    	fout.println("Name:		sveinson");
    	fout.println("Class:		CS20S");
    	fout.println("Assignment:	A2 Frequency Counter");
    	fout.println("*******************************************");       
    } // end bannerOut

}  // end class
