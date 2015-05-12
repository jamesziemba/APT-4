import java.util.ArrayList;
import java.util.HashMap;

public class OlympicSort {
	public String[] standings(String[] results) {
		HashMap<String,Integer[]> count = new HashMap<String,Integer[]>();
		for(String s : results){
			for(int j = 0;j<s.length();j++){
				if(j== 0){
					if(count.get(s.substring(0, 3))==null){
						count.put(s.substring(0, 3),new Integer[]{0,0,0});
					}
					count.get(s.substring(0, 3))[0]+=1;	
				}
				if(j== 4){
					if(count.get(s.substring(4, 7))==null){
						count.put(s.substring(4, 7),new Integer[]{0,0,0});
					}
					count.get(s.substring(4, 7))[1]+=1;	
				}
				if(j== 8){
					if(count.get(s.substring(8))==null){
						count.put(s.substring(8),new Integer[]{0,0,0});
					}
					count.get(s.substring(8))[2]+=1;	
				}
			}
		}
		HashMap<String,Integer> points = new HashMap<String,Integer>();
		for(String s : count.keySet()){
			points.put(s,count.get(s)[0]*1000+count.get(s)[1]*10+count.get(s)[2]);
		}
//		for(String s:points.keySet()){
//			System.out.println(s+ " "+points.get(s));
//		}
		String[] retval = new String[count.keySet().size()];
		int i =0;
		while(!points.isEmpty()){
			int max = 0;
			String compare = "";
			String addval = "";
			for(String s : points.keySet()){
				if(max ==0){
					max = points.get(s);
					compare = s;
					addval = s + " " + count.get(s)[0] + " " + count.get(s)[1] + " " + count.get(s)[2];
				}
				if(points.get(s)>max){
					max = points.get(s);
					compare = s;
					addval = s + " " + count.get(s)[0] + " " + count.get(s)[1] + " " + count.get(s)[2];
				}
				if(points.get(s)==max && s.charAt(0)<compare.charAt(0)){
					max = points.get(s);
					compare = s;
					addval = s + " " + count.get(s)[0] + " " + count.get(s)[1] + " " + count.get(s)[2];
				}
				if(points.get(s)==max && s.charAt(0)==compare.charAt(0) && s.charAt(1)<compare.charAt(1)){
					max = points.get(s);
					compare = s;
					addval = s + " " + count.get(s)[0] + " " + count.get(s)[1] + " " + count.get(s)[2];
				}
				if(points.get(s)==max && s.charAt(0)==compare.charAt(0) && s.charAt(1)==compare.charAt(1) && s.charAt(2)<compare.charAt(2)){
					max = points.get(s);
					compare = s;
					addval = s + " " + count.get(s)[0] + " " + count.get(s)[1] + " " + count.get(s)[2];
				}
				
			}
			points.remove(compare);
			retval[i] = addval;
			i++;
		}
//		for(String s:retval){
//			System.out.println(s);
//		}
		return retval;
	}
	public static void main(String[] args){
		String[] results = new String[]{"GER AUT USA", "AUT USA GER", "USA GER AUT"};
		OlympicSort myTest = new OlympicSort();
		System.out.println(myTest.standings(results));
	}

}
