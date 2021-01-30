// Most Common word - LeetCode 819

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
      HashSet<String> bannedWords = new HashSet<>();
        for(String word: banned){
            bannedWords.add(word);
        }
        HashMap<String,Integer> counts = new HashMap<>();
        // replace all the non characters by string, convert lower to upper and split them
        for(String word: paragraph.replaceAll("[^a-zA-Z]"," ").toLowerCase().split(" ")){
            if(!bannedWords.contains(word)){
              counts.put(word,counts.getOrDefault(word,0)+1);   
            }
        }
        
    String result = "";
    for(String key: counts.keySet()){
        if(result.equals("") || counts.get(key)>counts.get(result)){
            result = key;
        }
    }
    return result;
    }
}