package te;
import java.util.ArrayList;
import java.util.List;

class matrix{
     
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        postion postion=new postion();
        int x=matrix.length;
        int y=matrix[0].length;
        int size=x*y;
        int[][] temp=Bigmatrix(matrix);
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[0].length;j++){
                System.out.print(temp[i][j]+" ");
            }
            System.out.println();
        }
        while(size>0){
            if(postion.rightBoolean){
                System.out.print(temp[postion.XP][postion.yp]+" ");
                result.add(temp[postion.XP][postion.yp]);
                temp[postion.XP][postion.yp]=-101;
                if(postion.rightBoolean&&temp[postion.XP][postion.yp+1]==-101){
                    postion.downBoolean=true;
                    postion.rightBoolean=false;
                     postion.XP++;
                }
                else{
                    //System.out.println(postion.yp+1);
                    postion.yp++;
                }
                
                
            }
            else if(postion.leftBoolean){
                System.out.print(temp[postion.XP][postion.yp]+" ");
                 result.add(temp[postion.XP][postion.yp]);
                temp[postion.XP][postion.yp]=-101;
                if(postion.leftBoolean&&temp[postion.XP][postion.yp-1]==-101){
                    postion.upBoolean=true;
                    postion.leftBoolean=false;
                    postion.XP--;
                }else{
                    postion.yp--;
                }     
            }
            else if(postion.upBoolean){
                System.out.print(temp[postion.XP][postion.yp]+" ");
                 result.add(temp[postion.XP][postion.yp]);
                temp[postion.XP][postion.yp]=-101;
                if(postion.upBoolean&&temp[postion.XP-1][postion.yp]==-101){
                    postion.rightBoolean=true;
                    postion.upBoolean=false;
                     postion.yp++;
                }else{
                    postion.XP--;
                }

            }
            else if(postion.downBoolean){
                System.out.print(temp[postion.XP][postion.yp]+" ");
                result.add(temp[postion.XP][postion.yp]);
                temp[postion.XP][postion.yp]=-101;
                if(postion.downBoolean&&temp[postion.XP+1][postion.yp]==-101){
                    postion.downBoolean=false;
                    postion.leftBoolean=true;
                    postion.yp--;
                }
                else{
                    postion.XP++;
                }
                
            }
            size--;
        }


        return result;

    }
   
    private class postion{
       int XP=0;
       int yp=1;
       Boolean upBoolean=false;
       Boolean downBoolean=false;
       Boolean leftBoolean=false;
       Boolean rightBoolean=true;

    }
    public int[][] Bigmatrix(int[][] matrix){
        int[][] Bigmatrix=new int[matrix.length+1][matrix[0].length+2];
        for(int i=0;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length+1;j++){
                 Bigmatrix[i][j]=matrix[i][j-1];
            }
        }
        for(int i=0;i<matrix.length+1;i++){
            Bigmatrix[i][matrix[0].length+1]=-101;
        }
        for(int i=0;i<matrix.length+1;i++){
            Bigmatrix[i][0]=-101;
        }
        for(int i=0;i<matrix[0].length+1;i++){
            Bigmatrix[matrix.length][i]=-101;

        }

        return Bigmatrix;

    }
}