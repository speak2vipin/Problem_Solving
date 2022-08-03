class MyCalendar {
    List<int[]> hours;
    public MyCalendar() {
       hours = new ArrayList<int[]>();
    }
    
    public boolean book(int start, int end) {
        for(int[] i : hours) {
            if(i[0]>=end || i[1]<=start) {
                continue;
            } else {
                return false;
            }
        }
        int temp[] = {start, end};
        hours.add(temp);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */