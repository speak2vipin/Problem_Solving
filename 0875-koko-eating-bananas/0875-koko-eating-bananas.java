class Solution {
    public int minEatingSpeed(int[] piles, int h) {
		long low = 1;
		long high = piles[0];
		for (int pile : piles) {
			high = Math.max(high, pile);
		}
		long ans = 0;
		while (low <= high) {
			long mid = low + (high - low) / 2;
			if (isPossible(piles, mid, h)) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return (int) low;

	}

	boolean isPossible(int[] piles, long speed, int h) {
		long count = 0;
		for (int pile : piles) {
			count+=(pile/speed);
			if(pile%speed != 0) {
				count++;
			}
		}
		return count > h;
	}
}