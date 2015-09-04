public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
  List<Interval> list = new ArrayList<Interval>();
  int n = intervals.size();
  if (n==0) {
      list.add(newInterval);
      return list;
  }
  int i = 0;
  while (i<n && intervals.get(i).end<newInterval.start)
      list.add(intervals.get(i++));
  if (i<n)    
      newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
  list.add(newInterval);
  while (i<n && intervals.get(i).start<=newInterval.end)
      newInterval.end = Math.max(newInterval.end, intervals.get(i++).end);
  while (i<n)
      list.add(intervals.get(i++));
  return list;
}
