import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) throws Exception {
        ReadNames rn = new ReadNames();
        Parser parser = new Parser(rn.getNamesBuffer());
        System.out.println("#ofNames: "+rn.getNamesBuffer().size());
        if (rn.getNamesBuffer().size() <= 0)
            exit(1);
        switch(args[0]) {
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
        }
    }
}
