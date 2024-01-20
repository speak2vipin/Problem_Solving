class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000_000_007;
        int n = arr.length;
        //int left[] = leftNextLesser(arr);
        //int right[] = rightNextGreater(arr);
        long total = 0;
        for(int i=0; i<n; i++) {
            int li = i-1;
            long c1 = 0;
            while(li>-1 && arr[li]>=arr[i]) {
                c1++;
                li--;
            }
            int ri = i+1;
            long c2 =0;
            while(ri<n && arr[i]<arr[ri]) {
                c2++;
                ri++;
            }
           // System.out.println(c1 + " " + c2 + " " + arr[i]);
            total = (total + ((((c1+1)*(c2+1))%mod) * arr[i])%mod)%mod;
        }
        return (int)total;
        
    }
    
    int[] leftNextLesser(int arr[]) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int index[] = new int[n];
        
        for(int i=0; i<n; i++) {
            if(st.isEmpty()) {
                index[i] = 0;
            } else {
                while(!st.isEmpty() && arr[st.peek()]>arr[i]) {
                    st.pop();
                }
                if(st.isEmpty()) {
                    index[i] = i;
                } else {
                    index[i] = i-st.peek();
                }
            }
            st.push(i);
            System.out.println(index[i]);
        }
        return index;
    }
    
    int[] rightNextGreater(int arr[]) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int index[] = new int[n];
        
        for(int i=n-1; i>-1; i--) {
            if(st.isEmpty()) {
                index[i] = 0;
            } else {
                while(!st.isEmpty() && arr[st.peek()]<=arr[i]) {
                    st.pop();
                }
                if(st.isEmpty()) {
                    index[i] = n-1-i;
                } else {
                    index[i] = st.peek()-i-1;
                }
            }
            st.push(i);
        }
        return index;
    }
}