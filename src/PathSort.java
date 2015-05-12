import java.util.ArrayList;
import java.util.Collections;

public class PathSort {
	public String[] sortPath(String[] dire) {
		ArrayList<String> dire1 = new ArrayList<String>();
		for(String s : dire){
			dire1.add(s);
		}
		String[] retval = new String[dire1.size()];
		int idx = 0;
		while(dire1.size() != 0){
			
			for(int i = 1;i<=50;i++){
				ArrayList<String> delete = new ArrayList<String>();
				for(String s : dire1){
					int tempcount = 0;
					for(int j = 0;j<s.length();j++){
						if(s.charAt(j)=='/'){
							tempcount++;
						}
					}
					if(tempcount == i){
						delete.add(s);
					}
				}
				Collections.sort(delete);
//				for(String s: delete){
//					System.out.println(s);
//				}
				for(String s:delete){
					retval[idx] = s;
					idx++;
					dire1.remove(s);
				}
			}
			

		}
		return retval;
	}
	public static void main(String[] args){
		String[] dire = new String[]{"/","/a/","/b/","/c/","/d/","/e/","/f/","/g/","/a/a/","/g/t/h/","/g/f/"};
		PathSort myTest = new PathSort();
		dire = myTest.sortPath(dire);
		for(String s:dire){
			System.out.println(s);
		}
	}
}