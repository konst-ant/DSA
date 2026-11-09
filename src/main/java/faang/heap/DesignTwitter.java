package faang.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * LC 355: Design Twitter.
 * Supports posting tweets, following/unfollowing users, and retrieving the 10 most
 * recent tweets from a user and the people they follow via a heap merge.
 */
public class DesignTwitter {

    private int timestamp = 0;
    private final Map<Integer, List<Tweet>> userTweets = new HashMap<>();
    private final Map<Integer, Set<Integer>> following = new HashMap<>();

    public void postTweet(int userId, int tweetId) {
        userTweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Set<Integer> people = new HashSet<>(following.getOrDefault(userId, new HashSet<>()));
        people.add(userId);

        for (int person : people) {
            List<Tweet> tweets = userTweets.get(person);
            if (tweets == null) {
                continue;
            }
            int idx = tweets.size() - 1;
            if (idx >= 0) {
                Tweet t = tweets.get(idx);
                heap.offer(new int[]{t.time, t.id, person, idx});
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!heap.isEmpty() && result.size() < 10) {
            int[] top = heap.poll();
            result.add(top[1]);
            int person = top[2];
            int idx = top[3] - 1;
            if (idx >= 0) {
                Tweet t = userTweets.get(person).get(idx);
                heap.offer(new int[]{t.time, t.id, person, idx});
            }
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = following.get(followerId);
        if (set != null) {
            set.remove(followeeId);
        }
    }

    private static class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        DesignTwitter twitter = new DesignTwitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }
}
