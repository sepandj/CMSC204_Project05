/**
 * @author Sepand Jahrominejad
 * 
 * CMSC 204 - Project 5
 * 
 * 11/17/2022
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * 
 * This class converts the given Morse code into a regular text
 *
 */
public class MorseCodeConverter {
	
	static MorseCodeTree<String> tree = new MorseCodeTree<String>();
	
	/**
	 * The default constructor
	 */
	public MorseCodeConverter() {
		
	}
	
	
	/**
	 * Prints the binary Morse code tree in the form of a string by calling toArrayList method
	 * @return the string containing all the elements of the binary tree
	 */
	public static String printTree() {
		
		String treeStr = "";
		
		
		for(int i=0; i<tree.toArrayList().size(); i++) {
			treeStr += tree.toArrayList().get(i);
			treeStr += " ";
		}
		
		return treeStr.substring(0, treeStr.length()-1);
	}
	
	
	
	/**
	 * This method converts a String of Morse code into regular text
	 * @param code the Morse code to be decoded
	 * @return a String of regular text
	 */
	public static String convertToEnglish(String code) {
	
		String[] words = code.split(" ");
		String convertedStr = "";
		
		for(int i=0; i<words.length; i++) {
			if(words[i].charAt(0)!='/') {
				convertedStr += tree.fetch(words[i]);
			}
			else
				convertedStr += " ";
		}
		return convertedStr;
		
	}
	
	
	/**
	 * Converts a file containing Morse code into regular text
	 * @param codeFile the file that contains the Morse code
	 * @return a String of regular text
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		
		String code = "";
		
		Scanner reader = new Scanner(codeFile);
		
		while(reader.hasNextLine()) {
			code += reader.nextLine();
		}
		reader.close();
		
		String[] words = code.split(" ");
		String convertedStr = "";
		
		for(int i=0; i<words.length; i++) {
			if(words[i].charAt(0)!='/') {
				convertedStr += tree.fetch(words[i]);
			}
			else
				convertedStr += " ";
		}
		return convertedStr;
	}

}
