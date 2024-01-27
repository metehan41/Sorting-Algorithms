import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static double calculatorInsertionSort(int[] arr) {
        InsertionSort insertionSort2 = new InsertionSort();

        double startTime = System.nanoTime();
        insertionSort2.sort(arr);
        double endTime = System.nanoTime();
        double totalTime = (endTime - startTime) * Math.pow(10, -6);
        return totalTime;
    }

    public static double calculatorMergeSort(int[] arr) {
        MergeSort mergeSort = new MergeSort();

        double startTime = System.nanoTime();
        mergeSort.sort(arr, 0, arr.length - 1);
        double endTime = System.nanoTime();
        double totalTime = (endTime - startTime) * Math.pow(10, -6);
        return totalTime;
    }

    public static double calculatorPigeonholeSort(int[] arr) {
        PigeonholeSort pigeonholeSort = new PigeonholeSort();

        double startTime = System.nanoTime();
        pigeonholeSort.pigeonhole_sort(arr, arr.length);
        double endTime = System.nanoTime();
        double totalTime = (endTime - startTime) * Math.pow(10, -6);
        return totalTime;
    }

    public static double calculatorCountSort(int[] arr) {
        CountSort countSort = new CountSort();

        double startTime = System.nanoTime();
        countSort.countSort(arr, arr.length - 1);
        double endTime = System.nanoTime();
        double totalTime = (endTime - startTime) * Math.pow(10, -6);
        return totalTime;
    }

    public static void reverse(ArrayList<int[]> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            int[] tmp = new int[arrayList.get(i).length];
            int r = arrayList.get(i).length;
            for (int j = 0; j < arrayList.get(i).length; j++) {
                tmp[r - 1] = arrayList.get(i)[j];
                r--;
            }
            arrayList.set(i, tmp);
        }
    }

    public static ArrayList<double[]> sort(ArrayList<int[]> arrayList) {

        double totalTimeInsSort = 0;
        double[] arrTotalTimeInsSort = new double[10];
        int i = 0;
        for (int[] arr : arrayList) {
            for (int j = 0; j < 10; j++) {
                calculatorInsertionSort(arr.clone());
            }
        }
        for (int[] arr : arrayList) {
            for (int j = 0; j < 10; j++) {
                totalTimeInsSort += calculatorInsertionSort(arr.clone());
            }
            totalTimeInsSort /= 10;
            arrTotalTimeInsSort[i] = totalTimeInsSort;
            i++;
            totalTimeInsSort = 0;
        }
        i = 0;

        double totalTimeMergeSort = 0;
        double[] arrTotalTimeMergeSort = new double[10];
        for (int[] arr : arrayList) {
            for (int j = 0; j < 10; j++) {
                calculatorMergeSort(arr.clone());
            }
        }
        for (int[] arr : arrayList) {
            for (int j = 0; j < 10; j++) {
                totalTimeMergeSort += calculatorMergeSort(arr.clone());
            }
            totalTimeMergeSort /= 10;
            arrTotalTimeMergeSort[i] = totalTimeMergeSort;
            i++;
            totalTimeMergeSort = 0;
        }
        i = 0;

        double totalTimePigSort = 0;
        double[] arrTotalTimePigSort = new double[10];
        for (int[] arr : arrayList) {
            for (int j = 0; j < 10; j++) {
                calculatorPigeonholeSort(arr.clone());
            }
        }
        for (int[] arr : arrayList) {
            for (int j = 0; j < 10; j++) {
                totalTimePigSort += calculatorPigeonholeSort(arr.clone());
            }
            totalTimePigSort /= 10;
            arrTotalTimePigSort[i] = totalTimePigSort;
            i++;
            totalTimePigSort = 0;
        }
        i = 0;

        double totalTimeCountSort = 0;
        double[] arrTotalTimeCountSort = new double[10];
        for (int[] arr : arrayList) {
            for (int j = 0; j < 10; j++) {
                calculatorCountSort(arr.clone());
            }
        }
        for (int[] arr : arrayList) {
            for (int j = 0; j < 10; j++) {
                totalTimeCountSort += calculatorCountSort(arr.clone());
            }
            totalTimeCountSort /= 10;
            arrTotalTimeCountSort[i] = totalTimeCountSort;
            i++;
            totalTimeCountSort = 0;
        }

        ArrayList<double[]> arrayListTotalTime = new ArrayList<>();
        arrayListTotalTime.add(arrTotalTimeInsSort);
        arrayListTotalTime.add(arrTotalTimeMergeSort);
        arrayListTotalTime.add(arrTotalTimePigSort);
        arrayListTotalTime.add(arrTotalTimeCountSort);
        return arrayListTotalTime;
    }

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Metehan\\ass1-2\\src\\TrafficFlowDataset.csv"));
        String line = br.readLine();
        int i = 0;
        int[] inputAxis = {512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 251282};

        int[] size512 = new int[512];
        int[] size1024 = new int[1024];
        int[] size2048 = new int[2048];
        int[] size4096 = new int[4096];
        int[] size8192 = new int[8192];
        int[] size16384 = new int[16384];
        int[] size32768 = new int[32768];
        int[] size65536 = new int[65536];
        int[] size131072 = new int[131072];
        int[] size251281 = new int[251281];

        ArrayList<int[]> arrayList = new ArrayList<>();
        arrayList.add(size512);
        arrayList.add(size1024);
        arrayList.add(size2048);
        arrayList.add(size4096);
        arrayList.add(size8192);
        arrayList.add(size16384);
        arrayList.add(size32768);
        arrayList.add(size65536);
        arrayList.add(size131072);
        arrayList.add(size251281);


        while ((line = br.readLine()) != null) {

            String[] cols = line.split(",");
            int num = Integer.parseInt(cols[7]);
            if (i < 512) {
                size512[i] = num;
            }
            if (i < 1024) {
                size1024[i] = num;
            }
            if (i < 2048) {
                size2048[i] = num;
            }
            if (i < 4096) {
                size4096[i] = num;
            }
            if (i < 8192) {
                size8192[i] = num;
            }
            if (i < 16384) {
                size16384[i] = num;
            }
            if (i < 32768) {
                size32768[i] = num;
            }
            if (i < 65536) {
                size65536[i] = num;
            }
            if (i < 131072) {
                size131072[i] = num;
            }
            if (i < 251281) {
                size251281[i] = num;
            }
            i++;
        }

        ArrayList<double[]> TotalTimeUnsortedData = sort(arrayList);


        double[][] yAxis = new double[4][10];
        yAxis[0] = TotalTimeUnsortedData.get(0);
        yAxis[1] = TotalTimeUnsortedData.get(1);
        yAxis[2] = TotalTimeUnsortedData.get(2);
        yAxis[3] = TotalTimeUnsortedData.get(3);


        showAndSaveChart("Total Time On Random Data", inputAxis, yAxis);

        for (int j = 0; j < 10; j++) {
            InsertionSort tmp = new InsertionSort();
            arrayList.set(j, tmp.sort(arrayList.get(j)));
        }
        ArrayList<double[]> TotalTimeSortedData = sort(arrayList);

        yAxis[0] = TotalTimeSortedData.get(0);
        yAxis[1] = TotalTimeSortedData.get(1);
        yAxis[2] = TotalTimeSortedData.get(2);
        yAxis[3] = TotalTimeSortedData.get(3);


        showAndSaveChart("Total Time On Sorted Data", inputAxis, yAxis);


        reverse(arrayList);
        System.out.println("ters çevrilmiş sorted arraydaki ilk eleman");
        System.out.println(arrayList.get(arrayList.size() - 1)[0]);
        System.out.println("ters çevrilmiş sorted arraydaki son eleman");
        System.out.println(arrayList.get(arrayList.size() - 1)[arrayList.get(arrayList.size() - 1).length - 1]);
        ArrayList<double[]> TotalTimeReverseSortedData = sort(arrayList);

        yAxis[0] = TotalTimeReverseSortedData.get(0);
        yAxis[1] = TotalTimeReverseSortedData.get(1);
        yAxis[2] = TotalTimeReverseSortedData.get(2);
        yAxis[3] = TotalTimeReverseSortedData.get(3);


        showAndSaveChart("Total Time On Reverse Sorted Data", inputAxis, yAxis);
    }

    public static void showAndSaveChart(String title, int[] xAxis, double[][] yAxis) throws IOException {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).title(title)
                .yAxisTitle("Time in Milliseconds").xAxisTitle(title).build();

        double[] doubleX = Arrays.stream(xAxis).asDoubleStream().toArray();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        // Add a plot for a sorting algorithm
        chart.addSeries("Insertion Sort", doubleX, yAxis[0]);
        chart.addSeries("Merge Sort", doubleX, yAxis[1]);
        chart.addSeries("PigeonHole Sort", doubleX, yAxis[2]);
        chart.addSeries("Count Sort", doubleX, yAxis[3]);

        // Save the chart as PNG
        BitmapEncoder.saveBitmap(chart, title + ".png", BitmapEncoder.BitmapFormat.PNG);

        // Show the chart
        new SwingWrapper(chart).displayChart();
    }

}
