package Array;

import java.util.Collections;

/**
 * Created by yu7rin on 7/26/2018.
 */
public class MergeIntervals_56 {
    /*做题目需要仔细分析题目 分析后可以得出如果list时按照intervals的start顺序排布
    * 那么当 pre interval end > post interval end时则两interval重叠
    * 由于题目并没有给出list内有序 所以我们自己排个序 不排序的话判断重叠逻辑就会很复杂
    * 所以以后涉及到前后大小判断最好都先排个序
    * */
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null) return null;



        Collections.sort(intervals, (Interval o1, Interval o2) -> o1.start - o2.start);
        for(int i = 1 ; i < intervals.size();) {
            if(intervals.get(i - 1).end >= intervals.get(i).start) {

                intervals.get(i - 1).end = Math.max(intervals.get(i - 1).end ,intervals.get(i).end);

                intervals.remove(i);
            }else {
                i++;
            }
        }
        return intervals;
    }
}
