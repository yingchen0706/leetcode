/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    class SortInterval implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new SortInterval());
        LinkedList<Interval> stack = new LinkedList<>();
        List<Interval> res = new LinkedList<>();
        
        for (Interval elem: intervals) {
            stack.add(elem);
        }
        
        while (!stack.isEmpty()) {
            Interval first = stack.pop();
            Interval top = stack.peek();
            if (top == null) {
                res.add(first);
                break;
            }
            if (first.end <=top.end && first.end >= top.start) {
                top.start = first.start;
            } else if (first.end > top.end) {
                top.start = first.start;
                top.end = first.end;
            } else {
                res.add(first);
            }
        }
        return res;
    }
}
