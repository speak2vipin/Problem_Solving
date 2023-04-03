class Solution {
    public int numRescueBoats(int[] people, int limit) {
        /*
		int temp[] = new int[limit + 1];
		for (int weight : people) {
			temp[weight] = temp[weight] + 1;
		}
		int count = 0;
		int tempWeight = 0;
		int tempLimit = 0;
		int index = limit;
		while (index > 0) {
			tempLimit = limit;
			tempWeight = index;
			if (temp[tempWeight] <= 0) {
				index--;
			} else {
				count++;
				temp[tempWeight]--;
				tempLimit = tempLimit - tempWeight;
				tempWeight = tempLimit;
				while (tempWeight > 0) {
					if (temp[tempWeight] > 0) {
						temp[tempWeight]--;
						break;
					} else {
						tempWeight--;
					}
				}
			}
		}
		return count;
    }*/
        
        Arrays.sort(people);
        int i=0, j= people.length-1;
        int ans = 0;
        
        while(i<=j) {
            ans++;
            if(people[i]+people[j]<=limit) {
                i++;
            }
            j--;
        }
        return ans;
    }
}