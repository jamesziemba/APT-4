import java.util.HashMap;

public class CountSort {
	static String alpha = "abcdefghijklmnopqrstuvwxyz";
	static String[] input;
	public String[] countSorter(String[] wordList) {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(String s : wordList){
			if(map.get(s)==null){
				map.put(s, 0);
			}
			map.put(s, map.get(s)+1);
		}
		String[] retval = new String[map.keySet().size()];
		int index = 0;
		while(map.keySet().size()!=0){
			int maxnumber = 0;
			String maxword = "";
			for(String s : map.keySet()){
				if(map.get(s)>maxnumber){
					maxnumber = map.get(s);
					maxword = s;
				}
				else{
					if(map.get(s)==maxnumber){
						if(alpha.indexOf(s.charAt(0))<alpha.indexOf(maxword.charAt(0))){
							maxnumber = map.get(s);
							maxword = s;
						}
						if(s.charAt(0)==maxword.charAt(0)){

							if(alpha.indexOf(s.charAt(1))<alpha.indexOf(maxword.charAt(1))){
								maxnumber = map.get(s);
								maxword = s;
							}
						}

					}
				}
				
			}
			retval[index] = maxword;
			index++;
			map.remove(maxword);
		}
		return retval;
	}
	public static void main(String[] args){
		input = new String[]{"blah","blah","blah"};
		CountSort myTest = new CountSort();
		String[] vals = new String[input.length];
		vals = myTest.countSorter(new String[]{"blah","blah","blah"});
		for(String s : vals){
			System.out.println(s);
		}
	}
}