package com.example.mumershaukat.eme_mess;

/**
 * Created by pc on 4/27/2017.
 */

public class Value_Recycler_View {
    public Value_Recycler_View() {
    }

    public static String[]  splitter(String res)
    {
        String  b="\"";
        String str1= res.replaceAll(b,"");
        String part[]=str1.split("\\]");
        String str2=str1.replaceAll("\\[","").replaceAll("\\]", "");

        for(int i=0;i<part.length;i++)
        {
            part[i]=part[i].replaceAll("\\[", "");
        }
        String[] Value={part[0],part[1]};


        return Value;
    }
}
