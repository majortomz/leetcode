package solution300_399;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by zjw on 2018/01/18 14:18
 * Description:
 */
public class P355_DesignTwitter {

    class Twitter {

        Map<Integer, Set<Integer>> followMap;
        Map<Integer, List<int[]>> tweetMap;
        int count = 0;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            tweetMap = new HashMap<>();
            followMap = new HashMap<>();
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            System.out.println(tweetMap.putIfAbsent(userId, new ArrayList<>()));
            tweetMap.get(userId).add(0, new int[]{tweetId, count++});
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed.
         * Each item in the news feed must be posted by users who the user followed or by the user herself.
         * Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            List<int[]> result = new ArrayList<>();
            result.addAll(tweetMap.getOrDefault(userId, new ArrayList<>()));
            for (Integer followeeId : followMap.getOrDefault(userId, new HashSet<>())) {
                result.addAll(tweetMap.getOrDefault(followeeId, new ArrayList<>()));
            }
            result.sort((x, y) -> (y[1] - x[1]));
            return result.stream().limit(10).map(x -> x[0]).collect(Collectors.toCollection(ArrayList::new));
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            if (followerId != followeeId) {
                followMap.putIfAbsent(followerId, new HashSet<>());
                followMap.get(followerId).add(followeeId);
            }

        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            if (followMap.containsKey(followerId)) {
                followMap.get(followerId).remove(followeeId);
            }
        }

    }

    public static void main(String[] args) {
        Twitter twitter = new P355_DesignTwitter().new Twitter();
        twitter.postTweet(1, 5);
    }
}
