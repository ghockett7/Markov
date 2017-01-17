import java.util.Arrays;
import java.util.List;
//you store a list of ngrams as the value for a given NGram. Then you choose one at random, and take the last character.
//you account for probability by adding repetitive values to the list. 

public class NGram implements Comparable<NGram> {
	// this first
	// an array of strings that contains the previous characters
	private String[] contents;
	private String separator;
	public NGram(List<String> source, String sep) {
		separator = sep;
		contents = new String[source.size()];
		contents = Arrays.copyOf(source.toArray(new String[source.size()]),
				source.size());
	}
	public int compareTo(NGram other) {
		// do this third
		// loop over words
		// use string compareTo
		// if you everything is the same until the end of one of the Ngrams,
		// then return the difference in length
		// of the Ngrams
		// TODO: complete compareTo per the specifications defined by Comparable
		// and the assignment.
		NGram og = (NGram) other;
		int count = 0;
		if (this.contents.length >= other.contents.length) {
			count = other.contents.length;
		} else {
			count = this.contents.length;
		}

		for (int i = 0; i < count; i++) {
			if (this.contents[i].compareTo(og.contents[i]) != 0) {
				return this.contents[i].compareTo(og.contents[i]);
			}
		}
		if (this.contents.length == og.contents.length) {
			return 0;
		} else {
			return this.contents.length - og.contents.length;
		}
	}
	public boolean equals(Object o) {
		// do this second
		// make sure that o is an Ngram
		// if o.instanceof(Ngram) then continue\
		// make sure they have the same length
		// loop over the words in the ngram and make sure that they are all the
		// same
		// if all of these conditions are true, then you return true, else
		// return false
		// TODO: complete equals per the specifications defined by the Object
		// class and the assignment.
		if (o instanceof NGram) {
			NGram other = (NGram) o;
			if (this.contents.length == other.contents.length)
				;
			{
				if (Arrays.equals(this.contents, other.contents)) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	public int hashCode() {
		// do this fourth
		// loop over words
		// sum the hash codes
		// use built in string hashcode
		// if you have the same words in a different order, it will return the
		// same hashcode. You could multiply
		// the hashcodes by the word index in order to minimize collisions and
		// then sum
		// TODO: define a hashCode function which minimizes the number of
		// collisions of NGrams in a HashMap or Set.
		int hashSum = 1;
		for (int i = 0; i < this.contents.length; i++) {
			hashSum *= i+this.contents[i].hashCode(); //i+
		}
		return hashSum;
	}

	public String toString() {
		// do this first
		// want last element of list/array
		// TODO: create a String representation of an NGram based on the
		return contents[contents.length - 1] + separator;
	}
}