 public static List<String> getTopGames(int num, int topKGames, String[] games, int numReviews, String[] reviews) {
        Map<String, Integer> totalCount = new HashMap<>(), reviewsCount = new HashMap<>(), gameIdx = new HashMap<>();
//        0: total, 1: reviews count
        for (int i = 0; i < games.length; i++) {
            gameIdx.putIfAbsent(games[i].toLowerCase(), i);
        }
        analyzeReviews(reviews, gameIdx, totalCount, reviewsCount);
        Comparator<int[]> sort = (v1, v2) -> v1[1] == v2[1] ? Integer.compare(v1[2], v2[2]) : Integer.compare(v1[1], v2[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(sort);
//        0: idx, 1: total, 2: unique
        for (String game : totalCount.keySet()) {
            pq.add(new int[]{gameIdx.get(game), totalCount.get(game), reviewsCount.get(game)});
            if (pq.size() > topKGames) pq.poll();
        }
        LinkedList<String> result = new LinkedList<>();
        while (!pq.isEmpty()) {
            result.addFirst(games[pq.poll()[0]]);
        }
//        return pq.stream().map(val -> val[0]).map(idx -> games[idx]).collect(Collectors.toList());
//        return pq.stream().sorted(sort).map(val -> val[0]).map(idx -> games[idx]).collect(Collectors.toList());
        return result;
    }

    public static List<String> topMentioned(int topKGames, String[] games, String[] reviews) {
        Map<String, Integer> totalCount = new HashMap<>(), reviewsCount = new HashMap<>(), gameIdx = new HashMap<>();
//        0: total, 1: reviews count
        for (int i = 0; i < games.length; i++) {
            gameIdx.putIfAbsent(games[i].toLowerCase(), i);
        }
        analyzeReviews(reviews, gameIdx, totalCount, reviewsCount);
        Comparator<int[]> sort = (v1, v2) -> v1[1] == v2[1] ? Integer.compare(v1[2], v2[2]) : Integer.compare(v1[1], v2[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(sort);
//        0: idx, 1: total, 2: unique
        for (String game : totalCount.keySet()) {
            pq.add(new int[]{gameIdx.get(game), totalCount.get(game), reviewsCount.get(game)});
            if (pq.size() > topKGames) pq.poll();
        }
        LinkedList<String> result = new LinkedList<>();
        while (!pq.isEmpty()) {
            result.addFirst(games[pq.poll()[0]]);
        }
//        return pq.stream().map(val -> val[0]).map(idx -> games[idx]).collect(Collectors.toList());
//        return pq.stream().sorted(sort).map(val -> val[0]).map(idx -> games[idx]).collect(Collectors.toList());
        return result;
    }

    private static void analyzeReviews(String[]
                                               reviews, Map<String, Integer> games, Map<String, Integer> totalCount, Map<String, Integer> reviewsCount) {
        for (String review : reviews) {
            Set<String> curReviewGames = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < review.length(); i++) {
                char cur = review.charAt(i);
                if (Character.isAlphabetic(cur)) {
                    sb.append(Character.toLowerCase(cur));
                } else if (cur == ' ') {
                    String word = sb.toString();
                    sb = new StringBuilder();
                    if (games.containsKey(word)) {
//                        If the current word is a game word.
                        totalCount.put(word, totalCount.getOrDefault(word, 0) + 1);
                        if (curReviewGames.add(word)) {
                            reviewsCount.put(word, reviewsCount.getOrDefault(word, 0) + 1);
                        }
                    }
                }
            }
            String word = sb.toString();
            if (word.length() > 0 && games.containsKey(word)) {
//                        If the current word is a game word.
                totalCount.put(word, totalCount.getOrDefault(word, 0) + 1);
                if (curReviewGames.add(word)) {
                    reviewsCount.put(word, reviewsCount.getOrDefault(word, 0) + 1);
                }
            }
        }
    }