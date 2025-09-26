package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class DesignFoodRatingSystemTest {
	@Test
	/* Input
 		 ["FoodRatings", "highestRated", "highestRated", "changeRating", 
 		 "highestRated", "changeRating", "highestRated"]
 		 [[["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", 
 		 "japanese", "japanese", "greek", "japanese", "korean"], 
 		 [9, 12, 8, 15, 14, 7]], ["korean"], ["japanese"], ["sushi", 16], 
 		 ["japanese"], ["ramen", 16], ["japanese"]]
 		 Output
 		 [null, "kimchi", "ramen", null, "sushi", null, "ramen"] 
	*/
	public void test1() {
		DesignFoodRatingSystem task = new DesignFoodRatingSystem();
		DesignFoodRatingSystem.FoodRatings foodRatings = 
			task.new FoodRatings(
				new String[] {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"}, 
				new String[] {"korean", "japanese", "japanese", "greek", "japanese", "korean"}, 
				new int[] {9, 12, 8, 15, 14, 7});
		String result1 = foodRatings.highestRated("korean");
		assertNotNull(result1);
		assertEquals("kimchi", result1);
		String result2 = foodRatings.highestRated("japanese");
		assertNotNull(result2);
		assertEquals("ramen", result2);
		foodRatings.changeRating("sushi", 16);
		String result3 = foodRatings.highestRated("japanese");
		assertNotNull(result3);
		assertEquals("sushi", result3);
		foodRatings.changeRating("ramen", 16);
		String result4 = foodRatings.highestRated("japanese");
		assertNotNull(result4);
		assertEquals("ramen", result4);
	}
}
