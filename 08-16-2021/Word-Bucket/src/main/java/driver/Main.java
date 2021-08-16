package driver;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		bucketize("she sells sea shells by the sea", 10);
		bucketize("the mouse jumped over the cheese", 7);
		bucketize("fairy dust coated the air", 20);
		bucketize("a b c d e", 2);
		bucketize("this is a potato that is big", 5);
	}
	
	public static void bucketize(String phrase, int n) {
		List<String> bucket = new ArrayList<String>();
		
		int len = phrase.length();
		int start = 0;
		int end = 0;
		
		while (end < len) {
			if (start + n >= len) {
				// Final chunk of phrase
				String bkt = phrase.substring(start, len);
				bkt = bkt.trim();
				bucket.add(bkt);
				start = end = len;
			} else {
				end = start + n;
				// Search from back to front for a space character
				while (end > start && phrase.charAt(end) != ' ') {
					end--;
				}

				if (end == start) {
					// Word is too big, move to start of next word
					int space = phrase.substring(start).indexOf(' ');
					start += space;
				} else {
					// Found a bucket to add to the array
					String bkt = phrase.substring(start, end);
					bkt = bkt.trim();
					bucket.add(bkt);
					start = end + 1;
				}
			}
		}
		
		System.out.println(bucket);
	}
}
