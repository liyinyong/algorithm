package com.algorithm;

import java.util.Arrays;

/**
 * @author 71972
 * @date 2019/4/12
 */
public class Algorithm {
    public static void main(String[] args) {
        int[] array = {5, 3, 7, 4, 8, 2, 9, 6, 1};
        //Algorithm.selectSort(array);
        //Algorithm.insertSort(array);
        //Algorithm.shellSort(array);
        //Algorithm.bubbleSort(array);

        Algorithm.quickSort(array);
        System.out.println(Algorithm.binarySearch(array, 7, 0, array.length - 1));
    }

    /**
     * 选择排序，在乱序数组中，假设第一位数最小，依次让后面的数与之比较，若遇到比它小的数就交换位置，
     * 一趟下来第一个数就是序列中最小的数，然后从第二个数开始重复操作
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (temp > array[j]) {
                    array[i] = array[j];
                    array[j] = temp;
                    temp = array[i];
                }
            }
        }
        System.out.println(Arrays.toString(array) + "selectSort");
    }

    /**
     * 插入排序
     * 思路：如同玩扑克牌一样，每次摸牌都将它与手中的牌比较，始终将牌放在比它大的牌前面，
     * 比它小的牌后面。这样当牌全部摸到手上后，就是一个有序的序列
     * int[] array = {5, 3, 7, 4, 8, 2, 9, 6, 1};
     * 357482961
     * 357482961
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array) + "insertSort");
    }

    /**
     * shell排序
     * 希尔排序，也称递减增量排序算法，是插入排序的一种更高效的改进版本。希尔排序是非稳定排序算法。
     * 希尔排序是基于插入排序的以下两点性质而提出改进方法的：
     * 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率；
     * 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位。
     * 先取一个正整数d1 < n, 把所有相隔d1的记录放一组，每个组内进行直接插入排序；然后d2 < d1，重复上述分组和排序操作；直至di = 1，即所有记录放进一个组中排序为止。
     * int[] array = {5, 3, 7, 4, 8, 2, 9, 6, 1};
     */
    public static void shellSort(int[] array) {
        int temp;
        for (int r = array.length / 2; r >= 1; r = r / 2) {
            for (int i = r; i < array.length; i++) {
                temp = array[i];
                for (int j = i - r; j >= 0; j = j - r) {
                    if (temp < array[j]) {
                        array[j + r] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(array) + "shellSort");
    }

    private void sort(int[] array) {
        int temp;
        for (int r = array.length / 2; r >= 1; r = r / 2) {
            for (int i = r; i < array.length; i++) {
                temp = array[i];
                for (int j = i - r; j >= 0; j = j - r) {
                    if (array[j] > temp) {
                        array[j + r] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
    }

    /**
     * 冒泡排序
     * 思路：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。
     * 即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
     * * int[] array = {5, 3, 7, 4, 8, 2, 9, 6, 1};
     * 537482619
     */
    public static void bubbleSort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array) + "bubbleSort");
    }

    /**
     * 快速排序是排序方法里面速率最快的一种方法，是对冒泡排序的一种改进， 属于不稳地排序。
     */
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array) + "quickSort");

    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int middle = getMiddle(array, low, high);
            quickSort(array, low, middle);
            quickSort(array, middle + 1, high);
        }
    }

    private static int getMiddle(int[] array, int low, int high) {
        int temp = array[low];
        while (low < high) {
            while (low < high && array[high] >= temp) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= temp) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = temp;
        return low;
    }


    /**
     * 二分查找的基本思路是：首先确定该查找区间的中间点位置： int mid = (low+upper) / 2；
     * 然后将待查找的值与中间点位置的值比较：若相等，则查找成功并返回此位置。若中间点位置值大于待查值，则新的查找区间是中间点位置的左边区域。
     * 若中间点位置值小于待查值，
     * 则新的查找区间是中间点位置的右边区域。下一次查找是针对新的查找区间进行的。
     */
    public static int binarySearch(int[] array, int num, int low, int high) {
        int middle = (high - low) / 2 + low;
        if (num == array[middle]) {
            return middle;
        }
        if (num > array[middle]) {
            return binarySearch(array, num, middle + 1, high);
        }
        return binarySearch(array, num, low, middle);
    }
}
