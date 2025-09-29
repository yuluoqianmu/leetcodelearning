package com.shml.leetcode.page700_750;

/**
 * 一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。
 * 给你一个二维数组 classes ，其中 classes[i] = [passi, totali] ，
 * 表示你提前知道了第 i 个班级总共有 totali 个学生，其中只有 passi 个学生可以通过考试。
 * 给你一个整数 extraStudents ，表示额外有 extraStudents 个聪明的学生，他们 一定 能通过任何班级的期末考。
 * 你需要给这 extraStudents 个学生每人都安排一个班级，使得 所有 班级的 平均 通过率 最大 。
 * 一个班级的 通过率 等于这个班级通过考试的学生人数除以这个班级的总人数。平均通过率 是所有班级的通过率之和除以班级数目。
 * 请你返回在安排这 extraStudents 个学生去对应班级后的 最大 平均通过率。
 * 与标准答案误差范围在 10-5 以内的结果都会视为正确结果。
 *
 * 输入：classes = [[1,2],[3,5],[2,2]], extraStudents = 2
 * 输出：0.78333
 * 解释：你可以将额外的两个学生都安排到第一个班级，平均通过率为 (3/4 + 3/5 + 2/2) / 3 = 0.78333 。
 */
public class Test {
    public static void main(String[] args) {

    }

    public double maxAvgPass(int[][] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        double maxAvg = 0.0;
        double[] maxpass = new double[n];
        for (int i = 0; i < n; i++) {
            double mxTmp = 0.0;
            int j = 0;
            while (j < k) {
                mxTmp += Math.max(mxTmp, (nums[i][0] + j) / (nums[i][1] +j));
                j++;
            }
            maxpass[i] = mxTmp;
        }

        return maxAvg;
    }

}
