class Solution {
    public String convert(String s, int numRows) {

        if(numRows == 1 || numRows >= s.length()){
            return s;
        }

        StringBuilder[] arr = new StringBuilder[numRows];

        for(int i = 0; i < numRows; i++){
            arr[i] = new StringBuilder();
        }

        int currentRow = 0;
        int direction = 1;

        for(int i = 0; i < s.length(); i++){

            arr[currentRow].append(s.charAt(i));

            if(currentRow == 0){
                direction = 1;
            }
            else if(currentRow == numRows - 1){
                direction = -1;
            }

            currentRow += direction;
        }

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < numRows; i++){
            result.append(arr[i]);
        }

        return result.toString();
    }
}