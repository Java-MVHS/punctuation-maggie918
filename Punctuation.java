//Maggie Lu P6
//12-11-2024
//Punctuation.java

/* This program will take some text, read it word by word and print all
 * of the words that have some punctuation in it.
 * 
 * There will be no field variables. 
 * You will have a variable for the text. You can copy and paste the entire text
 * at the end as the value of variable
 * 
 * There is a method called searchIt, which is called from main
 * searchIt will call the methods getPuncuationWords, and printWords
 * getPunctuationWords will call ceckForPunctuation

PSEUDOCODE:

mAIN METHOD: 
	create instance of Punctuation class
	call searchIt()

searchIt()
	call getPunctuationWords and store in variable
	call printWords, pass in variable

getPunctuationWords()
	Store long speech thing in line 
	check for punctuation by calling checkForPunctuation method
	store checkForPunctuation method return value in variable
	return that variable
checkForPunctuation()
	store all punctuation marks in variable puncts
	D&I space to 0
	D word
	while loop (while space value isn't -1)

	set space to the indexOf ' '
	if the space = -1, it is the last word
		store directly in word, no modifications to input
	otherwise:
	store word variable: substring of input, from indexs 0 to space
	remove word from input with substring method

	check for punctuation mark once word is singled out:
	- use loop to go through each letter/character of the word, check if it is in the string of punctuations
	if it is, add to the output along with ' '
	return the output
*/
public class Punctuation //Punctuation class
{
	public static void main(String[] args) //main method
	{
		Punctuation punc = new Punctuation(); //instance of class
		punc.searchIt(); //calls searchIt
	}

	public void searchIt() //calls 2 methods
	{
		String printThis = getPunctuationWords(); //Stores the output in variable
		printWords(printThis); //this method prints the output
	}
	
	public String getPunctuationWords() //contains the long Churchill speech, calls checkForPunctuation()
	{
		//The text
		String line = "Blood, Sweat, and Tears by Winston Churchill" +
		"May 13, 1940" + 
		"Mr. Speaker: " + 
		"On Friday evening last I received His Majesty's commission to" +
		" a new Administration. It was the evident wish and will of" +
		" Parliament and the nation that this should be conceived on the broadest possible basis" +
		" and that it should include all parties, both those who supported the" +
		" late Government and also the parties of the Opposition." +
		"I have completed the most important part of this task. A war C" + 
		"abinet has been formed of five Members, representing, with the " +
		"Liberal Opposition, the unity of the nation. The three party Leaders" + 
		"have agreed to serve, either in the War Cabinet or in high " +
		"executive office. The three Fighting Services have been filled. " +
		"it was necessary that this should be done in one single day, " +
		"on account of the extreme urgency and rigour of events. " +
		"A number of other key positions were filled yesterday, and " +
		"I am submitting a further list to His Majesty tonight. I hope " +
		"to complete the appointment of the principal Ministers during " +
		"tomorrow. The appointment of the other Ministers usually " + 
		"takes a little longer, but I trust that, when Parliament meets " +
		"this part of my task will be completed, and that the Administration " + 
		"will be complete in all respects." + "Sir, I considered it" + 
		" in the public interest to suggest that the House should be " + 
		"summoned to meet today. Mr. SPeaker agreed and took the necessary" +
		" steps, in accordance with the powers conferred upon him by the Resolution" +
		"of the House. At the end of the proceedings today, the " +
		"Adjournment of the House will be proposed until Tuesday, " +
		"the 21st May, with, of course, provision for earlier meeting, " +
		"if need be. The buisness to be considered during that week " + 
		"will be notified to Members at the earliest opportunity. I now " + 
		"invite the House, by the Resolution which stands in my name, to "
		+ "record its approval of the steps taken and to declare its con" +
		"fidence in the new Government." + "Sir, to form an Administration"
		+ "of this scale and complexity is a serious undertaking in itself" +
		", but it must be remembered that we are in a preliminary stage" +
		" of one of the greatest battles in history, that we are in " +
		"action at many points in Norway and in Holland, that we have " +
		"to be prepared in the Mediterranean, that the air battle is " + 
	"continuous and that many preparations have to be made here at home." +
	" In this crisis I hope I may be pardoned if I do not address the " +
	"House at any length today. I hope that any of my friends and colleagues," +
	" or former colleagues, who are affected by the political " +
	"reconstruction, will make all allowances for any lack of ceremony with" +
	" which it has been necessary to act. I would say to the House, as I " +
	"said to those who’ve joined this government: " +
	"\"I have nothing to offer but blood, toil, tears and sweat.\"" +
	"We have before us an ordeal of the most grievous kind. We have before " +
	"us many, many long months of struggle and of suffering. You ask, what" +
	" is our policy? I will say: It is to wage war, by sea, land and air," +
	" with all our might and with all the strength that God can give us; to"+
	" wage war against a monstrous tyranny, never surpassed in the dark and "
	+ "lamentable catalogue of human crime. That is our policy. You" +
	" ask, what is our aim? I can answer in one word: victory. Victory at" +
	" all costs, victory in spite of all terror, victory, however long and" +
	" hard the road may be; for without victory, there is no survival. Let" +
	" that be realised; no survival for the British Empire, no survival " +
	"for all that the British Empire has stood for, no survival for the urge" +
	" and impulse of the ages, that mankind will move forward towards its goal. " +
	"But I take up my task with buoyancy and hope. I feel sure that our cause" +
	" will not be suffered to fail among men. At this time I feel " + 
	"entitled to claim the aid of all, and I say, \"Come then, let us go forward" +
	" together with our united strength.\"";
		String punctWords = checkForPunctuation(line); //calls checkForPunctuation, stores it in the output that contains
														//all the words that have a punctuation mark
		return punctWords; //return so can put in print method
	}
	
	public void printWords(String punctWords) //print words with punctuation
	{
		System.out.println("\n\n\nThe words that have punctuation marks are: " + punctWords + "\n\n\n"); //print all the words that have punctuation marks in them
	}
	
	public String checkForPunctuation(String input) //checkForPunctuation checks which words have punctuation
	{
		String puncts = ".\")!;:,?(-'"; //string that stores all the "punctuations"
		int space = 0; //initialize space index to 0
		String output = "";
		String word;
		while(space != -1) //loop runs as long as there is still a word in the string
		{
			space = input.indexOf(' '); //to separate words
			 //check for space from starting index
			if(space == -1)
				word = input; //means last word, store last word in word
			else 
			{
				word = input.substring(0, space); //single out the word to find punctuations
				input = input.substring(space+1); //remove word from string
			}
			for(int ch = 0;ch<word.length();ch++) //checks each character in the word to see if it is a punctuation mark
				if(puncts.indexOf(word.charAt(ch)) != -1) //if the character in the word is a punctuation mark,
					output = output + word + " "; //add it to the output
		}
		return output; //return the output
	}
}
