package sample.Tool.GetAndPost;

/**
 * @autHor LHYJTZ
 * @data 2021年04月23日 13:51
 */
public class GetAndPost {
    public String cs(String name) {
        if (name != null) {
            System.out.println(name);
            return name;
        } else {
            System.out.println("null");
            return "null";
        }
    }
}
