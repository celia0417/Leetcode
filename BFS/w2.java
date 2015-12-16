package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class w2 {
	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		String s;
//		while ((s = in.readLine()) != null) {
		String s= "Three apples | my 3 apples";
			PassageFilter passageFilter = new PassageFilter();
			passageFilter.filter(s);
			System.out.println(passageFilter.getFormattedOutput());
//		}
	}

	/**
	 * The class PassageFilter provides methods to filter passages from a raw
	 * input text and stores a list of filtered passages.
	 * 
	 * @author John
	 *
	 */
	private static class PassageFilter {

		private final List<String> outputPassages;

		public PassageFilter() {
			this.outputPassages = new ArrayList<String>();
		}

		public void filter(String rawInput) {
			String[] passages = rawInput.split("\\|");

			for (String thisPass : passages) {
				String thisNormed = normalize(thisPass);
				boolean filt = false;
				for (int i = 0; i < outputPassages.size(); i++) {
					String existingPass = outputPassages.get(i);
					String existingNormed = normalize(existingPass);
					if (thisNormed.equals(existingNormed)) {
						int ldiff = thisPass.length() - existingPass.length();
						if (ldiff >= 0) {
							filt = true;
							break;
						} else
							outputPassages.remove(i--);
					}else if(existingNormed.contains(thisNormed)){
					    filt = true;
						break;
					}else if (thisNormed.contains(existingNormed)){
					      outputPassages.remove(i--);   
					} else if (existingNormed.contains(thisPass)) {
						filt = true;
						break;
					}
				}
				if (!filt)
					outputPassages.add(thisPass);
			}
		}

		private String normalize(String passage) {
		    String str = " "
					+ passage.trim().replaceAll("\\s+", " ").replace(".", "")
							.replace(';', ',').toLowerCase() + " ";
		    if (str.contains("one")){
		        str = str.replaceAll("one", "1");
		    } else if (str.contains("two")){
		        str = str.replaceAll("two", "2");
		    } else if (str.contains("three")){
		        str = str.replaceAll("three", "3");
		    } else if (str.contains("four")){
		        str = str.replaceAll("four", "4");
		    } else if (passage.contains("five")){
		        str = str.replaceAll("five", "5");
		    }
		    
			return str;
		}

		public String getFormattedOutput() {
			boolean first = true;
			StringBuilder sb = new StringBuilder();
			for (String op : outputPassages) {
				if (!first)
					sb.append('|');
				first = false;
				sb.append(op);
			}
			return sb.toString();
		}

	}
}
