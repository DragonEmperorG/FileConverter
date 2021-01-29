package cn.edu.whu.unsc;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        String inputFilePath = "D:\\SharedFolder\\PrintFolder\\Debug\\20200117Data\\20200117_102332_bba\\RawTS.csv";
//        String outputFilePath = "D:\\SharedFolder\\PrintFolder\\Debug\\20200117Data\\20200117_095208_100\\zhongtest1M.txt";

//        File outputFile = new File(outputFilePath);

        int coarseDetectorNum = 0;
        int falseCoarseDetectorNum = 0;
        final String BIT_FLAG = "001";
        final String BIT_FLAG_FORMAT = "bba";

        try {
            FileInputStream fileInputStream = new FileInputStream(inputFilePath);
//            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            BufferedReader buffReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line;
            StringBuilder stringBuilder;
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss.SSS");
            while ((line = buffReader.readLine()) != null) {
                stringBuilder = new StringBuilder();
                String[] lineArray = line.split(",");
                int lineArrayLength = lineArray.length;

                coarseDetectorNum++;

                if (!lineArray[3].equals(BIT_FLAG)) {
                    falseCoarseDetectorNum++;
                }

//                String date = lineArray[lineArrayLength - 2] + " " + lineArray[lineArrayLength - 1] + "00";
//                calendar.setTime(simpleDateFormat.parse(date));

//                stringBuilder.append(line);
//                stringBuilder.append(",").append(calendar.getTimeInMillis());
//                stringBuilder.append("\n");
//                fileOutputStream.write(stringBuilder.toString().getBytes());
            }

            fileInputStream.close();
//            fileOutputStream.close();

            double successRate = (double) (coarseDetectorNum - falseCoarseDetectorNum) / (double) (coarseDetectorNum) * 100.0;

            System.out.format("%s, %3.2f, %d\n", BIT_FLAG_FORMAT, successRate, coarseDetectorNum);

            System.out.print("Convert complete.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
