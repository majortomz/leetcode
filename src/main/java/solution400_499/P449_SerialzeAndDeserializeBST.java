package solution400_499;

import java.util.Arrays;

/**
 * Created by zjw on 2018/02/01 15:23
 * Description:
 */
public class P449_SerialzeAndDeserializeBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Codec {


        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            // System.out.println(preOrder(root) + ";" + midOrder(root));
            return preOrder(root) + ";" + midOrder(root);
        }

        private String preOrder(TreeNode root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            if (root.left != null) {
                sb.append(preOrder(root.left));
                sb.append("#");
            }
            sb.append(root.val);
            if (root.right != null) {
                sb.append("#");
                sb.append(preOrder(root.right));
            }
            return sb.toString();
        }

        private String midOrder(TreeNode root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            sb.append(root.val);
            if (root.left != null) {
                sb.append("#");
                sb.append(midOrder(root.left));
            }
            if (root.right != null) {
                sb.append("#");
                sb.append(midOrder(root.right));
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0 || data.split(";").length == 0) {
                return null;
            }
            String[] splits = data.split(";");
            String[] preSplits = splits[0].split("#"), midSplits = splits[1].split("#");
            int[] pres = new int[preSplits.length], mids = new int[midSplits.length];
            for (int i = 0; i < pres.length; i++) {
                pres[i] = Integer.valueOf(preSplits[i]);
                mids[i] = Integer.valueOf(midSplits[i]);
            }
            // System.out.println(Arrays.toString(pres) + " " + Arrays.toString(mids));
            return helper(pres, mids, 0, pres.length - 1, 0, mids.length - 1);
        }

        private TreeNode helper(int[] pres, int[] mids, int ps, int pe, int ms, int me) {
            if (ps > pe || ms > me) {
                return null;
            }
            TreeNode root = new TreeNode(mids[ms]);
            int p = Arrays.binarySearch(pres, ps, pe + 1, mids[ms]);
            int lenLeft = p - ps;
            root.left = helper(pres, mids, ps, p - 1, ms + 1, ms + lenLeft);
            root.right = helper(pres, mids, p + 1, pe, ms + lenLeft + 1, me);
            return root;
        }
    }

}
