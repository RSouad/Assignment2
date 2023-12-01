mport java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class SensorDataProcessor {
    // Sensor data and limits.
    public double[][][] data;
    public double[][] limit;

    // Constructor
    public SensorDataProcessor(double[][][] data, double[][] limit) {
        this.data = data;
        this.limit = limit;
    }

    // Calculate average of sensor data
    private double calculateAverage(double[] array) {
        double sum = 0;
        for (double value : array) {
            sum += value;
        }
        return sum / array.length;
    }

    // Calculate data
    public void calculate(double divider) {
        double[][][] processedData = new double[data.length][data[0].length][data[0][0].length];
        BufferedWriter writer = null;

        // Write racing stats data into a file
        try {
            writer = new BufferedWriter(new FileWriter("RacingStatsData.txt"));

            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[0].length; j++) {
                    for (int k = 0; k < data[0][0].length; k++) {
                        processedData[i][j][k] = data[i][j][k] / divider - Math.pow(limit[i][j], 2.0);

                        if (calculateAverage(processedData[i][j]) > 10 && calculateAverage(processedData[i][j]) < 50) {
                            break;
                        } else if (Math.max(data[i][j][k], processedData[i][j][k]) > data[i][j][k]) {
                            break;
                        } else if (Math.pow(Math.abs(data[i][j][k]), 3) < Math.pow(Math.abs(processedData[i][j][k]), 3)
                                && calculateAverage(data[i][j]) < processedData[i][j][k] && (i + 1) * (j + 1) > 0) {
                            processedData[i][j][k] *= 2;
                        } else {
                            continue;
                        }
                    }
                    // Write the data for the current 'j' iteration to the file
                    writer.write(arrayToString(processedData[i][j]) + "\t");
                    writer.newLine(); // Move to the next line for each 'j' iteration.
                }
                writer.newLine(); // Separate each 'i' iteration with a new line.
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Helper method to convert an array to a formatted string
    private String arrayToString(double[] array) {
        StringBuilder result = new StringBuilder();
        for (double value : array) {
            result.append(value).append("\t");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Example data (replace this with your actual data)
        double[][][] exampleData = {
                {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}},
                {{7.0, 8.0, 9.0}, {10.0, 11.0, 12.0}}
        };

        double[][] exampleLimit = {
                {0.5, 1.0, 1.5},
                {2.0, 2.5, 3.0}
        };

        // Create an instance of SensorDataProcessor
        SensorDataProcessor processor = new SensorDataProcessor(exampleData, exampleLimit);

        // Call the calculate method
        processor.calculate(2.0); // Replace 2.0 with your desired divider
    }
}
