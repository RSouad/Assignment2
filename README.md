![image](https://github.com/RSouad/Assignment2/assets/134312321/3fc92f70-3d3c-46b7-af05-72fdd43e9020)# Assignment2


Souad Ridwan 2115094:

public DataProcessor(double[][][] data, double[][] limit)

This part of the code I modified the name of the constructor because it didn't match the name of the class it's in, and having a different name can cause the code structure to be unclear and inconsistent, making it difficult for other developers to understand the constructor without looking at its implementation.


 for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[0].length; j++) {
                    for (int k = 0; k < data[0][0].length; k++) {

1-the varibles i,j,k are declared outside the loop and their initial values are 0, this may lead to an unexpected behaivor so insted of declaring them outside the loop we declared them inside the loop










//////////////////////////////
Layali Khayat 2110211

inefficient bufferedWriter usage:
The code currently writes only one dimension of the three-dimensional array to the file. It might be better to format the output in a more organized manner.












/////////////////////////////
Norah Abdullah 2110970
Its better to print the stack trace for debugging purposes rather than printing generic error message.


