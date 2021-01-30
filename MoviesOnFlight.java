// Returns an ARRAY OF INDICES AND NOT THE ACTUAL VALUE

class Solution {
	class pair {
		int lo, hi;
		pair(int lo, int hi) {
			this.lo = lo;
			this.hi = hi;
		}
	}
	public int[] moviesOnFlight(List<Integer> movieDurations, int d) {
		int time = d - 30;
		Map<Integer, Integer> originalOrder = new HashMap();
		for (int i = 0; i < movieDurations.size(); i++) {
			originalOrder.put(movieDurations.get(i), i);
		}
		Collections.sort(movieDurations);
		if (movieDurations.size() < 2 || movieDurations.get(0) + movieDurations.get(1) > time) {
			return new int[0];
		}
		Map<Integer, List<pair>> map = new HashMap();
		int max = 0;
		int lo = 0, hi = movieDurations.size() - 1;
		while (lo < hi) {
			if (movieDurations.get(lo) + movieDurations.get(hi) > time) {
				hi--;
			} else {
				int curTime = movieDurations.get(lo) + movieDurations.get(hi);
				if (curTime >= max) {
					if (curTime > max) {
						max = curTime;
						map.put(curTime, new ArrayList());
					}
					map.get(max).add(new pair(lo, hi));
				}
				lo++;
			}
		}
		List<pair> maxtime = map.get(max);
		max = 0;
		int[] res = new int[2];
		for (pair p : maxtime) {
			int temp = Math.max(movieDurations.get(p.lo), movieDurations.get(p.hi));
			if (temp > max) {
                max = temp;
				int index1 = originalOrder.get(movieDurations.get(p.lo));
				int index2 = originalOrder.get(movieDurations.get(p.hi));
				res[0] = (index1 > index2) ? index2 : index1;
				res[1] = index1 + index2 - res[0];
			}
		}
		return res;
	}
	public static void main(String[] args) {
		List<Integer> movieDurations = new ArrayList();
        movieDurations.add(90);
        movieDurations.add(85);
        movieDurations.add(75);
        movieDurations.add(60);
        movieDurations.add(120);
        movieDurations.add(150);
        movieDurations.add(125);
		int d = 250;
		Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.moviesOnFlight(movieDurations, d)));
	}
}