package onemoretime;

import java.util.Stack;

public class SimplyfyPath {

    public static void main(String[] args) {
        SimplyfyPath sp = new SimplyfyPath();
//        System.out.println(sp.simplifyPath("/home/"));
//        System.out.println(sp.simplifyPath("/home/../root"));
//        System.out.println(sp.simplifyPath("/"));
//        System.out.println(sp.simplifyPath("//home"));
        System.out.println(sp.simplifyPath("//home//f1"));
    }

    public String simplifyPath(String path){
        Stack<String> stringStack = new Stack<>();
        String[] components = path.split("/");

        for(String directory: components){
            if(directory.equals(".") || directory.isEmpty()) {
                continue;
            }
            else if (directory.equals("..")){
                if(!stringStack.isEmpty()){
                    stringStack.pop();
                }
            }
            else {
                stringStack.push(directory);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s: stringStack){
            sb.append("/");
            sb.append(s);
        }

        return sb.length() > 0 ? sb.toString(): "/";
    }
}
