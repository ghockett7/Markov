import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//brute generator does not store any value
//in brute generator you loop through the list of values, find the given NGram. Find all of the possibilities and then return 
//one of them. 
public class BruteGenerator implements TextGenerator {
	// k is equal to the size of the state you need to keep track of
	private TrainingText text;
	private Random rand;

	public BruteGenerator() {
		rand = new Random();
		// initializes rand
	}

	public BruteGenerator(int n) {
		rand = new Random(n);
		// finds rand based on a range
	}

	public int train(Scanner source, String delimiter, int k) {
		text = new TrainingText(source, delimiter, k);
		return text.size();
		// intitializes text, returns the size of the trainingtext.
	}

	public String generateText(int length) {
		// length is the number of words or characters that we want to return.
		// determine a start state(seed)
		int start = rand.nextInt(text.size());
		String finstring = "";
		StringBuilder output = new StringBuilder();
		// randomly pick where you start
		// generate a random number between 1 and the total number of possible
		// states
		// ^upper bound must be less than this total number. its equal to (size
		// -k)
		// NGram seed = text.get(start)
		NGram seed = text.get(start);
		for (int i = 0; i < length; i++) {
			ArrayList<NGram> states = new ArrayList<NGram>();
			for (int k = 0; k < text.size()-1; k++) {
				if (text.get(k).equals(seed)) {
					states.add(text.get(k + 1));
				}
			}
			int n = rand.nextInt(states.size());
			seed = (states.get(n));
			start = text.indexOf((NGram) states.get(n), start);
			output.append(seed);
			//finstring += seed.toString();
		}
		// for i 0 to length
		// find all of the instances of seed in the text
		// text.indexOf(NGram seed, int startpos)
		// compile a list of every following state

		// if seed occurs at index i... then we want the state at i+1(because
		// this directly follows the seed)
		// randomly choose an item from this list.
		// append.toString to the output text
		return output.toString();
//use stringBuilder
	}

}

