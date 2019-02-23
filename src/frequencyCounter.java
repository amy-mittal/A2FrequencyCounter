/********************************************************************
 * Programmer:	A. Mittal
 * Class:  CS20S
 *
 * Assignment:  A2 Q1 - Create Data File
 * Program Name:  name of public class
 *
 * Description: create a data file with 1000 random numbers
 ***********************************************************************/
 
 // import java libraries here as needed
 
 import javax.swing.*;
 //import java.text.DecimalFormat;
 import java.io.*;
import java.util.Random;

public class frequencyCounter {  // begin class
    
    public static void main(String[] args)throws IOException {  // begin main
    
    // ********* declaration of constants **********
    
        final int UPPERBOUND = 50;
        final int DATASIZE = 1000;
    
    // ********** declaration of variables **********
//
//        String strin;		// string data input from keyboard
//        String strout;		// processed info string to be output
//        String bannerOut;		// string to print banner to message dialogs
//
//        String prompt;		// prompt for use in input dialogs
//
//        String delim = "[ :]+";	// delimiter string for splitting input string
//        String[] tokens;                        // string array for gathering input
//        
//        String nl = System.lineSeparator();
//        // new line character for file writing
        
        int n = 0;      // random number to be printed to file
    	
    // ***** create objects *******
    
        Random random = new Random();
       
        PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("outFile.txt")));
    	
    // ********** Print output Banner **********
//
//        printBanner();      // call printBanner method
////        fileBanner(fout);       // call fileBanner method
//        bannerOut = windowBanner();
	    	
    // ************************ get input **********************


    // ************************ processing ***************************
        
        for(int i = 0; i < DATASIZE; i++){
            n = random.nextInt(UPPERBOUND);
            n++;
            fout.println(n);
        } // end for

    // ************************ print output ****************************
    
    
    // ******** closing message *********
        
        System.out.println("end of processing.");
        
    // ***** close streams *****
        
        fout.close();               // close output stream
        
    }  // end main
//    
////****************** static methods ***************
//
// /***********************************************************
//    *   Purpose: Create a banner string that can be used to 
//    *           print the banner to a message dialog or the console
//    *           window
//    *   Interface:  no parameters
//    *   Returns:    no return
//    * **************************************************************/
//    public static String windowBanner(){
//        String bannerOut = "";
//        
//    	bannerOut = "*******************************************\n";
//    	bannerOut += "Name:		your name here\n";
//    	bannerOut += "Class:		CS20S\n";
//    	bannerOut += "Assignment:	Ax Qy\n";
//    	bannerOut += "*******************************************\n\n"; 
//        
//        return bannerOut;
//    } // end bannerOut
//
//    /***********************************************************
//    *   Purpose: print a banner to the console window
//    *   Interface:  no parameters
//    *   Returns:    no return
//    * **************************************************************/    
//    public static void printBanner(){
//    	System.out.println("*******************************************");
//    	System.out.println("Name:		sveinson");
//    	System.out.println("Class:		CS20S");
//    	System.out.println("Assignment:	Ax Qy");
//    	System.out.println("*******************************************");        
//    } // end print banner
//    
// 
//    /***********************************************************
//    *   Purpose: prints a banner to the output file
//    *   Interface:  print writer fout
//    *   Returns:    no return
//    * **************************************************************/
//    public static void fileBanner(PrintWriter fout){
//     	fout.println("*******************************************");
//    	fout.println("Name:		sveinson");
//    	fout.println("Class:		CS20S");
//    	fout.println("Assignment:	Ax Qy");
//    	fout.println("*******************************************");       
//    } // end bannerOut

}  // end class
