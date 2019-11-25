import static java.lang.System.exit;

public class Main {

<<<<<<< HEAD
    public static void main(String [] args) throws Exception {
        ReadNames rn = new ReadNames();
        Parser parser = new Parser(rn.getNamesBuffer());
        if(rn.getNamesBuffer().size()<=0)
            exit(1);
        switch (args[0]){
            case "CountSpecificString":
                parser.countSpecificString(args[1]);
                break;
            case "CountAllStrings":
                parser.countAllStrings(Integer.parseInt(args[1]));
                break;
            case "CountMaxString":
                parser.countMaxString(Integer.parseInt(args[1]));
                break;
            case "AllIncludesString":
                parser.allIncludesString(args[1]);
                break;
            case "GenerateName":
                parser.generateName();
                break;
            default:
               throw new Exception("Invalid Usage");

=======
    public static void main(String[] args) {
        ReadNames rn = new ReadNames();
        Parser parser = new Parser(rn.getNamesBuffer());
        //System.out.println(rn.getNamesBuffer());

        if (rn.getNamesBuffer().size() <= 0)
            exit(1);
        switch (args[0]){
            case "CountSpecificString": /*DONE*/
                parser.countSpecificString(args[1]);
                break;
            case "CountAllStrings": //way to DONE
                parser.countAllStrings(Integer.parseInt(args[1]));
                break;
            case "CountMaxString":  //way to DONE
                parser.countMaxString(Integer.parseInt(args[1]));
                break;
            case "AllIncludesString": /*DONE*/
                parser.allIncludesString(args[1]);
                break;
            case "GenerateName": //TODO - BONUS
                parser.generateName();
                break;
            default:
                System.out.println("-------Invalid Usage--------");
>>>>>>> c6eeedc... 25.11
        }
    }
}
