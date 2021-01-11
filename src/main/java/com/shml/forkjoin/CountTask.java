package com.shml.forkjoin;

import java.util.ArrayList;
import java.util.concurrent.*;

public class CountTask extends RecursiveTask<Long> {

    private static final int THRESHOLD = 10000;
    private long start;
    private long end;

    public CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute) {
            for (long i=start; i<end; i++) {
                sum += i;
            }
        } else {
            //分成100个小任务
            long step = (start + end) / 100;
            ArrayList<CountTask> subTaskList = new ArrayList<>();
            long pos = start;
            for (int i=0; i<100; i++) {
                long lastOne = pos + step;
                if (lastOne > end) {
                    lastOne = end;
                }
                CountTask subTask = new CountTask(pos, lastOne);
                pos += step + 1;
                subTaskList.add(subTask);
                subTask.fork();
            }
            for (CountTask task : subTaskList) {
                sum += task.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(0, 200000L);
        ForkJoinTask<Long> result = forkJoinPool.submit(countTask);
        try {
            long res = result.get();
            System.out.println(res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
