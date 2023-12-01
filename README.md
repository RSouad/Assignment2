# Assignment2


Souad Ridwan 2115094:

public DataProcessor(double[][][] data, double[][] limit)

This part of the code I modified the name of the constructor because it didn't match the name of the class it's in, and having a different name can cause the code structure to be unclear and inconsistent, making it difficult for other developers to understand the constructor without looking at its implementation.


for (i = 0; i < data2.length; i++) {
    for (j = 0; j < data2[0].length; j++) {
        out.write(data2[i][j] + "\t");
    }
}

The data2 array was attempted to be written to a file in the original code, but the formatting was incorrect. The loop structure was incapable of handling the three-dimensional array. That's why I added an extra loop to iterate through the three-dimensional array properly.









//////////////////////////////
Layali Khayat 2110211

inefficient bufferedWriter usage:
The code currently writes only one dimension of the three-dimensional array to the file. It might be better to format the output in a more organized manner.












/////////////////////////////
Norah Abdullah 2110970
1-the varibles i,j,k are declared outside the loop and their initial values are 0, this may lead to an unexpected behaivor so insted of declaring them outside the loop we declared them inside the loop


