public static int maxProfit(int[] invetory, int order) {
            Integer[] b = new Integer[invetory.length];
            for (int i = 0; i < invetory.length; i++) {
                    b = invetory;
            }
            Arrays.sort(b, (o1,o2) -> o2-o1);
            Integer[] a = new Integer[invetory.length+1];
            for (int i = 0; i < invetory.length; i++) {
                    a = b;
            }
            a[invetory.length] = 0;
            int supIdx = 1;
            int maxPro = 0;
            while(order >= 0 && supIdx < a.length) {
                    while(supIdx < a.length && a[supIdx-1] == a[supIdx]) {
                            supIdx++;
                    }//move the pointer to the second largest number in the array and then we will know how many suppliers who have the largest inventory
                    if(a[supIdx-1] == 0) break;
                    int supMulti = supIdx;
                    int diff = a[supIdx-1] - a[supIdx];
                    int localCountToOrder = diff * supMulti;
                    localCountToOrder = Math.min(order, localCountToOrder);
                    order -= localCountToOrder;
                    int localPro = a[supIdx-1];
                    while(localCountToOrder > 0 && localPro >= a[supIdx]) {
                            int curCountToTake = Math.min(supMulti, localCountToOrder);
                            maxPro += localPro * curCountToTake;
                            localPro--;
                            localCountToOrder -= curCountToTake;
                    }
                    supIdx++;
            }
            return maxPro;
    }
