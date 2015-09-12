import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class WordGenerator {
	
	private Scanner scan;
	private int wordCounter;
	private int sentenceCounter;
	
	//also need JU test file that tests get word count and get sentence count
	
	public WordGenerator(String filename) throws IOException{
		//constructs new generator that processes text from given file
		this.scan = new Scanner(new File (filename));
	}

	public boolean hasNext(){
		//true if there is text left to process
		return (this.scan).hasNext();
	}
		
	public String next(){
		//return the next word
		//don't have to worry about not having a next
		String n = (this.scan).next();
		if(n.charAt(n.length() - 1) == '.' || n.charAt(n.length() - 1) == '!' || n.charAt(n.length() - 1) == '?'){
			sentenceCounter++;
		}
		this.wordCounter++;
		return n;
	}
	
	public int getWordCount(){
		//returns number of words produced by WordGenerator so far
		return wordCounter;
	}
		
	public int getSentenceCount(){
		//returns number of sentences produced by the WordGenerator so far. 
		//sentence is number of times a sentence ending punctuation mark appears ('.', '!', '?')
		return sentenceCounter;
	}

}
