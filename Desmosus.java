public class Desmosus
{
    public static void main(String[] args)
    {
        String eq = "y=x";
        int yLoc = eq.indexOf("y");
        int eLoc = eq.indexOf("=");
        String leftSide = eq.substring(0, eLoc);
        String rightSide = eq.substring(eLoc);


    }    

}
