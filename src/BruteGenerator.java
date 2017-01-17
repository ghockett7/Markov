//import java.util.ArrayList;
//import java.util.Random;
//import java.util.Scanner;
//
//public class BruteGenerator implements TextGenerator{
//	private TrainingText text;
//	private Random rand;
//	
//
//
//	public BruteGenerator(){
//		rand = new Random();
//	}
//	
//	public BruteGenerator(int randomSeed){
//		rand = new Random(randomSeed);
//	}
//
//	@Override
//	//function initializes 'text' which is a TrainingText object, so that it can be used later.
//	//The function returns the size of text
//	public int train(Scanner source, String delimiter, int k) {
//		text =  new TrainingText(source, delimiter,k);
//		return text.size();
//	}
//
//	@Override
//	//function is used to generate random text
//	//a random seed is generated from text. This seed is used to find
//	//the next NGram seeds in text and append them to the list.
//	//random NGram seeds are generated from the list and appended to the output string
//	//to produce random text
//	public String generateText(int length) {
//		NGram seed = text.get(rand.nextInt(text.size()));
//		String output = "";
//		for(int i=0; i<length;i++){
//			ArrayList<NGram> state = new ArrayList<NGram>();
//			for(int j=0; j<text.size()-1;j++){
//				if (seed.equals(text.get(j))){
//					NGram val = text.get(j+1);
//					state.add(val);
//				}
//			}
//			NGram rando = state.get(rand.nextInt(state.size()));
//			seed = rando;
//			System.out.println(output);
//			output = output + rando;
//			state.clear();
//		}
//		
//		return output;
//	}
//
//		
//
//
//}
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BruteGenerator implements TextGenerator{
	
	TrainingText text;
	Random rand;
	
	public BruteGenerator(){
		rand = new Random();
	}
	public BruteGenerator(int n){
		rand = new Random(n);
	}

	@Override
	public int train(Scanner source, String delimiter, int k) {
		text = new TrainingText(source, delimiter, k);
		return text.size();
	}

	@Override
	public String generateText(int length) {
		int start = rand.nextInt(text.size());
		NGram seed = text.get(start);
		String output = "";		
		ArrayList<NGram> master = new ArrayList<NGram>();

		for(int i = 0; i<length;i++){
			for(int j = 0;j<text.size(); j++){
				if(j+1<text.size()){
					if(seed.equals(text.get(j))){
						System.out.println(output);
						master.add(text.get(j+1));
					}

				}

			}

			int tempI = rand.nextInt(master.size());
			seed = master.get(tempI);
			output = output + seed.toString();
			master.clear();
		}
		System.out.println("");
		System.out.print("b");


		return output;
	}

	

}


