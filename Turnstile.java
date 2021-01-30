
public class Turnstile {


public static int[] getTimes(int numCustomers, int[] arrTime, int[] direction) {
        Queue<int[]> in = new LinkedList<>(), out = new LinkedList<>();
//        0: time, 1: idx
        for (int i = 0; i < arrTime.length; i++) {
            int time = arrTime[i], dir = direction[i];
            if (dir == 1) {
                out.add(new int[]{time, i});
            } else {
                in.add(new int[]{time, i});
            }
        }
        int[] times = new int[arrTime.length];
        int pre = 1, time = 0;
        while (!in.isEmpty() || !out.isEmpty()) {
            boolean hasIn = !in.isEmpty() && in.peek()[0] <= time;
            boolean hasOut = !out.isEmpty() && out.peek()[0] <= time;
            if (hasIn && hasOut) {
                if (pre == 1) {
//                    Let the person out
                    times[out.poll()[1]] = time;
                } else {
                    times[in.poll()[1]] = time;
                }
            } else if (hasIn) {
                times[in.poll()[1]] = time;
                pre = 0;
            } else if (hasOut) {
                times[out.poll()[1]] = time;
                pre = 1;
            } else {
                pre = 1;
            }
            time++;
        }
        return times;
    }
	
	public static void main(String[] args) {
        System.out.println("Solution 1");
        System.out.println(Arrays.toString(getTimes(new int[]{0, 0, 1, 5}, new int[]{0, 1, 1, 0})));
        System.out.println(Arrays.toString(getTimes(new int[]{1, 2, 4}, new int[]{0, 1, 1})));
        System.out.println(Arrays.toString(getTimes(new int[]{1, 1}, new int[]{1, 1})));
        System.out.println(Arrays.toString(getTimes(new int[]{1, 1, 3, 3, 4, 5, 6, 7, 7}, new int[]{1, 1, 0, 0, 0, 1, 1, 1, 1})));

    }
	
	}