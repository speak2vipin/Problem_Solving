class FoodRatings {
    Map<String, PriorityQueue<Object[]>> cuisinesFoodMap = null;
	Map<String, String> foodsCuisinesMap = null;
	Map<String, Integer> foodsRatingsMap = null;

	public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
		cuisinesFoodMap = new HashMap<>();
		foodsCuisinesMap = new HashMap<>();
		foodsRatingsMap = new HashMap<>();

		int n = foods.length;
		for (int i = 0; i < n; i++) {
			foodsCuisinesMap.put(foods[i], cuisines[i]);
			foodsRatingsMap.put(foods[i], ratings[i]);
			cuisinesFoodMap
					.computeIfAbsent(cuisines[i],
							val -> 
            new PriorityQueue<Object[]>(
                (x, y) -> ((Integer) x[0]).compareTo((Integer) y[0]) == 0
									? (((String) x[1]).compareTo((String) y[1]))
									: ((Integer) y[0]).compareTo((Integer) x[0])))

					.offer(new Object[] { ratings[i], foods[i] });
		}
	}

	public void changeRating(String food, int newRating) {
		String cuisine = foodsCuisinesMap.get(food);
		cuisinesFoodMap.get(cuisine).offer(new Object[] { newRating, food });
		foodsRatingsMap.put(food, newRating);
	}

	public String highestRated(String cuisine) {
		Object[] top = cuisinesFoodMap.get(cuisine).peek();
		while (foodsRatingsMap.get(top[1]).compareTo((Integer)top[0])!=0) {
			cuisinesFoodMap.get(cuisine).poll();
			top = cuisinesFoodMap.get(cuisine).peek();
		}
		return (String) top[1];
	}
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */