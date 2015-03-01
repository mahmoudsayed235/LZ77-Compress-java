import java.io.*;
import javax.swing.*;
import java.io.IOException;
import java.util.*;
import java.util.StringTokenizer;
public class Compress {
public static void main(String[]args) throws IOException {
        JOptionPane.showMessageDialog(null, "Welcome To My Program ! \n\n ");
        while(true){
                String[] buttons = { "Compress", "Decompress", "Exit" };

    int rc = JOptionPane.showOptionDialog(null, "What You Want To Do ? ", "LZ77",
        JOptionPane.WARNING_MESSAGE, 3, null, buttons, buttons[2]);
    if(rc==0){
    Scanner kb=new Scanner(System.in);
    PrintWriter outputFile = new PrintWriter("Compress.txt");
    String txt;
    int length=0;
    int size=0;
    int loc=0;
    char nextChar;
    char [] array2;
    String g="";
    String comp="";
    String dummy="~";
    char [] array;
    int f=0;
    int s=0;
    int h=0;
    int d=1000000000;
    String multiLineMsg = "";
    int i = 1;
    int count=0;
    boolean status = false;
    boolean check=false;
    txt=JOptionPane.showInputDialog(null, "Enter your TEXT : ");
    txt=dummy+txt;
    array=txt.toCharArray();
    for (i = 1; i < txt.length(); i++) {
        comp+=array[i];
        array2=comp.toCharArray();
        f=i-1;
        h=i;
        int n;
        int z;
   for(z=i-1;z>=0;z--)
   {
       status=false;
    if(array2[s]!=array[z])
    {
    continue;
    }
   if(array2[s]==array[z])
   {
       loc=z;
       n=i-z;

       if(i==txt.length()-2&&n<=d)
       {
       d=n;
       }
       n=d;
       h=i;
       s=0;
   status=true;
   }
   int r;
   r=0;
   int old=0;
   int nw=0;
        if(status==true){
        for (int j = z;j>=0;j--)
        {
            /////////////////////     
                for (int k = j; (k <=h)&&(k<i); k++) {
                    if(array[k]==array2[s])
                {
                h++;
                r++;
                if(h==txt.length())
                {
                break;
                }
                comp+=array[h];
                array2=comp.toCharArray();
                nw=k-j;
                status=true;
                }
                if(array[k]!=array2[s])
                {
                nw=k-j;
                break;

                }
                s++;
                }
            if(status==true)
            {

            s=0;
            if(g.length()>=comp.length()&&old>nw)
            {
            break;
            }
            if(g.length()<comp.length()&&old<=nw){
                g="";
                length=i-z;
                
                for(int b=0;b<r;b++){
                
                        g+=array2[b];
            }
            old=nw;
            }
            comp="";
            r=0;
            size=g.length();
            comp+=array[i];
            break;
            }
        }
        }
    }
                    if(status==false)
            {
              if(size+i>=txt.length())
              {
              size=1;
              length=d;
              }
              if(length==1000000000)
              {
              length=i-loc;
              }
              i=i+size;

              if(i>=txt.length())
              {

              i=txt.length()-1;
              array[i]='-';
              }
            nextChar=array[i];
            outputFile.println("<"+length+","+size+",'"+nextChar+"'>");
             multiLineMsg+="<"+length+","+size+",'"+nextChar+"'> ";
            comp="";
            g="";
           h=i;
           size=0;
            length=0;
             }
        
    }
                   JFrame parent = new JFrame();
    JOptionPane.showMessageDialog(parent, multiLineMsg);
    outputFile.close();
    }
////////////////////////////////////////
    if(rc==1)
           {
    char [] next = null;
    char[]data;
    String multiLineMsg="";
    String st;
    String dummy ="";
    String dec="";
    char[]k=new char[40];
    int dumm;
    int point=9;
    char nextC = 0;
    int size = 0;
    int count=0;
      Scanner keyboard = new Scanner(System.in);
      File file = new File("Compress.txt");
      Scanner inputFile = new Scanner(file);
      while (inputFile.hasNext())
      {
         String deCompress = inputFile.nextLine();
        StringTokenizer stoke=new StringTokenizer(deCompress,"<,'>");
        while(stoke.hasMoreTokens()){

                 st=stoke.nextToken();
              dec+=st;
        }
      }
      int y=0;
      dummy=" ";
      dummy+=dec;
      data=dummy.toCharArray();
      int m;
      int r;
      int a;
      int s;
      for(m=1;m<dummy.length();m++)
      {
       point=  data[m]-48;
      
       size=data[m+1]-48;
       nextC=data[m+2];
      
       
       for(r=count;r<40;r++)
       {
       dumm=r;
       for(a=0;a<point;a++)

       {   dumm--;
      
       continue;
       }
       for(s=0;s<size;s++)
       {
           if(point>0){
               k[r]=k[dumm];

       dumm++;
       r++;
       }
       }
       k[r]=nextC;
       dumm++;
       r++;
       count=r;
       break;
       }
       
       m=m+2;
      }
       

      multiLineMsg="";
       for (int h = 0; h <count; h++) {
           if(k[h]!='-'){
           multiLineMsg+=k[h];
           }
       }
      PrintWriter outputFile2 = new PrintWriter("DeCompress.txt");
      outputFile2.println(multiLineMsg);
    JFrame parent = new JFrame();
    JOptionPane.showMessageDialog(parent, multiLineMsg);
      inputFile.close();
      outputFile2.close();
       }
    
    ////////////////////////////////////
    if(rc==2)
     {
     JOptionPane.showMessageDialog(null, "Thank You To Use My Programe ! \n\n Disinged By : Khaled Jamal .\n ID : 20080464");
     System.exit(0);
     }

}
}
}