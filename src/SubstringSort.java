import java.util.ArrayList;
import java.util.Collections;

public class SubstringSort {
	public String[] sortSubstrings(String[] wordList) {
		if(wordList.length == 2){
			if(wordList[0].length()>wordList[1].length()){
				String zero = wordList[0];
				String one = wordList[1];
				wordList[0] = one;
				wordList[1] = zero;
				return wordList;
			}
			else{
				return wordList;
			}
		}
		int size = wordList.length;
		String vowels = "aeiou";
		String[] split = new String[size];
		int index = 0;
		for(String s : wordList){
			ArrayList<String> adder = new ArrayList<String>();
			int starter = 0;
			for(int i =0;i<s.length();i++){
				if(i!=s.length()-1){
					if(vowels.contains(s.substring(i, i+1)) && !vowels.contains(s.substring(i+1, i+2)) && i!=s.length()-1){
						adder.add(s.substring(starter,i+1));
						starter = i+1;
					}
				}
				if(i == s.length()-1){
					adder.add(s.substring(starter));
				}
			}
			Collections.sort(adder);
			String combined = "";
			for(String st : adder){
				combined+=st;
			}
			split[index] = combined;
			index++;
		}
		ArrayList<String> sorted = new ArrayList<String>();
		while(sorted.size()!=size){
			int first = 0;
			for(int i = 0;i<split.length;i++){
				if(i==0){
					first = i;
				}
				if(split[first].compareTo(split[i])>0){
					first = i;
				}
				if(split[first].equals(split[i])){
					if(wordList[first].compareTo(wordList[i])>1){
						first = i;
					}
				}

			}
			sorted.add(wordList[first]);
			split[first] = "zzzzzzzzzzzzzzzzzzzzzzz";

		}
		String[] retval = new String[sorted.size()];
		for(int i = 0;i<sorted.size();i++){
			retval[i] = sorted.get(i);
		}
		return retval;
	}
	public static void main(String[] args){
		SubstringSort myTest = new SubstringSort();
		String[] wordList = new String[]{"badne", "baarne" };
		wordList = myTest.sortSubstrings(wordList);
		for(String s: wordList){
			System.out.println(s);
		}
	}
}