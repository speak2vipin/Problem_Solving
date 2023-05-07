class FrequencyTracker {
    int freq[];
    int count[];
    
    public FrequencyTracker() {
        freq = new int[100001];
        count = new int[100001];;
    }
    
    public void add(int number) {
        
        if(freq[count[number]]>0) {
            freq[count[number]]--;
        }
        count[number]++;
        freq[count[number]]++;
    }
    
    public void deleteOne(int number) {
        if(count[number]>0) {
            freq[count[number]]--;
            count[number]--;
            if(count[number]>0) {
                 freq[count[number]]++;
            }
        }
    }
    
    public boolean hasFrequency(int frequency) {
       return freq[frequency]>0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */