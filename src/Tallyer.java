import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * The Tallyer class provides functionality for reading ID and topic pairs from user input,
 * and tallying the number of occurrences of each topic.
 */
public class Tallyer {

    /**
     * The main method serves as the entry point for the program. It reads pairs of IDs and topics
     * from standard input, stores them in lists, and then calculates the number of occurrences
     * of each topic. The IDs and topics are guaranteed to not include internal whitespace.
     *
     * @param args command-line arguments (not used in this implementation)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<String> ids = new ArrayList<>();
        List<String> topics = new ArrayList<>();
        
        // Reading input for IDs and topics
        // Assumes file is well formed into pairs
        while (input.hasNext()) {
            ids.add(input.next());
            topics.add(input.next());
        }
        input.close();
        
        // Wave 1
        Map<String, Integer> topicCounts = tallyTopics(topics);
        System.out.println("Here are how many times each topic appears (unfiltered):");
        System.out.println(topicCounts);

        // Wave 2
        Map<String, Integer> topicCountsFiltered = tallyTopicsFiltered(ids, topics);
        System.out.println("Here are how many times each topic appears (filtered):");
        System.out.println(topicCountsFiltered);
    }

    /**
     * Tally the occurrences of each topic from the provided lists of IDs and topics.
     * This method takes two lists, one of IDs and one of topics, and returns a map
     * where each topic is associated with the number of times it appears in the input.
     *
     * @param ids a list of strings representing IDs associated with each topic
     * @param topics a list of strings representing the topics to be tallied
     * @return a map containing topics as keys and their occurrence counts as values
     */
    public static Map<String, Integer> tallyTopics(List<String> topics) {
        // WAVE 1
        // TODO: Remove the print statements and implement this method
       Map<String, Integer> topicCount = new HashMap<>();
        for (String topic : topics) {
            if (!topicCount.containsKey(topic)) {
                topicCount.put(topic, 1);
            }
            else {
                int currentCount = topicCount.get(topic);
                int newCount = currentCount + 1;
                topicCount.put(topic, newCount);
             }
           }
                return topicCount;
     }

    /**
     * Tally the occurrences of each topic from the provided lists of IDs and topics.
     * This method takes two lists, one of IDs and one of topics, and returns a map
     * where each topic is associated with the number of times it appears in the input.
     * However, any user who did not enter exactly 2 topics should not have their votes counted.
     *
     * @param ids a list of strings representing IDs associated with each topic
     * @param topics a list of strings representing the topics to be tallied
     * @return a map containing topics as keys and their occurrence counts as values
     */
    public static Map<String, Integer> tallyTopicsFiltered(List<String> ids, List<String> topics) {
      // WAVE 2
      // TODO: Implement this method
    Map<String, Integer> topicCount = new HashMap<>();
    Map<String, Integer> voteCount = new HashMap<>(); 
      
        for (String id : ids) {
            if (!voteCount.containsKey(id)) {
                voteCount.put(id, 1);
            }
            else {
                int currentCount = voteCount.get(id);
                int newCount = currentCount + 1;
                voteCount.put(id, newCount);
            }
        }
        

        
        if (voteCount.equals(2)) {
                for(String topic : topics){
                    if (!topicCount.containsKey(topic)) {
                        topicCount.put(topic, 1);
                    }
                    else {
                        int currentCount = topicCount.get(topic);
                        int newCount = currentCount + 1;
                        topicCount.put(topic, newCount);
                    }
                }
            }
                    
        
        return topicCount;
  }
}
